package akopensource.rbtrees;

public class Node {

    private int data, color; //0 - red, 1 - black
    private Node left, right, parent;

    public Node(int data) {
        this.data = data;
        left = right = parent = null;
        color = 0;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
