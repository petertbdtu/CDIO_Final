package gr_34.controller;

import gr_34.boundary.GUIBoundary;
import gr_34.entity.Spiller;

public class SpillerController {
	private GUIBoundary guiB;
	private Spiller[] spillere;
	private int antalSpillere;
	private int nutidigSpillerIndex;
	
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
			String navn = this.guiB.anmodString("Indtast " + (i+1) +". spillers navn");
			spillere[i] = new Spiller(navn, startBalance);
		}
	}
	
	public Spiller[] getSpillere()
	{
		return spillere;
	}
	
	public void gåTilNæsteSpiller()
	{
		if (spillere[nutidigSpillerIndex].getEkstraTur())
		{
			spillere[nutidigSpillerIndex].setEkstraTur(false);
			spillere[nutidigSpillerIndex].forøgAntalEkstraTur();
			
			if (spillere[nutidigSpillerIndex].getAntalEkstraTure() >= 3)
			{
				// TODO Spiller skal fængsles efter 3 ekstra ture.
				guiB.sendBesked("Spiller burde fængsles!");
				
			}
			else
			{
				// Spiller får sin ekstra tur.
				guiB.sendBesked(spillere[nutidigSpillerIndex].getNavn() +
						" slog to ens så De får en ekstra tur!");
			}
			
		}
		else // Skifter spiller hvis de ikke har ekstra tur.
		{
			spillere[nutidigSpillerIndex].nulstilAntalEkstraTur();
			nutidigSpillerIndex = (nutidigSpillerIndex+1) % antalSpillere;
		}
		
		// Springer spillere over hvis de er gået fallit. Inklusiv dem med ekstra tur.
		if (spillere[nutidigSpillerIndex].erFallit())
			gåTilNæsteSpiller();
		
	}
	
	public Spiller getNutidigSpiller() 
	{
		return spillere[nutidigSpillerIndex];
	}
	
	public int getNutidigSpillerIndex()
	{
		return nutidigSpillerIndex;
	}
	
	/**
	 * Returnerer true hvis der kun er en (eller nul) spillere der ikke er fallit.
	 * @return 
	 */
	public Boolean harVinder()
	{
		int antalIkkeFallit = 0;
		for (Spiller s : spillere)
			if ( !s.erFallit() ) antalIkkeFallit++;
		if (antalIkkeFallit <= 1)
			return true;
		return false;
	}
	
	/**
	 * 
	 * @return første ikke-fallitte spiller. Null hvis der ikke er nogen ikke-fallitte.
	 */
	public Spiller getVinder()
	{
		for (Spiller s : spillere)
			if ( !s.erFallit() ) return s;
		return null;
	}
	
}
