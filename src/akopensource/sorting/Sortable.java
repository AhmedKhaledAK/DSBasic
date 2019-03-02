package akopensource.sorting;

import akopensource.linkedlist.MyLinkedList;

public interface Sortable {
    void quickSort(int [] array, int p, int r);
    void selectionSortIterative(Integer [] array);
    void selectionSortRecursive(Integer [] array, int index);
    void insertionSortIterative(Integer [] array);
    void insertionSortLinkedList(MyLinkedList linkedList);
}
