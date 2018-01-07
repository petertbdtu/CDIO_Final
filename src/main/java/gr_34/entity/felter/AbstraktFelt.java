package gr_34.entity.felter;

public abstract class AbstraktFelt {
	
	private String beskrivelse;
	private String subText;
	private String titel;
	
	public AbstraktFelt(String beskrivelse, String subText, String titel) {
		this.beskrivelse = beskrivelse;
		this.subText = subText;
		this.titel = titel;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getBeskrivelse() {
		return beskrivelse;
	}
	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}
	public void setSubText(String subText) {
		this.subText = subText;
	}
	public String getSubText() {
		return subText;
	}
}
