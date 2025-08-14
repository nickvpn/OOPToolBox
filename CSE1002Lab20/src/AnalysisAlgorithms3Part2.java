// Nicholas Welsh April 1, 2025

public class AnalysisAlgorithms3Part2 {

    public static int iterCount = 1; // for counting the amount of traces for output

    private static void insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            printHelper(numbers);
            iterCount++;
            int j = i;
            while (j > 0 && numbers[j] < numbers[j - 1]) {
                // Swap numbers[j] and numbers [j - 1]
                int temp = numbers[j];
                numbers[j] = numbers[j - 1];
                numbers[j - 1] = temp;
                j--;
            }

        }
        printHelper(numbers);
    }

    public static void printHelper(int[] arr){
        //helper for output
        int j = 0; // fix double final element
        for(int i = 0; i < arr.length-1; i++){

            if((i - 1) < 0){
                if(iterCount < 10) System.out.print("Trace  " + (iterCount) + ": [");
                else System.out.print("Trace " + (iterCount) + ": [");
            }

            System.out.print(arr[i] + ",");

            j++;
        }
        if((j + 1) == arr.length){
            System.out.print(arr[j] + "]");
        }

        System.out.println();
    }

    public static void main(String[] args){
        int [] test1 = {54,12,7,39,11,3, 5, 99, 56, 32, 87, 34, 1, -4, 18};

        insertionSort(test1);

    }
}
