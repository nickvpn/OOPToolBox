/**
 * A class to simulate a die that can be rolled.
 * Includes use for integers and integer arrays with dice that have sides less than or greater than 6.
 * Version 2: Adds equals(), roll(), defeats() methods
 * @author (Nicholas Welsh)
 * @version (2)
 */

import java.util.Random;

public class BiasedDie {
    // Private final instances for exclusive use within this class
    private final int[] dieSides;
    private final Random randomNumber;
    int x = 5;
    // Constructor with integer n argument
    public BiasedDie(int n){
        this.randomNumber = new Random();

        this.x = 10;
        this.dieSides = new int[n]; // creating a die with n sides

        // labeling dieSides from 1 to n
        for(int i = 0; i < this.dieSides.length; i++){
            this.dieSides[i] = i+1;
        }
    }

    // Constructor with integer array argument
    public BiasedDie(int[] array){
        this.randomNumber = new Random();
        this.dieSides = new int[array.length]; // creating an array with same length

        // populating the array with same elements as argument array
        for(int i = 0;  i < this.dieSides.length; i++){
            this.dieSides[i] = array[i];
        }
    }

    // Compares two dice, returning true if both dice are exactly equal, and false otherwise
    public boolean equals(BiasedDie otherDie){
        if(this.dieSides.length == otherDie.dieSides.length){ //Check if the lengths of both dice are equal
            int numEqual = 0;
            for(int i = 0; i < this.dieSides.length; i++){
                //Check if corresponding sides of each die are equal
                if(this.dieSides[i] == otherDie.dieSides[i]){
                    numEqual++; // Increment the count of equal sides
                }
            }
            // Check if the number of equal sides equals the length of the dieSides array
            if(numEqual == this.dieSides.length){
                return true;
            } else return false;
        }
        else return false;
    }

    // Simulates a roll by utilizing nextInt() from the Random object
    public int roll(){
        int index = this.randomNumber.nextInt(dieSides.length);
        return this.dieSides[index];
    }

    // Checks whether one die's roll is greater than another die's roll (thus indicating that it defeats the other die)
    public boolean defeats(BiasedDie otherDie){
        if(this.roll() > otherDie.roll()) return true;
        else return false;
    }

    // Overriding default toString for descriptive output of each die
    @Override
    public String toString(){
        String output = "This die has " + this.dieSides.length + " sides:";
        // output the elements of the dieSides array in order
        for(int i = 0; i < this.dieSides.length; i++) {
            output += " " + this.dieSides[i];
        }
        return output;
    }

}
