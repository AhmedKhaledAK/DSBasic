package akopensource.huffman;

public class Node {
    private char c;
    private int freq;
    private Node left;
    private Node right;

    public Node(char c, int freq){
        this.c = c;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }

    void addLeft(Node n){
        this.left = n;
    }

    void addRight(Node n){
        this.right = n;
    }

    int getFreq(){
        return this.freq;
    }

}
