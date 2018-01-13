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
			g.vischanceKort(spiller.getNavn() + " har haft held med sine aktier. De modtager 50kr.");
			g.sendBesked(" ");
			break;
		case Betal100Vogn:
			spiller.fratrækPenge(100);
			g.vischanceKort("De har anskaffet nye dæk til deres vogn, betal 100kr.");
			g.sendBesked(" ");
			break;
		case BetalTold20:
			spiller.fratrækPenge(20);
			g.vischanceKort("De har været i udlandet og haft købt alt for mange cigaretter med hjem. Betal told 20kr.");
			g.sendBesked(" ");
			break;
		case BetalVask10:
			spiller.fratrækPenge(10);
			g.vischanceKort("Betal for vognvask  og smøring 10kr.");
			g.sendBesked(" ");
			break;
		case FuldStop100:
			spiller.fratrækPenge(100);
			g.vischanceKort("Du har kørt frem for fuld stop, betal 100kr.");
			g.sendBesked(" ");
			break;
		case GåTilRådhus:
			ml.flytSpiller(spiller, spiller.getPosition(), 39);
			g.vischanceKort("Tag ind på rådhuspladsen");
			g.sendBesked(" ");
			break;
		case Modtag20:
			spiller.tilføjPenge(20);
			g.vischanceKort("De har solgt deres gamle klude, de modtager 20kr.");
			g.sendBesked(" ");
			break;
		case PBøde20:
			spiller.fratrækPenge(20);
			g.vischanceKort("De har måttet vedtage en parkeringsbøde. Betal 20kr.");
			g.sendBesked(" ");
			break;
		case Præmie100:
			spiller.tilføjPenge(100);
			g.vischanceKort("Deres præmieobligation er kommet ud. De modtager 100kr");
			g.sendBesked(" ");
			break;
		case RykFremTilStart:
			ml.flytSpiller(spiller, spiller.getPosition(), 0);
			g.vischanceKort(spiller.getNavn() + " er gået frem mod start feltet, de modtager 200kr");
			g.sendBesked(" ");
			spiller.tilføjPenge(200);
			g.opdaterAllesPenge();
			break;
		case RykTilbageTilStart:
			ml.flytSpiller(spiller, spiller.getPosition(), 0);
			g.vischanceKort(spiller.getNavn() + " rykker tilbage til start. De modtager ikke startpenge.");
			g.sendBesked(" ");
			break;
		case RykTreFelterTilbage:
			ml.flytSpiller(spiller, spiller.getPosition(), (spiller.getPosition()-3)%40);
			g.vischanceKort("De glider på en bananskrald, ryk tre felter tilbage.");
			g.sendBesked(" ");
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
