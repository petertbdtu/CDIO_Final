package gr_34.controller;

import gr_34.boundary.GUIBoundary;
import gr_34.entity.Spiller;

public class SpillerController {
	private GUIBoundary guiB;
	private Spiller[] spillere;
	private int antalSpillere;
	private int nutidigSpiller;
	
	public SpillerController (GUIBoundary guiB)
	{
		this.guiB = guiB;
	}
	
	/**
	 * 
	 * @param startBalance
	 */
	public void opretSpillere(int startBalance)
	{
		antalSpillere = this.guiB.anmodIntMinMax("Vælg antal spillere, mellem 2-6", 2, 6);
		
		spillere = new Spiller[antalSpillere];
		for (int i = 0; i < antalSpillere; i++)
		{
			String navn = this.guiB.anmodString("Indtast " + i +". spillers navn");
			spillere[i] = new Spiller(navn, startBalance);
		}
	}
	
	public Spiller[] getSpillere()
	{
		return spillere;
	}
	
	public Spiller næsteSpiller()
	{
		nutidigSpiller = (nutidigSpiller+1) % antalSpillere;
		Spiller p = spillere[nutidigSpiller];
		return p;
	}
}
