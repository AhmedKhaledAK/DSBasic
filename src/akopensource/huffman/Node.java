package akopensource.huffman;

public class Node implements Comparable<Node>{
    private char c;
    private Integer freq;
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

    Integer getFreq(){
        return this.freq;
    }

    @Override
    public int compareTo(Node o) {
        return this.getFreq().compareTo(o.getFreq());
    }
}
