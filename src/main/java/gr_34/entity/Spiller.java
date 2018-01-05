package gr_34.entity;

public class Spiller {
	private String navn;
	private Konto konto;
	
	public Spiller(String navn, Konto konto) {
		this.konto = konto;
		this.navn = navn;
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
