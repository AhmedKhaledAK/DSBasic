package akopensource.btrees;

import akopensource.tuples.Pair;

public class BTree {

    private int t;
    private BTreeNode root;

    public BTree(int t) {
        this.root = new BTreeNode(true, t);
        this.t = t;
    }

    public Pair search(int k) {
        return search(root, k);
    }

    private Pair search(BTreeNode node, int k) {
        if (node == null)
            return null;
        int i = 0;
        while (i <= node.getN() && k > node.getKey(i))
            i++;
        if (i <= node.getN() && k == node.getKey(i))
            return new Pair(node, i);
        else
            return search(node.getChild(i), k);

    }

    public void splitChild(BTreeNode node, int i) {
        BTreeNode n = new BTreeNode(node.getChild(i).isLeaf(), this.t);
        n.setN(t - 2);
        BTreeNode child = node.getChild(i);
        for (int j = 0; j < t - 2; j++)
            n.getKeys().add(child.getKey(j + t));
        if (!child.isLeaf()) {
            for (int j = 0; j < t; j++)
                n.getChildren().add(child.getChild(j + 1));
        }
        child.setN(t-2);
        node.getKeys().add(i,child.getKey(t-1));
        //node.getChildren().add(i,child.getChild(t-1));
        //node.getChildren().add(i+1,child.getChild(t));

        node.setChild(i, child);
        node.setChild(i+1, n);

        node.setN(node.getN() + 1);
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
