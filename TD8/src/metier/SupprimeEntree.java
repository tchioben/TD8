/**
 * 
 */
package metier;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import connectionBDD.BDDConnection;
import domaine.Entree;
import fabrique.FabriqueEntree;

/**
 * @author Tchioben
 *
 */
public class SupprimeEntree {
	
	public static void supprimEntree(String nom, String prenom){
		FabriqueEntree e = FabriqueEntree.getInstance();
		e.supprimeEntree(nom, prenom);
		int n = BDDConnection.getNumeroPersonne(nom, prenom);
		BDDConnection.deletePersonne(n,nom, prenom);
	}
	
	
}
