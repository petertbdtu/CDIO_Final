package gr_34.controller;
import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
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

	GUIBoundary grafics;

	public MatadorController() {
	}

	public void playGame()
	{
		// Få Antal spillere
		int AntalSpillere;
		AntalSpillere = AntalSpillere();
		
		// Lav array af spillere og Udfyld arrayet
		GUI_Player[] players = new GUI_Player[AntalSpillere];
		players = OpretSpillere(AntalSpillere);
				
		GUI_Field[] fields = new GUI_Field[40];
		GUI.setNull_fields_allowed(true);

		//Dette er så simpelt som det kan blive.
		fields[0] = new GUI_Street();

		//Der tilføjes et par værdier.

		GUI_Street testStreet= new GUI_Street();
		testStreet.setTitle("Anker Engelundsvej");
		testStreet.setBorder(Color.CYAN); //Useful to show owner
		testStreet.setRent("600,-");
		fields[1] = testStreet;	
		
		//Der findes andre typer af felter.
        fields[2] = new GUI_Shipping();
        fields[2].setForeGroundColor(Color.PINK);
        
		this.grafics = new GUIBoundary(fields, players);
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
