package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}

	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}

	public String getNom() {
		return nom;
	}
	
	public int getforce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
		
	}

	private String prendreParole() {
		return "Le romain " + getNom() + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		}
		 else {
				parler("J'abandonne...");
		}
		
	}
	public static void main(String[] args) {
		Romain romus  = new Romain("romus", 15);
		romus.prendreParole();
		romus.parler("Ave César !");
		romus.recevoirCoup(15);
	}
}