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

    // bottom-up approach for longest common sub-sequence
    public static int LCS(String s1, String s2){
        int [][] table = new int [s1.length()+1][s2.length()+1];
        for(int i = 0; i <= s1.length(); i++){
            for(int j = 0; j <= s2.length(); j++){
                if(i==0 || j==0) table[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1)) table[i][j] = 1 + table[i-1][j-1];
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


    // longest palindromic sub-sequence
    public static int LPS(String s){
        int [][]table = new int [s.length()][s.length()];
        for (int i =0; i < s.length(); i++)
            table[i][i] = 1;
        for(int i = 2; i <= s.length(); i++){
            for(int j = 0; j < s.length()-i+1; j++){
                int l = j+i-1;
                boolean b = s.charAt(j) == s.charAt(l);
                if(i==2 && b)
                    table[j][l] = 2;
                else if(b)
                    table[j][l] = table[j+1][l-1] + 2;
                else table[j][l] = Integer.max(table[j+1][l], table[j][l-1]);
            }
        }
        return table[0][s.length()-1];
    }

    // longest common substring
    public static int LCSubstring(String s1, String s2){
        int [][] table = new int[s1.length()+1][s2.length()+1];
        int max=0;
        for(int i =0; i <= s1.length(); i++){
            for(int j=0; j <=s2.length(); j++){
                if(i==0 || j ==0)
                    table[i][j] = 0;
                else if (s1.charAt(i-1) == s2.charAt(j-1))
                    table[i][j] = 1 + table[i-1][j-1];
                else table[i][j] = 0;
                max=Integer.max(max,table[i][j]);
            }
        }

        return max;
    }

    // rod-cutting problem (not DP)
    public static int cutRodNotDP(int [] prices, int n){
        if(n==0) return 0;
        int q = Integer.MIN_VALUE;
        for(int i = 1; i <=n; i++){
            q = Integer.max(q,cutRodNotDP(prices,n-i) + prices[i]);
        }
        return q;
    }

    // bottom-up approach for rod-cutting problem
    public static int cutRod(int [] prices, int n){
        int [] maxPrices = new int[n+1];
        maxPrices[0] = 0;
        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <=i; j++){
                q = Integer.max(q, maxPrices[i-j] + prices[j]);
            }
            maxPrices[i] = q;
        }
        return maxPrices[n];
    }

    // top-down approach for rod-cutting problem
    public static int cutRodRecursive(int [] prices, int n){
        int [] maxPrices = new int[n+1];
        for(int i = 0; i < maxPrices.length; i++){
            maxPrices[i] = Integer.MIN_VALUE;
        }
        return cutRodRecursive(prices,n, maxPrices);
    }

    private static int cutRodRecursive(int[] prices, int n, int[] maxPrices) {
        if(maxPrices[n]>=0) return maxPrices[n];
        int q =0;
        if(n==0) q=0;
        else {
            q = Integer.MIN_VALUE;
            for (int i =1; i <= n; i++){
                q = Integer.max(q,cutRodRecursive(prices,n-i, maxPrices)+prices[i]);
            }
        }
        maxPrices[n] = q;
        return q;
    }

    // bottom-up approach for Longest increasing sub-sequence problem
    public static int LIS(int [] ar){
        int [] T = new int [ar.length];
        for(int i = 0; i < ar.length; i++){
            T[i] = 1;
        }
        int max = Integer.MIN_VALUE;
        for(int i =0; i < ar.length; i++) {
            for (int j = 0; j < i; j++) {
                if (ar[i] > ar[j] && T[i] < T[j] + 1) {
                    T[i] = T[j] + 1;
                    max = Integer.max(max, T[i]);
                }
            }
        }
        return max;
    }

}
