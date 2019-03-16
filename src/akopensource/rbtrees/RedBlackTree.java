package akopensource.rbtrees;

public class RedBlackTree {
    private Node root;

    public RedBlackTree(Node root) {
        this.root = root;
    }

    public RedBlackTree(int data) {
        root = new Node(data);
        root.setColor(1);
    }

    public void insert(int data){
        Node z = new Node(data);
        Node node = this.root, n = null;
        while (node != null){
            n = node; // get leaf node
            if(z.getData() < node.getData())
                node = node.getLeft();
            else
                node = node.getRight();
        }
        z.setParent(n);
        if(n==null)
            this.root = z;
        else if(z.getData() < n.getData())
            n.setLeft(z);
        else
            n.setRight(z);
        // No need for setting the color or left and right child to null because they're already
        // set when creating the node
        insertFixup(z);
    }

    private void insertFixup(Node z) {
        while (z.getParent() != null && z.getParent().getColor() == 0){
            if(z.getParent() == z.getParent().getParent().getLeft()){
                Node uncle = z.getParent().getParent().getRight();
                if (uncle != null && uncle.getColor() == 0){ // case 1
                    uncle.setColor(1);
                    z.getParent().setColor(1);
                    z.getParent().getParent().setColor(0);
                    z = z.getParent().getParent();
                } else if (z == z.getParent().getRight()){
                    z = z.getParent();
                    rotateLeft(z);
                    z.getParent().setColor(1);
                    z.getParent().getParent().setColor(0);
                    rotateRight(z.getParent().getParent());
                } else if (z == z.getParent().getLeft()){
                    z.getParent().setColor(1);
                    z.getParent().getParent().setColor(0);
                    rotateRight(z.getParent().getParent());
                }
            }
            else{
                Node uncle = z.getParent().getParent().getLeft();
                if(uncle != null && uncle.getColor() == 0){
                    uncle.setColor(1);
                    z.getParent().setColor(1);
                    z.getParent().getParent().setColor(0);
                    z = z.getParent().getParent();
                } else if (z == z.getParent().getLeft()){
                    z = z.getParent();
                    rotateRight(z);
                    z.getParent().setColor(1);
                    z.getParent().getParent().setColor(0);
                    rotateLeft(z.getParent().getParent());
                } else if (z == z.getParent().getRight()){
                    z.getParent().setColor(1);
                    z.getParent().getParent().setColor(0);
                    rotateLeft(z.getParent().getParent());
                }
            }
        }
        root.setColor(1);
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
    public void traverseInorder (Node rootNode){
        if(rootNode != null){
            traverseInorder(rootNode.getLeft());
            System.out.println(rootNode.getData() + " color " + rootNode.getColor());
            traverseInorder(rootNode.getRight());
        }
    }
}
