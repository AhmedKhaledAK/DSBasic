package akopensource.huffman;

public class Node implements Comparable<Node>{
    private char c;
    private Integer freq;
    private Node left;
    private Node right;

    public Node(char c, int freq){
        this.c = c;
        this.freq = freq;
        // the left and right nodes are already null, this is for more illustration
        this.left = null;
        this.right = null;
    }

    Node(){

    }

    void addLeft(Node n){
        this.left = n;
    }

    void addRight(Node n){
        this.right = n;
    }

    public Integer getFreq(){
        return this.freq;
    }

    void addFreq(int freq){
        this.freq = freq;
    }

    public Node getLeft(){
        return this.left;
    }

    public Node getRight(){
        return this.right;
    }

    @Override
    public int compareTo(Node o) {
        return this.getFreq().compareTo(o.getFreq());
    }
}
