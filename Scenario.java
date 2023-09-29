package histoire;

import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("asterix", 8);
		Romain minus = new Romain("minus", 6);
		asterix.parler("Bonjour à tous");
		minus.parler("UN GAU ... UN GAUGAU...");
		while(minus.getforce()> 0)
		{
			asterix.frapper(minus);
		}
	}

}
