package gr_34.entity;

public class Spiller {
	private String navn;
	private Konto konto;
	private int position;
	private Boolean fallit;
	private boolean iFængsel;
	private int antalFængselsTure;
	private boolean ekstraTur;
	private int antalEkstraTure;

	public Spiller(String navn, int startBalance) {
		this.konto = new Konto(startBalance);
		this.navn = navn;
		fallit = false;
		iFængsel = false;
		antalFængselsTure = 0;
	}

	public String getNavn() {
		return navn;
	}

	public int getPenge() {
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
		sum = konto.getPenge() + beløb;
		konto.setPenge(sum);
	}

	public void fratrækPenge(int beløb) {
		int sum;
		sum = konto.getPenge() - beløb;
		if (sum < 0) {
			konto.setPenge(0);
			fallit = true;
		} else
			konto.setPenge(sum);
	}

	public boolean erFallit() {
		return fallit;
	}

	public void setIFængsel(boolean erIFængsel) {
		this.iFængsel = erIFængsel;
	}

	public boolean erIFængsel() {
		return this.iFængsel;
	}

	public void forøgFængselsTure() {
		antalFængselsTure++;
	}

	public void nulstilFængselsTure() {
		antalFængselsTure = 0;
	}
	
	public int getFængselsTure()
	{
		return antalFængselsTure;
	}
	
	public boolean getEkstraTur()
	{
		return ekstraTur;
	}
	
	public void setEkstraTur(boolean ekstraTur)
	{
		this.ekstraTur = ekstraTur;
	}
	
	public int getAntalEkstraTure()
	{
		return this.antalEkstraTure;
	}
	
	public void forøgAntalEkstraTur()
	{
		this.antalEkstraTure++;
	}
	
	public void nulstilAntalEkstraTur()
	{
		this.antalEkstraTure = 0;
	}
}
