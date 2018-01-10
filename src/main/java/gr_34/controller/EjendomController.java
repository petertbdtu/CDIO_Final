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
			int antalBygninger = ejendom.getAntalBygning();
			spiller.fratrækPenge(ejendom.getLeje(antalBygninger));
			ejendom.getEjer().tilføjPenge(ejendom.getLeje(antalBygninger));
			g.opdaterAllesPenge();
			g.sendBesked(spiller.getNavn() + " lander på " + ejendom.getTitel() + " som er ejet af "
					+ ejendom.getEjer().getNavn() + ". " + spiller.getNavn() + " betaler " + ejendom.getEjer().getNavn()
					+ " " + ejendom.getLeje(antalBygninger) + "kr."); 
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
			g.opdaterAllesPenge();
			g.sendBesked(spiller.getNavn() + " lander på " + ejendom.getTitel() + " som er ejet af "
					+ ejendom.getEjer().getNavn() + ". " + spiller.getNavn() + " betaler " + ejendom.getEjer().getNavn()
					+ " " + rederiPris + "kr."); 
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
			g.opdaterAllesPenge();
			g.sendBesked(spiller.getNavn() + " lander på " + ejendom.getTitel() + " som er ejet af "
					+ ejendom.getEjer().getNavn() + ". " + spiller.getNavn() + " betaler " + ejendom.getEjer().getNavn()
					+ " " + bryggeriPris + "kr."); 
		}
		else
			g.sendBesked(spiller.getNavn() + " er landet på en gade som De selv ejer");
	}
	
	private void ramtUkøbtEjendom(AbstraktEjendom ejendom, Spiller spiller)
	{
		g.sendBesked(spiller.getNavn() + " lander på " + ejendom.getTitel() + " som er til salg.");
		
		String valg = g.anmodValgKnap(spiller.getNavn() + ", vil De købe " + ejendom.getTitel() +
				" til " + ejendom.getPris() + "?", "Køb", "Sæt til auktion");
		
		if (valg.equals("Køb"))
		{
			spiller.fratrækPenge(ejendom.getPris());
			ejendom.setEjer(spiller);
			// TODO Tilføj at ejendommen bliver købt
			g.opdaterAllesPenge();
			g.sendBesked(spiller.getNavn() + " har købt " + ejendom.getTitel()
			+ " for " + ejendom.getPris() + "kr.");
		}
		else
		{
			// TODO Auktionslogik
		}
	}
	
	public void købtAlleGader(Gade ejendom, Spiller spiller) {
		int antalBygninger = ejendom.getAntalBygning();
		g.sendBesked(spiller.getNavn() + " lander på " + ejendom.getTitel() + " som er til salg.");
		
		String valg = g.anmodValgKnap(spiller.getNavn() + ", vil De sætte et hus på Deres grund? Det koster " + ejendom.getBygningPris() + 
				"Ja", "Nej");
		if(valg.equals("Ja")) {
			antalBygninger++;
			spiller.fratrækPenge(ejendom.getBygningPris());
			ejendom.setAntalBygning(antalBygninger);
			g.opdaterAllesPenge();
			g.sendBesked(spiller.getNavn() + " har købt hus på " + ejendom.getTitel());
		}
	}
	
	public void betalLejeRederi(Rederi ejendom, Spiller spiller)
	{
		int ejersAntalRederier = 0;
		for (int i = 0; i < ANTAL_REDERIER; i++)
		{
			if ( rederier[i].getEjer().equals( ejendom.getEjer() ) )
				ejersAntalRederier++;
		}
		int leje = 25;
		
		for (int i = 0; i < ejersAntalRederier; i++)
		{
			leje *= 2;
		}
		
		spiller.fratrækPenge(leje);
		ejendom.getEjer().tilføjPenge(leje);
		
		g.opdaterAllesPenge();
	}
	
	public void betalLejeBryggeri(Bryggeri ejendom, Spiller spiller)
	{
		int leje
		if
		
		
		spiller.fratrækPenge(leje);
		ejendom.getEjer().tilføjPenge(leje);
		
		g.opdaterAllesPenge();
	}
}
