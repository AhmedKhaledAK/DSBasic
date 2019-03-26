package akopensource.btrees;

public class BTreeNode {

    private int n;
    private int[] keys;
    private BTreeNode[] children;
    //int t; // minimum degree
    private boolean isLeaf;

    public BTreeNode(boolean isLeaf, int t) {
        this.isLeaf = isLeaf;
        keys = new int[2 * t - 1];
        children = new BTreeNode[2 * t];
        n=-1;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int[] getKeys() {
        return keys;
    }

    public void setKeys(int[] keys) {
        this.keys = keys;
    }

    public int getKey(int i){
        return keys[i];
    }

    public BTreeNode[] getChildren() {
        return children;
    }

    public void setChildren(BTreeNode[] children) {
        this.children = children;
    }

    public BTreeNode getChild(int i){
        return children[i];
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }


}
