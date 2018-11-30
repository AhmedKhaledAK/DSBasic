package akopensource.sorting;

public class Sortings implements Sortable {

    private int [] sortedArray;

    @Override
    public void quickSort(int[] array, int p, int r) {
        if(p < r){
            int q = partition(array, p, r);
            quickSort(array, p, q-1);
            quickSort(array, q+1, r);
        }
        this.sortedArray = array;
    }

    private int partition(int[] array, int p, int r) {
        int pivot = array[r];
        int i = p-1;
        for (int j = p; j <= r-1; j++){
            if(array[j] <= pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i+1];
        array[i+1] = array[r];
        array[r] = temp;
        return i+1;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }
}
