package gr_34.controller;

public class RaflebægerTestStubFængsel extends Raflebæger {

	private int[] testArray = {
			6,6,
			1,-1,
			
			6,6,
			1,-1,
			
			3,3,
			1,-1,
			
			3,3,
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