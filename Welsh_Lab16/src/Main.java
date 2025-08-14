//Nicholas Welsh 3/11/2025
// The purpose of this program is to take an array of integers and find the two elements in the array that are closest to each other in value.
public class Main {
    public static void main(String[] args) {
        int[] a = {23,5,-1,15,7,-9,12,19,-5}; // closest pair: 5 and 7
        int[] b = {100, 35, 12, 82, 22, 55, -9}; // closest pair: 12 and 22
        int[] c = {-5, 11, -6, 15, 19, 45, -8}; // closest pair: -5 and -6
        int[] d = {-100, 101, 0, 204}; // closest pair: -100 and 0
        int[] closestA = closestPair(a);
        System.out.println("Closest pair for a is: " + closestA[0] + "," + closestA[1] + " (should be 5 and 7)");
        int[] closestB = closestPair(b);
        System.out.println("Closest pair for b is: " + closestB[0] + "," + closestB[1] + " (should be 12 and 22)");
        int[] closestC = closestPair(c);
        System.out.println("Closest pair for c is: " + closestC[0] + "," + closestC[1] + " (should be -5 and -6)");
        int[] closestD = closestPair(d);
        System.out.println("Closest pair for d is: " + closestD[0] + "," + closestD[1] + " (should be -100 and 0)");

    }

    public static int[] closestPair(int[] nums){
        int minDiff = Math.abs(nums[0]-nums[1]); // setting the minimum difference (big number for the first case)

        int elementOne = nums[0];
        int elementTwo = nums[1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int difference = Math.abs(nums[i] - nums[j]);
                if (difference < minDiff) {
                    minDiff = difference;
                    elementOne = nums[i];
                    elementTwo = nums[j];
                }
            }
        }

        return new int[]{elementOne, elementTwo};
    }
}
