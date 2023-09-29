package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("asterix", 8);
		Romain minus = new Romain("minus", 6);
		Gaulois obelix = new Gaulois("Ob�lix", 25);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.parler("Je vais aller pr�parer une petite potion...");
		int forcePotion = panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par B�l�nos, ce n'est pas juste !");
		asterix.boirePotion(forcePotion);
		asterix.parler("Bonjour");
		minus.parler("UN GAU ... UN GAUGAU...");
		while(minus.getforce()> 0)
		{
			asterix.frapper(minus);
		}
	}

}