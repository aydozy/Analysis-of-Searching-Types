
//---------------------------------------------
// Title: Method Class
// Author: Ayda Nil Özyürek
// Description: In this class, which sort will be selected first is taken from the user.
//              In the sorted array, the numbers with the smallest difference are selected and printed on the screen.
//---------------------------------------------
import java.util.Scanner;

public class Method {

	public static void Method(Integer[] array, String[] sortOption) {
		// --------------------------------------------------
		// Summary: I used this method to call another method
		// --------------------------------------------------
		pairwiseDifference(array, sortOption);
	}

/*	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Integer[] array = { 23, 1, 5, 102, 34, 99 }; // This is the array which given to us
		System.out.println("Enter the sort you want to use:"); // The part where the user is asked which sort to choose
		String sortChoise = sc.nextLine();
		String[] sortOption = new String[1];
		sortOption[0] = sortChoise;

		pairwiseDifference(array, sortOption);
	}*/

	public static void pairwiseDifference(Integer[] array, String[] sortOption) {
		// --------------------------------------------------
		// Summary: I used this method to check the correctness of the sortArray and
		// allow the method with the smallest difference to be used if the sort used is
		// correct.
		// Precondition: sortOption is a String Array, array is a Integer Array.
		// Postcondition: If the condition is true, the method will be available.
		// --------------------------------------------------
		boolean isValid = sortArray(sortOption, array);
		if (isValid) {
			findSmallestDiff(array);
		}
	}

	private static boolean sortArray(String[] sortOption, Integer[] array) {
		// --------------------------------------------------
		// Summary: With this method, we come to the case with the sort style taken from
		// the user. The array is sorted according to the sort written in Case.
		// Precondition: sortOption is a String Array, array is a Integer Array.
		// Postcondition: Sort is done according to sortOption.
		// --------------------------------------------------
		switch (sortOption[0]) {
		case "Selection":
			Selection.sort(array);
			return true;
		case "Insertion":
			Insertion.sort(array);
			return true;
		case "Merge":
			Merge.sort(array);
			return true;
		case "Quick":
			Quick.sort(array);
			return true;
		default:
			// If the entered sorts do not match the cases, the text to be printed on the
			// screen
			System.err.println("Enter a valid sorting algorithm");
			return false;
		}
	}

	private static void findSmallestDiff(Integer[] array) {
		// --------------------------------------------------
		// Summary: With this method, we find the smallest value between a pair in the
		// sorted array.
		// Precondition: array is a Integer Array.
		// Postcondition:The pair found and the difference between them are printed
		// using the absolute
		// value.
		// --------------------------------------------------
		int minAbsDiff = Integer.MAX_VALUE;
		int first = 0;
		int second = 0;
		int total = Integer.MAX_VALUE;

		// O(n)
		for (int i = 0; i < array.length - 1; i++) {
			// Takes the difference by looking at the number itself and the next. Math.abs
			// was used so that the result was not negative.
			minAbsDiff = Math.min(minAbsDiff, Math.abs(array[i] - array[i + 1]));
		}

		// O(n)
		for (int i = 0; i < array.length - 1; i++) {
			if (Math.abs(array[i] - array[i + 1]) == minAbsDiff && total > array[i] + array[i + 1]) {
				first = array[i];
				second = array[i + 1];
				total = first + second;
			}
		}

		System.out.println(minAbsDiff + "[" + first + " " + second + "]");
	}

}
