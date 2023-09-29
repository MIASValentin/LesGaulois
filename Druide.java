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
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à " + effetPotionMax + ".");
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
	
	public void preparerPotion() {
		Random x = new Random();
		int forcePotion;
		forcePotion = x.nextInt(effetPotionMax);
		if (forcePotion > 7) {
			parler("J'ai préparé une super potion de force :" + forcePotion);
		} else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est deulement de force :" + forcePotion);
		}
	}
}
