
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Assignment2 {
    public static int countDigits(int num){

        int count = 0;
        while (num != 0){
            num/= 10;
             count++;
        }
        return count;
    }

    public static int nthDigitBack(int n, int num){

        // calculate the divisor to extract the nth digit from the right
        int divisor = 1;
        int digit;

        for( int i = 0; i < n; i++){
            divisor = divisor * 10;
        }

        digit = (num / divisor) % 10;
        return digit;
    }

    public static int nthDigit(int n, int num){

        String numString = String.valueOf(num); // convert num into string
      int digitIndex = numString.length(); // get the length of the String

        char digitChar = numString.charAt(n); //Get the character at the desired index
    int digit = Character.getNumericValue(digitChar); //convert the character to integer

        return digit;
    }

    public static int[] nthDigitTally(int n, int[] nums) {
        int[] tally = new int[10]; // Array to store the frequencies of digits (0-9)
        for (int index = 0; index < nums.length; index++) {
            int number = nums[index];
            updateTally(n, number, tally); // //call updatetally with number, tally and n in the appropriate order
        }
        return tally;
    }

    public static void updateTally(int n, int num, int[] tally) {
        int digit = nthDigit(n, num);
        tally[digit]++;  // Increment the frequency count for the digit
    }

    public static void printTally(int[] tally) {
        for (int i = 0; i < tally.length; i++) {
            System.out.println("Tally[" + i + "]: " + tally[i]);
        }
    }

    public static List<Integer> readMysteriousNumbers(String fileName) {

            File file = new File(fileName);
            List<Integer> list = new ArrayList<>();
            try{
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    int number = Integer.parseInt(line);
                    list.add(number);
                }
            }catch(Exception e){
                System.out.println("Bad file path");
            }
            return list;
        }

    public static void main(String[] args) {//test CountDigit
        int num;
        Scanner scanner = new Scanner(System.in);
       System.out.println("Enter number to count digits:");
        num = scanner.nextInt();
        System.out.println("You enter: " + num);
        System.out.println("Digits count:: " + countDigits(num));

        System.out.println();
        System.out.println();

        //test NthDigitBack
        int num2;
        int n;

        System.out.println("Enter any number to test the NthDigitBack");
        num2 = scanner.nextInt();
       // System.out.println("You enter: " + num2);
        System.out.println("Enter the nth/index number");
        n = scanner.nextInt();

        //System.out.println("The nth number you enter: " + n);
        System.out.println("the index/Nth Digit Back number: " + nthDigitBack(n, num2));

        System.out.println();
        System.out.println();

        //Test NthDigit
        int numDigit;
        int nDigit;

        System.out.println("Enter any number to test the NthDigit");
        numDigit = scanner.nextInt();
        //System.out.println("You enter: " + numDigit);
        System.out.println("Enter the nth number");
        nDigit = scanner.nextInt();
        //System.out.println("The nth number you enter: " + nDigit);
        System.out.println("Nth Digit: " + nthDigit(nDigit, numDigit));

        System.out.println();
        System.out.println();






        //testing nthDigitTally
        int nthDigitTally;
        int numDigitally;


        System.out.println("Enter the number to updateTally");
        numDigitally = scanner.nextInt();

        System.out.println("Enter the index number to updateTally");
        nthDigitTally = scanner.nextInt();


        System.out.println();
        System.out.println("Printing the updateTally");
        int[] tally = new int[10];
        updateTally(nthDigitTally, numDigitally, tally);
        printTally(tally);

        System.out.println();
        System.out.println();
        List<Integer> nums = readMysteriousNumbers("data.txt");
        System.out.println(nums);

        //testing nthDigitTally
        System.out.println("Enter the index number to nthDigitTally");
        n = scanner.nextInt();
        System.out.println();
        System.out.println("Printing the nthDigitTally");

        tally = nthDigitTally(n, nums.stream().mapToInt(i -> i).toArray());
        printTally(tally);

    }
}
