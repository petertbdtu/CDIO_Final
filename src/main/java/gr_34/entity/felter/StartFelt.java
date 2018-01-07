package gr_34.entity.felter;

public class StartFelt extends AbstraktFelt {

	private int startPenge;

	public StartFelt(String beskrivelse, String subText, String titel, int startPenge) {
		super(beskrivelse, subText, titel);
		this.startPenge = startPenge;
	}
	
}
