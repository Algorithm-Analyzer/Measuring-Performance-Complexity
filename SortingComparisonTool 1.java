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


