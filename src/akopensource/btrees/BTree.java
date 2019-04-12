package akopensource.btrees;

import akopensource.tuples.Pair;

public class BTree {

    private int t;
    private BTreeNode root;

    public BTree(int t, int k) {
        this.root = new BTreeNode(true, t);
        this.t = t;
        this.root.setKey(0, k);
        this.root.setN(1);
    }

    public Pair search(int k) {
        return search(root, k);
    }

    private Pair search(BTreeNode node, int k) {
        if (node == null)
            return null;
        int i = 0;
        while (i < node.getN() && k > node.getKey(i))
            i++;
        if (i < node.getN() && k == node.getKey(i))
            return new Pair(node, i);
        else
            return search(node.getChild(i), k);

    }

    private void splitChild(BTreeNode node, int i) {
        BTreeNode c = node.getChild(i);
        BTreeNode n = new BTreeNode(c.isLeaf(), this.t);
        n.setN(t - 1);
        for (int j = 0; j < t - 1; j++)
            n.setKey(j, c.getKey(j + t));

        if (!c.isLeaf()) {
            for (int j = 0; j < t; j++)
                n.setChild(j, c.getChild(j + t));
        }
        c.setN(t - 1);

        for (int j = node.getN(); j > i + 1; j--)
            node.setChild(j + 1, node.getChild(j));

        node.setChild(i + 1, n);
        for (int j = n.getN() - 1; j >= i; j--)
            node.setKey(j + 1, node.getKey(j));

        node.setKey(i, c.getKey(t - 1));
        node.setN(node.getN() + 1);
    }

    public void insert(int k) {
        BTreeNode r = this.root;
        if (r.getN() == 2 * t - 1) {
            BTreeNode newRoot = new BTreeNode(false, this.t);
            newRoot.setChild(0, this.root);
            splitChild(newRoot, 0);
            insertNonFull(newRoot, k);
            this.root = newRoot;
        } else
            insertNonFull(r, k);
    }

    private void insertNonFull(BTreeNode n, int k) {
        int i = n.getN() - 1;
        if (n.isLeaf()) {
            while (i >= 0 && k < n.getKey(i)) {
                n.setKey(i + 1, n.getKey(i));
                i--;
            }
            n.setKey(i+1, k);
            n.setN(n.getN() + 1);
        } else {
            while (i >= 0 && k < n.getKey(i))
                i--;
            i += 1;
            if (n.getChild(i).getN() == 2 * t - 1) {
                splitChild(n, i);
                if (k > n.getKey(i))
                    i = i + 1;
            }
            insertNonFull(n.getChild(i), k);
        }
    }

    public int getPredecessor(BTreeNode node, int i){
        BTreeNode c = node.getChild(i);
        while (!c.isLeaf())
            c = c.getChild(c.getN());

        return c.getKey(c.getN()-1);
    }

    public int getSuccessor(BTreeNode node, int i){
        BTreeNode c = node.getChild(i);
        while (!c.isLeaf())
            c = c.getChild(0);

        return c.getKey(0);
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public BTreeNode getRoot() {
        return root;
    }

    public void setRoot(BTreeNode root) {
        this.root = root;
    }
}
