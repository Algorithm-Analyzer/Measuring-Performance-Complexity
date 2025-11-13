import java.util.Arrays;
import java.util.Random;


public class AlgorithmPerformance {


   * Linear Search: Simple search by checking each element one by one
     * Time Complexity: O(n) - slower than binary search but works on unsorted arrays
     */


        // Outer loop: we need to do n passes
        for (int i = 0; i < n; i++) {
            // Inner loop: compare adjacent numbers
            for (int j = 0; j < n - i - 1; j++) {
                steps++; // Count this comparison

                // If left number is bigger than right number, swap them
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];        // Save left number
                    arr[j] = arr[j + 1];      // Put right number on left
                    arr[j + 1] = temp;        // Put saved number on right
                }
            }
        }
        return steps; // Return total comparisons made
    }

