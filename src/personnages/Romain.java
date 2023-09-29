package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		super();
		this.nom = nom;
		assert force > 0;
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
		assert force > 0;
		int forcedebut = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		}
		 else {
				parler("J'abandonne...");
		}
		assert force < forcedebut;
	}
	public static void main(String[] args) {
		Romain minus  = new Romain("minus", 6);
		minus.prendreParole();
		minus.parler("Ave César !");
		minus.recevoirCoup(15);
	}
}