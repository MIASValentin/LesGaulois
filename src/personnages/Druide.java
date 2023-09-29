package personnages;
import java.util.*;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		super();
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " � " + effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
		
	}

	private String prendreParole() {
		return "Le druide " + getNom() + " : ";
	}
	
	public int preparerPotion() {
		Random x = new Random();
		int forcePotion;
		forcePotion = x.nextInt(effetPotionMax);
		while (forcePotion < effetPotionMin)
		{
			forcePotion = x.nextInt(effetPotionMax);
		}
		if (forcePotion > 7) {
			parler("J'ai pr�par� une super potion de force : " + forcePotion);
		} else {
			parler("Je n'ai pas trouv� tous les ingr�dients, ma potion est seulement de force : " + forcePotion);
		}
		return forcePotion;
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() == "Ob�lix")
		{
			parler("Non, Ob�lix !... Tu n'auras pas de potion magique !");
		}
		else {
			gaulois.boirePotion(preparerPotion());
		}
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();
	}
}