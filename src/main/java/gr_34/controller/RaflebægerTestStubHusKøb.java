package gr_34.controller;

public class RaflebægerTestStubHusKøb extends Raflebæger {

	private int[] testArray = {
			3,3, // Køb Roskildevej
			3,3, // Leje Roskildevej 0 huse = 6kr
			
			1,1, // Køb Valby Langgade
			1,1, // Leje Valby Langgade 0 huse = 6kr
			
			1,0, // Umuligt kast, køb Allégade
			1,0, // Leje Allégade 0 huse alle grunde = 8kr * 2 = 16kr
			
			1,0, // Ligegyldigt kast, bør anmodes om at købe huse - Vælg Allégade
			0,0, // Leje Allégade 1 hus = 40kr
			
			0,0, // Køb hus på anden rød grund. Bør ikke kunne købe på Allégade igen
			0,0, // Leje Allégade 1 hus = 40kr
			
			0,0, // Køb hus på anden rød grund. Bør ikke kunne købe på Allégade igen
			0,0, // Leje Allégade 1 hus = 40kr
			
			0,0, // Køb hus på Allégade
			0,0, // Leje Allégade 2 huse = 100kr
			
			0,0, // Køb hus på anden rød grund. Bør ikke kunne købe på Allégade igen
			0,0, // Leje Allégade 2 hus = 100kr
			
			0,0, // Køb hus på anden rød grund. Bør ikke kunne købe på Allégade igen
			0,0, // Leje Allégade 2 hus = 100kr
			
			0,0, // Køb hus på Allégade
			0,0, // Leje Allégade 3 hus = 300kr
			
			0,0, // Køb hus på anden rød grund. Bør ikke kunne købe på Allégade igen
			0,0, // Leje Allégade 3 hus = 300kr
			
			0,0, // Køb hus på anden rød grund. Bør ikke kunne købe på Allégade igen
			0,0, // Leje Allégade 3 hus = 300kr
			
			0,0, // Køb hus på Allégade
			0,0, // Leje Allégade 4 hus = 450kr
			//osv....
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
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