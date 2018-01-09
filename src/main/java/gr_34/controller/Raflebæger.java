package gr_34.controller;
import gr_34.entity.Terning;

public class Raflebæger {
	private int øjneVærdi0;
	private int øjneVærdi1;
	private int sum;
	
	public int kastTerninger() {
		Terning terning = new Terning();
		øjneVærdi0 = terning.kast();
		øjneVærdi1 = terning.kast();
		sum = øjneVærdi0+øjneVærdi1;
		
		return sum;
	}
	
	

	public int getØjne0() {
		return øjneVærdi0;
	}



	public int getØjne1() {
		return øjneVærdi1;
	}



	public int getSum() {
		return sum;
	}

}
