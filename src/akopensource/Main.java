package akopensource;

import akopensource.maindir.BinarySearchTree;
import akopensource.maindir.Heap;
import akopensource.maindir.Node;
import akopensource.sorting.Sortings;

public class Main {

    public static void main(String[] args) {
        //TESTING

        /* HEAP TEST */

        /*Integer [] hp = {0,6,5,20,12,30,1,5,5,2,3,4};

        Heap heap = new Heap(hp);

        heap.sort();

        for(int i = 1; i < hp.length; i++){
            System.out.print(hp[i] + " ");
        }*/

        /*Quicksort Test */

        /*int [] array = {2,8,7,1,3,5,6,4};
        Sortings sortings = new Sortings();
        sortings.quickSort(array, 0, 7);
        array = sortings.getSortedArray();
        for (int i : array){
            System.out.print(i + " ");
        }
*/
        BinarySearchTree bst = new BinarySearchTree();
        bst.addToTree(50);
        bst.addToTree(30);
        bst.addToTree(20);
        bst.addToTree(40);
        bst.addToTree(70);
        bst.addToTree(60);
        bst.addToTree(80);

        bst.traverseInorder(bst.getRootNode());
    }
}
