package gr_34.entity;

import java.awt.Color;
import gr_34.entity.felter.*;

public class FeltCreator {
	
	
	public static AbstraktFelt[] getFelter() {
		AbstraktFelt[] felter = new AbstraktFelt[40];
		felter[0] = new StartFelt("De modtager 200kr", "", "START");
		int[] leje = {2, 10, 30, 90, 160, 250};
		felter[1] = new Gade("", "", "Rødovrevej", 60, 30, Color.GRAY, leje, 10);
		felter[2] = new ChanceFelt("", "Prøv lykken", "Prøv lykken");
		int[] leje1 = {4, 20, 60, 180, 320, 510};
		felter[3] = new Gade("", "", "Hvidovrevej", 60, 20, Color.GRAY, leje1, 50);
		felter[4] = new BetalSkatFelt("", "", "", 200);
		felter[5] = new Rederi("", "", "Øresund", 200, 100);
		int[] leje2 = {6, 30, 90, 270, 400, 550};
		felter[6] = new Gade("", "", "Roskildevej", 100, 50, Color.RED, leje2, 50);
		felter[7] = new ChanceFelt("", "Prøv lykken", "Prøv lykken");
		int[] leje3 = {6, 30, 90, 270, 400, 550};
		felter[8] = new Gade("", "", "Valby Langgade", 100, 50, Color.RED, leje3, 50);
		int[] leje4 = {8,40,100,300,450,600};
		felter[9] = new Gade("", "", "Allégade", 120, 60, Color.RED, leje4, 50);
		felter[10] = new Fængsel("Fængsel", "", "Fængsel");
		int[] leje5 = {10, 50,150,450,625,750};
		felter[11] = new Gade("", "", "Frederiksberg Allé", 140, 70, Color.GREEN, leje5, 100);
		felter[12] = new Bryggeri("", "", "Tuborg", 150, 75);
		felter[13] = new Gade("", "", "Bülowsvej", 140, 70, Color.GREEN, leje5, 100);
		int[] leje6 = {12,60,180,500,700,900};
		felter[14] = new Gade("", "", "Gl. Kongevej", 160, 80, Color.GREEN, leje6, 100);
		felter[15] = new Rederi("", "", "D.F.D.S", 200, 100);
		int [] leje7 = {14,70,200,550,750,950};
		felter[16] = new Gade("", "", "Bernstorffsvej", 180, 90, Color.DARK_GRAY, leje7, 100);
		felter[17] = new ChanceFelt("", "Prøv lykken", "Prøv lykken");
		felter[18] = new Gade("", "", "Hellerupvej", 180, 90, Color.DARK_GRAY, leje7, 100);
		int [] leje8 = {16,80,220,600,800,1000};
		felter[19] = new Gade("", "", "Strandvej", 200, 100, Color.DARK_GRAY, leje8, 100);
		felter[20] = new Parkering("", "", "");
		int[] leje9 = {18,90,250,700,875,1050};
		felter[21] = new Gade("", "", "Trianglen", 220, 110, Color.ORANGE, leje9, 150);
		felter[22] = new ChanceFelt("", "Prøv lykken", "Prøv lykken");
		felter[23] = new Gade("", "", "Østerbrogade", 220, 110, Color.ORANGE, leje9, 150);
		int[] leje10 = {20,100,300,750,925,1100};
		felter[24] = new Gade("", "", "Grønningen", 240, 120, Color.ORANGE, leje10, 150);
		felter[25] = new Rederi("", "", "Ø.K", 200, 100);
		int[] leje11 = {22,110,330,800,975,1150};
		felter[26] = new Gade("", "", "Bredgade", 260, 130, Color.WHITE, leje11, 150);
		felter[27] = new Gade("", "", "Kg. Nytorv", 260, 130, Color.WHITE, leje11, 150);
		felter[28] = new Bryggeri("", "", "Carlsberg", 150, 75);
		int[] leje12 = {22,120,360,850,1025,1200};
		felter[29] = new Gade("", "", "Østergade", 280, 140, Color.WHITE, leje12, 150);
		felter[30] = new GåIFængsel("De sættes i fængsel", "", "");
		int[] leje13 = {26,130,390,900,1100,1275};
		felter[31] = new Gade("", "", "Amagertorv", 300, 150, Color.YELLOW, leje13, 200);
		felter[32] = new Gade("", "", "Vimmelskaftet", 300, 150, Color.YELLOW, leje13, 200);
		felter[33] = new ChanceFelt("", "Prøv lykken", "Prøv lykken");
		int[] leje14 = {28,150,450,1000,1200,1400};
		felter[34] = new Gade("", "", "Nygade", 320, 160, Color.YELLOW, leje14, 200);
		felter[35] = new Rederi("", "", "D/S Bornholm 1866", 200, 100);
		felter[36] = new ChanceFelt("", "Prøv lykken", "Prøv lykken");
		int[] leje15 = {35,175,500,1100,1300,1500};
		felter[37] = new Gade("", "", "Frederiksberggade", 350, 175, new Color(120, 90, 60), leje15, 200);
		felter[38] = new BetalSkatFelt("", "", "", 100);
		int[] leje16 = {50,200,600,1400,1700,2000};
		felter[39] = new Gade("", "", "Rådhuspladsen", 400, 200, new Color(120, 90, 60), leje16, 200);
		
		return felter;
		
	}

}
