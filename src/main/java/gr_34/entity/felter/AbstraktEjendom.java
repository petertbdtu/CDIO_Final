package gr_34.entity.felter;

import gr_34.entity.Spiller;

public abstract class AbstraktEjendom extends AbstraktFelt {

	private int pris;
	private Spiller ejer;
	private int pant;
	
	public AbstraktEjendom(String beskrivelse, String subText, String titel, int pris, 
			int pant) {
		super(beskrivelse, subText, titel);
		this.pris = pris;
		this.pant = pant;
	}
	public void setPant(int pant) {
		this.pant = pant;
	}
	public int getPant() {
		return this.pant;
	}

	public Spiller getEjer() {
		return this.ejer;
	}
	public void setEjer(Spiller ejer) {
		this.ejer = ejer;
	}
	public int getPris() {
		return this.pris;
	}
	public void setPris(int pris) {
		this.pris = pris;
	}

}
