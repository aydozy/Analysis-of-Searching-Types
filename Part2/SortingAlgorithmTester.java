
//---------------------------------------------
// Title: SortingAlgorithmTester Class
// Author: Ayda Nil Özyürek
// Description: It is a class that provides an understanding of the performance of sorts.
//---------------------------------------------
import java.util.Random;
import java.util.Scanner;

public class SortingAlgorithmTester {

	public static void main(String[] args) {

		// "seed" taken from the user as a input.
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a seed to create random generated values :");
		System.out.print("Seed : ");
		int seed = scanner.nextInt();

		// inputSize integer array
		int[] inputSizes = { 250, 1000, 4000, 16000, 64000 };

		// Since each inputSize entered is written to the screen in all sort types we
		// have, a string array has been created.
		String[] algorithms = { "Selection", "Insertion", "Merge", "Quick" };

		createAndSort(seed, inputSizes, algorithms);

	}

	private static void createAndSort(int seed, int[] inputSize, String[] algorithms) {
		// ---------------------------
		// Summary:This method calculates time in 4 different sort type according to
		// inputSize
		// Precondition: seed is integer, algorithms is String array and inputSize is
		// integer array
		// Postcondition: Returns 4 different sorts for the 5 different inputSize and
		// exits the
		// loop. So we see the elapsed time for each sort.
		// ---------------------------
		String[] sortOption = new String[1];

		for (int i = 0; i < inputSize.length; i++) {
			System.out.println("İnput size: " + inputSize[i]);
			System.out.println();

			for (int j = 0; j < algorithms.length; j++) {
				sortOption[0] = algorithms[j];

				System.out.println();
				System.out.println("Sort option: " + algorithms[j]);
				System.out.println("Random");
				Integer[] array = createArray(seed, inputSize[i]);
				// 1
				long start = System.currentTimeMillis();
				Method.Method(array, sortOption);
				long end = System.currentTimeMillis();
				// 2
				start = System.currentTimeMillis();
				Method.Method(array, sortOption);
				end = System.currentTimeMillis();
				// 3
				start = System.currentTimeMillis();
				Method.Method(array, sortOption);
				end = System.currentTimeMillis();
				System.out.println("Time: " + (end - start));

				System.out.println("Ascending");
				array = createAscArray(seed, inputSize[i]);
				// 1
				start = System.currentTimeMillis();
				Method.Method(array, sortOption);
				end = System.currentTimeMillis();
				// 2
				start = System.currentTimeMillis();
				Method.Method(array, sortOption);
				end = System.currentTimeMillis();
				// 3
				start = System.currentTimeMillis();
				Method.Method(array, sortOption);
				end = System.currentTimeMillis();
				System.out.println("Time: " + (end - start));

				System.out.println("Descending");
				array = createDescArray(seed, inputSize[i]);
				// 1
				start = System.currentTimeMillis();
				Method.Method(array, sortOption);
				end = System.currentTimeMillis();
				// 2
				start = System.currentTimeMillis();
				Method.Method(array, sortOption);
				end = System.currentTimeMillis();
				// 3
				start = System.currentTimeMillis();
				Method.Method(array, sortOption);
				end = System.currentTimeMillis();

				System.out.println("Time: " + (end - start));
			}
		}
	}

	public static Integer[] createArray(int seed, int inputSize) {
		// ---------------------------
		// Summary:An array using the same seed value is created and all operations are
		// done on this array.
		// ---------------------------

		Integer[] array = new Integer[inputSize];
		Random random = new Random(seed);

		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt();
		}

		return array;
	}

	private static Integer[] createDescArray(int seed, int inputSize) {
		// ---------------------------
		// Summary:This method creates an array in descending order using the seed and
		// size.
		// ---------------------------

		Integer[] temp = createArray(seed, inputSize);
		Quick.sort(temp);

		Integer[] array = new Integer[inputSize];
		for (int i = inputSize - 1; i >= 0; i--) {
			array[i] = temp[inputSize - i - 1];
		}

		return array;
	}

	private static Integer[] createAscArray(int seed, int inputSize) {
		// ---------------------------
		// Summary:This method creates an array in ascending order using the seed and
		// size.
		// Since my sort algorithms already do ascending sorting, I created an ascending
		// order array using the quick sort in this method.
		// ---------------------------
		Integer[] array = createArray(seed, inputSize);
		Quick.sort(array);

		return array;
	}

}
