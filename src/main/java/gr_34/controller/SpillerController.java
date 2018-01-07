package gr_34.controller;

import gr_34.entity.Spiller;

public class SpillerController {
	private Spiller[] spillere;
	private int nutidigSpiller;
	
	public SpillerController (Spiller[] spillere)
	{
		this.spillere = spillere;
		nutidigSpiller = 0;
	}
	
	public Spiller næsteSpiller()
	{
		Player p = spillere[nutidigSpiller];
		nutidigSpiller++;
		// TODO 
		return p;
	}
}
