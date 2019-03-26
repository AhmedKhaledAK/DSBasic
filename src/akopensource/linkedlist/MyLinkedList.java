package akopensource.linkedlist;

public class MyLinkedList {
    Node head, tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    //These methods can actually be minimized to one method only. I'm splitting insertion into
    // three methods just for educational purposes.

    public Node insertInMiddle(Node n, int key){
        if(head == null || tail == null)
            return initializeLinkedList(key);
        Node newNode = new Node(key);
        newNode.next = n.next;
        n.next = newNode;
        newNode.previous = n;
        newNode.next.previous = newNode;
        return newNode;
    }

    public Node insertHead(int key){
        if(head != null)
            return insertInMiddle(head, key);
        return initializeLinkedList(key);
    }

    public Node insertTail(int key){
        if(tail != null)
            return insertInMiddle(tail.previous, key);
        return initializeLinkedList(key);
    }

    private Node initializeLinkedList(int key){
        head = new Node();
        tail = new Node();
        Node newNode = new Node(key);
        head.next = newNode;
        newNode.previous = head;
        newNode.next = tail;
        tail.previous = newNode;
        return newNode;
    }

    public void printLinkedList(){
        Node n = head.next;
        while(n != tail){
            System.out.print(n.data +" ");
            n = n.next;
        }
        System.out.println();
    }

    public Node getHead(){
        return head.next;
    }

    public Node getHeadNode(){
        return head;
    }

    public Node getTail(){
        return tail.previous;
    }

    public Node getTailNode(){
        return tail;
    }
}
