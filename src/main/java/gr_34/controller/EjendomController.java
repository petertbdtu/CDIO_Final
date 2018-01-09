package gr_34.controller;

import gr_34.boundary.GUIBoundary;
import gr_34.entity.Spiller;
import gr_34.entity.felter.AbstraktEjendom;
import gr_34.entity.felter.AbstraktFelt;
import gr_34.entity.felter.Bryggeri;
import gr_34.entity.felter.Gade;
import gr_34.entity.felter.Rederi;

public class EjendomController {

	private GUIBoundary g;
	private final int ANTAL_GADER = 22;
	private final int ANTAL_BRYGGERIER = 2;
	private final int ANTAL_REDERIER = 4;
	private Gade[] gader = new Gade[ANTAL_GADER];
	private Bryggeri[] bryggerier = new Bryggeri[ANTAL_BRYGGERIER];
	private Rederi[] rederier = new Rederi[ANTAL_REDERIER];

	public EjendomController(GUIBoundary gui, BrætController bræt) {
		this.g = gui;

		AbstraktFelt[] felter = bræt.getFelter();

		// TODO Find ud af om der er en bedre måde at finde alle slags ejendomme.

		int gadeTæller = 0;
		int rederiTæller = 0;
		int bryggeriTæller = 0;

		for (int i = 0; i < felter.length; i++) {
			if (felter[i] instanceof Gade) {
				gader[gadeTæller] = (Gade) felter[i];
				gadeTæller++;
			} else if (felter[i] instanceof Rederi) {
				rederier[rederiTæller] = (Rederi) felter[i];
				rederiTæller++;
			} else if (felter[i] instanceof Bryggeri) {
				bryggerier[bryggeriTæller] = (Bryggeri) felter[i];
				bryggeriTæller++;
			}
		}

	}

	public void ramtEjendom(AbstraktEjendom ejendom, Spiller spiller) {
		if (ejendom instanceof Gade)
			ramtGade((Gade) ejendom, spiller);

		else if (ejendom instanceof Rederi)
			ramtRederi((Rederi) ejendom, spiller);

		else if (ejendom instanceof Bryggeri)
			ramtBryggeri((Bryggeri) ejendom, spiller);

	}

	private void ramtGade(Gade ejendom, Spiller spiller) {
		int gadePris = ejendom.getPris();
		// TODO logik iforhold til antal af ejede gader tjek array hver tur?
		if (ejendom.getEjer() == null)
		{
			ramtUkøbtEjendom(ejendom, spiller);
		}
		else if (ejendom.getEjer() != spiller)
		{
			spiller.fratrækPenge(gadePris);
			ejendom.getEjer().tilføjPenge(gadePris);
			g.sendBesked(spiller.getNavn() + "lander på " + ejendom.getTitel() + " som er ejet af "
					+ ejendom.getEjer().getNavn() + ". " + spiller.getNavn() + " betaler " + ejendom.getEjer().getNavn()
					+ gadePris + "kr."); 
		}
		else
			g.sendBesked(spiller.getNavn() + " er landet på en gade som De selv ejer");
	}

	private void ramtRederi(Rederi ejendom, Spiller spiller) {
		int rederiPris = ejendom.getPris();
		// TODO logik iforhold til antal af ejede gader tjek array hver tur?
		if (ejendom.getEjer() == null)
		{
			ramtUkøbtEjendom(ejendom, spiller);
		}
		else if (ejendom.getEjer() != spiller)
		{
			spiller.fratrækPenge(rederiPris);
			ejendom.getEjer().tilføjPenge(rederiPris);
			g.sendBesked(spiller.getNavn() + "lander på " + ejendom.getTitel() + " som er ejet af "
					+ ejendom.getEjer().getNavn() + ". " + spiller.getNavn() + " betaler " + ejendom.getEjer().getNavn()
					+ rederiPris + "kr."); 
		}
		else
			g.sendBesked(spiller.getNavn() + " er landet på en gade som De selv ejer");
	}

	private void ramtBryggeri(Bryggeri ejendom, Spiller spiller) {
		int bryggeriPris = ejendom.getPris();
		// TODO logik iforhold til antal af ejede gader tjek array hver tur?
		if (ejendom.getEjer() == null)
		{
			ramtUkøbtEjendom(ejendom, spiller);
		}
		else if (ejendom.getEjer() != spiller)
		{
			spiller.fratrækPenge(bryggeriPris);
			ejendom.getEjer().tilføjPenge(bryggeriPris);
			g.sendBesked(spiller.getNavn() + "lander på " + ejendom.getTitel() + " som er ejet af "
					+ ejendom.getEjer().getNavn() + ". " + spiller.getNavn() + " betaler " + ejendom.getEjer().getNavn()
					+ bryggeriPris + "kr."); 
		}
		else
			g.sendBesked(spiller.getNavn() + " er landet på en gade som De selv ejer");
	}
	
	private void ramtUkøbtEjendom(AbstraktEjendom ejendom, Spiller spiller)
	{
		g.sendBesked(spiller.getNavn() + " lander på " + ejendom.getTitel() + " som er til salg. KOD VIDERE!");
		//g.anmodValg?("Vil de købe denne (EJENDOM) til (PRIS)?", "Køb", "Sæt til auktion");
	}
}
