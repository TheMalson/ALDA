package fifth_package;

import java.util.Random;
import java.util.Scanner;

public class StockTickArray {

	private StockTick[] stockArray;
	private int numbComparisons;

	public StockTickArray(int länge) {

		stockArray = new StockTick[länge]; 									// Create Stock Tick Array with relevant size

		for (int i = 0; i < länge; i++) { 									// Fill Array with rnd combinations of names and courses
			stockArray[i] = new StockTick(rndSymbol(), rndCourse());
		}

	}
	
	
	public int getNumbComparisons() {
		return numbComparisons;
	}


	public void setNumbComparisons(int numbComparisons) {
		this.numbComparisons = numbComparisons;
	}

	
	public void insertionSort(int left, int right) {
		
		int i,j,l,r,m;
		StockTick x;
		
		//Sort by course
		
		this.numbComparisons = 0;
		for (i=left;i<right+1;i++) {
			
			x = stockArray[i];
			l = 0;
			r = i-1;
			
			while (l<=r) {													//If true, m represents the location the selected (i) StockTick should be
				m = (l + r)/2;
			
				if(lessthan(x.getKurs(),stockArray[m].getKurs())) r = m-1;		//Get the position of next higher or equal courses in sorted part
				else l = m+1;
				
			}
			
			for(j=i-1; j>=l;j--) {												//Shift everything to the right
				stockArray[j+1] = stockArray[j];			
			}
			
			stockArray[l]=x;														//Put selected Stock Tick at right spot in sorted part
		}
		
		
	}
	
	public void quickSort1() {
		numbComparisons=0;
		int left = 0;
		int right = this.stockArray.length-1;
		
		//Sort by courses
		_quickSortC(left,right);
		System.out.println("----------------------------");
		System.out.println("Es wurder erfolgreich nach Kursen sortiert:");
		printStockArray();
		
		//Sort by names
		_quickSortN(left,right);
		System.out.println("----------------------------");
		System.out.println("Es wurder erfolgreich nach Namen sortiert:");
		printStockArray();
		
	}
	
	public void quickSort2() {
		numbComparisons=0;
		int left = 0;
		int right = this.stockArray.length-1;
		
		_quickSortC(left,right);
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Es wurden " + numbComparisons + " Vergleiche bei Median durchgeführt");
		
		
		numbComparisons=0;
		_quickSortCRandom(left,right);
		System.out.println("Es wurden " + numbComparisons + " Vergleiche bei zufälligem Pivot durchgeführt");
		System.out.println("-----------------------------------------------------------------");
		
	}
	
	public void quickSort3() {
		
		numbComparisons=0;
		int left = 0;
		int right = this.stockArray.length-1;
		
		_quickSortC(left,right);
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Es wurden " + numbComparisons + " Vergleiche bei normalem Quick Sort durchgeführt");
		
		
		_quickSortCMix(left,right);
		System.out.println("Es wurden " + numbComparisons + " Vergleiche bei der Mix Methode durchgeführt");
		System.out.println("-----------------------------------------------------------------");
		
	}
	
	private void _quickSortC (int left, int right) {
		
		//Sort by course
		
			int pivot = this.stockArray[(left+right)/2].getKurs();
			int i = left;
			int j = right;
			
			// --Partition--
			
			while (i<=j) {
				while(lessthan(stockArray[i].getKurs(),pivot)) i++;						//As long as course is smaller than pivot, go to next one -->
				while(lessthan(pivot,stockArray[j].getKurs())) j--;						//As long as pivot is smaller than course, go to next one <--
				if(i<=j) {							
					swap(i,j);															//Swap the two StockTicks												
					i++;j--;
				}
			}
			
			// --Rekursion--
			
			if(left<j) _quickSortC(left,j);												//If j has not gone through the whole array. Sort left part
			if(i<right) _quickSortC(i,right);												//If i has not gone through the whole array. Sort right part
			
	}
	
	private void _quickSortCRandom (int left, int right) {
		
		Random r = new Random();
		int pivot = stockArray[(int)((int) (r.nextDouble() * (right-left+1))+left)].getKurs(); 		// Rnd Numb between left and right to choose random pivot;
		int i = left;
		int j = right;
		
		// --Partition--
		
		while (i<=j) {
			while(lessthan(stockArray[i].getKurs(),pivot)) i++;						//As long as course is smaller than pivot, go to next one -->
			while(lessthan(pivot,stockArray[j].getKurs())) j--;						//As long as pivot is smaller than course, go to next one <--
			if(i<=j) {							
				swap(i,j);															//Swap the two StockTicks												
				i++;j--;
			}
		}
		
		// --Rekursion--
		
		if(left<j) _quickSortC(left,j);												//If j has not gone through the whole array. Sort left part
		if(i<right) _quickSortC(i,right);												//If i has not gone through the whole array. Sort right part
		
	}
	
	private void _quickSortCMix (int left, int right) {
		
		int sequArrayLength = right - left + 1;										//If array length is smaller than 11 use insertion sort
		if (sequArrayLength<=10) {
			insertionSort(left,right);
			return;
		}
		
		//Sort by course
		
		int pivot = this.stockArray[(left+right)/2].getKurs();
		int i = left;
		int j = right;
		
		// --Partition--
		
		while (i<=j) {
			while(lessthan(stockArray[i].getKurs(),pivot)) i++;						//As long as course is smaller than pivot, go to next one -->
			while(lessthan(pivot,stockArray[j].getKurs())) j--;						//As long as pivot is smaller than course, go to next one <--
			if(i<=j) {							
				swap(i,j);															//Swap the two StockTicks												
				i++;j--;
			}
		}
		
		// --Rekursion--
		
		if(left<j) _quickSortC(left,j);												//If j has not gone through the whole array. Sort left part
		if(i<right) _quickSortC(i,right);												//If i has not gone through the whole array. Sort right part
		
		
		
	}
	
	private void _quickSortN (int left, int right) {
		
		//Sort by course
		
			String pivot = this.stockArray[(left+right)/2].getSymbol();
			int i = left;
			int j = right;
			
			// --Partition--
			
			while (i<=j) {
				while(letterBefore(stockArray[i].getSymbol(),pivot)) i++;						//As long as course is smaller than pivot, go to next one -->
				while(letterBefore(pivot,stockArray[j].getSymbol())) j--;						//As long as pivot is smaller than course, go to next one <--
				if(i<=j) {							
					swap(i,j);															//Swap the two StockTicks												
					i++;j--;
				}
			}
			
			// --Rekursion--
			
			if(left<j) _quickSortN(left,j);												//If j has not gone through the whole array. Sort left part
			if(i<right) _quickSortN(i,right);												//If i has not gone through the whole array. Sort right part
	}
	
	private boolean lessthan(int x, int y) {
		this.numbComparisons++;
		if(x<y) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean letterBefore(String a, String b) {
		this.numbComparisons++;
		if(a.compareTo(b)<0) return true; 												//Comparison of String Unicode
		return false;
	}
	
	public void printStockArray() {
		for (int i = 0;i<stockArray.length;i++) {
			System.out.println(i+1 + ". " + stockArray[i].getSymbol() + ": " + stockArray[i].getKurs());
		}
	}
			
	private void swap(int i , int j) {
		StockTick p = this.stockArray[i];
		stockArray[i] = stockArray[j];
		stockArray[j] = p;
		this.numbComparisons++;
	}

	private String rndSymbol() {
	
		String[] options = { "AMNZ", "IBM", "CSCO", "HPQ", "GOOG", "ORCL", "BABA", "AAPL", "TWTR", "AMD" };
		Random r = new Random();
		return options[(int) ((int) (r.nextDouble() * options.length))]; // Rnd Numb between 0-9 to choose one option
	}
	
	private int rndCourse() {
		Random r = new Random();
		return (int) (r.nextDouble() * 31) + 60; 						// Rnd Numb between 60-80 to choose one option
	}
}