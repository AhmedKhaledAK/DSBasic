package akopensource.sorting;

import akopensource.linkedlist.MyLinkedList;
import akopensource.linkedlist.Node;
import akopensource.maindir.Heap;
import akopensource.maindir.Utilities;

public class Sortings implements Sortable {

    /* TODO: quicksort iterative and mergesort iterative*/

    @Override
    public void quickSort(int[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            quickSort(array, p, q - 1);
            quickSort(array, q + 1, r);
        }
    }

    private int partition(int[] array, int p, int r) {
        int pivot = array[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[r];
        array[r] = temp;
        return i + 1;
    }

    @Override
    public void selectionSortIterative(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int min = Integer.MAX_VALUE;
            int mini = -1;
            for (int j = i; j < length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    mini = j;
                }
            }
            Integer temp = array[i];
            array[i] = array[mini];
            array[mini] = temp;
        }
    }

    @Override
    public void selectionSortRecursive(int[] array, int index) {
        if (index == array.length - 1) return;
        int mini = Utilities.findMinimumRecursive(array, index, Integer.MAX_VALUE, -1);
        Integer temp = array[index];
        array[index] = array[mini];
        array[mini] = temp;
        selectionSortRecursive(array, index + 1);
    }

    @Override
    public void insertionSortIterative(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int k = array[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (k < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = k;
        }
    }

    @Override
    public void insertionSortLinkedList(MyLinkedList linkedList) {
        Node head = linkedList.getHead().getNext();

        while (head != linkedList.getTailNode()) {
            int key = head.getData();
            Node n = head.getPrevious();
            while (n != linkedList.getHeadNode()) {
                if (key < n.getData()) {
                    n.getNext().setData(n.getData());
                } else {
                    break;
                }
                n = n.getPrevious();
            }
            n.getNext().setData(key);
            head = head.getNext();
        }
    }

    @Override
    public void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
    }

    @Override
    public void mergeSortRecursively(int[] array, int s, int e) {
        if (s < e) {
            int m = (s + e) / 2;
            mergeSortRecursively(array, s, m);
            mergeSortRecursively(array, m + 1, e);
            merge(array, s, m, e);
        }
    }

    @Override
    public void heapSort(int[] array) {
        Heap heap = new Heap(array);
        heap.sort();
    }

    private void merge(int[] array, int s, int m, int e) {
        int[] aLow = new int[m - s + 1], aHigh = new int[e - m];
        int k = s;
        for (int i = 0; i < aLow.length; i++)
            aLow[i] = array[k++];
        k = m + 1;
        for (int i = 0; i < aHigh.length; i++)
            aHigh[i] = array[k++];
        k = s;
        int i = 0, j = 0;
        while (i < aLow.length && j < aHigh.length) {
            if (aLow[i] <= aHigh[j])
                array[k++] = aLow[i++];
            else
                array[k++] = aHigh[j++];
        }

        while (i < aLow.length)
            array[k++] = aLow[i++];

        while (j < aHigh.length)
            array[k++] = aHigh[j++];
    }
}
