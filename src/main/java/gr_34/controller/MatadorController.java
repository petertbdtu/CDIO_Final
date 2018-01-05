package gr_34.CDIO_Final;

public class MatadorController {
	DiceCup diceCup;
	
	void playGame(){
		
		winner = false;
		while(!winner) {
			//PLAYERTurn
			Player p = nextPlayer();
			diceCup.rollDice();
			boardController.movePlayer(p, diceController.getEyes());
			Field f = boardController.getField(p);
			resolveField(p, f);
			
		}
	}

	private void resolveField(Player p, Field f) {
		if (f instanceof ChanceField) {
			chanceController.resolveField(p,f);
		} (f instanceof Property){
			propertyCOntroller.handleProperty(p,(Property)f)
		}
	}

	private Player nextPlayer() {
		// TODO Auto-generated method stub
		return null;
	}
}
