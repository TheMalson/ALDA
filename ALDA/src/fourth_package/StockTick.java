package fourth_package;

public class StockTick {
	private String symbol;
	private int kurs;
	
	public StockTick(String symbol, int course) {
		this.setSymbol(symbol);
		this.setKurs(course);
	}
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getKurs() {
		return kurs;
	}
	public void setKurs(int kurs) {
		this.kurs = kurs;
	}
	
	
	
}
