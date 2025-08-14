// Nicholas Welsh Lab 19
// The purpose of this lab is to analyze the BinarySearch algorithm using a timeTrial method.

import java.util.Arrays;
import java.util.Random;

public class AnalysisAlgorithms2 {

    public static int countOps;

    public static int binarySearch(int [] numbers, int key) {
        int mid;
        int low;
        int high;

        low = 0;
        high = numbers.length - 1;
        countOps = 0;

        while (high >= low) {
            mid = (high + low) / 2;
            countOps++;
            if (numbers[mid] < key) {
                low = mid + 1;
            } else if (numbers[mid] > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1; // not found
    }

    public static int timeTrial(int n){
        int[] newArray = new int[n];

        Random random = new Random();

        for(int i = 0; i < newArray.length; i++){
            newArray[i] = random.nextInt(n);
        }

        Arrays.sort(newArray);

        int key = random.nextInt(n);

        binarySearch(newArray, key);

        return countOps;
    }

    public static void main(String[] args){

        System.out.println("Nicholas Welsh: Running Time Trials...");
        for(int i = 64; i <= 100000; i*=2){

            System.out.println("n: " + i + ", count: " + timeTrial(i));
        }
        System.out.println();

    }

}
