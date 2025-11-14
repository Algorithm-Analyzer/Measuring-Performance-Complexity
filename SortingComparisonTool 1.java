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
            
            // Measure search time (run multiple times for better accuracy)
            int iterations = 1000;
            long startTime = System.nanoTime();
            for (int i = 0; i < iterations; i++) {
                binarySearch(arr, target);
            }
            long endTime = System.nanoTime();

            // Average time per search
            double timeMs = (endTime - startTime) / 1_000_000.0 / iterations;
            printRow(size, timeMs);
        }
    }

    // Bubble Sort:
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // Outer loop: passes through the array
        for (int i = 0; i < n - 1; i++) {
            // Inner loop: compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // If current element is greater than next, swap them
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    /**
     * Test Bubble Sort on different array sizes
     */
    public static void testBubbleSort(int[] sizes, long seed) {
        printHeader("Bubble Sort");
        for (int size : sizes) {
            // Generate random array
            int[] arr = generateRandomArray(size, seed);
            
            // Measure sorting time
            long startTime = System.nanoTime();
            bubbleSort(arr);
            long endTime = System.nanoTime();
            
            // Convert nanoseconds to milliseconds
            double timeMs = (endTime - startTime) / 1_000_000.0;
            printRow(size, timeMs);
        }
    }

    //QUICK SORT

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get pivot position
            int pivotIndex = partition(arr, low, high);
            
            // Recursively sort elements before and after pivot
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    /**
     * Partition: Places pivot in correct position and arranges smaller/larger elements
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose last element as pivot
        int i = low - 1; // Index of smaller element
        
        for (int j = low; j < high; j++) {
            // If current element is smaller than pivot
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
    
    /**
     * Test Quick Sort on different array sizes
     */
    public static void testQuickSort(int[] sizes, long seed) {
        printHeader("Quick Sort");
        for (int size : sizes) {
            // Generate same random array (same seed)
            int[] arr = generateRandomArray(size, seed);
            
            // Measure sorting time
            long startTime = System.nanoTime();
            quickSort(arr, 0, arr.length - 1);
            long endTime = System.nanoTime();
            
            double timeMs = (endTime - startTime) / 1_000_000.0;
            printRow(size, timeMs);
        }
    }
//HELPER METHODS
public static int[] generateRandomArray(int size, long seed) {
        Random random = new Random(seed);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10000); // Random numbers 0-9999
        }
        return arr;
    }
    
    /**
     * Create a copy of array to preserve original
     */
    public static int[] copyArray(int[] original) {
        return Arrays.copyOf(original, original.length);
    }
    
    /**
     * Print table header
     */
    public static void printHeader(String algorithmName) {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("Algorithm: " + algorithmName);
        System.out.println("=".repeat(40));
        System.out.println("Input Size | Time (ms)");
        System.out.println("-".repeat(40));
    }
    
    /**
     * Print table row
     */
    public static void printRow(int size, double timeMs) {
        System.out.printf("%-10d | %.2f%n", size, timeMs);
    }

