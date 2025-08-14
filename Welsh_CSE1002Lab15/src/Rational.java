// Nicholas Welsh 3/06/2025
// The purpose of this class is to represent rational numbers and their basic operations on them.

public class Rational {
    private int numerator;
    private int denominator;

    // recursive to be used only in reduce() method
    private static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a % b);
    }

    // constructor
    public Rational(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // inverts a fraction
    public void invert(){
        int temp = this.numerator;
        this.numerator = this.denominator;
        this.denominator = temp;
    }

    // switches the fraction's sign
    public void negate(){
        this.numerator = -this.numerator;
    }

    // reduce a fraction to simplest form
    public Rational reduce(){
        Rational reducedFraction = new Rational(this.numerator, this.denominator);
        int gcd = gcd(reducedFraction.numerator, reducedFraction.denominator);
        reducedFraction.numerator /= gcd;
        reducedFraction.denominator /= gcd;

        if(reducedFraction.denominator < 0){ // check if the denominator is negative
            reducedFraction.negate();
            reducedFraction.denominator = -reducedFraction.denominator;
        }

        return new Rational(reducedFraction.numerator, reducedFraction.denominator);
    }

    // adds two fractions
    public Rational add(Rational fraction){
        int newNumerator = this.numerator * fraction.denominator + fraction.numerator * this.denominator;
        int newDenominator = this.denominator * fraction.denominator;
        return new Rational(newNumerator, newDenominator).reduce();
    }

    // subtracts two fractions
    public Rational subtract(Rational fraction){
        int newNumerator = this.numerator * fraction.denominator - fraction.numerator * this.denominator;
        int newDenominator = this.denominator * fraction.denominator;
        return new Rational(newNumerator, newDenominator).reduce();
    }

    // multiplies two fractions
    public Rational multiply(Rational fraction) {
        int newNumerator = this.numerator * fraction.numerator;
        int newDenominator = this.denominator * fraction.denominator;
        return new Rational(newNumerator, newDenominator).reduce();
    }

    // divides two fractions
    public Rational divide(Rational fraction){
        int newNumerator = this.numerator * fraction.denominator;
        int newDenominator = this.denominator * fraction.numerator;
        return new Rational(newNumerator, newDenominator).reduce();
    }

    /* another way to do divide()
    public Rational divide(Rational other) {
        Rational divisor = new Rational(other.denominator, other.numerator);
        return this.multiply(divisor.reduce();
    }
     */

    // format toString for each fraction (add the / bar)
    @Override
    public String toString(){
        return this.numerator + "/" + this.denominator;
    }
}
