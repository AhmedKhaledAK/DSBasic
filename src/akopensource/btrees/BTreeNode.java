package akopensource.btrees;

public class BTreeNode {

    private int n;
    private int[] keys;
    private BTreeNode[] children;
    //int t; // minimum degree
    private boolean isLeaf;

    BTreeNode(boolean isLeaf, int t) {
        this.isLeaf = isLeaf;
        keys = new int[2 * t -1];
        children = new BTreeNode[2 * t];

        n=0;
    }

    public int getN() {
        return n;
    }

    void setN(int n) {
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

    void setKey(int i, int k) {
        this.keys[i] = k;
    }

    public BTreeNode[] getChildren() {
        return children;
    }

    public void setChildren(BTreeNode[] children) {
        this.children = children;
    }

    BTreeNode getChild(int i){
        return children[i];
    }

    void setChild(int i, BTreeNode child) {
        this.children[i] = child;
    }

    boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public void traverse(){
        int i;
        for (i = 0; i < this.getN(); i++) {
            if(!this.isLeaf)
                this.getChild(i).traverse();
            System.out.println(this.getKey(i));
        }
        // last traverse.
        if (!this.isLeaf)
            this.getChild(i).traverse();
    }
}
