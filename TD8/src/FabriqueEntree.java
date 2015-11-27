

import java.util.HashMap;
/**
 * 
 */

/**
 * @author Léa Vanelle & Benoît Bailleul
 *
 */
public class FabriqueEntree {

	private static FabriqueEntree INSTANCE = null;
	
	private HashMap<Integer,Entree> lesEntrees;
	
	private static int sequence;
	
	public FabriqueEntree(){
		this.setLesEntrees(new HashMap<Integer,Entree>());
		this.setSequence(BDDConnection.getPersonneSequence()+1);
	}
	
	public static FabriqueEntree getInstance(){
		System.out.println("ok");
		if (INSTANCE == null){
			INSTANCE = new FabriqueEntree();
		}
		return INSTANCE;
	}

	/**ajoute une entree dans la hashmap et BDD
	 * @param entree : la nouvelle entree
	 */
	public void addEntreeBDDetObjet(String nom, String prenom){
		System.out.println(nom+prenom);
		Entree entree= new Entree(nom,prenom);
		System.out.println("ok ca marche");
		if (!entreeExiste(entree)){
			sequence++;
			BDDConnection.addPersonne(getSequenceString(), nom, prenom);
			this.lesEntrees.put(entree.hashCode(), entree);
		}
	}
	
	
	/**ajoute une entree dans la hashmap et BDD
	 * @param entree : la nouvelle entree
	 */
	public void addEntreeObjet(String nom, String prenom){
		Entree entree= new Entree(nom,prenom);
		if (!entreeExiste(entree)){
			this.lesEntrees.put(entree.hashCode(), entree);
		}
	}
	
	private boolean entreeExiste(Entree entree) {
		if (this.lesEntrees.get(entree)!=null){
			return true;
		}
		return false;
	}

	/**
	 * @return the lesEntrees
	 */
	public HashMap<Integer,Entree> getLesEntrees() {
		return lesEntrees;
	}

	/**
	 * @param lesEntrees the lesEntrees to set
	 */
	public void setLesEntrees(HashMap<Integer,Entree> lesEntrees) {
		this.lesEntrees = lesEntrees;
	}

	public int getSequence() {
		return sequence;
	}
	
	public static String getSequenceString(){
		String seq = String.valueOf(sequence);
		return seq;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	
	
	
}
