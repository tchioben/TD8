import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * 
 */

/**
 * @author Léa Vanelle & Benoît Bailleul
 *
 */
public class ConnectionBD {

	public static void connection(){
		String url = "jdbc:mysql://webtp.fil.univ-lille1.fr";
		String login = "bailleul";
		String password= "valiance";
		java.sql.Connection conn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, login,password);
			
			String sql = "select * from personne";
			
			st.executeQuery(sql);
		}
		catch (SQLException e){
			System.out.println("ok");
			e.printStackTrace();
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		finally {
			try{
				conn.close();
				st.close();
			}
			catch (SQLException e){
				System.out.println("ok");
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	connection();
	}
}
