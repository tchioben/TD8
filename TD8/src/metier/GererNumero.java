/**
 * 
 */
package metier;

import connectionBDD.BDDConnection;
import domaine.Numero;
import fabrique.FabriqueNumero;

/**
 * @author Tchioben
 *
 */
public class GererNumero {

		public static Numero addNumero(String nom, String prenom,String code, String valeur) {
			FabriqueNumero fe = FabriqueNumero.getInstance();
			AssoEntreeNumero.assoEntreeNumero(nom, prenom, code, valeur);
			int numPersonne = BDDConnection.getNumeroPersonne(nom,prenom);
			Numero num = fe.addNumero(code, valeur);
			BDDConnection.addNumero(num.getId(), numPersonne, nom, prenom);
			return num;
		}

		
		public static Numero getNumero(String code, String valeur){
			FabriqueNumero fe = FabriqueNumero.getInstance();
			return fe.getNumero(code, valeur);
		}


		public static void supprimeNumeroDeLaBDD(String nom,String prenom,Numero Numero) {
			String code = Numero.getCode();
			String valeur = Numero.getValeur();
			int n = BDDConnection.getNumeroPersonne(nom, prenom);
			BDDConnection.deleteUnNumero(n, code, valeur);
		}
		
}
