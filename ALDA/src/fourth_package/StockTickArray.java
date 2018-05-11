package fourth_package;

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

	private String rndSymbol() {

		String[] options = { "AMNZ", "IBM", "CSCO", "HPQ", "GOOG", "ORCL", "BABA", "AAPL", "TWTR", "AMD" };
		Random r = new Random();
		return options[(int) ((int) (r.nextDouble() * options.length))]; // Rnd Numb between 0-9 to choose one option
	}

	private int rndCourse() {
		Random r = new Random();
		return (int) (r.nextDouble() * 31) + 50; 						// Rnd Numb between 50-80 to choose one option
	}

	public void sortStockTickArray() {

		Scanner s = new Scanner(System.in);
		boolean correctInput = false;
		this.numbComparisons = 0;

		while (correctInput != true) {
			System.out.println("");
			System.out.println("Bitte gewünschtes Sortierverfahren angeben:");
			System.out.println("(A) Sortieren durch Einfügen mit sequentieller Suche");
			System.out.println("(B) Sortieren durch Einfügen mit binärer Suche");
			System.out.println("Bitte A oder B eingeben");
			System.out.println("--------------------------------------------------------");

			String userInput = s.nextLine();

			if (userInput.equals("A")) {
				System.out.println("-------------------------------------------------------");
				seqSort();
				correctInput=true;
			} else if (userInput.equals("B")) {
				System.out.println("-------------------------------------------------------");
				binSort();
				correctInput=true;
			} else {
				System.out.println("Falsche Eingabe");
				System.out.println("Bitte wählen Sie eine der gültigen Optionen: A oder B");
			}
		}
		
		this.printStockArray();
		System.out.println("-------------------------------------------------------");
		System.out.println("Das sortieren war erfolgreich.");
		System.out.println("Es wurden dabei " + this.getNumbComparisons() + " Vergleiche durchgeführt.");
	}
	
	
	public void sortStockTickArray(String a) {
			if(a.equals("A")) {
				seqSort();
			} else{
			binSort();
			} 
		}
		
	private void seqSort() {
		int i,j;
		StockTick x;
		
		//Sort by course
		
		for(i = 1; i<stockArray.length;i++) {
			x=stockArray[i];															//Save selected StockTick
			j=i;																		//Create assisting variable
			while (j > 0 && lessthan(x.getKurs(),stockArray[j-1].getKurs())){			//Check where course is smaller than currently selected course
				stockArray[j] = stockArray[j-1];										//If true shift them to the right
				j--;																	//Select next course
			}
			stockArray[j] = x;															//If not smaller than put selected Stock Tick on free spot in array
		}
		
		//Sort by Name
		
		for(i = 1; i<stockArray.length;i++) {
			x=stockArray[i];															//Save selected StockTick
			j=i;																		//Create assisting variable
			while (j > 0 && letterBefore(x.getSymbol(),stockArray[j-1].getSymbol())){	//Check where order is before currently selected String
				stockArray[j] = stockArray[j-1];										//If true shift them to the right
				j--;																	//Select next String
			}
			stockArray[j] = x;															//If not before than put selected Stock Tick on free spot in array
		}
	}
	
	private void binSort() {
		
		int i,j,left,right,m;
		StockTick x;
		
		//Sort by course
	
		for (i=1;i<stockArray.length;i++) {
			
			x = stockArray[i];
			left = 0;
			right = i-1;
			
			while (left<=right) {													//If true, m represents the location the selected (i) StockTick should be
				m = (left + right)/2;
				
				if(lessthan(x.getKurs(),stockArray[m].getKurs())) right = m-1;		//Get the position of next higher or equal courses in sorted part
				else left = m+1;
				
			}
			
			for(j=i-1; j>=left;j--) {												//Shift everything to the right
				stockArray[j+1] = stockArray[j];			
			}
			
			stockArray[left]=x;														//Put selected Stock Tick at right spot in sorted part
		}
		
		//Sort by Name
		
		for (i=1;i<stockArray.length;i++) {
			
			x = stockArray[i];
			left = 0;
			right = i-1;
			
			while (left<=right) {													//If true, m represents the location the selected (i) StockTick should be
				m = (left + right)/2;
				
				if(letterBefore(x.getSymbol(),stockArray[m].getSymbol())) right = m-1;		//Get the position of next higher or equal name in sorted part
				else left = m+1;
				
			}
			
			for(j=i-1; j>=left;j--) {												//Shift everything to the right
				stockArray[j+1] = stockArray[j];			
			}
			
			stockArray[left]=x;														//Put selected Stock Tick at right spot in sorted part
		}
		
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
	
	public boolean isSorted() {
		boolean isSorted = true;
		
		for(int i=0;i<stockArray.length;i++) {
			for(int j=i+1;j<stockArray.length;j++) {
				if(stockArray[i].getSymbol().compareTo(stockArray[j].getSymbol()) > 0) isSorted =false;		//Test symbol
				if(stockArray[i].getSymbol().compareTo(stockArray[j].getSymbol()) == 0) {					//If symbol is the same test courses
				if(stockArray[i].getKurs()>stockArray[j].getKurs()) isSorted =false;
				}
			}
		}
		
		return isSorted;
	}
	
	public int binarySearch(String symbol) {
		
		int left = 0;
		int right = stockArray.length-1;
		int m=0;
		
		System.out.println("Es wird nach " + symbol + " gesucht.");
		
		while(stockArray[m].getSymbol().equals(symbol)!=true && left<=right) {
			
			m =(left+right)/2;
			if(letterBefore(stockArray[m].getSymbol(),symbol)) {
				left = m+1;
			} else { 
				right = m -1;
			}
		} 
		
		if(stockArray[m].getSymbol().equals(symbol)) {
			System.out.println("Position: " +(m+1)+ "; Name: " + stockArray[m].getSymbol() + "; Kurs: "  + stockArray[m].getKurs());
			return m;
		} else {
			System.out.println("Keine Übereinstimmung gefunden!");
		}
		
		return -1;
		
		
	}
}
