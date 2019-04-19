package akopensource;

import akopensource.btrees.BTree;
import akopensource.btrees.BTreeNode;
import akopensource.graphs.Graph;
import akopensource.hashtables.HashTable;
import akopensource.linkedlist.MyLinkedList;
import akopensource.maindir.*;
import akopensource.rbtrees.RedBlackTree;
import akopensource.sorting.Sortings;
import akopensource.tuples.Pair;

public class Main {

    public static void main(String[] args) {
        //TESTING


        Graph graph = new Graph(6,1);
        graph.insertInAdjList(0, 1);
        graph.insertInAdjList(0, 3);
        graph.insertInAdjList(1, 4);
        graph.insertInAdjList(2, 4);
        graph.insertInAdjList(2, 5);
        graph.insertInAdjList(3, 1);
        graph.insertInAdjList(4, 3);
        graph.insertInAdjList(5, 5);

        //graph.bfs(2);
        graph.dfs();
        System.out.println("----------------");

        graph.printGraphAdjList();
        graph.printVisited();

        /*graph.insertInMatrix(0,1);
        graph.insertInMatrix(0, 4);
        graph.insertInMatrix(1, 2);
        graph.insertInMatrix(1, 3);
        graph.insertInMatrix(1, 4);
        graph.insertInMatrix(2, 3);
        graph.insertInMatrix(3, 4);

        graph.printGraphMatrix();*/


        /*Sortings sortings = new Sortings();
        int [] array = {2,8,7,1,3,5,6,4};
        //sortings.bubbleSortRecursive(array, 0);
        sortings.insertionSortRecursive(array, 1);
        for (int i : array){
            System.out.print(i + " ");
        }*/

        /*Sortings sortings = new Sortings();
        int [] array = {2,8,7,1,3,5,6,4};
        sortings.quickSortIterative(array, 0, 7);
        for (int i : array){
            System.out.print(i + " ");
        }*/


        /*BTree bTree = new BTree(3,10);
        bTree.insert(20);
        bTree.insert(5);
        bTree.insert(6);
        bTree.insert(12);
        bTree.insert(30);
        bTree.insert(7);
        bTree.insert(17);

        bTree.getRoot().traverse();

        Pair pair = bTree.search(7);
        BTreeNode node =(BTreeNode) pair.getFirstElem();

        System.out.println(pair.getFirstElem() + " " + pair.getSecondElem());
        for (int i = 0; i < node.getN(); i++){
            System.out.println(node.getKey(i));
        }

        System.out.println("DELETION-----");
        bTree.delete(20);
        bTree.getRoot().traverse();*/

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
        /*MyLinkedList linkedList = new MyLinkedList();
        linkedList.insertTail(65);
        linkedList.insertTail(25);
        linkedList.insertTail(12);
        linkedList.insertTail(22);
        linkedList.insertTail(11);

        linkedList.printLinkedList();
        System.out.println();
        Sortings sortings = new Sortings();
        sortings.bubbleSortLinkedList(linkedList);
        linkedList.printLinkedList();*/

        // 22 33 4 5 6 7 8 55 3 2 1 6 4

        /*RedBlackTree tree = new RedBlackTree(7);

        tree.insert(3);
        tree.insert(18);
        tree.insert(10);
        tree.insert(22);
        tree.insert(8);
        tree.insert(11);
        tree.insert(26);
        tree.insert(2);
        tree.insert(6);
        tree.insert(13);

        tree.traverseInorder(tree.getRoot());
        System.out.println();
        tree.traverseLevelOrder();

        System.out.println();
        System.out.println("SEARCH: " + tree.search(26).getData());
        System.out.println();

        System.out.println("Deleting 18, 11, 3, 10, 22");

        tree.delete(18);
        //tree.traverseInorder(tree.getRoot());
        //System.out.println();

        tree.delete(11);
        //tree.traverseInorder(tree.getRoot());
        //System.out.println();

        tree.delete(3);
        //tree.traverseInorder(tree.getRoot());
        //System.out.println();

        tree.delete(10);
        //tree.traverseInorder(tree.getRoot());
        //System.out.println();

        tree.delete(22);
        tree.traverseInorder(tree.getRoot());
        System.out.println();
        tree.traverseLevelOrder();*/

        // System.out.println(redBlackTree.search(13));


        /*Sortings sortings = new Sortings();
        int[] array = {5,2,4,7,1,3,2,6};
        sortings.mergeSortRecursively(array,0,7);

        for (int e : array) {
            System.out.print(e + " ");
        }*/



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
