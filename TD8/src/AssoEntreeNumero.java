

/**
 * 
 */

/**
 * @author Léa Vanelle & Benoît Bailleul
 *
 */
public class AssoEntreeNumero {

	public static void assoEntreeNumero(String nom, String prenom, String code, String valeur){
		FabriqueEntree fe = FabriqueEntree.getInstance();
		FabriqueNumero fn = FabriqueNumero.getInstance();
		fe.addEntreeBDDetObjet(nom, prenom);
		fn.addNumero(code, valeur);
	}
}
