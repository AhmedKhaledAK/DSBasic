package akopensource.linkedlist;

import java.util.LinkedList;

public class Node {
    int key;
    Node next;
    Node previous;

    public Node(int key) {
        this.key = key;
        next = null;
        previous = null;
    }
    public Node(int key, Node next, Node previous){
        this.key = key;
        this.next = next;
        this.previous=previous;
    }

    public Node(){
        next = null;
        previous = null;
    }

    public int getKey() {
        return key;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
