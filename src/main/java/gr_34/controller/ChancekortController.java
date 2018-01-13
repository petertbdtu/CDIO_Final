package gr_34.controller;

import java.util.Random;

import gr_34.boundary.GUIBoundary;
import gr_34.entity.ChanceEffekt;
import gr_34.entity.Chancekort;
import gr_34.entity.ChancekortCreator;
import gr_34.entity.Spiller;
import gr_34.spillogik.MatadorLogik;

public class ChancekortController {
	
	
	private GUIBoundary g;
	Chancekort[] chancekort;
	private MatadorLogik ml;
		
	public ChancekortController(GUIBoundary g) {
		chancekort = ChancekortCreator.getChancekort();
		bland();
		this.g = g;
	}
	
	public Chancekort[] getChancekort() {
		return this.chancekort;
	}
	
	public Chancekort getKort(int KortNummer) {
		return chancekort[KortNummer];
	}
	
	public void indlæsLogik(MatadorLogik ml) {
		this.ml = ml;
	}
	
	public void udførEffekt(Spiller spiller, ChanceEffekt ce) {
		switch(ce) {
		case AktieModtag50:
			spiller.tilføjPenge(50);
			g.sendBesked(spiller.getNavn() + " modtager 50kr fra sine aktier.");
			break;
		case Betal100Vogn:
			spiller.fratrækPenge(100);
			g.sendBesked("De har anskaffet nye dæk til deres vogn, betal 100kr.");
			break;
		case BetalTold20:
			spiller.fratrækPenge(20);
			g.sendBesked("De har været i udlandet og haft købt alt for "
					+ "mange cigaretter med hjem- betal told 20kr.");
			break;
		case BetalVask10:
			spiller.fratrækPenge(10);
			g.sendBesked("Betal for vognvask  og smøring 10kr.");
			break;
		case FuldStop100:
			spiller.fratrækPenge(100);
			g.sendBesked("Du har kørt frem for fuld stop, betal 100kr.");
			break;
		case GåTilRådhus:
			ml.flytSpiller(spiller, spiller.getPosition(), 39);
			g.sendBesked("Tag ind på rådhuspladsen");
			break;
		case Modtag20:
			spiller.tilføjPenge(20);
			g.sendBesked("De har solgt deres gamle klude, de modtager 20kr.");
			break;
		case PBøde20:
			spiller.fratrækPenge(20);
			g.sendBesked("De har måttet vedtage en parkeringsbøde. Betal 20kr.");
			break;
		case Præmie100:
			spiller.tilføjPenge(100);
			g.sendBesked("Deres præmieobligation er kommet ud. De modtager 100kr");
			break;
		case RykFremTilStart:
			ml.flytSpiller(spiller, spiller.getPosition(), 0);
			g.sendBesked(spiller.getNavn() + " er gået frem mod start feltet, de modtager 200kr");
			spiller.tilføjPenge(200);
			g.opdaterAllesPenge();
			break;
		case RykTilbageTilStart:
			ml.flytSpiller(spiller, spiller.getPosition(), 0);
			g.sendBesked(spiller.getNavn() + " rykker tilbage til start. De modtager ikke startpenge.");
			break;
		case RykTreFelterTilbage:
			ml.flytSpiller(spiller, spiller.getPosition(), (spiller.getPosition()-3)%40);
			g.sendBesked("De glider på en bananskrald, ryk tre felter tilbage.");
			break;
		default:
			break;
		}	
	}
	
	public int getLength() {
		return chancekort.length;
	}
	
	public void bland() {

		// Kopieret fra løsningsforslag til kortspil lektion 8.

		Chancekort[] tempBunke = new Chancekort[chancekort.length];

		Random rn = new Random();

		int count = 0;

		do{

			int i = rn.nextInt(chancekort.length);

			if (tempBunke[i] == null) {

				tempBunke[i] = chancekort[count];

				count++;

			}

		} while (count < chancekort.length);

		chancekort = tempBunke;

	}
	
	public Chancekort trækKort() {

		// Tag øverste kort

		Chancekort trukket = chancekort[chancekort.length - 1];

		// Læg tilbage i bunden

		for (int i = chancekort.length-1; i > 0; i--) {

			chancekort[i] = chancekort[i - 1];

		}

		chancekort[0] = trukket;

		return trukket;

	}
	
	public void udførChanceFelt(Spiller spiller) {
		ChanceEffekt ce = trækKort().getEffekt();
		udførEffekt(spiller, ce);
	}
}
