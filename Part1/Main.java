//---------------------------------------------
// Title: Main Class
// Author: Ayda Nil Özyürek
// Description: This class uses for reading the file which given to us and print the arrays which we sorted.
//---------------------------------------------

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// read the integers.txt file
		System.out.println("Integers are reading from the integers.txt file, the array is:");
		int numbers[] = readFiles("integers.txt");
		int n = numbers.length;

		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = numbers[i];
		}
		printArray(arr);

		// read the doubles.txt file
		System.out.println("Doubles are reading from the doubles.txt file, the array is:");
		double[] numbers2 = readFiles2("doubles.txt");
		int d = numbers2.length;

		Double[] arr2 = new Double[d];
		for (int i = 0; i < d; i++) {
			arr2[i] = numbers2[i];
		}
		printArray2(arr2);

		System.out.println("The original array is:");
		int numbers1[] = readFiles("integers.txt");
		int n1 = numbers.length;

		Integer[] arr1 = new Integer[n];
		for (int i = 0; i < n1; i++) {
			arr1[i] = numbers1[i];
		}
		printArrayMerge(arr1);

		
		// I am creating Route object with given 10 different input. 
		Route[] route = { new Route("Ankara", "Antalya"), new Route("Ankara", "Istanbul"),
				new Route("Istanbul", "Antalya"), new Route("Antalya", "Izmir"), new Route("Izmir", "Antalya"),
				new Route("Izmir", "Ankara"), new Route("Antalya", "Ankara"), new Route("Ankara", "Izmir"),
				new Route("Istanbul", "Izmir"), new Route("Istanbul", "Ankara") };


		System.out.println();

		Quick.sort(route); // (step 6)
		for (int i = 0; i < route.length; i++) {
			System.out.println(route[i].source + " " + route[i].destination);
		}

		System.out.println();

		System.out.println("Step 6 has been completed.");
	}

	private static int[] readFiles(String file) {
		try {
			File f = new File(file);
			Scanner s = new Scanner(f);
			int n = 0;

			while (s.hasNextInt()) {
				n++;
				s.nextInt();
			}
			int S[] = new int[n];

			Scanner s1 = new Scanner(f);

			for (int i = 0; i < S.length; i++)
				S[i] = s1.nextInt();

			return S;

		} catch (Exception e) {
			return null;
		}
	}

	private static double[] readFiles2(String file) {
		// ---------------------------
		// Summary:This method same as the readFiles method with one difference we want
		// to read
		// double array this time, so I modified the given method for double.
		// ---------------------------
		try {
			File f = new File(file);
			Scanner s = new Scanner(f);
			int n = 0;

			while (s.hasNextLine()) {
				n++;
				s.nextLine();
			}
			double S[] = new double[n];

			Scanner s1 = new Scanner(f);

			for (int i = 0; i < S.length; i++)
				S[i] = Double.parseDouble(s1.nextLine());

			return S;

		} catch (Exception e) {
			return null;
		}
	}

	private static void printArray2(Double[] arr2) {
		for (int i = 0; i < arr2.length; i++)
			System.out.print(arr2[i] + " ");
		System.out.println();

		Insertion.sort(arr2);
		System.out.println(
				"The array of double values has been sorted in increasing order by using the insertion sort algorithm:");
		Insertion.show(arr2); // (step3)
		System.out.println("Step 3 has been completed");

		System.out.println();

	}

	public static void printArray(Integer[] arr)

	{
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		Insertion.sort(arr); // This line sort the array in increasing order (step1)
		System.out.println("The array has been sorted in increasing order by using the insertion sort algorithm:");
		Insertion.show(arr);// This line print the sorted array in the console
		System.out.println("Step 1 has been completed.");

		System.out.println();

		Insertion.descSort(arr); // This line sort the array in decreasing order (step2)
		System.out.println(
				"The array of integers that has been sorted in decreasing order by using the insertion sort algorithm:");
		Insertion.show(arr);// This line print the sorted array in the console
		System.out.println("Step 2 has been completed.");

		System.out.println();

	}

	public static void printArrayMerge(Integer[] arr1)

	{
		for (int i = 0; i < arr1.length; i++)
			System.out.print(arr1[i] + " ");
		System.out.println();

		Merge.sort(arr1);// This line sort the array in descending order (step4)
		System.out.println(
				"The array of integer values has been sorted in descending order by using the merge sort algorithm is:");
		Merge.show(arr1); // This line print the sorted array in the console
		System.out.println("Step 4 has been completed.");

		

	}
}
