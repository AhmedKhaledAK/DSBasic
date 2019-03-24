package akopensource.maindir;

public class Heap {

    private int [] heap;
    private int size;

    public Heap(int[] heap) {
        this.heap = heap;
        this.size = heap.length-1;
    }

    public void sort() {
        buildMax();
        for(int i = heap.length - 1; i > 0; i--){
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            size -= 1;
            maxHeapify(0);
        }
    }

    public void buildMax() {
        size = heap.length-1;
        for (int i = size/ 2; i >= 0; i--){
            maxHeapify(i);
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



    private int right(int i) {
        return 2*i+2;
    }

    private int left(int i) {
        return 2*i+1;
    }

}
