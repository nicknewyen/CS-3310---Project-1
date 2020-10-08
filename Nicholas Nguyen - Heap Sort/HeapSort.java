// Author:	Nicholas Nguyen
// Date:	10/07/2020
// Class:	CS 3310.02

import java.util.Random;

public class HeapSort {

	// methods to get index of the parent or left/right child
	// of the node at index i
	@SuppressWarnings("unused")
	private static int parentIdx(int i) { 
		return (i - 1) / 2; // using integer division instead of math.floor
	}

	private static int leftIdx(int i) {
		return 2 * i + 1;
	}

	private static int rightIdx(int i) {
		return 2 * i + 2;
	}

	// restore max-heap property for the heap with
	// parent node at index i
	// assumes children of A[i] are roots of max-heaps
	public static void maxHeapify(int[] A, int i, int heapMaxIdx) {
		int L = leftIdx(i);
		int R = rightIdx(i);
		int largest = i;
		if (L <= heapMaxIdx && A[L] > A[i]) {
			largest = L;
		}
		if (R <= heapMaxIdx && A[R] > A[largest]) {
			largest = R;
		}
		if (largest != i) {
			swap(A, i, largest);
			maxHeapify(A, largest, heapMaxIdx);
		}
	}

	// turn an arbitrary array into a max-heap
	public static void buildMaxHeap(int[] A) {
		int heapMaxIdx = A.length - 1;
		for (int i = heapMaxIdx / 2; i >= 0; i--) {
			maxHeapify(A, i, heapMaxIdx);
		}
	}

	// Performs heap sort
	public static void heapSort(int[] A) {
		int heapMaxIdx = A.length - 1;
		buildMaxHeap(A);
		for (int i = A.length - 1; i > 0; i--) {
			swap(A, 0, i); // since A[0] is max element
			heapMaxIdx--;
			maxHeapify(A, 0, heapMaxIdx);
		}
	}
	
    static void printArray(int arr[])
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
    
	public static void fillWithRandomInts(int[] array) {
		Random rnd = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rnd.nextInt(array.length);
		}
	}
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}

	public static void main(String[] args) {
		System.out.println("Heap Sort\n");
		int[] array1 = new int[10];
		int[] array2 = new int[100];
		int[] array3 = new int[1000];
		int[] array4 = new int[10000];
		int[] array5 = new int[100000];
		int[] array6 = new int[1000000];
		
		// ARRAY 10
		System.out.println("Array Size: 10");
		fillWithRandomInts(array1);
		long nano_array_startTime1 = System.nanoTime();
		long ms_array_startTime1 = System.currentTimeMillis();
		heapSort(array1);
		long ms_array_endTime1 = System.currentTimeMillis();
		long nano_array_endTime1 = System.nanoTime();
		System.out.println("Time to sort the array in nanoseconds: " + (nano_array_endTime1 - nano_array_startTime1) + " ns");
		System.out.println("Time to sort the array in milliseconds: " + (ms_array_endTime1 - ms_array_startTime1) + " ms\n");
		
		// ARRAY 100
		System.out.println("Array Size: 100 (DEMO)");
		fillWithRandomInts(array2);
		// Print Unsorted Array
		System.out.println("Unsorted Array:");
		printArray(array2);
		
		long nano_array_startTime2 = System.nanoTime();
		long ms_array_startTime2 = System.currentTimeMillis();
		heapSort(array2);
		long ms_array_endTime2 = System.currentTimeMillis();
		long nano_array_endTime2 = System.nanoTime();
		// Print Sorted Array
		System.out.println("===========================================\n Sorted Array:");
		printArray(array2);
		System.out.println("Time to sort the array in nanoseconds: " + (nano_array_endTime2 - nano_array_startTime2) + " ns");
		System.out.println("Time to sort the array in milliseconds: " + (ms_array_endTime2 - ms_array_startTime2) + " ms\n");
		
		// ARRAY 1000 
		System.out.println("Array Size: 1,000");
		fillWithRandomInts(array3);
		long nano_array_startTime3 = System.nanoTime();
		long ms_array_startTime3 = System.currentTimeMillis();
		heapSort(array3);
		long ms_array_endTime3 = System.currentTimeMillis();
		long nano_array_endTime3 = System.nanoTime();
		System.out.println("Time to sort the array in nanoseconds: " + (nano_array_endTime3 - nano_array_startTime3) + " ns");
		System.out.println("Time to sort the array in milliseconds: " + (ms_array_endTime3 - ms_array_startTime3) + " ms\n");
		
		// ARRAY 10000
		System.out.println("Array Size: 10,000");
		fillWithRandomInts(array4);
		long nano_array_startTime4 = System.nanoTime();
		long ms_array_startTime4 = System.currentTimeMillis();
		heapSort(array4);
		long ms_array_endTime4 = System.currentTimeMillis();
		long nano_array_endTime4 = System.nanoTime();
		System.out.println("Time to sort the array in nanoseconds: " + (nano_array_endTime4 - nano_array_startTime4) + " ns");
		System.out.println("Time to sort the array in milliseconds: " + (ms_array_endTime4 - ms_array_startTime4) + " ms\n");
		
		// ARRAY 100000
		System.out.println("Array Size: 100,000");
		fillWithRandomInts(array5);
		long nano_array_startTime5 = System.nanoTime();
		long ms_array_startTime5 = System.currentTimeMillis();
		heapSort(array5);
		long ms_array_endTime5 = System.currentTimeMillis();
		long nano_array_endTime5 = System.nanoTime();
		System.out.println("Time to sort the array in nanoseconds: " + (nano_array_endTime5 - nano_array_startTime5) + " ns");
		System.out.println("Time to sort the array in milliseconds: " + (ms_array_endTime5 - ms_array_startTime5) + " ms\n");
		
		// ARRAY 1000000
		System.out.println("Array Size: 1,000,000");
		fillWithRandomInts(array6);
		long nano_array_startTime6 = System.nanoTime();
		long ms_array_startTime6 = System.currentTimeMillis();
		heapSort(array6);
		long ms_array_endTime6 = System.currentTimeMillis();
		long nano_array_endTime6 = System.nanoTime();
		System.out.println("Time to sort the array in nanoseconds: " + (nano_array_endTime6 - nano_array_startTime6) + " ns");
		System.out.println("Time to sort the array in milliseconds: " + (ms_array_endTime6 - ms_array_startTime6) + " ms");
	}
}