package akopensource.maindir;

public class Heap {

    private Integer [] heap;
    private int size;

    public Heap(Integer[] heap) {
        this.heap = heap;
        this.size = heap.length-1;
    }

    public void sort() {
        buildMax();
        for(int i = heap.length - 1; i >= 2; i--){
            int temp = heap[1];
            heap[1] = heap[i];
            heap[i] = temp;
            size -= 1;
            maxHeapify(1);
        }
    }

    public void buildMax() {
        size = heap.length-1;
        for (int i = heap.length/ 2; i > 1; i--){
            maxHeapify(i-1);
        }
    }

    public void maxHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest;

        if(l <= size && heap[l] >= heap[i])
            largest = l;
        else largest = i;
        if(r <= size && heap[r] >= heap[largest])
            largest = r;
        if(largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            maxHeapify(largest);
        }
    }



    public int right(int i) {
        return 2*i+1;
    }

    public int left(int i) {
        return 2*i;
    }

}
