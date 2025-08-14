public class RationalClient {
    public static void main(String[] args) {
        Rational zero = new Rational(0,1); // Testing default constructor; object represents 0/1
        Rational oneHalf = new Rational(1,2); // Object to represent one half
        Rational fourSixths = new Rational(4,6); // Object to represent four-sixths (this gives us a chance to test the reduce method as well)

        // Test toString() and toDouble(); also tests that values are correct for the objects
        System.out.println("This is zero: " + zero);
        System.out.println("This is one half: " + oneHalf);
        System.out.println("This is four-sixths: " + fourSixths);
        System.out.println("Four-sixths can be reduced to: " + fourSixths.reduce());

        //Test operators
        Rational sum = oneHalf.add(fourSixths);  // sum contains 7/6
        Rational prod = oneHalf.multiply(fourSixths); // prod contains 1/3 (1/2 * 4/6 = 4/12 = 1/3)
        Rational diff = oneHalf.subtract(fourSixths); // diff is -1/6
        Rational quot = oneHalf.divide(fourSixths); //quotient is 3/4
        System.out.println("This is the sum of those two numbers (7/6): " + sum);
        System.out.println("This is the product of those two numbers (1/3): " + prod);
        System.out.println("This is the difference of those two numbers (-1/6): " + diff);
        System.out.println("This is the quotient of those two numbers (3/4): " + quot);

        System.out.println();
        // Test invert on sum
        sum.invert();
        System.out.println("Here is the sum inverted (6/7): " + sum);

        // Test negate on prod
        prod.negate();
        System.out.println("Here is the product negated (-1/3): " + prod);
    }
}
