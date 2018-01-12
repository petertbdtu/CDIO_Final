package gr_34.controller;

public class RaflebægerTestStubTaber extends Raflebæger {

	private int[] testArray = {
			2,3,
			0,0,
			
			5,5,
			0,0,
			
			1,5,
			0,0,
			
			1,1,
			0,0,
			
			1,0,
			0,0,
			
			1,1,
			0,0,
			
			0,1,
			0,0,
			
			1,1,
			0,0,
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