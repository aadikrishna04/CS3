package U04_Recursion_10_Snowflake;

public class RecursionProbs {
    public double sumReciprocals(int n) {
        if (n == 1) {
            return n;
        } else {
            return (1 / (double) n) + sumReciprocals(n - 1);
        }
    }

    // Int reaches max value earlier so return type changed to long
    public long productOfEvens(int n) {
        if (n <= 1) {
            return 2;
        } else {
            return (2 * n) * productOfEvens(n - 1);
        }
    }

    public String conversion(int num, int base) {
        if (num == 0) {
            return "";
        } else {
            return conversion(num / base, base) + num % base;
        }
    }

    public int matchingDigits(int a, int b) {
        
    }
}
