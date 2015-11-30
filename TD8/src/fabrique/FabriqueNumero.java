package fabrique;

import java.util.ArrayList;

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

	private ArrayList<Numero> listeNums;

	private int compteur;

	private FabriqueNumero() {
		this.listeNums = new ArrayList<Numero>();
		this.compteur = 1;
	}

	public Numero addNumero(String code, String valeur) {
		Numero num = new Numero(compteur++, code, valeur);
		this.listeNums.add(num);
		return num;
	}

	public Numero getNumero(int id) {
		return this.listeNums.get(id);
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
	public ArrayList<Numero> getLsiteNums() {
		return listeNums;
	}

	/**
	 * NSTANC
	 * 
	 * @param lsiteNums
	 *            the lsiteNums to set
	 */
	public void setLsiteNums(ArrayList<Numero> lsiteNums) {
		this.listeNums = lsiteNums;
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
