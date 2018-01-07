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
				Gade g = (Gade) felter[i];
				
				Integer pris = g.getPris();
				String prisString = pris.toString();
				
				fields[i] = new GUI_Street();
				fields[i].setBackGroundColor( g.getFarve() );
				fields[i].setSubText( prisString );
				
			}
			else if (felter[i] instanceof ChanceFelt)
			{
				fields[i] = new GUI_Chance();
			}
			else if (felter[i] instanceof Rederi)
			{
				fields[i] = new GUI_Shipping();
			}
			else if (felter[i] instanceof Bryggeri)
			{
				fields[i] = new GUI_Brewery();
			}
			else if (felter[i] instanceof StartFelt)
			{
				fields[i] = new GUI_Start();
			}
			else if (felter[i] instanceof Fængsel || felter[i] instanceof GåIFængsel)
			{
				fields[i] = new GUI_Jail();
			}
			else if (felter[i] instanceof BetalSkatFelt)
			{
				fields[i] = new GUI_Tax();
			}
			else if (felter[i] instanceof Parkering)
			{
				fields[i] = new GUI_Refuge();
			}
			
			fields[i].setTitle(felter[i].getTitel());
			fields[i].setDescription(felter[i].getBeskrivelse());
			//fields[i].setSubText(felter[i].getSubText());
			
		}
	}
	
	public int anmodIntMinMax(String msg, int min, int max)
	{
		int i = 0;
		
		do
		{
			i = gui.getUserInteger(msg, min, max);
		} while (min <= i && i <= max);
		
		return i;
	}
	
	public String anmodString(String msg)
	{
		return gui.getUserString(msg);
	}
	
	public void indlæsSpillere(Spiller[] spillere)
	{
		players = new GUI_Player[spillere.length];
		
		for (int i = 0; i < spillere.length; i++)
		{
			players[i].setName(spillere[i].getNavn());
			players[i].setBalance(spillere[i].getPenge());
			gui.addPlayer(players[i]);
		}
	}
	
	public void flytSpiller(GUI_Player p, int gammelPos, int nyPos)
	{
		this.fields[gammelPos].setCar(p, false);
		this.fields[nyPos].setCar(p, true);
	}
}