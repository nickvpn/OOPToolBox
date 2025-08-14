//Nicholas Welsh April 1, 2025

import java.util.Random;

public class AnalysisAlgorithms3 {
    public static int countOps;

    private static void insertionSort(int[] numbers) {
        countOps = 0;
        for (int i = 1; i < numbers.length; i++) {
            int j = i;
            countOps += 2;
            while (j > 0 && numbers[j] < numbers[j - 1]) {
                // Swap numbers[j] and numbers [j - 1]
                int temp = numbers[j];
                numbers[j] = numbers[j - 1];
                numbers[j - 1] = temp;
                j--;
                countOps += 10;
            }
        }
    }


    public static int timeTrial(int n){
        int[] newArray = new int[n];

        Random random = new Random();

        for(int i = 0; i < newArray.length; i++){
            newArray[i] = random.nextInt(n);
        }

        insertionSort(newArray);

        return countOps;
    }

    public static void main(String[] args){
        int[] test1 = {4, 2, 7, 9, 11, 3};
        int[] test2 = {15, 10, 6, 16, 12, 4, 2};

        int current;
        double previous = timeTrial(32);

        for(int i = 64; i <= 20000; i *= 2){
            current = timeTrial(i);
            System.out.printf("%7d %11d %4.3f\n", i, current , current/previous);
            previous = current;
        }
    }
}
