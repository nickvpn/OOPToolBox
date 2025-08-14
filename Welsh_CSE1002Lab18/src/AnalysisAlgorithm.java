// Nicholas Welsh 3/25/25
// The purpose of this program is to analyze the "threeSumCount" algorithm.
import java.util.Random;

public class AnalysisAlgorithm {
    public static long countOps;

    public static int threeSumCount(int[] nums){
        int n = nums.length;
        int count = 0;
        countOps = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        count++;
                        countOps++;
                    }
                    countOps++;
                }
            }
        }
        return count;

    }

    public static long timeTrial(int n){
        int[] newArray = new int[n];

        Random random = new Random();

        for(int i = 0; i < newArray.length; i++){
            newArray[i] = random.nextInt(n+1) - (n/2);
        }

        threeSumCount(newArray);

        return countOps;
    }

    public static void main(String[] args){
        long current = 0;
        double previous = 0.0;

        previous = timeTrial(16);

        System.out.println("Nicholas Welsh: Running Time Trials...");
        for(int i = 32; i < 4097; i*=2){
            current = timeTrial(i);
            System.out.println("n: " + i + ", countOps: " + current + ", current/previous: " + (current/previous));
            previous = current;
        }
        System.out.println();
    }
}
