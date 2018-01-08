package gr_34.spillogik;

import gr_34.boundary.GUIBoundary;
import gr_34.controller.BrætController;
import gr_34.controller.EjendomController;
import gr_34.controller.SpillerController;
import gr_34.controller.Raflebæger;
import gr_34.entity.Spiller;

public class MatadorLogik {
	private SpillerController s;
	private BrætController b;
	private EjendomController e;
	private GUIBoundary g;
	
	public void UdførSpillerTur(Raflebæger raflebæger, Spiller nutidigSpiller) {
		//Sørg for at hvis man ryger i fængsel så trigger man ikke start penge.
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
		
		
	}
}
