//---------------------------------------------
// Title: Quick Class
// Author: Robert Sedgewick, Kevin Wayne - Algorithms-Addison-Wesley Professional (2011)
// page 273
// Description: This class uses for sorting.
//---------------------------------------------
public class Merge {

	private static Comparable[] aux; // auxiliary array for merges

	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length]; // Allocate space just once.
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) { // Sort a[lo..hi].
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid); // Sort left half.
		sort(a, mid + 1, hi); // Sort right half.
		//merge(a, lo, mid, hi); // Merge results (code on page 271).
		mergeDesc(a, lo, mid, hi);
	}
	
	/*public static void sort2(Comparable[] a, int lo, int hi) { // Sort a[lo..hi].
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid); // Sort left half.
		sort(a, mid + 1, hi); // Sort right half.
		//merge(a, lo, mid, hi); // Merge results (code on page 271).
		mergeDesc(a, lo, mid, hi);
	}*/

	public static void merge(Comparable[] a, int lo, int mid, int hi) { // Merge a[lo..mid] with a[mid+1..hi].
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
			aux[k] = a[k];
		for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
	}

	public static void mergeDesc(Comparable[] a, int lo, int mid, int hi) { // Merge a[lo..mid] with a[mid+1..hi].
		// ---------------------------
		// Summary:This method same as the merge method with one difference we want to array
		// start with the biggest number so I changed the only one line to do that.
		// ---------------------------
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
			aux[k] = a[k];
		for (int k = lo; k <= hi; k++)
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[i], aux[j])) // when we change the this line only, it gives us descending order array
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
	}

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}

}
