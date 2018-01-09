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
	private boolean vundet = false;
	
	public void UdførSpillerTur(Raflebæger raflebæger, Spiller nutidigSpiller) {
		//Sørg for at hvis man ryger i fængsel så trigger man ikke start penge.
		raflebæger.kastTerninger();
		int slag = raflebæger.getSum(); 
		String navn = nutidigSpiller.getNavn();
		
		int gammelPosition = nutidigSpiller.getPosition();
		// modulo sørger for at den nye position ikke går udenfor vores mængde af felter.
		int nyPosition = (gammelPosition + slag) % b.getFelter().length;
		// et normal slag bør ikke tillade en til at rykke baglens.
		if (nyPosition < gammelPosition) {
			g.sendBesked(navn + "har passeret start feltet, de modtager 200kr");
			nutidigSpiller.tilføjPenge(200);
		}
		g.flytSpiller(s.getNutidigSpillerIndex(), gammelPosition, nyPosition);
		
		AbstraktFelt ramtFelt = b.getFelt(nyPosition);
		
		if (ramtFelt instanceof AbstraktEjendom)
		{
			e.ramtEjendom( (AbstraktEjendom) ramtFelt, nutidigSpiller);
		}
		else if (ramtFelt instanceof ChanceFelt)
		{
			//TODO Chance logik
		}
		else if (ramtFelt instanceof StartFelt)
		{
			//TODO StartFelt Logik
		}
		else if (ramtFelt instanceof Fængsel)
		{
			//TODO Fængsel Logik
		}
		else if (ramtFelt instanceof GåIFængsel)
		{
			//TODO GåIFængsel Logik
		}
		else if (ramtFelt instanceof BetalSkatFelt)
		{
	
		}
		else if (ramtFelt instanceof Parkering)
		{
		}
	}

	public boolean isVundet() {
		return vundet;
	}

	public void setVundet(boolean vundet) {
		this.vundet = vundet;
	}
}
