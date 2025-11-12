import java.util.*;

public class SortingComparisonTool {

    // BUBBLE SORT - Simple but slow
    // Like sorting cards by repeatedly swapping adjacent ones that are in wrong order
    public static int bubbleSort(int[] arr) {
        int n = arr.length; // Get how many numbers we have
        int steps = 0; // Count how many comparisons we make
        
