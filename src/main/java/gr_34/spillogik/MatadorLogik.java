package gr_34.spillogik;

import gr_34.boundary.GUIBoundary;
import gr_34.controller.BrætController;
import gr_34.controller.ChancekortController;
import gr_34.controller.EjendomController;
import gr_34.controller.Raflebæger;
import gr_34.controller.SpillerController;
import gr_34.entity.Spiller;
import gr_34.entity.felter.AbstraktEjendom;
import gr_34.entity.felter.AbstraktFelt;
import gr_34.entity.felter.BetalSkatFelt;
import gr_34.entity.felter.ChanceFelt;
import gr_34.entity.felter.Fængsel;
import gr_34.entity.felter.GåIFængsel;
import gr_34.entity.felter.Parkering;
import gr_34.entity.felter.StartFelt;

public class MatadorLogik {
	private SpillerController s;
	private BrætController b;
	private EjendomController e;
	private GUIBoundary g;
	private ChancekortController c;
	private Raflebæger raflebæger;

	private final int FÆNGSEL_POSITION = 10;
	

	public MatadorLogik(SpillerController s, BrætController b, EjendomController e, GUIBoundary g,
			Raflebæger raflebæger, ChancekortController c) {
		this.s = s;
		this.b = b;
		this.e = e;
		this.g = g;
		this.raflebæger = raflebæger;
		this.c = c;
	}

	public void UdførSpillerTur() {

		Spiller nutidigSpiller = s.getNutidigSpiller();

		if (nutidigSpiller.erIFængsel())
			udførFængselTur(nutidigSpiller);

		if (!nutidigSpiller.erIFængsel())
			udførNormalTur(nutidigSpiller);
	}

	/**
	 * @param nutidigSpiller
	 */
	private void udførNormalTur(Spiller nutidigSpiller) {
		String navn = nutidigSpiller.getNavn();

		raflebæger.kastTerninger();
		int slag = raflebæger.getSum();
		this.g.visTerning(raflebæger.getØjne0(), raflebæger.getØjne1());
		
		// Ekstra tur hvis man slår to ens
		if (raflebæger.getØjne0() == raflebæger.getØjne1())
		{
			nutidigSpiller.setEkstraTur(true);
		}
		
		int gammelPosition = nutidigSpiller.getPosition();
		// modulo sørger for at den nye position ikke går udenfor vores mængde af
		// felter.
		int nyPosition = (gammelPosition + slag) % b.getFelter().length;

		// giver penge for at passere start.
		// et normal slag bør ikke tillade en til at rykke baglens.
		if (nyPosition < gammelPosition) {
			g.sendBesked(navn + " har passeret start feltet, de modtager 200kr");
			nutidigSpiller.tilføjPenge(200);
			g.opdaterAllesPenge();
		}

		flytSpiller(nutidigSpiller, gammelPosition, nyPosition);
	}

	private void udførFængselTur(Spiller nutidigSpiller) {
		String navn = nutidigSpiller.getNavn();
		String valg = g.anmodValgKnap(navn + " er i fængsel. De kan komme ud ved at betale eller slå to ens.",
				"Betal 200kr", "Slå terninger");

		if (valg.equals("Betal 200kr")) {
			// Betal 200kr
			nutidigSpiller.fratrækPenge(200);
			nutidigSpiller.setIFængsel(false);
			nutidigSpiller.nulstilFængselsTure();
			g.opdaterAllesPenge();
			g.sendBesked(navn + " har betalt 200kr for at slippe ud af fængslet. Nyd deres frihed!");
		} else {
			// Slå terninger
			
			raflebæger.kastTerninger();
			g.visTerning(raflebæger.getØjne0(), raflebæger.getØjne1());
			
			if (raflebæger.getØjne0() == raflebæger.getØjne1()) {
				// To ens, frihed
				nutidigSpiller.setIFængsel(false);
				nutidigSpiller.nulstilFængselsTure();
				g.opdaterAllesPenge();
				g.sendBesked(navn + " har slået to ens. Nyd deres GRATIS frihed!");
			} else {
				// Forskellige, ingen gratis løsladelse.
				if (nutidigSpiller.getFængselsTure() > 3) {
					// Smid spiller ud, opkræv 200kr
					nutidigSpiller.fratrækPenge(200);
					nutidigSpiller.setIFængsel(false);
					nutidigSpiller.nulstilFængselsTure();
					g.opdaterAllesPenge();
					g.sendBesked(navn + " er tvunget til at betale 200kr for at slippe ud af fængslet.");
				} else {
					// Spiller forbliver i fængslet.
					nutidigSpiller.forøgFængselsTure();
					g.sendBesked(navn + " må desværre blive i fængslet. De har brugt " +
					nutidigSpiller.getFængselsTure() + " af deres 3 terningekast forsøg.");
				}
			}
		}
	}

	/**
	 * Flytter spilleren og kalder relevant logik.
	 * 
	 * @param nutidigSpiller
	 * @param gammelPosition
	 * @param nyPosition
	 */
	public void flytSpiller(Spiller nutidigSpiller, int gammelPosition, int nyPosition) {
		g.flytSpiller(s.getNutidigSpillerIndex(), gammelPosition, nyPosition);
		nutidigSpiller.setPosition(nyPosition);

		AbstraktFelt ramtFelt = b.getFelt(nyPosition);

		if (ramtFelt instanceof AbstraktEjendom) {
			e.ramtEjendom((AbstraktEjendom) ramtFelt, nutidigSpiller);
		} else if (ramtFelt instanceof ChanceFelt) {
			c.udførChanceFelt(nutidigSpiller);
		} else if (ramtFelt instanceof StartFelt) {
			g.sendBesked(nutidigSpiller.getNavn() + " er kommet tilbage start.");
		} else if (ramtFelt instanceof Fængsel) {
			g.sendBesked(nutidigSpiller.getNavn() + " er på besøg i fængslet.");
		} else if (ramtFelt instanceof GåIFængsel) {
			g.sendBesked(nutidigSpiller.getNavn() + " går direkte i fængsel.");
			g.flytSpiller(s.getNutidigSpillerIndex(), nyPosition, FÆNGSEL_POSITION);
			nutidigSpiller.setPosition(FÆNGSEL_POSITION);
			nutidigSpiller.setIFængsel(true);
			ramtFelt = b.getFelt(FÆNGSEL_POSITION);
		} else if (ramtFelt instanceof BetalSkatFelt) {
			int betalPris = ((BetalSkatFelt) ramtFelt).getBetalPris();
			if (betalPris == 200) {
				String valg = g.anmodValgKnap(nutidigSpiller.getNavn() + " skal betale skat.", "Betal indkomstskat 10%",
						"Betal 200kr.");
				if (valg.equals("Betal 200kr.")) {
					nutidigSpiller.fratrækPenge(betalPris);
					g.opdaterAllesPenge();
				} else {
					int ejendomsSkat = (int) (nutidigSpiller.getPenge() * 0.10);
					nutidigSpiller.fratrækPenge(ejendomsSkat);
					g.opdaterAllesPenge();
				}
			} else {
				g.sendBesked("Extraordinær statsskat " + nutidigSpiller.getNavn() + " skal betale 100kr.");
				nutidigSpiller.fratrækPenge(betalPris);
				g.opdaterAllesPenge();
			}

		} else if (ramtFelt instanceof Parkering) {
			g.sendBesked(nutidigSpiller.getNavn() + " parkerer gratis.");
		}
	}

	public boolean isVundet() {
		return s.harVinder();
	}
}
