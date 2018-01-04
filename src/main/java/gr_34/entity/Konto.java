package gr_34.entity;
/**
 * 
 * @author Sebastian
 *
 */

public class Konto {
	private int penge;
	
	public Konto(int penge) {
		this.penge = penge;
	}

	public int getPenge() {
		return penge;
	}

	public void setPenge(int penge) {
		this.penge = penge;
	}

	public String toString() {
		return "["+penge+"]";
	}
	
}
