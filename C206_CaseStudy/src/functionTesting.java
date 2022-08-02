import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class functionTesting {

	static Connection conn;
	static Statement statement;
	static ResultSet rs;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		functionTesting ft = new functionTesting();
		ft.start();
		
	}
	
	public static void start() {
		try {
			String connectionString = "jdbc:mysql://localhost:3306/c206";
			String userid = "root";
			String password = "";


			conn = DriverManager.getConnection(connectionString, userid, password);
			statement = conn.createStatement();
			//rs = statement.executeQuery("SELECT Name, Category, HasSeaview, DistanceKm, ClosingTime FROM jogging_spot");

		} catch (SQLException se) {
			se.printStackTrace();
		}
		getCategory();
		
	}
	
	public static void getCategory() {
		try {
			String sql = "SELECT cca_category_list.CategoryName FROM cca_category_list INNER JOIN cca_list ON cca_category_list.CategoryId = cca_list.ccaId";
			
			rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String catName = rs.getString("categoryName");
				System.out.println(catName);
			}
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

}
