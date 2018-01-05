package gr_34.boundary;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class GUIBoundary {
	
	GUI gui;
	GUI_Field[] fields;
	GUI_Player[] players;
	
	public GUIBoundary(GUI_Field[] fields, GUI_Player[] players)
	{
		this.fields = fields;
		this.gui = new GUI(fields);
		
		this.players = players;
		for (GUI_Player p : players)
			this.gui.addPlayer(p);
	}
	
	public void flytSpiller(GUI_Player p, int gammelPos, int nyPos)
	{
		this.fields[gammelPos].setCar(p, false);
		this.fields[nyPos].setCar(p, true);
	}
}