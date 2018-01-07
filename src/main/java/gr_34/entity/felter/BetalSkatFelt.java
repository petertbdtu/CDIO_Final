package gr_34.entity.felter;

public class BetalSkatFelt extends AbstraktFelt {

	private int betalPris;

	public BetalSkatFelt(String beskrivelse, String subText, String titel, int betalPris) {
		super(beskrivelse, subText, titel);
		this.betalPris = betalPris;
	}
	
}
