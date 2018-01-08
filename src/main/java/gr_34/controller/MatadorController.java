package gr_34.controller;

import gr_34.boundary.GUIBoundary;

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
		
		BrætController bræt = new BrætController();
		
		GUIBoundary guiB = new GUIBoundary(bræt.getFelter());
		
		SpillerController sc = new SpillerController(guiB);
		sc.opretSpillere(1500);

		guiB.indlæsSpillere(sc.getSpillere());
		
//		MatadorLogik matador = new MatadorLogik( alle controllere? )
//		
//		while (!matador.erVundet())
//		{
//			matador.udførTur();
//		}
		
		
	}

}
