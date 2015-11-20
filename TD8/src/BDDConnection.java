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
	
	private Connection c;
	
	public BDDConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://webtp.fil.univ-lille1.fr:3306/vanelle?user=vanelle&password=mouais^^030792");
			
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
	
	public void requete(){
		try {
			
			PreparedStatement ps = c.prepareStatement("Select * from brands");
			System.out.println("ps crée");
			ResultSet rs = ps.executeQuery();
			System.out.println("J'ai executé la query");
			while(rs.next()){
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("j'essaie de me connecter ...");
		BDDConnection cn = new BDDConnection();
		System.out.println("Connection réussie");
		cn.requete();
	}
}
