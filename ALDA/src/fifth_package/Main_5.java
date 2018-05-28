package fifth_package;



public class Main_5 {

	public static void main(String[] args) {
		
		StockTickArray SArray = new StockTickArray(100);
		
		//Task 1
		
		System.out.println("");
		System.out.println("Augabe 1");
		SArray.printStockArray();
		SArray.quickSort1();
		SArray.printStockArray();
	
		//Task 2
		
		System.out.println("");
		System.out.println("Augabe 2");
		SArray.quickSort2();
		
		
		//Task 3
		
		System.out.println("");
		System.out.println("Augabe 3");
		SArray.quickSort3();
		
		

	}

}
