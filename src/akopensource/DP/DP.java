package akopensource.DP;

public class DP {

    public static long fibonacci(int n){
        long [] fib = new long [n];
        fib[0]=1;
        fib[1]=1;
        for (int i =2; i < n; i++)
            fib[i] = fib[i-1] + fib[i-2];
        return fib[n-1];
    }

    public static long fibonacciNotDP(int n){
        if(n<2) return 1;
        return fibonacciNotDP(n-1) + fibonacciNotDP(n-2);
    }
}
