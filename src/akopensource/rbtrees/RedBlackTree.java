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

    public Node search(int data){
        return search(data, this.root);
    }

    private Node search(int data, Node node){
        if (node == null || node.getData() == data)
            return node;
        if (data < node.getData())
            return search(data, node.getLeft());
        return search(data, node.getRight());
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
                } else {
                    if (z == z.getParent().getRight()) {
                        z = z.getParent();
                        rotateLeft(z);
                    }
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
                } else {
                    if (z == z.getParent().getLeft()) {
                        z = z.getParent();
                        rotateRight(z);
                    }
                    z.getParent().setColor(1);
                    z.getParent().getParent().setColor(0);
                    rotateLeft(z.getParent().getParent());
                }
            }
        }
        root.setColor(1);
    }

    private void rotateLeft(Node x){
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

    private void rotateRight(Node x){
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


    private void transplant(Node u, Node v){
        if (u.getParent() == null)
            this.root = v;
        else if (u == u.getParent().getLeft())
            u.getParent().setLeft(v);
        else u.getParent().setRight(v);
    }

    public void delete(int data){
        Node target = search(data);
        Node y = target, x = null;
        int yOriginalColor = y.getColor();
        if (target.getLeft() == null){
            x = target.getRight();
            transplant(target, target.getRight());
        } else if (target.getRight() == null){
            x = target.getLeft();
            transplant(target, target.getLeft());
        } else {
            y = findMinimum(target.getRight());
            yOriginalColor = y.getColor();
            x = y.getRight();
            if (y.getParent() == target && x != null)
                x.setParent(y);
            else {
                transplant(y, y.getRight());
                y.setRight(target.getRight());
                y.getRight().setParent(y);
            }
            transplant(target,y);
            y.setLeft(target.getLeft());
            y.getLeft().setParent(y);
            y.setColor(target.getColor());
        }
        if (yOriginalColor == 1)
            deleteFixup(x);
    }

    private void deleteFixup(Node x) {
        Node sibling = null;
        while (x != null && x != this.root && x.getColor() == 1){
            if (x == x.getParent().getLeft()){
                sibling = x.getParent().getRight();
                if (sibling.getColor() == 0){
                    sibling.setColor(1);
                    x.getParent().setColor(0);
                    rotateLeft(x.getParent());
                    sibling = x.getParent().getRight();
                }
                if ((sibling.getLeft() == null || sibling.getLeft().getColor() == 1 ) && (sibling.getRight() == null
                        || sibling.getRight().getColor() == 1)) {
                    sibling.setColor(0);
                    x = x.getParent();
                } else {
                    if (sibling.getRight() == null || sibling.getRight().getColor() == 1) {
                        sibling.getLeft().setColor(1);
                        sibling.setColor(0);
                        rotateRight(sibling);
                        sibling = x.getParent().getRight();
                    }
                    sibling.setColor(x.getParent().getColor());
                    x.getParent().setColor(1);
                    sibling.getRight().setColor(1);
                    rotateLeft(x.getParent());
                    x = this.root;
                }
            } else {
                sibling = x.getParent().getLeft();
                if (sibling.getColor() == 0){
                    sibling.setColor(1);
                    x.getParent().setColor(0);
                    rotateRight(x.getParent());
                    sibling = x.getParent().getLeft();
                }
                if ((sibling.getLeft() == null || sibling.getLeft().getColor() == 1 ) && (sibling.getRight() == null
                        || sibling.getRight().getColor() == 1)){
                    sibling.setColor(0);
                    x = x.getParent();
                } else {
                    if (sibling.getLeft() == null || sibling.getLeft().getColor() == 1) {
                        sibling.getRight().setColor(1);
                        sibling.setColor(0);
                        rotateLeft(sibling);
                        sibling = x.getParent().getLeft();
                    }
                    sibling.setColor(x.getParent().getColor());
                    x.getParent().setColor(1);
                    sibling.getLeft().setColor(1);
                    rotateRight(x.getParent());
                    x = this.root;
                }
            }
        }
        if (x != null) {
            x.setColor(1);
        }
    }

    public Node findMinimum(){
        return findMinimum(this.root);
    }

    private Node findMinimum(Node rootNode){
        while (rootNode.getLeft() != null)
            rootNode = rootNode.getLeft();
        return rootNode;
    }

    private Node getSuccessor(Node x){
        if (x.getRight() != null)
            return findMinimum(x.getRight());
        Node parent = x.getParent();
        while (parent != null && x == parent.getRight()){
            x = parent;
            parent = parent.getParent();
        }
        return parent;
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
