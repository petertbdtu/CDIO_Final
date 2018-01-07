package gr_34.entity;

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
}
