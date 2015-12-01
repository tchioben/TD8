package fabrique;

import java.util.HashMap;
/**
 * 
 */


import connectionBDD.BDDConnection;
import domaine.Entree;

/**
 * @author Léa Vanelle & Benoît Bailleul
 *
 */
public class FabriqueEntree {

	private static FabriqueEntree INSTANCE = null;

	private HashMap<Integer, Entree> lesEntrees;

	private static int sequence;

	private FabriqueEntree() {
		this.setLesEntrees(new HashMap<Integer, Entree>());
		this.setSequence(BDDConnection.getPersonneSequence() + 1);
	}

	public static FabriqueEntree getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new FabriqueEntree();
		}
		return INSTANCE;
	}

	/**
	 * ajoute une entree dans la hashmap et BDD
	 * 
	 * @param entree
	 *            : la nouvelle entree
	 * @return 
	 */
	public Entree addEntreeBDDetObjet(String nom, String prenom) {
		Entree entree = new Entree(nom, prenom);
		if (!entreeExiste(entree)) {
			sequence++;
			BDDConnection.addPersonne(getSequenceString(), nom, prenom);
			this.lesEntrees.put(entree.hashCode(), entree);
		} 
		else { entree = this.lesEntrees.get((nom.hashCode()+prenom.hashCode())*7); }
		return entree;
	}

	/**
	 * ajoute une entree dans la hashmap et BDD
	 * 
	 * @param entree
	 *            : la nouvelle entree
	 * @return 
	 */
	public Entree addEntreeObjet(String nom, String prenom) {
		Entree entree = new Entree(nom, prenom);
		if (!entreeExiste(entree)){
			this.lesEntrees.put(entree.hashCode(), entree);
		}
		return entree;
	}

	private boolean entreeExiste(Entree entree) {
		if (this.lesEntrees.get(entree.hashCode()) != null) {
			return true;
		}
		return false;
	}

	/**
	 * @return the lesEntrees
	 */
	public HashMap<Integer, Entree> getLesEntrees() {
		return lesEntrees;
	}

	/**
	 * @param lesEntrees
	 *            the lesEntrees to set
	 */
	public void setLesEntrees(HashMap<Integer, Entree> lesEntrees) {
		this.lesEntrees = lesEntrees;
	}

	public int getSequence() {
		return sequence;
	}

	public static String getSequenceString() {
		String seq = String.valueOf(sequence);
		return seq;
	}

	public void setSequence(int sequence) {
		FabriqueEntree.sequence = sequence;
	}

	public Entree newEntree(String nom, String prenom) {
		Entree entree= new Entree(nom, prenom);
		return entree;
	}
	
	public void supprimeEntree(String nom, String prenom){
		this.lesEntrees.remove(nom.hashCode()+prenom.hashCode());
	}

}
