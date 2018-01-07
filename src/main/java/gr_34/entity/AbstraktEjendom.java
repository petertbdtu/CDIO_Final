package gr_34.entity;

public abstract class AbstraktEjendom extends AbstraktFelt {

	private int pris;
	private Spiller ejer;
	private int pant;
	
	public AbstraktEjendom(String beskrivelse, String subText, String titel, int pris, 
			Spiller ejer, int pant) {
		super(beskrivelse, subText, titel);
		this.pris = pris;
		this.ejer = ejer;
		this.pant = pant;
	}
	public void setPant(int pant) {
		this.pant = pant;
	}
	public int getPant() {
		return this.pant;
	}

	public Color getFarve() {
		return farve;
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
