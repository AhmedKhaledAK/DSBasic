package akopensource.maindir;

public class Numbers {
    public static int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }

    //binary gcd algorithm (for large numbers)
    public static int bgcd(int a, int b){
        if(a == b || b == 0)
            return a;
        if(a == 0)
            return b;

        // a and b are even
        if((a & 1) == 0 && (b & 1) == 0)
            return bgcd(a >> 1, b >> 1) << 1;

        // a is even, b is odd
        else if((a & 1) == 0)
            return bgcd(a >> 1, b);

        // a is odd, b is even
        else if ((b & 1) == 0)
            return bgcd(a, b >> 1);

        // a and b are odd, a >= b
        else if(a >= b)
            return bgcd((a-b) >> 1, b);

        // a and b are odd, a < b
        return bgcd(a, (b-a) >> 1);

    }
}
