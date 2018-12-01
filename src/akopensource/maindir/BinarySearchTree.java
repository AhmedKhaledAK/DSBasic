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

    public Node search(int key){
        return search(key, rootNode);
    }

    //we can rewrite this procedure in an iterative fashion by "unrolling" the recursion into a while loop
    //On most computers, the iterative version is more efficient
    private Node search(int key, Node rootNode){
        if(rootNode == null || key == rootNode.getKey())
            return rootNode;
        if(key < rootNode.getKey())
            return search(key, rootNode.left);
        return search(key, rootNode.right);
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
