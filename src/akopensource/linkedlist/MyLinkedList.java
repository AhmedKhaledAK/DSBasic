package akopensource.linkedlist;

public class MyLinkedList {
    Node head, tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

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
            System.out.println(n.key);
            n = n.next;
        }
    }

    public Node getHead(){
        return head.next;
    }

    public Node getTail(){
        return tail.previous;
    }
}
