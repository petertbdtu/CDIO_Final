package gr_34.controller;

public class RaflebægerTestStubTaber extends Raflebæger {

	private int[] testArray = {
			2,3,
			1,-1,
			
			4,6,
			1,-1,
			
			1,5,
			1,-1,
			
			0,2,
			1,-1,
			
			1,0,
			1,-1,
			
			0,2,
			1,-1,
			
			0,1,
			1,-1,
			
			0,2,
			1,-1,
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