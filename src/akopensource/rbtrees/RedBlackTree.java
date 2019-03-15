package akopensource.rbtrees;

public class RedBlackTree {
    private Node root;

    public RedBlackTree(Node root) {
        this.root = root;
    }

    public RedBlackTree() {
    }

    public void rotateLeft(Node x){
        Node y = null;
        if(x.getRight() != null)
            y = x.getRight();

        x.setRight(y.getLeft());
        if(y.getLeft() != null)
            y.getLeft().setParent(x);

        y.setParent(x.getParent());
        if(x == root)
            root = y;
        else if (x == x.getParent().getLeft())
            x.getParent().setLeft(y);
        else x.getParent().setRight(y);

        y.setLeft(x);
        x.setParent(y);
    }

    public void rotateRight(Node x){
        Node y = null;
        if (x.getLeft() != null)
            y = x.getLeft();

        x.setLeft(y.getRight());
        if(y.getRight() != null)
            y.getRight().setParent(x);

        y.setParent(x.getParent());
        if(x == root)
            root = y;
        else if(x == x.getParent().getLeft())
            x.getParent().setLeft(y);
        else x.getParent().setRight(y);

        y.setRight(x);
        x.setParent(y);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
