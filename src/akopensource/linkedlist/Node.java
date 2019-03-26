package akopensource.linkedlist;

public class Node {
    int data;
    Node next;
    Node previous;

    public Node(int data) {
        this.data = data;
        next = null;
        previous = null;
    }
    public Node(int data, Node next, Node previous){
        this.data = data;
        this.next = next;
        this.previous=previous;
    }

    public Node(){
        next = null;
        previous = null;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
