package akopensource.maindir;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomArrays {


    public static int[] generateRandomArray(int size) {
        return generateRandomArray(size, 0, 1000);
    }

    public static int[] generateRandomArray(int size, int origin, int bound) {
        Random random = new Random();
        IntStream intStream = random.ints(size, origin, bound + 1);
        return intStream.toArray();
    }

    // can be done with shuffle method in collections
    public static void shuffleArray(int [] array){
        int len = array.length;
        for(int i = 0; i < len; i++){
            int j = new Random().nextInt(len);
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }
    }

}
