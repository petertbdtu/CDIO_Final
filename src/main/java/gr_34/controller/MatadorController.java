package gr_34.controller;

import gr_34.boundary.GUIBoundary;
import gr_34.spillogik.MatadorLogik;

public class MatadorController {
	// DiceCup diceCup;
	//
	// void playGame(){
	//
	// winner = false;
	// while(!winner) {
	// //PLAYERTurn
	// Player p = nextPlayer();
	// diceCup.rollDice();
	// boardController.movePlayer(p, diceController.getEyes());
	// Field f = boardController.getField(p);
	// resolveField(p, f);
	//
	// }
	// }
	//
	// private void resolveField(Player p, Field f) {
	// if (f instanceof ChanceField) {
	// chanceController.resolveField(p,f);
	// } (f instanceof Property){
	// propertyCOntroller.handleProperty(p,(Property)f)
	// }
	// }
	//
	// private Player nextPlayer() {
	// // TODO Auto-generated method stub
	// return null;
	// }

	public MatadorController() {
	}

	public void playGame()
	{
		Raflebæger raflebæger = new RaflebægerTestStub();
		
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
