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

