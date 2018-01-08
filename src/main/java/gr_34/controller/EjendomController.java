package gr_34.controller;

import gr_34.entity.Spiller;
import gr_34.entity.felter.AbstraktEjendom;
import gr_34.entity.felter.AbstraktFelt;
import gr_34.entity.felter.Bryggeri;
import gr_34.entity.felter.Gade;
import gr_34.entity.felter.Rederi;
import gui_main.GUI;

public class EjendomController {
	
	private GUI g;
	private final int ANTAL_GADER = 22;
	private final int ANTAL_BRYGGERIER = 2;
	private final int ANTAL_REDERIER = 4;
	private Gade[] gader = new Gade[ANTAL_GADER];
	private Bryggeri[] bryggerier = new Bryggeri[ANTAL_BRYGGERIER];
	private Rederi[] rederier = new Rederi[ANTAL_REDERIER];
	
	public EjendomController (GUI gui, BrætController bræt)
	{
		this.g = gui;
		
		AbstraktFelt[] felter = bræt.getFelter();
		
		// TODO Find ud af om der er en bedre måde at finde alle slags ejendomme.
		
		int gadeTæller = 0;
		int rederiTæller = 0;
		int bryggeriTæller = 0;
		
		for (int i = 0; i < felter.length; i++)
		{
			if (felter[i] instanceof Gade)
			{
				gader[gadeTæller] = (Gade) felter[i];
				gadeTæller++;
			}
			else if (felter[i] instanceof Rederi)
			{
				rederier[rederiTæller] = (Rederi) felter[i];
				rederiTæller++;
			}
			else if (felter[i] instanceof Bryggeri)
			{
				bryggerier[bryggeriTæller] = (Bryggeri) felter[i];
				bryggeriTæller++;
			}
		}
		
	}
	
	public void ramtEjendom(AbstraktEjendom ejendom, Spiller spiller)
	{
		if (ejendom instanceof Gade)
			ramtGade( (Gade) ejendom, spiller);
		
		else if (ejendom instanceof Rederi)
			ramtRederi( (Rederi) ejendom, spiller);
		
		else if (ejendom instanceof Bryggeri)
			ramtBryggeri( (Bryggeri) ejendom, spiller);
		
	}
	
	private void ramtGade(Gade ejendom, Spiller spiller)
	{
		// TODO gade-logik. Kræver viden om samme farve gader?
	}
	
	private void ramtRederi(Rederi ejendom, Spiller spiller)
	{
		// TODO rederi-logik. Kræver viden om alle rederier.
	}
	
	private void ramtBryggeri(Bryggeri ejendom, Spiller spiller)
	{
		// TODO bryggeri-logik. Kræver viden om alle bryggerier
	}
}
