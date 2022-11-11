package U04_Recursion_10_Snowflake;

public class Runner {
    public static void main(String[] args) {
        RecursionProbs r = new RecursionProbs(); // Create RecursionProbs object for testing

        System.out.println("Sum reciprocals >>> " + r.sumReciprocals(10)); // Test sumReciprocals method

        System.out.println("Product of n evens >>> " + r.productOfEvens(10)); // Test productOfEvens method

        System.out.println("Conversion >>> " + r.conversion(10, 2)); // Test conversion method
        System.out.println("Conversion >>> " + r.conversion(1453, 8)); // Test conversion method

        System.out.println("Check digits >>> " + r.matchingDigits(1000, 0)); // Test matchingDigits method
    }
}
