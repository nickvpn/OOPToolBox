/**
 * A Driver for the BiasedDie Class (Assignment 3b) in order to test the equals(), roll(), and defeats() methods.
 *
 * @author (Nicholas Welsh)
 * @version (1)
 */

import java.util.Scanner;
public class BDDriverB
{
    public static void main(String[] args) {
        //scanner object for user input
        Scanner kb = new Scanner(System.in);

        //title with my name
        System.out.println("Driver program for BiasedDie.java - By Nicholas Welsh for CSE1002");
        System.out.println();

        // create a normal die with 6 sides and its copy
        BiasedDie normalDie = new BiasedDie(6);
        System.out.println(normalDie.x);
        normalDie.roll();
        BiasedDie normalDieCopy = new BiasedDie(6);

        // create a "strange" die using an array of sides
        int[] strangeDieSides = {2, 4, 5, 6, 7, 8};
        BiasedDie strangeDie = new BiasedDie(strangeDieSides);

        // demonstration of the equals() method with different and identical sides
        System.out.println("Demonstration of equals() method:");
        System.out.println();
        System.out.println(normalDie);
        System.out.println(strangeDie);

        // Compare normalDie and strangeDie (which should not be equal since their sides differ)
        System.out.println("True or False, These two dice are equal to each other: " + normalDie.equals(strangeDie));
        System.out.println();

        // Compare normalDie and its copy (which should be equal as they have identical sides)
        System.out.println(normalDie);
        System.out.println(normalDieCopy);
        System.out.println("True or False, These two dice are equal to each other: " + normalDie.equals(normalDieCopy));
        System.out.println();
        System.out.println();

        // demonstration of the intransitive property among three differently configured dice
        System.out.println("Demonstration of three dice being 'intransitive':");

        // Set up three dice: Die's A, B, and C, with side values from the article:
        // "Mathematicians Roll Dice and Get Rock-Paper-Scissors" - Kristina Armitage/Quanta Magazine
        int[] dieASides = {3, 3, 3, 3, 3, 6};
        int[] dieBSides = {2, 2, 2, 5, 5, 5};
        int[] dieCSides = {1, 4, 4, 4, 4, 4};

        //create each die using the array constructor
        BiasedDie dieA = new BiasedDie(dieASides);
        BiasedDie dieB = new BiasedDie(dieBSides);
        BiasedDie dieC = new BiasedDie(dieCSides);

        //output of all three die
        System.out.println();
        System.out.println("Die A, " + dieA);
        System.out.println("Die B, " + dieB);
        System.out.println("Die C, " + dieC);
        System.out.println();

        // prompt the user for the number of games each pair of dice will compete in
        System.out.print("Enter number of games each die will play against each other: ");
        int num = kb.nextInt();

        // Variables to track wins for each die
        int aWins = 0; //number of games where Die A beats Die B
        int bWins = 0; //number of games where Die B beats Die C
        int cWins = 0; //number of games where Die C beats Die A

        //simulate a series of games where each match-up outcome is determined by the dice roll
        for(int i = 0; i < num; i++){
            if(dieA.defeats(dieB)) aWins++;
            if(dieB.defeats(dieC)) bWins++;
            if(dieC.defeats(dieA)) cWins++;
        }

        // Calculate the win percentage for each match-up by converting wins to a percentage
        double aWinPercentage = ((double) aWins /num) * 100; //note: cast as double
        double bWinPercentage = ((double) bWins /num) * 100;
        double cWinPercentage = ((double) cWins /num) * 100;

        //print the number of games played and the win percentages for each match-up
        System.out.println("Number of times games played: " + num);
        System.out.printf("A beats B %.3f %% of the time.%n", aWinPercentage);
        System.out.printf("B beats C %.3f %% of the time.%n", bWinPercentage);
        System.out.printf("C beats A %.3f %% of the time.%n", cWinPercentage);

    }
}