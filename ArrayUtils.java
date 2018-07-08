package homeExerciseLesson5;

import java.util.Random;
import java.util.Scanner;

public class ArrayUtils {
    // обьявление константы - длинна массива
    private static final int ARRAY_SIZE = 10;

    // обьявление константы - максимальное рандомное число
    private static final int MAX_RANDOM_NUMBER = 100;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = new int[ARRAY_SIZE];

        fillArrayWithRandomNumbers(array);

        printArrayToConsole(array);

        int arraySum = calculateArraySum(array);
        System.out.println("Array sum = " + arraySum);

        int evenNumbersCount = countEvenNumbersInArray(array);
        System.out.println("Even numbers count = " + evenNumbersCount);

        int oddNumbersCount = countOddNumbersInArray(array);
        System.out.println("Odd numbers count = " + oddNumbersCount);

        bubbleSort(array);

        printArrayToConsole(array);

        int maxNumberInArray = findMaxNumber(array);
        System.out.println("Max number in array  = " + maxNumberInArray);

        int minNumberInArray = findMinNumber(array);
        System.out.println("Min number in array  = " + minNumberInArray);

        System.out.println("Enter number for find in array: ");
        int number = sc.nextInt();

        int indexOfElement = find(array, number);
        if (indexOfElement == -1) {
            System.out.println("Element don't exist in array");
        } else {
            System.out.println("This is " + indexOfElement + "th element in array");
        }

    }

    private static void fillArrayWithRandomNumbers(int[] array) {
        Random randomGenerator = new Random();
        for(int i = 0; i < array.length; i++) {
            int randomNumber = randomGenerator.nextInt(MAX_RANDOM_NUMBER);
            array[i] = randomNumber;
        }
    }

    private static void printArrayToConsole(int[] array) {
        System.out.println("Print array to console: ");
        for(int i = 0; i < array.length; i++) {
            int arrayElement = array[i];
            System.out.print(arrayElement + " ");
        }
        System.out.println();
    }

    private static int calculateArraySum(int[] array) {
        int arraySum = 0;
        for(int i = 0; i < array.length; i++) {
            int arrayElement = array[i];
            arraySum = arraySum + arrayElement;
        }
        return arraySum;
    }

    private static int countEvenNumbersInArray(int[] array) {
        int evenNumbersCount = 0;
        for(int i = 0; i < array.length; i++) {
            int arrayElement = array[i];
            if(arrayElement % 2 == 0) {
                evenNumbersCount += 1;
            }
        }
        return evenNumbersCount;
    }

    private static int countOddNumbersInArray(int[] array) {
        int oddNumbersCount = 0;
        for(int i = 0; i < array.length; i++) {
            int arrayElement = array[i];
            if(arrayElement % 2 != 0) {
                oddNumbersCount += 1;
            }
        }
        return oddNumbersCount;
    }

    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        int temp;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if(array[i] > array[i+1]){
                    isSorted = false;

                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
    }

    public static int findMaxNumber(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    public static int findMinNumber(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    public static int find (int[] array, int element) {
        int index = -1;
        if (array != null) {
            int low = 0, high = array.length, mid;
            while (low < high) {
                mid = (low + high)/2;
                if (element == array[mid]) {
                    index = mid;
                    break;
                } else {
                    if (element < array[mid]){
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return index;
    }
}
