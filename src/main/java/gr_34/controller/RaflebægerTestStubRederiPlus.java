package gr_34.controller;

public class RaflebægerTestStubRederiPlus extends Raflebæger {

	private int[] testArray = {
			1,4, // Køb Rederi Øresund
			4,1, // Leje 25
			
			4,6, // Rederi Ø.K.
			4,6, // 50
			
			4,6, // Rederi Bornholm
			4,6, // 100
			
			4,6, // Rederi D.F.D.S.
			4,6, // 200
			
			// Passer start på henholdsvis hver deres tur.
			5,1, // Køb Rødovrevej
			2,4, // Leje 2
			
			6,3, // Fængselsbesøg
			3,4, // Valby Langgade 
			
			0,2, // Køb Tuborg
			1,3, // Leje Tuborg
			6,6, // Udregning af leje m. et bryggeri, (6+6)*4 = 48
			
			3,5, // Helle
			4,3, // Køb Strandvej af anden spiller
			
			3,5, // Køb Carlsberg
			6,3, // Leje Carlsberg
			1,1, // Udregning af leje m. begge bryggerier, (1+1)*10 = 20
			
			2,3, // Chancefelt
			1,1, // Fængsel med ekstra tur
			
			};
	private int rollNum = 0;
	
	private int v1, v2, s;
	
	@Override
	public int kastTerninger() {
		v1 = testArray[rollNum];
		v2 = testArray[rollNum+1];
		
		rollNum = (rollNum + 2) % testArray.length;
		
		s = v1 + v2;
		return s;
	}
	
	@Override
	public int getØjne0() {
		return v1;
	}

	@Override
	public int getØjne1() {
		return v2;
	}

	@Override
	public int getSum() {
		return s;
	}
}