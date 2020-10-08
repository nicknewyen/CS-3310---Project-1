import java.util.Random;

public class BubbleSort
{
    // Function that implements Bubble Sort algorithm to sort array in ascending order
    void bubbleSort(int arr[])
    {
        int n = arr.length;
        /* Iterate through the array such that the algorithm can compare adjacent elements
        and pass through as many times needed to sort the entire array. */
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j] (adjacent arrays)
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }   // end bubbleSort

    // Function to print an array, 10 elements per row
    void printArray(int arr[])
    {
        int rowCount = 0;   //Iterator to keep track of when to create new row
        int n = arr.length;
        for (int i=0; i<n; ++i)
        {
            // If the current element is a multiple of 10, create a new row
            if (rowCount >= 10)
            {
                System.out.println();
                rowCount = 0;   // Reset the rowCount iterator
            }
            System.out.printf("%3d" + " ", arr[i]);     // Print out element in the array with 3 digit wide format
            rowCount++;     // Iterate rowCount
        }
        System.out.println();      // Print out empty line
    }   // end printArray

    // Function to fill out an array with random values
    public static void fillArray(int[] arr)
    {
        // Create instance of Random class
        Random rand = new Random();
        int n = arr.length;
        for (int i = 0; i < n; i++)
            arr[i] = rand.nextInt(1000);    // Randomly generate int value between 0-999
    }   // end fillArray

    // Main method
    public static void main(String args[])
    {
        // Create new object of BubbleSort
        BubbleSort ob = new BubbleSort();

        // Allocate memory for arrays
        int[] array1 = new int[10];
        int[] array2 = new int[100];
        int[] array3 = new int[1000];
        int[] array4 = new int[10000];
        int[] array5 = new int[100000];
        int[] array6 = new int[1000000];

        /*
        Initialize long variables to keep track of elapsed time to sort the arrays. Fill the arrays with random elements
        with fillArray() method, sort the arrays with bubbleSort() method.
        Attempting to sort an array of 1 million elements will cause the program to run for a few minutes.
         */
        fillArray(array1);
        long nano_array1_startTime = System.nanoTime();
        ob.bubbleSort(array1);
        long nano_array1_endTime = System.nanoTime();
        System.out.println("Elapsed time to sort array of 10 elements: \n" + (nano_array1_endTime - nano_array1_startTime) + " ns or " + ((nano_array1_endTime - nano_array1_startTime)/1000000.0) + " ms");
        System.out.println("\n------------------------------\n");

        fillArray(array2);
        long nano_array2_startTime = System.nanoTime();
        ob.bubbleSort(array2);
        long nano_array2_endTime = System.nanoTime();
        System.out.println("Elapsed time to sort array of 100 elements: \n" + (nano_array2_endTime - nano_array2_startTime) + " ns or " + ((nano_array2_endTime - nano_array2_startTime)/1000000.0) + " ms");
        System.out.println("\n-----------------------------\n");

        fillArray(array3);
        long nano_array3_startTime = System.nanoTime();
        ob.bubbleSort(array3);
        long nano_array3_endTime = System.nanoTime();
        System.out.println("Elapsed time to sort array of 1,000 elements: \n" + (nano_array3_endTime - nano_array3_startTime) + " ns or " + ((nano_array3_endTime - nano_array3_startTime)/1000000.0) + " ms");
        System.out.println("\n-----------------------------\n");

        fillArray(array4);
        long nano_array4_startTime = System.nanoTime();
        ob.bubbleSort(array4);
        long nano_array4_endTime = System.nanoTime();
        System.out.println("Elapsed time to sort array of 10,000 elements: \n" + (nano_array4_endTime - nano_array4_startTime) + " ns or " + ((nano_array4_endTime - nano_array4_startTime)/1000000.0) + " ms");
        System.out.println("\n-----------------------------\n");

        fillArray(array5);
        long nano_array5_startTime = System.nanoTime();
        ob.bubbleSort(array5);
        long nano_array5_endTime = System.nanoTime();
        System.out.println("Elapsed time to sort array of 100,000 elements: \n" + (nano_array5_endTime - nano_array5_startTime) + " ns or " + ((nano_array5_endTime - nano_array5_startTime)/1000000.0) + " ms");
        System.out.println("\n-----------------------------\n");

        fillArray(array6);
        long nano_array6_startTime = System.nanoTime();
        ob.bubbleSort(array6);
        long nano_array6_endTime = System.nanoTime();
        System.out.println("Elapsed time to sort array of 1,000,000 elements: \n" + (nano_array6_endTime - nano_array6_startTime) + " ns or " + ((nano_array6_endTime - nano_array6_startTime)/1000000.0) + " ms");
    } // end main
}
