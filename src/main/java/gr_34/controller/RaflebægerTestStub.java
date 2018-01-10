package gr_34.controller;

public class RaflebægerTestStub extends Raflebæger {

	private int[] testArray = {
			1,4, // Køb Rederi Øresund
			4,1, // Leje 25
			
			5,5, // Rederi Ø.K.
			5,5, // 50
			
			5,5, // Rederi Bornholm
			5,5, // 100
			
			5,5, // Rederi D.F.D.S.
			5,5, // 200
			
			// Passer start på henholdsvis hver deres tur.
			5,1, // Køb Rødovrevej
			2,4, // Leje 2
			
			6,3, // Fængselsbesøg
			3,3, // Chancekort (Ikke implementeret, kræver yderligere teststub)
			
			1,1, // Køb Tuborg
			2,3, // Leje Tuborg
			6,6, // Udregning af leje m. et bryggeri, (6+6)*4 = 48
			
			4,4, // Helle
			4,3, // Køb Strandvej af anden spiller
			
			3,5, // Køb Carlsberg
			6,3, // Leje Carlsberg
			1,1, // Udregning af leje m. begge bryggerier, (1+1)*10 = 20
			
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