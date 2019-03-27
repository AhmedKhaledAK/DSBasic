package akopensource;

import akopensource.btrees.BTree;
import akopensource.hashtables.HashTable;
import akopensource.linkedlist.MyLinkedList;
import akopensource.maindir.*;
import akopensource.rbtrees.RedBlackTree;
import akopensource.sorting.Sortings;

public class Main {

    public static void main(String[] args) {
        //TESTING


        BTree bTree = new BTree(3,10);
        bTree.insert(10);
        bTree.insert(20);
        bTree.insert(5);
        bTree.insert(6);
        bTree.insert(12);
        bTree.insert(30);
        bTree.insert(7);
        bTree.insert(17);

        bTree.getRoot().traverseBTree();


        /*HashTable hashTable = new HashTable(10);
        hashTable.chainedHashInsert(25);
        hashTable.chainedHashInsert(23);
        hashTable.chainedHashInsert(9);
        hashTable.chainedHashInsert(25);
        hashTable.chainedHashInsert(25);
        hashTable.chainedHashInsert(9);

        hashTable.printHashTable();*/

        /*Sortings sortings = new Sortings();
        int [] array = {65, 25, 12, 22, 11};
        //sortings.selectionSortIterative(array);
        sortings.insertionSortIterative(array);
        for (int e: array) {
            System.out.print(e+" ");
        }*/


        /*Sortings sortings = new Sortings();

        for(int i = 10; i < 15; i++){
            System.out.printf("SIZE %d ---------\n", i);
            int [] array = RandomArrays.generateRandomArray(i);
            System.out.println("QUICK SORT --");
            sortings.quickSort(array, 0, array.length-1);
            System.out.println("ARRAY---");
            for (int e : array) {
                System.out.print(e + " ");
            }
            RandomArrays.shuffleArray(array);
            System.out.println();

            System.out.println("INSERTION SORT --");
            sortings.insertionSortIterative(array);
            System.out.println("ARRAY---");
            for (int e : array) {
                System.out.print(e + " ");
            }
            RandomArrays.shuffleArray(array);
            System.out.println();

            System.out.println("SELECTION SORT --");
            sortings.selectionSortIterative(array);
            System.out.println("ARRAY---");
            for (int e : array) {
                System.out.print(e + " ");
            }
            RandomArrays.shuffleArray(array);
            System.out.println();

            System.out.println("MERGE SORT --");
            sortings.mergeSortRecursively(array, 0, array.length-1);
            System.out.println("ARRAY---");
            for (int e : array) {
                System.out.print(e + " ");
            }
            RandomArrays.shuffleArray(array);
            System.out.println();

            System.out.println("HEAP SORT");
            sortings.heapSort(array);
            System.out.println("ARRAY---");
            for (int e : array) {
                System.out.print(e + " ");
            }
            RandomArrays.shuffleArray(array);
            System.out.println();
        }
*/
       /* MyLinkedList linkedList = new MyLinkedList();
        linkedList.insertTail(65);
        linkedList.insertTail(25);
        linkedList.insertTail(12);
        linkedList.insertTail(22);
        linkedList.insertTail(11);

        linkedList.printLinkedList();
        System.out.println();
        Sortings sortings = new Sortings();
        sortings.insertionSortLinkedList(linkedList);
        linkedList.printLinkedList();*/


        /*RedBlackTree redBlackTree = new RedBlackTree(41);
        redBlackTree.insert(38);
        redBlackTree.insert(31);
        redBlackTree.insert(12);
        redBlackTree.insert(19);
        redBlackTree.insert(8);

        redBlackTree.traverseInorder(redBlackTree.getRoot());*/


        /*Sortings sortings = new Sortings();
        int[] array = {5,2,4,7,1,3,2,6};
        sortings.mergeSortRecursively(array,0,7);

        for (int e : array) {
            System.out.print(e + " ");
        }
*/
        /* HEAP TEST */

        /*int [] hp = {0,0,6,5,20,30,1,5,2,3,4};

        //Heap heap = new Heap(hp);

        Sortings sortings = new Sortings();
        sortings.heapSort(hp);

        for(int i = 0; i < hp.length; i++){
            System.out.print(hp[i] + " ");
        }*/

        /*Quicksort Test */

        /*int [] array = {2,8,7,1,3,5,6,4};
        Sortings sortings = new Sortings();
        sortings.quickSort(array, 0, 7);
        for (int i : array){
            System.out.print(i + " ");
        }*/

        //TEST BST

        /*BinarySearchTree bst = new BinarySearchTree();
        bst.addToTree(50);
        bst.addToTree(30);
        bst.addToTree(20);
        bst.addToTree(40);
        bst.addToTree(70);
        bst.addToTree(60);
        bst.addToTree(80);

        bst.traverseInorder(bst.getRootNode());

        System.out.println("------------");
        Node n = bst.findMaximum();
        System.out.println(n.getData());*/

        //System.out.println(Numbers.bgcd(99, 78));

        /*Triplet triplet = Numbers.extendedEuclid(99,78);
        System.out.println(triplet.getFirstElem());
        System.out.println(triplet.getSecondElem());
        System.out.println(triplet.getThirdElem());
*/
    }
}
