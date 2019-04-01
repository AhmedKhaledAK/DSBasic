package akopensource.sorting;

import akopensource.linkedlist.MyLinkedList;

public interface Sortable {
    void quickSort(int [] array, int p, int r);
    void quickSortIterative(int [] array, int p, int r);
    void selectionSortIterative(int [] array);
    void selectionSortRecursive(int [] array, int index);
    void insertionSortIterative(int [] array);
    void insertionSortLinkedList(MyLinkedList linkedList);
    void bubbleSort(int [] array);
    void bubbleSortRecursive(int [] array, int index);
    void mergeSortRecursively(int [] array, int s, int e);
    void heapSort(int [] array);
}
