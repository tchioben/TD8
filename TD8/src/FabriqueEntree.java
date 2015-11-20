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
	
	public FabriqueEntree(){
		this.setLesEntrees(new HashMap<Integer,Entree>());
	}
	
	public static FabriqueEntree getInstance(){
		if (INSTANCE == null){
			INSTANCE = new FabriqueEntree();
		}
		return INSTANCE;
	}

	/**ajoute une entree dans la hashmap
	 * @param entree : la nouvelle entree
	 */
	public void addEntree(String nom, String prenom){
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
	
	
	
}
