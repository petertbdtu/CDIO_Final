package gr_34.entity.felter;

import java.awt.Color;

public class Gade extends AbstraktEjendom {

	private int[] leje;
	private int bygningPris;
	private int antalBygninger; // 5 = 1 hotel
	private Color farve;

	public Gade(String beskrivelse, String subText, String titel, int pris, int pant, Color farve, int[] leje,
			int bygningPris) {
		super(beskrivelse, subText, titel, pris, pant);
		this.leje = leje;
		this.farve = farve;
		this.bygningPris = bygningPris;
		antalBygninger = 0;
	}

	public int getBygningPris() {
		return bygningPris;
	}

	public int getAntalBygninger() {
		return antalBygninger;
	}

	public void fjernBygning() {
		this.antalBygninger++;
	}

	public void tilføjBygning() {
		this.antalBygninger++;
	}

	public Color getFarve() {
		return farve;
	}

	public int getLeje() {
		return leje[this.antalBygninger];
	}

}
