package akopensource.maindir;

public class Node {
    int key;
    Node left;
    Node right;
    Node parent;
    //Nodes can have data of any type too

    public Node(int key){
        this.key = key;
        left = null;
        right = null;
    }

    public Node  addRight(int key, Node node){
        node.right = new Node(key);
        return node.right;
    }

    public Node addLeft(int key, Node node){
        node.left = new Node(key);
        return node.left;
    }

    public int getKey() {
        return key;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Node getParent() {
        return parent;
    }
}
