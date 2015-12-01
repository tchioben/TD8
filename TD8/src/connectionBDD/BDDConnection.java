package connectionBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDDConnection {


	public static BDDConnection INSTANCE = null;

	private static Connection c;

	public BDDConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://172.18.15.22:3306/bailleulb?user=bailleulb&password=valiance");

		} catch (ClassNotFoundException e) {
			System.out.println("Erreur classforname");
		} catch (SQLException e) {
			System.out.println("Erreur connection \n");
		}
	}

	public static void initBDD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://172.18.15.22:3306/bailleulb?user=bailleulb&password=valiance");

		} catch (ClassNotFoundException e) {
			System.out.println("Erreur classforname");
		} catch (SQLException e) {
			System.out.println("Erreur connection \n");
		}
	}

	public static BDDConnection getInstance() {
		if (INSTANCE == null) {
			return new BDDConnection();
		} else {
			return INSTANCE;
		}
	}

	public static void requete() {
		try {
			BDDConnection.getInstance();
			PreparedStatement ps = c.prepareStatement("select * from personne");
			System.out.println("ps cree");
			ResultSet rs = ps.executeQuery();
			// int n = ps.executeUpdate();
			System.out.println("J'ai executé la query");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addPersonne(String id_personne, String nom, String prenom) {
		try {

			BDDConnection.getInstance();
			PreparedStatement stmt = c
					.prepareStatement("INSERT INTO personne (id_personne,nom, prenom) VALUES(?, ?, ?)");
			stmt.clearParameters();
			stmt.setString(1, id_personne);
			stmt.setString(2, nom);
			stmt.setString(3, prenom);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addNumero(int i, int j,String code, String valeur) {
		try {
			BDDConnection.getInstance();
			PreparedStatement stmt = c.prepareStatement("INSERT INTO numero (id_numero,id_personne,code, valeur) VALUES(?,?, ?, ?)");
			stmt.clearParameters();
			stmt.setInt(1, i);
			stmt.setInt(2, j);
			stmt.setString(3, code);
			stmt.setString(4, valeur);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * supprime la personne ainsi que tous ses numeros associés.
	 * @param n 
	 */
	public static void deletePersonne(int n, String nom,String prenom) {
		try {
			BDDConnection.getInstance();
			deleteNumeros(n);
			PreparedStatement stmt = c.prepareStatement("delete from personne where nom=? and prenom =?");
			stmt.clearParameters();
			stmt.setString(1, nom);
			stmt.setString(2, prenom);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * supprime tous les numeros de la personne en parametre
	 * 
	 * @param n
	 */
	private static void deleteNumeros(int n) {
		try {
			BDDConnection.getInstance();
			PreparedStatement stmt = c.prepareStatement("delete from numero where id_personne=?");
			stmt.clearParameters();
			stmt.setInt(1, n);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	/**
	 * permet de retourner le dernier numero de la table Personne, pour avoir
	 * des valeurs uniques
	 * 
	 * @return le prochain numéro à utiliser. 
	 */
	public static int getPersonneSequence() {
		PreparedStatement stmt;
		ResultSet numero = null;
		int n=0;
		try {
			initBDD();
			stmt = c.prepareStatement("select max(id_personne) from personne");
			numero = stmt.executeQuery();
			numero.next();
			n = numero.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	/**
	 * permet de retourner le dernier numero de la table umero, pour avoir des
	 * valeurs uniques
	 * 
	 * @return le prochain numéro à utiliser.
	 */
	public static int getNumeroSequence() {
		PreparedStatement stmt;
		ResultSet numero = null;
		try {
			initBDD();
			stmt = c.prepareStatement("select max(id_numero) from numero");
			numero = stmt.executeQuery();
			System.out.println(numero.getRow());
		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		}
		return Integer.parseInt(numero.toString());
	}

	public static ResultSet getSelect(String table) {
		PreparedStatement stmt;
		ResultSet numero = null;
		try {
			initBDD();
			stmt = c.prepareStatement("select * from " + table);
			numero = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numero;
	}
	
	public static ResultSet getSelectNumeroWithIdpersonne(int i) {
		PreparedStatement stmt;
		ResultSet numero = null;
		try {
			initBDD();
			stmt = c.prepareStatement("select * from numero where id_personne =?");
			stmt.setInt(1, i);
			numero = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numero;
	}
	
/**
 * permet de recuperer l'identifiant de la personne
 * @param name nom
 * @param prenom prenom
 * @return 0 if he don't find the person
 */
	public static int getNumeroPersonne(String name,String prenom) {
		PreparedStatement stmt;
		ResultSet numero = null;
		try {
			initBDD();
			stmt = c.prepareStatement("select id_personne from personne where nom=? and prenom=?");
			stmt.setString(1, name);
			stmt.setString(2, prenom);
			numero = stmt.executeQuery();
			 numero.next();
			return numero.getInt(1);
		}
		catch (Exception e){
		}
		return 0;
	}

		public static void deleteUnNumero(int n,String code, String valeur) {
			try {
				BDDConnection.getInstance();
				PreparedStatement stmt = c.prepareStatement("delete from numero where id_personne=? and code=? and valeur=?");
				stmt.clearParameters();
				stmt.setInt(1, n);
				stmt.setString(2, code);
				stmt.setString(3, valeur);
				stmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		
}
