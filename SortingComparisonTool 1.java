import java.util.Arrays;
import java.util.Random;


public class AlgorithmPerformance {


   * Linear Search: Simple search by checking each element one by one
     * Time Complexity: O(n) - slower than binary search but works on unsorted arrays
     */


       public static int linearSearch(int[] arr, int target) {
        // Check each element from start to end
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found at index i
            }
        }
        return -1; // Not found
    }

 /**
     * Test Linear Search on different array sizes
     */
    public static void testLinearSearch(int[] sizes, long seed) {
        printHeader("Linear Search");
        for (int size : sizes) {
            // Generate unsorted array
            int[] arr = generateRandomArray(size, seed);

             // Pick an element that exists in the array
            int target = arr[size / 2];
            
            // Measure search time (run multiple times for better accuracy)
            int iterations = 1000;
            long startTime = System.nanoTime();
            for (int i = 0; i < iterations; i++) {
                linearSearch(arr, target);
            }
            long endTime = System.nanoTime();

            // Average time per search
            double timeMs = (endTime - startTime) / 1_000_000.0 / iterations;
            printRow(size, timeMs);
        }
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

                while (left <= right) {
            int mid = left + (right - left) / 2; // Find middle element
            
            // Check if target is at middle
            if (arr[mid] == target) {
                return mid; // Found!
            }
            // If target is greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

                return -1; // Not found
    }
    
   
 //Test Binary Search on different array sizes

    public static void testBinarySearch(int[] sizes, long seed) {
        printHeader("Binary Search");
        for (int size : sizes) {

            // Generate and sort array first
            int[] arr = generateRandomArray(size, seed);
            Arrays.sort(arr); // Sort using built-in method
            
            // Pick middle element to search for (guaranteed to exist)
            int target = arr[size / 2];
            