package second_package;


import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		
		StockTick[] randomArray = new StockTick[20];
		
		for (int i = 0; i<randomArray.length;i++) {
			randomArray[i] = new StockTick();
		}
		
		Random myRandomNumb = new Random();
		
		//Create random stock
		randomArray[0].setKurs(500, (float)(myRandomNumb.nextFloat() * 200));
		
		for(int i=1;i<randomArray.length;i++) {
			randomArray[i].setKurs(randomArray[i-1].getKurs(), (myRandomNumb.nextFloat() * 40)-20);
		}
		
		//Print Stock Values
		for(int i=0;i<randomArray.length;i++) {
			System.out.print(round(randomArray[i].getKurs()) + "; ");
		}
		System.out.println();
		
		//Call method to get maximum profit + Buy- & Sell-Day
		double[] suggestion = calcOpt(randomArray);
		
		//Display results
		System.out.println("--------------------------------");
		System.out.println("Einkaufstag: " + suggestion[0]);
		System.out.println("Verkaufstag: " + suggestion[1]);
		System.out.println("Profit: " + round(suggestion[2]*100) + " %");

	}
	
	public static double[] calcOpt(StockTick[] stockArray) {
		
		double[] suggestion = new double[3]; // [0] Buy-Suggestion [1] Sell-Suggestion [2] MaxProfit
		int length = stockArray.length;
		
		
		//Calculate max. profit for all possible combinations
		
		double maxProfit=0; 	//Temporary maximum of profits
		int kaufTag=0; 			//Buy-Suggestion (i)
		int verkaufTag=0;			//Sell-Suggestion (j)
		int j=0;
		
		for(int i = 0; i<length;i++) {
				double tempMax = ((stockArray[i].getKurs() - stockArray[j].getKurs())/stockArray[j].getKurs()); 
				if(tempMax>maxProfit) {
					maxProfit = tempMax;
					kaufTag=j+1;
					verkaufTag=i+1;
				} else if (stockArray[i].getKurs()<stockArray[j].getKurs()) {
					j=i;
				}
		}
		
		suggestion[0] = (double)kaufTag; //Buy 	(day)
		suggestion[1] = (double)verkaufTag; //Sell	(day)
		suggestion[2] = maxProfit;		//Profit in percent
		
		
		return suggestion;
	}
	
	public static double round(double numb) {
		return Math.round( numb * 100d ) / 100d;
	}

}
