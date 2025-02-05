package day2;
import java.util.Arrays; 
public class array {
    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 
        int[] copiedArray = Arrays.copyOfRange(originalArray, 3, 9);
        System.out.println("Original Array: " + Arrays.toString(originalArray)); 
        System.out.println("Copied Array: " + Arrays.toString(copiedArray)); 
    }
}