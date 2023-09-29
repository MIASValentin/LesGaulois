package personnages;

public class Gaulois 
{
	public Gaulois(String nom, int force)
	{
		this.nom = nom;
		this.force = force;
	}
	private String nom;
	private int force;
	private int effetPotion = 1;

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public int getEffetPotion() {
		return effetPotion;
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
		
	}

	private String prendreParole() {
		return "Le gaulois " + getNom() + " : ";
	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(force /3);
	}
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		asterix.prendreParole();
		asterix.parler("Bonjour !");
		Romain minus = new Romain("minus", 10);
		asterix.frapper(minus);
	}
}
