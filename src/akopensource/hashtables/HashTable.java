package akopensource.hashtables;

import akopensource.linkedlist.MyLinkedList;

public class HashTable {
    private MyLinkedList [] array;

    public HashTable(MyLinkedList[] array) {
        this.array = array;
    }

    public HashTable(int size) {
        this.array = new MyLinkedList[size];
    }

    public void chainedHashInsert(int data){
        int index = hashIndex(data);
        if(array[index] == null)
            array[index] = new MyLinkedList();
        array[index].insertTail(data);
    }

    // Since the linked list is doubly linked list
    // we can make deletion on O(1) time by sending the node itself to the function
    // and since we have its pointers, we can delete it easliy in O(1) time.

    private int hashIndex(int data) {
        return data % array.length;
    }

    public void printHashTable(){
        int i = 0;
        for(MyLinkedList ll : array){
            if(ll == null)
                System.out.println(i + ": NULL");
            else {
                System.out.print(i + ": ");
                ll.printLinkedList();
            }
            i++;
        }
    }
}
