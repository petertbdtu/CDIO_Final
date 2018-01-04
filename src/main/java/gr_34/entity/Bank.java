package gr_34.entity;

public class Bank {
	private Konto konto;
	
	public Bank (Konto konto) {
		this.konto = konto;
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
