package akopensource.maindir;

public class BinarySearchTree {

    private Node rootNode;

    public BinarySearchTree(){
        rootNode = null;
    }

    public void addToTree(int key){
        rootNode = addToTree(key, rootNode);
    }

    private Node addToTree(int key, Node rootNode){
        if(rootNode == null) {
            rootNode = new Node(key);
            return rootNode;
        }
        if(key < rootNode.getKey()) {
            rootNode.left = addToTree(key, rootNode.left);
        }
        else if(key > rootNode.getKey())
            rootNode.right = addToTree(key, rootNode.right);

        return rootNode;
    }

    public void traverseInorder (Node rootNode){
        if(rootNode != null){
            traverseInorder(rootNode.getLeft());
            System.out.println(rootNode.getKey());
            traverseInorder(rootNode.getRight());
        }
    }

    public Node getRootNode() {
        return rootNode;
    }
}
