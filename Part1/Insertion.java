//---------------------------------------------
// Title: Quick Class
// Author: Robert Sedgewick, Kevin Wayne - Algorithms-Addison-Wesley Professional (2011)
// page 251
// Description: This class uses for sorting.
//---------------------------------------------

public class Insertion {
	public static void sort(Comparable[] a) { // Sort a[] into increasing order.
		int N = a.length;
		for (int i = 1; i < N; i++) { // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
				exch(a, j, j - 1);
		}
	}

	
	public static void descSort(Comparable[] a) {
		// ---------------------------
		// Summary:This method same as the sort method with one difference we want to array
		// start with the biggest number so "for" loop designed this way.
		// ---------------------------
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && less(a[j - 1], a[j]); j--)
				exch(a, j, j - 1);
		}
	}


	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {

		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;

	}

	public static boolean isSorted(Comparable[] a) { // Test whether the array entries are in order.
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}

}
