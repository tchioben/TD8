import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Léa Vanelle & Benoît Bailleul
 *
 */
public class Entree {
	
	private String nom;

	private String prenom;
	
	private ArrayList<Integer> lesNuméros;

	public Entree(String nom, String prenom){
		this.nom = nom;
		this.prenom= prenom;
		this.lesNuméros= new ArrayList<Integer>();
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the lesNuméros
	 */
	public ArrayList<Integer> getLesNuméros() {
		return lesNuméros;
	}

	/**
	 * @param lesNuméros the lesNuméros to set
	 */
	public void setLesNuméros(ArrayList<Integer> lesNuméros) {
		this.lesNuméros = lesNuméros;
	}
	
	public boolean equals(Object o){
		return (this.nom.equals(((Entree) o).getNom()) && this.prenom.equals(((Entree) o).getPrenom()));
	}
	
	public String toString(){
		return this.nom+" "+this.prenom;
	}
	
	public int hashCode(){
		return this.nom.hashCode()+this.prenom.hashCode();
	}


	
	
}
