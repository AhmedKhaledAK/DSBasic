package akopensource.btrees;

import akopensource.tuples.Pair;

public class BTree {

    private int t;
    private BTreeNode root;

    public BTree(int t) {
        this.root = new BTreeNode(true, t);
        this.t = t;
    }

    public Pair search(int k){
        return search(root, k);
    }

    private Pair search(BTreeNode node, int k){
        if (node == null)
            return null;
        int i = 0;
        while (i <= node.getN() && k > node.getKey(i))
            i++;
        if(i <= node.getN() && k == node.getKey(i))
            return new Pair(node, i);
        else
            return search(node.getChild(i), k);

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
