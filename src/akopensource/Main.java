package akopensource;

import akopensource.linkedlist.MyLinkedList;
import akopensource.maindir.*;
import akopensource.rbtrees.RedBlackTree;
import akopensource.sorting.Sortings;

public class Main {

    public static void main(String[] args) {
        //TESTING

        /*Sortings sortings = new Sortings();
        Integer [] array = {65, 25, 12, 22, 11};
        //sortings.selectionSortIterative(array);
        sortings.insertionSortIterative(array);
        for (int e: array) {
            System.out.print(e+" ");
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


       /* Sortings sortings = new Sortings();
        Integer[] array = {5,2,4,7,1,3,2,6};
        sortings.mergeSortRecursively(array,0,7);

        for (int e : array) {
            System.out.print(e + " ");
        }*/

        /* HEAP TEST */

        Integer [] hp = {0,6,5,20,12,30,1,5,5,2,3,4};

        Heap heap = new Heap(hp);

        heap.sort();

        for(int i = 1; i < hp.length; i++){
            System.out.print(hp[i] + " ");
        }

        /*Quicksort Test */

        /*int [] array = {2,8,7,1,3,5,6,4};
        Sortings sortings = new Sortings();
        sortings.quickSort(array, 0, 7);
        array = sortings.getSortedArray();
        for (int i : array){
            System.out.print(i + " ");
        }
*/

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
        System.out.println(n.getKey());*/

        //System.out.println(Numbers.bgcd(99, 78));

        /*Triplet triplet = Numbers.extendedEuclid(99,78);
        System.out.println(triplet.getFirstElem());
        System.out.println(triplet.getSecondElem());
        System.out.println(triplet.getThirdElem());
*/
    }
}
