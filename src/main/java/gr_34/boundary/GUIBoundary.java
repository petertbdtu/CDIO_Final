package gr_34.boundary;

import gr_34.entity.felter.*;
import gr_34.entity.Spiller;
import gui_fields.GUI_Brewery;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Player;
import gui_fields.GUI_Refuge;
import gui_fields.GUI_Shipping;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;
import gui_fields.GUI_Tax;
import gui_main.GUI;

public class GUIBoundary {
	
	GUI gui;
	GUI_Field[] fields;
	GUI_Player[] players;
	
	public GUIBoundary(AbstraktFelt[] felter)
	{
		indlæsFelter(felter);
		this.gui = new GUI(fields);
	}

	private void indlæsFelter(AbstraktFelt[] felter)
	{
		fields = new GUI_Field[felter.length];
		for (int i = 0; i < felter.length; i++)
		{
			
			if (felter[i] instanceof Gade)
			{
				fields[i] = new GUI_Street();
				fields[i].setBackGroundColor( ((Gade) felter[i]).getFarve() );
				fields[i].setSubText( String.valueOf( ((Gade) felter[i]).getPris()) );
				
			}
			else if (felter[i] instanceof ChanceFelt)
			{
				fields[i] = new GUI_Chance();
			}
			else if (felter[i] instanceof Rederi)
			{
				fields[i] = new GUI_Shipping();
				fields[i].setSubText( String.valueOf( ((Rederi) felter[i]).getPris()) );
			}
			else if (felter[i] instanceof Bryggeri)
			{
				fields[i] = new GUI_Brewery();
				fields[i].setSubText( String.valueOf( ((Bryggeri) felter[i]).getPris()) );
			}
			else if (felter[i] instanceof StartFelt)
			{
				fields[i] = new GUI_Start();
				fields[i].setSubText(" ");
			}
			else if (felter[i] instanceof Fængsel)
			{
				fields[i] = new GUI_Jail();
				fields[i].setSubText("Fængsel");
			}
			else if (felter[i] instanceof GåIFængsel)
			{
				fields[i] = new GUI_Jail();
				fields[i].setSubText("Gå i fængsel");
			}
			else if (felter[i] instanceof BetalSkatFelt)
			{
				fields[i] = new GUI_Tax();
				fields[i].setSubText("Betal skat");
			}
			else if (felter[i] instanceof Parkering)
			{
				fields[i] = new GUI_Refuge();
				fields[i].setSubText("Helle");
			}
			
			// Hvis chancefelt har titel, forsvinder spørgsmålstegn
			if (!(felter[i] instanceof ChanceFelt))
				fields[i].setTitle(felter[i].getTitel());
			fields[i].setDescription(felter[i].getBeskrivelse());
			
		}
	}
	
	public int anmodIntMinMax(String msg, int min, int max)
	{
		int i = 0;
		
		do
		{
			i = gui.getUserInteger(msg, min, max);
		} while (i < min || i > max);
		
		return i;
	}
	
	public String anmodString(String msg)
	{
		return gui.getUserString(msg);
	}
	
	public String anmodValgKnap(String msg, String ... buttons)
	{
		return gui.getUserButtonPressed(msg, buttons);
	}
	
	public void sendBesked(String msg) {
		gui.showMessage(msg);
	}

	/**
	 * Tilføjer spillere til brættet. Rækkefølgen af arrayet er relevant i andre metoder.
	 * @param spillere
	 */
	public void indlæsSpillere(Spiller[] spillere)
	{
		players = new GUI_Player[spillere.length];
		
		for (int i = 0; i < spillere.length; i++)
		{
			Spiller spiller = spillere[i];
			players[i] = new GUI_Player(spiller.getNavn(), spiller.getPenge());
			gui.addPlayer(players[i]);
		}
	}
	
	/**
	 * Spillerne er i samme rækkefølge som de kommer ind i indlæsSpillere
	 * @param spillerIndex
	 * @param gammelPos
	 * @param nyPos
	 */
	public void flytSpiller(int spillerIndex, int gammelPos, int nyPos)
	{
		this.fields[gammelPos].setCar(players[spillerIndex], false);
		this.fields[nyPos].setCar(players[spillerIndex], true);
	}
	
	public void visTerning(int øjneVærdi0, int øjneVærdi1) {
		gui.setDice(øjneVærdi0, øjneVærdi1);
	}
}