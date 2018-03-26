package sortersTesterClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import interfaces.Sorter;
import sorterClasses.BubbleSortSorter;
import sorterClasses.InsertionSortSorter;
import sorterClasses.SelectionSortSorter;

public class IntegerSorterEnteroTester {
	//private static Sorter<Integer> sorter; 
	private static Random rnd; 
	private static ArrayList<Sorter<Entero>> sortersList = new ArrayList<>(); 

	public static void main(String[] args) { 

		sortersList.add(new SelectionSortSorter<Entero>()); 
		sortersList.add(new InsertionSortSorter<Entero>()); 
		sortersList.add(new BubbleSortSorter<Entero>());

		test("Sorting Using Default Comparator<Integer>", null); 
	}

	private static void test(String msg, Comparator<Entero> cmp) { 
		rnd = new Random(101); 

		System.out.println("\n\n*******************************************************");
		System.out.println("*** " + msg + "  ***");
		System.out.println("*******************************************************");

		Entero[] original, arr; 
		// generate random arrays is size i and test...
		for (int i=1; i<=20; i += 5) { 
			original = randomValues(i);
			showArray("\n ---Original array of size " + i + " to sort:", original); 

			for (int s=0; s<sortersList.size(); s++) {
				Sorter<Entero> sorter = sortersList.get(s); 
				arr = original.clone(); 
				sorter.sort(arr, cmp);
				showArray(sorter.getName() + ": ", arr); 
			}
		}
	}


	private static void showArray(String msg, Entero[] a) {
		System.out.print(msg); 
		for (int i=0; i<a.length; i++) 
			System.out.print("\t" + a[i]); 
		System.out.println();
	}


	private static Entero[] randomValues(int i) {
		Entero[] a = new Entero[i]; 
		for (int j=0; j<i; j++) {
			Entero ab = new Entero(rnd.nextInt(100));
			a[j] = ab;
		}
		return  a;
	}


}
