package gr_34.controller;

import gr_34.boundary.GUIBoundary;
import gr_34.entity.Spiller;

public class SpillerController {
	private GUIBoundary guiB;
	private Spiller[] spillere;
	private int nutidigSpiller;
	
	public SpillerController (GUIBoundary guiB)
	{
		this.guiB = guiB;
		
		int antalSpillere = guiB.anmodIntMinMax("Vælg antal spillere, mellem 2-6", 2, 6);
		int startBalance = 1500;
		
		spillere = new Spiller[antalSpillere];
		for (int i = 0; i < antalSpillere; i++)
		{
			String navn = guiB.anmodString("Indtast " + i +". spillers navn");
			spillere[i] = new Spiller(navn, startBalance);
		}
	}
	
	public void opretSpillere()
	{
		// TODO Opret spillere gennem GUI
	}
	
	public Spiller[] getSpillere()
	{
		return spillere;
	}
	
	public Spiller næsteSpiller()
	{
		Spiller p = spillere[nutidigSpiller];
		nutidigSpiller++;
		return p;
	}
}
