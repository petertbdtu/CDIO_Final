package gr_34.entity;

public class ChancekortCreator {
	
	public static Chancekort[] getChancekort() {
		 Chancekort[] ck = new  Chancekort[12];
		 
		ck[0] = new Chancekort(ChanceEffekt.GåTilRådhus);
		ck[1] = new Chancekort(ChanceEffekt.RykTreFelterTilbage);		
		ck[2] = new Chancekort(ChanceEffekt.RykFremTilStart);
		ck[3] = new Chancekort(ChanceEffekt.RykTilbageTilStart);
		ck[4] = new Chancekort(ChanceEffekt.Betal100Vogn );
		ck[5] = new Chancekort(ChanceEffekt.BetalVask10);
		ck[6] = new Chancekort(ChanceEffekt.BetalTold20);
		ck[7] = new Chancekort(ChanceEffekt.FuldStop100);
		ck[8] = new Chancekort(ChanceEffekt.Modtag20);
		ck[9] = new Chancekort(ChanceEffekt.PBøde20);
		ck[10] = new Chancekort(ChanceEffekt.Præmie100);
		ck[11] = new Chancekort(ChanceEffekt.AktieModtag50);
		
		
		 return ck;
	}
}
