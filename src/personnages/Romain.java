package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipements = 0;
	int NB_MAX_EQUIPEMENT = 2;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		assert force > 0;
		this.force = force;
		equipements = new Equipement[NB_MAX_EQUIPEMENT];
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
	private void ajouter(Equipement equipement) {
		equipements[nbEquipements] = equipement;
		nbEquipements += 1;
		System.out.println("Le soldat " + nom + " s'equipe avec un " + equipement + ".");
	}
	
	private boolean est_dans_tab(Equipement equipement) {
		int i = 0;
		while (i<NB_MAX_EQUIPEMENT) {
			if (equipements[i] == equipement)
				return true;
			i++;
		}
		return false;
	}
	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipements) {
		case 0:
			ajouter(equipement);
			break;
		case 1:
			if (est_dans_tab(equipement)) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
				break;
			}
			ajouter(equipement);
			break;
		default:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		}
	}
	
	public static void main(String[] args) {
		Romain minus  = new Romain("minus", 6);
		minus.prendreParole();
		minus.parler("Ave César !");
		minus.recevoirCoup(15);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

	}
}