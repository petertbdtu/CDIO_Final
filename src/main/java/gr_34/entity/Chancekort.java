package gr_34.entity;

public class Chancekort {
	private String beskrivelse;
	private ChanceEffekt effekt;
	
	public Chancekort(String beskrivelse, ChanceEffekt effekt) {
		this.beskrivelse = beskrivelse;
		this.effekt = effekt;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public ChanceEffekt getEffekt() {
		return effekt;
	}

	public void setEffekt(ChanceEffekt effekt) {
		this.effekt = effekt;
	}
	
}
