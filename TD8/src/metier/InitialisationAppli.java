/**
 * 
 */
package metier;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;

import connectionBDD.BDDConnection;
import domaine.Entree;
import domaine.Numero;
import fabrique.FabriqueEntree;
import fabrique.FabriqueNumero;

/**
 * @author Tchioben
 *
 */
public class InitialisationAppli {

	public static DefaultListModel initialisationEntree() { //DefaultListModel
		DefaultListModel dlm = new DefaultListModel();
		ResultSet rs = BDDConnection.getSelect("personne");
		FabriqueEntree fe = FabriqueEntree.getInstance();
		try {
			while (rs.next()) {
				String nom = rs.getString(2);
				String prenom = rs.getString(3);
				Entree e = fe.addEntreeObjet(nom, prenom);
				dlm.addElement(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dlm;

	}

	public static void initialisationNumero(DefaultListModel<Numero> lm2, String name,String prenom) {
		int n = BDDConnection.getNumeroPersonne(name, prenom);
		ResultSet rs2 = BDDConnection.getSelectNumeroWithIdpersonne(n);
		FabriqueNumero fn = FabriqueNumero.getInstance();
		lm2.removeAllElements();
		try {
			while (rs2.next()) {
				String code = rs2.getString(3);
				String valeur = rs2.getString(4);
				Numero num = fn.addNumero(code, valeur);
				lm2.addElement(num);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Numero ajouterNumero(String nom, String prenom, String code, String valeur) {
		FabriqueEntree fe= FabriqueEntree.getInstance();
		FabriqueNumero fn= FabriqueNumero.getInstance();
		Entree entree = fe.getLesEntrees().get(nom.hashCode()+prenom.hashCode());
		if (entree != null) {
			Numero n = fn.addNumero(code, valeur);
			BDDConnection.addNumero(n.getId(), BDDConnection.getNumeroPersonne(nom, prenom), code, valeur);
			return n;
		} 
		return null;
	}
	

}
