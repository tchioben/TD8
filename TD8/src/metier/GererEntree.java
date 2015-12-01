/**
 * 
 */
package metier;

import connectionBDD.BDDConnection;
import domaine.Entree;
import fabrique.FabriqueEntree;

/**
 * @author Tchioben
 *
 */
public class GererEntree {

	public static Entree addEntree(String nom, String prenom) {
		FabriqueEntree fe = FabriqueEntree.getInstance();
		return fe.addEntreeBDDetObjet(nom, prenom);
	}

	
	public static Entree getEntree(String nom, String prenom){
		FabriqueEntree fe = FabriqueEntree.getInstance();
		return fe.getLesEntrees().get(nom.hashCode()+prenom.hashCode());
	}


	public static void supprimeEntreeDeLaBDD(Entree entree) {
		String nom = entree.getNom();
		String prenom = entree.getPrenom();
		int n = BDDConnection.getNumeroPersonne(nom, prenom);
		BDDConnection.deletePersonne(n,nom,prenom);
	}
	

}
