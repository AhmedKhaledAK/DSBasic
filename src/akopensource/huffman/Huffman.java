package akopensource.huffman;

import java.util.Collections;
import java.util.PriorityQueue;

public class Huffman {

    private Node [] nodes;

    public Huffman(Node[] nodes){
        this.nodes = nodes;
    }

    public Node compress(){
        PriorityQueue<Node> pq = createQueue(this.nodes);
        for(int i =0; i < this.nodes.length -1; i++){
            Node node = new Node();
            Node x = pq.poll();
            Node y = pq.poll();
            node.addLeft(x);
            node.addRight(y);
        }
        return null;
    }


    private PriorityQueue<Node> createQueue(Node[] array) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Collections.addAll(queue, array); // adding all elements in helperArrayMST to queue
        return queue;
    }

}
