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
		// Få antal spillere til spillet -- Bedre håndtering af bruger input 
		int AntalSpillere = 0;
		AntalSpillere = Integer.parseInt(JOptionPane.showInputDialog("Indtast antal spillere: "));
		
		// Opret array der indeholder spillere
		GUI_Player[] players = new GUI_Player[AntalSpillere];
		// For hver spiller, bed om spillerens navn og tilføj det til arrayet
		for (int i = 0; i < AntalSpillere; i++) {
			String SpillerNavn = JOptionPane.showInputDialog("Indtast spiller " + String.valueOf(i + 1) + "'s navn: ");
			GUI_Player Spiller = new GUI_Player(SpillerNavn);
			players[i] = Spiller;
		}
		
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
}
