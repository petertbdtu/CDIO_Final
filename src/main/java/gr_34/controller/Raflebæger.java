package gr_34.entity;

public class Raflebæger {
	private int sum;
	
	public int kastTerninger() {
		Terning terning = new Terning();
		int a = terning.kast();
		int b = terning.kast();
		sum = a+b;
		
		return sum;
	}

	public int getSum() {
		return sum;
	}

}
