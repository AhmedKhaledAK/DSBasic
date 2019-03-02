package akopensource.maindir;

public class Utilities {
    public static int findMinimumRecursive(Integer [] array, int index, int min, int mini){
        if(index == array.length) return mini;
        if(array[index] < min){
            min = array[index];
            mini = index;
        }
        return findMinimumRecursive(array, index+1, min, mini);
    }
}
