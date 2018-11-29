package akopensource;

import akopensource.maindir.Heap;

public class Main {

    public static void main(String[] args) {
        //TESTING

        /* HEAP TEST */
        Integer [] hp = {0,6,5,20,12,30,1,5,5,2,3,4};

        Heap heap = new Heap(hp);

        heap.sort();

        for(int i = 1; i < hp.length; i++){
            System.out.print(hp[i] + " ");
        }
    }
}
