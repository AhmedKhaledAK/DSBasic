package akopensource.btrees;

import java.util.ArrayList;

public class BTreeNode {

    private int n;
    private ArrayList<Integer> keys;
    private ArrayList<BTreeNode> children;
    //int t; // minimum degree
    private boolean isLeaf;

    public BTreeNode(boolean isLeaf, int t) {
        this.isLeaf = isLeaf;
        keys = new ArrayList<>(2 * t -1);
        children = new ArrayList<>(2 * t);

        n=-1;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public ArrayList<Integer> getKeys() {
        return keys;
    }

    public void setKeys(ArrayList<Integer> keys) {
        this.keys = keys;
    }

    public int getKey(int i){
        return keys.get(i);
    }

    public ArrayList<BTreeNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<BTreeNode> children) {
        this.children = children;
    }

    public void setChild(int i, BTreeNode n){
//        this.getChildren().remove(i);
        this.getChildren().add(i, n);
    }

    public BTreeNode getChild(int i){
        return children.get(i);
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public void traverseBTree(){
        int i;
        for (i = 0; i <= this.n; i++) {
            if(!isLeaf){
                this.getChildren().get(i).traverseBTree();
            }
            System.out.print(this.getKeys().get(i) + " ");
            System.out.println();
        }
        if(!isLeaf){
            this.getChildren().get(i).traverseBTree();
        }
    }

}
