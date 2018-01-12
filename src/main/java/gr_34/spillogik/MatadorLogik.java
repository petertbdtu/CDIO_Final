package gr_34.spillogik;

import gr_34.boundary.GUIBoundary;
import gr_34.controller.BrætController;
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
	private Raflebæger raflebæger;
	private boolean vundet = false;
	
	public MatadorLogik(SpillerController s, BrætController b, EjendomController e,
			GUIBoundary g, Raflebæger raflebæger) {
		this.s = s;
		this.b = b;
		this.e = e;
		this.g = g;
		this.raflebæger = raflebæger;
	}
	
	public void UdførSpillerTur() {
		
		Spiller nutidigSpiller = s.getNutidigSpiller();
		String navn = nutidigSpiller.getNavn();
		
		//Sørg for at hvis man ryger i fængsel så trigger man ikke start penge.
		raflebæger.kastTerninger();
		int slag = raflebæger.getSum();
		this.g.visTerning( raflebæger.getØjne0(), raflebæger.getØjne1() );
		
		
		int gammelPosition = nutidigSpiller.getPosition();
		// modulo sørger for at den nye position ikke går udenfor vores mængde af felter.
		int nyPosition = (gammelPosition + slag) % b.getFelter().length;
		
		// giver penge for at passere start.
		// et normal slag bør ikke tillade en til at rykke baglens.
		if (nyPosition < gammelPosition) {
			g.sendBesked(navn + "har passeret start feltet, de modtager 200kr");
			nutidigSpiller.tilføjPenge(200);
			g.opdaterAllesPenge();
		}
		
		// Kan al spillerflytningsinstruks slås sammen ét sted?
		g.flytSpiller(s.getNutidigSpillerIndex(), gammelPosition, nyPosition);
		nutidigSpiller.setPosition(nyPosition);
		
		AbstraktFelt ramtFelt = b.getFelt(nyPosition);
		
		if (ramtFelt instanceof AbstraktEjendom)
		{
			e.ramtEjendom( (AbstraktEjendom) ramtFelt, nutidigSpiller);
		}
		else if (ramtFelt instanceof ChanceFelt)
		{
			//TODO Chance logik
			g.sendBesked(nutidigSpiller.getNavn() + " skal trække et chancekort. IKKE IMPLEMENTERET");

		}
		else if (ramtFelt instanceof StartFelt)
		{
			g.sendBesked(nutidigSpiller.getNavn() + " er kommet tilbage start.");
		}
		else if (ramtFelt instanceof Fængsel)
		{
			g.sendBesked(nutidigSpiller.getNavn() + " er på besøg i fængslet.");
		}
		else if (ramtFelt instanceof GåIFængsel)
		{
			g.sendBesked(nutidigSpiller.getNavn() + " går direkte i fængsel. IKKE IMPLEMENTERET");
			int fængselPosition = 10;
			nutidigSpiller.setPosition(fængselPosition);
			ramtFelt = b.getFelt(fængselPosition);
		}
		else if (ramtFelt instanceof BetalSkatFelt)
		{
			int betalPris = ((BetalSkatFelt) ramtFelt).getBetalPris();
			if(betalPris == 200) {
				String valg = g.anmodValgKnap(nutidigSpiller.getNavn() + " skal betale skat.", "Betal indkomstskat 10%", "Betal 200kr.");
				if(valg.equals("Betal 200kr.")) {
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
			
				
		}
		else if (ramtFelt instanceof Parkering)
		{
			g.sendBesked(nutidigSpiller.getNavn() + " parkerer gratis.");
		}
		
	}

	public boolean isVundet() {
		return vundet;
	}

	public void setVundet(boolean vundet) {
		this.vundet = vundet;
	}
}
