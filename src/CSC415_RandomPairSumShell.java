import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

public class CSC415_RandomPairSumShell {

    // Method to print the current timestamp
    private static void printTimeStamp(String sms) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date date = new Date();
        System.out.println(sms + " - " + formatter.format(date));
    }

    // Method to generate an array with random numbers
    private static int[] generateRandomArray(int size, int lowerBound, int upperBound) {
        Random rd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rd.nextInt(upperBound - lowerBound + 1) + lowerBound;
        }
        return arr;
    }

    // Method to find pairs that sum up to a given number without using extra storage
    private static void findPairsWithoutExtraStorage(int[] arr, int targetSum) {
        printTimeStamp("Execution started (Without Extra Storage)");

        //My code is from here
        //Loop in each element in the array
        for (int i = 0; i < arr.length; i++) {
            //Get the remain from target and element
            int remain = targetSum - arr[i];
            //loop find the remain if it is in array
            for (int j = 0; j < arr.length; j++) {
                //if found, print, stop looping
                if (arr[j] == remain) {
                    System.out.println(arr[i] + " + " + arr[j] + " = " + targetSum);
                    break;
                }
            }
        }
        System.out.println("No pair for other numbers!!!");
        //My code ended here
        
        printTimeStamp("Execution ended (Without Extra Storage)");
    }

    // Method to find pairs that sum up to a given number using a HashSet
    private static void findPairsWithHashSet(int[] arr, int targetSum) {
        printTimeStamp("Execution started (Using HashSet)");
        
        //My code is from here
        //Create new HashSet, loop the array and add elements to HashSet
        HashSet hash = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            hash.add(arr[i]);
        }

        //Loop every element in the array and find the remain in the set
        for (int i = 0; i < arr.length; i++) {
            //Get the remain from target and element
            int remain = targetSum - arr[i];
            //If set contains the remain, print
            if (hash.contains(remain)) {
                System.out.println(arr[i] + " + " + remain + " = " + targetSum);
            }
        }
        System.out.println("No pair for other numbers!!!");
        //My code ended here
        
        printTimeStamp("Execution ended (Using HashSet)");
    }

    public static void main(String[] args) {
        int[] randomNumbers = generateRandomArray(250000, 1, 2000000);
        int targetSum = 317;
        System.out.println("Target: " + targetSum + "\n");

        System.out.println("Finding pairs without extra storage:");
        findPairsWithoutExtraStorage(randomNumbers, targetSum);

        System.out.println("\nFinding pairs using HashSet:");
        findPairsWithHashSet(randomNumbers, targetSum);
    }
}



//    private static void printArr(int[] arr) {
//        System.out.println("Random array: ");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + "\t");
//            if (i != 0 && i % 10 == 0) {
//                System.out.println("");
//            }
//        }
//        System.out.println("\n");
//    }
