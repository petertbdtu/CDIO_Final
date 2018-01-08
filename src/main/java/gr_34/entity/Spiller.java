package gr_34.entity;

public class Spiller {
	private String navn;
	private Konto konto;
	private int position;
	
	public Spiller(String navn, int startBalance) {
		this.konto = new Konto(startBalance);
		this.navn = navn;
	}
	
	public String getNavn()
	{
		return navn;
	}
	
	public int getPenge()
	{
		return konto.getPenge();
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public void tilføjPenge(int beløb) {
		int sum;
		sum = konto.getPenge()+beløb;
		konto.setPenge(sum);
	}
	
	public void fratrækPenge(int beløb) {
		int sum;
		sum = konto.getPenge()-beløb;
		if (sum < 0) {
			konto.setPenge(0);
		} else
			konto.setPenge(sum);
	}
	
}
