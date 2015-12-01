package fabrique;

import java.util.HashMap;

import domaine.Numero;

/**
 * 
 */

/**
 * @author Léa Vanelle & Benoît Bailleul
 *
 */
public class FabriqueNumero {

	private static FabriqueNumero INSTANCE = null;

	private HashMap<Integer,Numero> listeNums;

	private int compteur;

	private FabriqueNumero() {
		this.listeNums = new HashMap<Integer,Numero>();
		this.compteur = 1;
	}

	public Numero addNumero(String code, String valeur) {
		Numero num = new Numero(compteur++, code, valeur);
		this.listeNums.put(num.hashCode(),num);
		return num;
	}

	public Numero getNumero(String code,String valeur) {
		return this.listeNums.get((code.hashCode()+valeur.hashCode())*13);
	}

	public static FabriqueNumero getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new FabriqueNumero();
		}
		return INSTANCE;
	}

	/**
	 * @return the lsiteNums
	 */
	public HashMap<Integer,Numero> getListeNums() {
		return listeNums;
	}

	/**
	 * NSTANC
	 * 
	 * @param lsiteNums
	 *            the lsiteNums to set
	 */
	public void setListeNums(HashMap<Integer,Numero> listeNums) {
		this.listeNums = listeNums;
	}

	/**
	 * @return the compteur
	 */
	public int getCompteur() {
		return compteur;
	}

	/**
	 * @param compteur
	 *            the compteur to set
	 */
	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

}
