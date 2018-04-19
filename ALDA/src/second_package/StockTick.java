package second_package;

public class StockTick {
	private double kurs;
	
	public double getKurs() {
		return kurs;
	}

	public void setKurs(double letzterKurs, float kursDiff) {
		this.kurs = letzterKurs + kursDiff;
	}
	
	
}
