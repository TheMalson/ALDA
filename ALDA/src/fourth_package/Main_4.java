package fourth_package;

import java.util.Random;
import java.util.Scanner;

public class Main_4 {

	public static void main(String[] args) {

	Scanner s = new Scanner(System.in);	
	System.out.println("Aufgebntyp wählen: (a) Testarray erstellen und sortieren oder (b) Vergleich der Sortierverfahren oder (c) Nach Firmensymbol suchen");

	String answer = s.nextLine();
	
	if(answer.equals("a")){
		firstTask();
	} else if(answer.equals("b")) {
		secondTask();
	} else if(answer.equals("c")){
		thirdTask();
	}
	
	}

	
	public static void firstTask() {
		//Aufgebenteil a)
			
		StockTickArray test1 = new StockTickArray(100);	
		System.out.println("Orginales Array:");
		test1.printStockArray();
		test1.sortStockTickArray();
	}
	
	public static void secondTask() {
		
		//Aufgabenteil b)
		
		int numbComparisonsSeq = 0;
		int numbComparisonsBin = 0;
		int numbOfTests = 10;
			
		for (int i = 0;i<numbOfTests;i++) {	
		StockTickArray newArray = new StockTickArray(100);
		
		//Sort the Array in the two possible ways and safe numb of Comparisons
		newArray.sortStockTickArray("A");
		numbComparisonsSeq += newArray.getNumbComparisons();
		newArray.sortStockTickArray("B");
		numbComparisonsBin += newArray.getNumbComparisons();
		}

		System.out.println("Durchschnittliche Anzahl an Vergleichen:");
		System.out.println("Sequenziell: " + numbComparisonsSeq/numbOfTests);
		System.out.println("Binär: " + numbComparisonsBin/numbOfTests);
	}
	
	public static void thirdTask() {
		
		//Aufgabenteil c)
		
		Scanner s = new Scanner(System.in);
		String symbol;
		
		System.out.println("Bitte geben sie das gesuchte Firmensymbol ein:");
		symbol = s.nextLine();
		
		//Create exemplary Array to test on
		StockTickArray exampleArray = new StockTickArray(100);	
		exampleArray.sortStockTickArray("B");
		exampleArray.printStockArray();
		
		//Test weather array is sorted
		
		if(exampleArray.isSorted()) {
			
			//Binary Search
			exampleArray.binarySearch(symbol);	
			
			
		} else {
			System.out.println("Fehler! Array ist nicht sortiert");
		}
	}
	
	
}
