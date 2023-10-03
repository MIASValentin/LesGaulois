package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	int NB_MAX_EQUIPEMENT = 2;
	private String texte;
	
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
	
//	public void recevoirCoup(int forceCoup) {
//		assert force > 0;
//		int forcedebut = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		}
//		 else {
//				parler("J'abandonne...");
//		}
//		assert force < forcedebut;
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		switch (force) {
		case 0:
			parler("Aïe");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
	// post condition la force a diminuée
	assert force < oldForce;
	return equipementEjecte;
	}
	
	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
		texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
		for (int i = 0; i < nbEquipement;) {
		if ((equipements[i] != null &&
		equipements[i].equals(Equipement.BOUCLIER)) == true) {
		resistanceEquipement += 8;
		} else {
		System.out.println("Equipement casque");
		resistanceEquipement += 5;
		}
		i++;
		}
		texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
	
		private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {if (equipements[i] == null) {
			continue;
		} else {
		equipementEjecte[nbEquipementEjecte] =
		equipements[i];
		nbEquipementEjecte++;
		equipements[i] = null;
		}
		}
		return equipementEjecte;
		}

	private void ajouter(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement += 1;
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
		switch(nbEquipement) {
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