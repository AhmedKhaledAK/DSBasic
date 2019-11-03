package akopensource.DP;

public class DP {

    // bottom-up approach
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

    // bottom-up approach
    public static int LCS(String s1, String s2){
        int [][] table = new int [s1.length()+1][s2.length()+1];
        for(int i = 0; i <= s1.length(); i++){
            for(int j = 0; j <= s2.length(); j++){
                if(i==0 || j==0) table[i][j] = 0;
                else if(s1.charAt(i-1) == s1.charAt(j-1)) table[i][j] = 1 + table[i-1][j-1];
                else table[i][j] = Integer.max(table[i][j-1], table[i-1][j]);
            }
        }

        return table[s1.length()][s2.length()];
    }

    public static int LCSNotDP(String s1, String s2, int i, int j){
        if(i==0 || j==0) return 0;
        if(s1.charAt(i-1) == s2.charAt(j-1)) return 1 + LCSNotDP(s1,s2,i-1,j-1);
        return Integer.max(LCSNotDP(s1,s2,i-1, j), LCSNotDP(s1,s2,i,j-1));
    }

}
