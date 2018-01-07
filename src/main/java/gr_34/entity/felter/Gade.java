package gr_34.entity.felter;

import java.awt.Color;

public class Gade extends AbstraktEjendom {

	private int[] leje; 
	private int bygningPris;
	private int antalBygning; // 5 = 1 hotel
	private Color farve;

	public Gade(String beskrivelse, String subText, String titel, int pris, 
			int pant, Color farve, int[] leje, int bygningPris) {
		super(beskrivelse, subText, titel, pris, pant);
		this.leje = leje;
		this.farve = farve;
		this.bygningPris = bygningPris;
		antalBygning = 0;
	}

	public int getBygningPris() {
		return bygningPris;
	}

	public void setBygningPris(int bygningPris) {
		this.bygningPris = bygningPris;
	}

	public int getAntalBygning() {
		return antalBygning;
	}

	public void setAntalBygning(int antalBygning) {
		this.antalBygning = antalBygning;
	}

	public Color getFarve() {
		return farve;
	}

	public int getLeje() {
		return leje[antalBygning];
	}

	public void setLeje(int[] leje) {
		this.leje = leje;
	}
	
	
}
