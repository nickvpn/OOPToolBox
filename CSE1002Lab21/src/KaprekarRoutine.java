//Nicholas Welsh 4/8/2025
import java.util.Arrays;
import java.util.Random;

public class KaprekarRoutine {

    public static void KaprekarRoutine(int n){
        System.out.println("Chosen Number: " + n);
        int ascendedNum = ascendingOrder(n);
        int descendedNum = descendingOrder(n);

        int subtractedNum = descendedNum - ascendedNum;
        int subtractedNum2 = 0;
        int temp = subtractedNum;

        System.out.printf("%04d\n", subtractedNum);
        while(temp != subtractedNum2){
            int ascendedNum2 = ascendingOrder(subtractedNum);
            int descendedNum2 = descendingOrder(subtractedNum);

            subtractedNum2 = descendedNum2 - ascendedNum2;
            temp = subtractedNum;
            subtractedNum = subtractedNum2;
            System.out.printf("%04d\n", subtractedNum2);

        }


    }


    public static int ascendingOrder(int n){
        int ones = n % 10;
        int tens = n / 10 % 10;
        int hundreds = n / 100 % 10;
        int thousands = n % 10000 / 1000;
        int[] array = {ones, tens, hundreds, thousands};
        Arrays.sort(array);

        int ascendedNum = 0;
        for(int i = 0; i < array.length; i++) {
            ascendedNum = ascendedNum * 10 + array[i];
        }


        return ascendedNum;
    }

    public static int descendingOrder(int n){
        int ones = n % 10;
        int tens = n / 10 % 10;
        int hundreds = n / 100 % 10;
        int thousands = n % 10000 / 1000;
        int[] array = {ones, tens, hundreds, thousands};
        Arrays.sort(array);

        int descendedNum = 0;
        for(int i = array.length; i > 0; i--){
            descendedNum += (int) (array[i-1] * Math.pow(10, i-1));
        }


        return descendedNum;
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        int n = random.nextInt(9998) + 1;

        while (n % 1111 == 0) {
            n = random.nextInt(9998) + 1;
        }

        return n;
    }

    public static void main(String[] args){
        KaprekarRoutine(generateRandomNumber());
    }
}
