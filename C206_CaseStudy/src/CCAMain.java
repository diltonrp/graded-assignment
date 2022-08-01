import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CCAMain {

	static Connection conn;
	static Statement statement;
	static ResultSet rs;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CCAMain ccaMain = new CCAMain();
		ccaMain.dbConnection();
	}
	
	private void dbConnection() {
		try {
			String connectionString = "jdbc:mysql://localhost:3306/c206";
			String userId = "root";
			String password = "";
			
			conn = DriverManager.getConnection(connectionString, userId, password);
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		System.out.println("Welcome to Woodleys Primary School!");
		System.out.println("Select your CCA according to your preferences. Have fun!");
	}
	
	private static void roleMenu() {
		System.out.println("I am a...");
		System.out.println("1. Teacher");
		System.out.println("2. Student");
		System.out.println("3. Parent");
		int roleSelection = Helper.readInt("Input your selection (1, 2, or 3) > ");
		
	}
	
	//------------------------student 1--------------------------------
	public static void addStudent() {
		
	}
	
	public static void viewStudent() {
		
	}
	
	public static void deleteStudent() {
		
	}
	//-------------------------end of student 1----------------------------
	//-------------------------student 2-----------------------------------
	public static void addCCADetail() {
		
	}
	
	public static void viewAllCCA() {
		
	}
	
	public static void deleteCCA() {
		
	}
	//-------------------------end of student 2----------------------------
	//-------------------------student 3-----------------------------------
	public static void addCCACategory() {
		
	}
	
	public static void viewAllCCACategory() {
		
	}
	
	public static void deleteAllCCACategory() {
		
	}
	//-------------------------end of student 3----------------------------
	//-------------------------student 4-----------------------------------
	public static void addParentAccount() { //remember to include student account
		
	}
	
	public static void viewRegisteredParents() {
		
	}
	
	public static void deleteParent() {
		
	}
	//-------------------------end of student 4----------------------------
	//-------------------------student 5-----------------------------------
	public static void studentLogin() { // login with student and CCA registration ID
		
	}
	
	public static void addStudentForCCA() {
		
	}
	
	public static void viewStudentsRegisteredForCCA() {
		
	}
	
}
