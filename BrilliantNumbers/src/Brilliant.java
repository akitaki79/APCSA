import java.util.ArrayList;


public class Brilliant {	

	ArrayList<Integer> brilliants = new ArrayList<Integer>();

	public Brilliant(int n) {
		for (int i = 0; n > brilliants.size(); i++) {
			if (Main.isBrilliant(i)) {
				brilliants.add(0,i);
			}
		}	
	}

}
