package gr_34.controller;
import javax.swing.*;
import java.awt.Color;
import gr_34.boundary.GUIBoundary;
import gui_fields.*;
import gui_main.GUI;

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

		guiB.indlæsSpillere(sc.getSpillere());
		
	}
	
	// TryParseInt funktionen forsøger at omsætte input parameteret value om til en integer. Fejler den vil den ikke returnere true men går ned i Catch blokken og returnere false.
	boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
	
	// AntalSpillere funktionen beder brugeren om at inputte en antal spillere og returnere det indtastede tal
	public int AntalSpillere() {
				// Få antal spillere til spillet. 
				int AntalSpillere = 0;	
				// Bliv ved med at rejs dialog indtil AntalSpillere variablen har fået en værdi
				while (AntalSpillere == 0) {
					String BrugerInput;
					// Vis input dialog
					BrugerInput = JOptionPane.showInputDialog("Indtast antal spillere (mellem 2 og 6): ");
					// Tjek om inputtet er et tal
					if (tryParseInt(BrugerInput)) {
						// Tjek om tallet er enten 2, 3, 4, 5 eller 6. Hvis det er, sæt AntalSpillere variablen
						if (Integer.parseInt(BrugerInput) >= 2 && Integer.parseInt(BrugerInput) <= 6) {
							AntalSpillere = Integer.parseInt(BrugerInput);
						}
					}
				}
				return AntalSpillere;
	} 
	
	// OpretSpillere funktionen spørger brugeren om navne på de ønskede spillere og returnere et array af GUI_Player med navne og start beløb på 30000
	public GUI_Player[] OpretSpillere(int AntalSpillere) {
		// Opret array der indeholder spillere
		GUI_Player[] players = new GUI_Player[AntalSpillere];
		// For hver spiller, bed om spillerens navn og tilføj det til arrayet
		for (int i = 0; i < AntalSpillere; i++) {
			String SpillerNavn = JOptionPane.showInputDialog("Indtast spiller " + String.valueOf(i + 1) + "'s navn: ");
			GUI_Player Spiller = new GUI_Player(SpillerNavn, 30000); // Her er sat 30000,- ind. vurdér om vi skal lave noget til at håndtere de enkelte sedler
			players[i] = Spiller;
		}
		return players;
	}

}
