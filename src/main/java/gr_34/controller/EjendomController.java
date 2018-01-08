package gr_34.controller;

import gr_34.entity.Spiller;
import gr_34.entity.felter.AbstraktEjendom;
import gr_34.entity.felter.Bryggeri;
import gr_34.entity.felter.Gade;
import gr_34.entity.felter.Rederi;
import gui_main.GUI;

public class EjendomController {
	
	private GUI g;
	private Gade[] gader;
	private Bryggeri[] bryggerier;
	private Rederi[] rederier;
	
	public EjendomController (GUI gui, Gade[] gader, Bryggeri[] bryggerier, Rederi[] rederier)
	{
		this.g = gui;
		this.gader = gader;
		this.bryggerier = bryggerier;
		this.rederier = rederier;
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
