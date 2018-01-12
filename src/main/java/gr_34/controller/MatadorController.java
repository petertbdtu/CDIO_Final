package gr_34.controller;

import gr_34.boundary.GUIBoundary;
import gr_34.spillogik.MatadorLogik;

public class MatadorController {

	public MatadorController() {
	}

	public void playGame()
	{
		Raflebæger raflebæger = new RaflebægerTestStubHusKøb();
		
		BrætController bræt = new BrætController();
		
		GUIBoundary guiB = new GUIBoundary(bræt);
		
		EjendomController e = new EjendomController(guiB, bræt, raflebæger);
		
		SpillerController sc = new SpillerController(guiB);
		sc.opretSpillere(1500);

		guiB.indlæsSpillere(sc);
		
		MatadorLogik matador = new MatadorLogik(sc, bræt, e, guiB, raflebæger);
		
		do 
		{
			matador.UdførSpillerTur();
			sc.gåTilNæsteSpiller();
		} while (!matador.isVundet());
		
		
	}

}
