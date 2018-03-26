package sortersTesterClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import sorterClasses.BubbleSortSorter;
import sorterClasses.InsertionSortSorter;
import sorterClasses.SelectionSortSorter;
import interfaces.Sorter;

public class Excercise2Tester {

	//private static Sorter<Integer> sorter; 
	private static Random rnd; 

	private static ArrayList<Sorter<Integer>> sortersList1 = new ArrayList<>(); 

	public static void main(String[] args) { 

		sortersList1.add(new SelectionSortSorter<Integer>()); 
		sortersList1.add(new InsertionSortSorter<Integer>()); 
		sortersList1.add(new BubbleSortSorter<Integer>());


		test1("Sorting Using Default Comparator<Integer>", null); 
		test1("Sorting Using IntegerComparator1", new IntegerComparator1()); 
		test1("Sorting Using IntegerComparator2", new IntegerComparator2()); 

	}

	private static void test1(String msg, Comparator<Integer> cmp) { 

		System.out.println("\n\n*******************************************************");
		System.out.println("*** " + msg + "  ***");
		System.out.println("*******************************************************");

		Integer[]  arr; 

		Integer[] original =  {5, 9, 20, 22, 20, 5, 4, 13, 17, 8, 22, 1, 3, 7, 11, 9, 10};

		// generate random arrays is size i and test...

		showArray("\n ---Original array of size " + original.length + " to sort:", original); 

		for (int s=0; s<sortersList1.size(); s++) {
			Sorter<Integer> sorter = sortersList1.get(s); 
			arr = original.clone(); 
			sorter.sort(arr, cmp);
			showArray(sorter.getName() + ": ", arr); 
		}
	}


	private static void showArray(String msg, Integer[] a) {
		System.out.print(msg); 
		for (int i=0; i<a.length; i++) 
			System.out.print("\t" + a[i]); 
		System.out.println();
	}


}
