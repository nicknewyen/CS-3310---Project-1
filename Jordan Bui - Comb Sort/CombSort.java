/*
Jordan Bui
CS 3310
Fall 2020
10/07/2020


Comb Sort
---------------------------------
Comb sort is an algorithm that improves the bubble sort by 
using gaps to compare the values. The gaps are determined 
based on the size of the array and shrink by a factor of 1.3.
This helps eliminate smaller values at the end of the list.
---------------------------------


Run Times
---------------------------------
Array Size 10
Elapsed time to sort the array: 6008ns
Elapsed time to sort the array: 0ms

Array Size 100
Elapsed time to sort the array: 36824ns
Elapsed time to sort the array: 0ms

Array Size 1,000
Elapsed time to sort the array: 611889ns
Elapsed time to sort the array: 0ms

Array Size 10,000
Elapsed time to sort the array: 3232629ns
Elapsed time to sort the array: 3ms

Array Size 100,000
Elapsed time to sort the array: 11268153ns
Elapsed time to sort the array: 11ms

Array Size 1,000,000
Elapsed time to sort the array: 112379363ns
Elapsed time to sort the array: 112ms
---------------------------------


Time Complexity
---------------------------------
Best Case:
Best case occurs when the array is already sorted or partially sorted
therefore, 
	a(n) = n
	a(n - 1) = n * (1/1.3)
	a(n - 2) = n * (1/1.3^2)
	a(n - 3) = n * (1/1.3^3)
	...
	a(n - i) = n * (1/1.3^i)
	
	==> B(n) = O(nlog(n)) 

Worst Case:
The worst case of the comb sort would be when the array
needs to swap every item in the array.
therefore,
	(n - 1) swaps for the first cycle
	(n - 2) swaps on the second cycle
	(n - 1) + (n - 2) +...+ 3 + 2 + 1
	= n(n - 1)/2

	==> W(n) = O(n^2)
	
Average Case:
Average case is shown:
the number of passes p is shown: (k1, k2, k3, ..., kp)
	p > logn - loglogn -> 
	p <= logn - loglogn
	p depends on the value of n
	average case (n - 1) + (n - 2) + ... + 2 + 1
	-> A(n) = O(n^2/2^p) for the number of cycles through gaps
	so,
	
	==> A(n) = O(n^2)
---------------------------------


Memory Complexity
---------------------------------
For all cases, there is only one array that will be sorted.
Only memory for one array must be allocated.
=> O(1)
---------------------------------
*/


import java.util.Random;

// Java Comb Sort
public class CombSort 
{
	// Resizes the value for gap
	int nextGap(int g)
	{
		g = (g*10) / 13;
		if (g < 1)
			return 1;
		return g;
	}

	
	// Sorts the array
	void sort(int arr[])
	{
		int len = arr.length;
		int gap = len;
		boolean hasSwapped = true;
		while (gap != 1 || hasSwapped == true)
		{
			gap = nextGap(gap);
			hasSwapped = false;
			for (int i = 0; i < len - gap; i++)
			{
				if (arr[i] > arr[i + gap])
				{
					int temp = arr[i];
					arr[i] = arr[i + gap];
					arr[i + gap] = temp;
					hasSwapped = true;
				}
			}
		}
	}
	
	// Test Program
	public static void main(String[] args) 
	{
		
		// Create CombSort and Random objects
		CombSort comb = new CombSort();
		Random rand = new Random();
		
		
		
		// Create Random array of 10
        int nums10[] = new int[10];
        System.out.println("Array Size 10");
        for (int i = 0; i < nums10.length; i++)
        {
        	nums10[i] = rand.nextInt(100);
        }
        // Sort array
        long nano_startTime = System.nanoTime();
        comb.sort(nums10); 
        long nano_endTime = System.nanoTime();
        // Print time to sort
        long nano_Time = nano_endTime - nano_startTime;
        long mil_Time = nano_Time/1000000;
        System.out.println("Elapsed time to sort the array: " + nano_Time + "ns");
        System.out.println("Elapsed time to sort the array: " + mil_Time + "ms");
        System.out.println("----------------------------------------");
		
		
		
		// Create Random array of 100
        int nums100[] = new int[100];
        System.out.println("Array Size 100");
        for (int i = 0; i < nums100.length; i++)
        {
        	nums100[i] = rand.nextInt(1000);
        }
        // Print Unsorted array
        System.out.println("Unsorted array of 100:"); 
        for (int i=0; i<nums100.length; i++)
        {
            System.out.print(nums100[i] + " ");
            if (i % 10 == 0 && i > 0)
            	System.out.println();
        }
        System.out.println();
        System.out.println();
        // Sort array
        nano_startTime = System.nanoTime();
        comb.sort(nums100); 
        nano_endTime = System.nanoTime();
        // Print Sorted array and time to sort
        nano_Time = nano_endTime - nano_startTime;
        mil_Time = nano_Time/1000000;
        System.out.println("Sorted array of 100:"); 
        for (int i=0; i<nums100.length; i++)
        {
            System.out.print(nums100[i] + " ");
            if (i % 10 == 0 && i > 0)
            	System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println("Elapsed time to sort the array: " + (nano_endTime - nano_startTime) + "ns");
        System.out.println("Elapsed time to sort the array: " + mil_Time + "ms");
        System.out.println("----------------------------------------");
        
        
        
        // Create Random array of 1000
        int nums1000[] = new int[1000];
        System.out.println("Array Size 1,000");
        for (int i = 0; i < nums1000.length; i++)
        {
        	nums1000[i] = rand.nextInt(1000);
        }
        // Sort array
        nano_startTime = System.nanoTime();
        comb.sort(nums1000); 
        nano_endTime = System.nanoTime();
        // Print time to sort
        nano_Time = nano_endTime - nano_startTime;
        mil_Time = nano_Time/1000000;
        System.out.println("Elapsed time to sort the array: " + nano_Time + "ns");
        System.out.println("Elapsed time to sort the array: " + mil_Time + "ms");
        System.out.println("----------------------------------------");
        
        
        
        // Create Random array of 1000
        int nums10000[] = new int[10000];
        System.out.println("Array Size 10,000");
        for (int i = 0; i < nums10000.length; i++)
        {
        	nums10000[i] = rand.nextInt(10000);
        }
        // Sort array
        nano_startTime = System.nanoTime();
        comb.sort(nums10000); 
        nano_endTime = System.nanoTime();
        // Print time to sort
        nano_Time = nano_endTime - nano_startTime;
        mil_Time = nano_Time/1000000;
        System.out.println("Elapsed time to sort the array: " + nano_Time + "ns");
        System.out.println("Elapsed time to sort the array: " + mil_Time + "ms");
        System.out.println("----------------------------------------");
        
        
        
        // Create Random array of 100000
        int nums100000[] = new int[100000];
        System.out.println("Array Size 100,000");
        for (int i = 0; i < nums100000.length; i++)
        {
        	nums100000[i] = rand.nextInt(100000);
        }
        // Sort array
        nano_startTime = System.nanoTime();
        comb.sort(nums100000); 
        nano_endTime = System.nanoTime();
        // Print time to sort
        nano_Time = nano_endTime - nano_startTime;
        mil_Time = nano_Time/1000000;
        System.out.println("Elapsed time to sort the array: " + nano_Time + "ns");
        System.out.println("Elapsed time to sort the array: " + mil_Time + "ms");
        System.out.println("----------------------------------------");
        
        
        
     // Create Random array of 1000000
        int nums1000000[] = new int[1000000];
        System.out.println("Array Size 1,000,000");
        for (int i = 0; i < nums1000000.length; i++)
        {
        	nums1000000[i] = rand.nextInt(1000000);
        }
        // Sort array
        nano_startTime = System.nanoTime();
        comb.sort(nums1000000); 
        nano_endTime = System.nanoTime();
        // Print time to sort
        nano_Time = nano_endTime - nano_startTime;
        mil_Time = nano_Time/1000000;
        System.out.println("Elapsed time to sort the array: " + nano_Time + "ns");
        System.out.println("Elapsed time to sort the array: " + mil_Time + "ms");
        System.out.println("----------------------------------------");
	}
}
