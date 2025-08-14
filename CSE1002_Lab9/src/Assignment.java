/**
 * Represents a weighted assignment grade
 *
 * @author (CSE 1002)
 * @version (2/11/2025)
 */
public class Assignment
{
    // instance variables 
    private double weight;
    private double grade;

    /**
     * Constructor for objects of class Quiz
     */
    public Assignment(double wt, double gd)
    {
        // initialise instance variables
        this.weight = wt;
        this.grade = gd;
    }

    /**
     * Getter method for weight
     *
     * @return    value of weight field
     */
    public double getWeight()
    {
        // return weight info
        return this.weight;
    }

    /**
     * Getter method for grade
     *
     * @return value of grade field
     */
    public double getGrade() {
        return this.grade;
    }

    /**
     * Compute weighted grade for this quiz
     *
     * @return value of weighted grade (weight * grade)
     */
    public double getWeightedGrade () {
        return this.weight * this.grade;
    }
}