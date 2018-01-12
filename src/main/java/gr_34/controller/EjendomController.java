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
	private Raflebæger raflebæger;
	private final int ANTAL_GADER = 22;
	private final int ANTAL_BRYGGERIER = 2;
	private final int ANTAL_REDERIER = 4;
	private Gade[] gader = new Gade[ANTAL_GADER];
	private Bryggeri[] bryggerier = new Bryggeri[ANTAL_BRYGGERIER];
	private Rederi[] rederier = new Rederi[ANTAL_REDERIER];

	public EjendomController(GUIBoundary gui, BrætController bræt, Raflebæger raflebæger) {
		this.g = gui;
		this.raflebæger = raflebæger;

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
		if (ejendom.getEjer() == null)
			ramtUkøbtEjendom(ejendom ,spiller);
		
		else if (ejendom instanceof Gade)
			ramtGade((Gade) ejendom, spiller);

		else if (ejendom instanceof Rederi)
			ramtRederi((Rederi) ejendom, spiller);

		else if (ejendom instanceof Bryggeri)
			ramtBryggeri((Bryggeri) ejendom, spiller);

	}
	
	private void ramtGade(Gade ejendom, Spiller spiller) {
		if (ejendom.getEjer() != spiller)
		{
			// TODO logik iforhold til antal af ejede gader
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
		if (ejendom.getEjer() != spiller)
		{
			betalLejeRederi(ejendom, spiller);
		}
		else
			g.sendBesked(spiller.getNavn() + " er landet på en gade som De selv ejer");
	}

	private void ramtBryggeri(Bryggeri ejendom, Spiller spiller) {
		if (ejendom.getEjer() != spiller)
		{ 
			betalLejeBryggeri(ejendom, spiller);
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
			// TODO Sæt ejer grafisk (ejer og farve osv.)
			g.opdaterAllesPenge();
			g.sendBesked(spiller.getNavn() + " har købt " + ejendom.getTitel()
			+ " for " + ejendom.getPris() + "kr.");
		}
		else
		{
			// TODO Auktionslogik
		}
	}
	
	/**
	 * Undersøger om spilleren ejer sæt af grunde.
	 * @param spiller
	 * @return grundeStatus array af booleans for hver grund. Samme rækkefølge som spillepladen.
	 */
	public Boolean[] fuldstændigtEjedeGrunde(Spiller spiller) {
		Boolean[] grundeStatus = new Boolean[22];
		for (int i = 0; i < 22; i++)
		{
			grundeStatus[i] = false;
		}
		int i = 0;
		
		// Lysegrå
		if (gader[0].getEjer() == spiller
				&& gader[1].getEjer() == spiller )
		{
			for (Boolean b : harPladsTilHuse(getSætAfGrunde(0)) )
				{
					grundeStatus[i] = b;
					i++;
				}
		}
		else i += 2;
		// Røde
		if (gader[2].getEjer() == spiller
				&& gader[3].getEjer() == spiller
				&& gader[4].getEjer() == spiller )
		{
			for (Boolean b : harPladsTilHuse(getSætAfGrunde(1)) )
			{
				grundeStatus[i] = b;
				i++;
			}
		}
		else i += 3;
		// Grønne
		if (gader[5].getEjer() == spiller
				&& gader[6].getEjer() == spiller
				&& gader[7].getEjer() == spiller )
		{
			for (Boolean b : harPladsTilHuse(getSætAfGrunde(2)) )
			{
				grundeStatus[i] = b;
				i++;
			}
		}
		else i += 3;
		// Mørkegrå
		if (gader[8].getEjer() == spiller
				&& gader[9].getEjer() == spiller
				&& gader[10].getEjer() == spiller )
		{
			for (Boolean b : harPladsTilHuse(getSætAfGrunde(3)) )
			{
				grundeStatus[i] = b;
				i++;
			}
		}
		else i += 3;
		// Orange
		if (gader[11].getEjer() == spiller
				&& gader[12].getEjer() == spiller
				&& gader[13].getEjer() == spiller )
		{
			for (Boolean b : harPladsTilHuse(getSætAfGrunde(4)) )
			{
				grundeStatus[i] = b;
				i++;
			}
		}
		else i += 3;
		// Hvide
		if (gader[14].getEjer() == spiller
				&& gader[15].getEjer() == spiller
				&& gader[16].getEjer() == spiller )
		{
			for (Boolean b : harPladsTilHuse(getSætAfGrunde(5)) )
			{
				grundeStatus[i] = b;
				i++;
			}
		}
		else i += 3;
		// Gule
		if (gader[17].getEjer() == spiller
				&& gader[18].getEjer() == spiller
				&& gader[19].getEjer() == spiller )
		{
			for (Boolean b : harPladsTilHuse(getSætAfGrunde(6)) )
			{
				grundeStatus[i] = b;
				i++;
			}
		}
		else i += 3;
		// Brune
		if (gader[20].getEjer() == spiller
				&& gader[21].getEjer() == spiller )
		{
			for (Boolean b : harPladsTilHuse(getSætAfGrunde(7)) )
			{
				grundeStatus[i] = b;
				i++;
			}
		}
		else i += 2;
		return grundeStatus;
	}
	
	/**
	 * Finder ud hvilke grunde der kan bygges huse på.
	 * @param sætAfGrunde grunde med samme farve.
	 * @return
	 */
	private Boolean[] harPladsTilHuse(Gade ... sætAfGrunde)
	{
		Boolean[] harPlads = new Boolean[sætAfGrunde.length];
		int minimumHuse = sætAfGrunde[0].getAntalBygning();
		for (int i = 1; i < sætAfGrunde.length; i++)
		{
			if ( minimumHuse > sætAfGrunde[i].getAntalBygning() )
				minimumHuse = sætAfGrunde[i].getAntalBygning();
		}
		for (int i = 0; i < sætAfGrunde.length; i++)
		{
			if (sætAfGrunde[i].getAntalBygning() >= minimumHuse)
				harPlads[i] = true;
		}
		return harPlads;
	}
	
	public Gade[] getSætAfGrunde(int indeks)
	{
		switch (indeks)
		{
		case 0: return new Gade[] {gader[0], gader[1]};
		case 1: return new Gade[] {gader[2], gader[3], gader[4]};
		case 2: return new Gade[] {gader[5], gader[6], gader[7]};
		case 3: return new Gade[] {gader[8], gader[9], gader[10]};
		case 4: return new Gade[] {gader[11], gader[12], gader[13]};
		case 5: return new Gade[] {gader[14], gader[15], gader[16]};
		case 6: return new Gade[] {gader[17], gader[18], gader[19]};
		case 7: return new Gade[] {gader[20], gader[21]};
		default: return new Gade[0];
		}
	}
	
	private void betalLejeRederi(Rederi ejendom, Spiller spiller)
	{
		int ejersAntalRederier = 0;
		for (int i = 0; i < ANTAL_REDERIER; i++)
		{
			if ( rederier[i].getEjer() == ejendom.getEjer() )
				ejersAntalRederier++;
		}
		
		int leje = 25;
		for (int i = 1; i < ejersAntalRederier; i++)
		{
			leje *= 2;
		}
		
		spiller.fratrækPenge(leje);
		ejendom.getEjer().tilføjPenge(leje);
		
		g.sendBesked(spiller.getNavn() + " lander på " + ejendom.getTitel() + " som er ejet af "
				+ ejendom.getEjer().getNavn() + ". " + spiller.getNavn() + " betaler " + ejendom.getEjer().getNavn()
				+ " " + leje + "kr."); 
		
		g.opdaterAllesPenge();
	}
	
	private void betalLejeBryggeri(Bryggeri ejendom, Spiller spiller)
	{
		raflebæger.kastTerninger();
		int leje = raflebæger.getSum();
		g.visTerning(raflebæger.getØjne0(), raflebæger.getØjne1());
		
		// Tjekker om begge rederier ejes af samme spiller.
		// Et af bryggerierne er 'ejendom' men det eneste der er relevant er om
		// begge har samme ejer
		if (bryggerier[0].getEjer() == bryggerier[1].getEjer())
			leje *= 10;
		else
			leje *= 4;
		
		spiller.fratrækPenge(leje);
		ejendom.getEjer().tilføjPenge(leje);
		
		g.sendBesked(spiller.getNavn() + " lander på " + ejendom.getTitel() + " som er ejet af "
				+ ejendom.getEjer().getNavn() + ". " + spiller.getNavn() + " betaler " + ejendom.getEjer().getNavn()
				+ " " + leje + "kr.");
		
		g.opdaterAllesPenge();
	}
}
