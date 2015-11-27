import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class BDDConnection {
	
	String url = "sql2.olympe.in";
	String userName = "y5cf3srf";
	String password = "P@ssw0rd2015";
	
	public static BDDConnection INSTANCE = null;
	
	private static Connection c;
	
	public BDDConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://webtp.fil.univ-lille1.fr:3306/bailleulb?user=bailleulb&password=valiance");
				
				
				
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur classforname");
		} catch (SQLException e) {
			System.out.println("Erreur connection \n");
		}
	}
	
	
	public static void initBDD(){
		try {
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection("jdbc:mysql://webtp.fil.univ-lille1.fr:3306/bailleulb?user=bailleulb&password=valiance");
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur classforname");
		} catch (SQLException e) {
			System.out.println("Erreur connection \n");
		}
	}
	
	public static BDDConnection getInstance(){
		if (INSTANCE == null){
			return new BDDConnection();
		}
		else {
			return INSTANCE;
		}
	}
	
	public static void requete(){
		try {
			initBDD();
			PreparedStatement ps = c.prepareStatement("select * from personne");
			System.out.println("ps crée");
			ResultSet rs = ps.executeQuery();
			//int n = ps.executeUpdate();
			System.out.println("J'ai executé la query");
			while(rs.next()){
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void addPersonne(String id_personne,String nom, String prenom){
		try {
			
			initBDD();
	        PreparedStatement stmt = c.prepareStatement("INSERT INTO personne (id_personne,nom, prenom) VALUES(?, ?, ?)");
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
	
	public static void addNumero(String id_numero,String id_personne,String code, String valeur){
		try {
			initBDD();
	        PreparedStatement stmt = c.prepareStatement("INSERT INTO personne (id_numero,id_personne,nom, prenom) VALUES(?,?, ?, ?)");
            stmt.clearParameters();
            stmt.setString(1, id_numero);
            stmt.setString(2, id_personne);
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
	 */
	public static void deletePersonne(String id_personne,String nom, String prenom){
		try {
			initBDD();
			deleteNumeros(id_personne);
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
	 * @param id_personne
	 */
	private static void deleteNumeros(String id_personne) {
		try {
			initBDD();
	        PreparedStatement stmt = c.prepareStatement("delete from numero where id_personne=?");
            stmt.clearParameters();
            stmt.setString(1, id_personne);
            stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * supprime seulement le numero de l'id en parametre
	 * @param id_numero
	 */
	private static void deleteNumero(String id_numero) {
		try {
			initBDD();
	        PreparedStatement stmt = c.prepareStatement("delete from numero where id_numero=?");
            stmt.clearParameters();
            stmt.setString(1, id_numero);
            stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("j'essaie de me connecter ...");
		BDDConnection cn = new BDDConnection();
		System.out.println("Connection réussie");
		cn.requete();
	}
	
	/**permet de retourner le dernier numero de la table Personne, pour avoir des valeurs uniques
	 * 
	 * @return le prochain numéro à utiliser.
	 */
	public static int getPersonneSequence(){
		PreparedStatement stmt;
		ResultSet numero = null;
		try {
			initBDD();
			stmt = c.prepareStatement("select max(id_personne) from personne");
			numero = stmt.executeQuery();
			// while (numero.next()) {
              //   System.out.println(numero.getString(1)); //+numero.getString(2)+ numero.getString(3));
             //}
			numero.next();
			System.out.println(numero.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  1;//Integer.parseInt(numero.get());
	}
	
	/**permet de retourner le dernier numero de la table umero, pour avoir des valeurs uniques
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
		return Integer.parseInt(numero.toString());
	}
	
	public static ResultSet getSelect(String table){
		PreparedStatement stmt;
		ResultSet numero = null;
		try {
			initBDD();
			stmt = c.prepareStatement("select * from "+table);
			numero = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numero;
		
	}
}
