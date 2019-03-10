package akopensource.sorting;

import akopensource.linkedlist.MyLinkedList;

public interface Sortable {
    void quickSort(Integer [] array, int p, int r);
    void selectionSortIterative(Integer [] array);
    void selectionSortRecursive(Integer [] array, int index);
    void insertionSortIterative(Integer [] array);
    void insertionSortLinkedList(MyLinkedList linkedList);
    void bubbleSort(Integer [] array);
    void mergeSortRecursively(Integer [] array, int s, int e);
}
