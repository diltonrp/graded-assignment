import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CCAMain {

	static Connection conn;
	static Statement statement;
	static ResultSet rs;
	
	public static String nameOfTeacher = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CCAMain ccaMain = new CCAMain();
		ccaMain.dbConnection();
		

		System.out.println("Welcome to Woodleys Primary School!");
		System.out.println("Select your CCA according to your preferences. Have fun!");
		Helper.line(80, "=");
		
		boolean continueMenu = true;
		
		while (continueMenu) {
			if (roleMenu() == 1) { // teacher
				System.out.println("Welcome");
				
				if (teacherVerification()) {
					viewStudents(teacherMenu());
				} else {
					System.out.println("You have entered the wrong id or password. What would you like to do?\n1. Return to home page\n2.Try entering id and password again");
					int userChoice = Helper.readInt("Enter your option (1 or 2) > ");
					if (userChoice == 1) {
						roleMenu();
					}
				}
				
			} else if (roleMenu() == 2) { // student
				
			} else if (roleMenu() == 3) { // parent
				
			} else {
				System.out.println("Please input a valid number");
			}
		}
		
	}
	
	private void dbConnection() {
		try {
			String connectionString = "jdbc:mysql://localhost:3306/c206";
			String userId = "root";
			String password = "";
			
			conn = DriverManager.getConnection(connectionString, userId, password);
			statement = conn.createStatement();
			
			
			System.out.println("Successfully connected to database!");
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	}
	
	private static int roleMenu() {
		System.out.println("I am a...");
		System.out.println("1. Teacher");
		System.out.println("2. Student");
		System.out.println("3. Parent");
		int roleSelection = Helper.readInt("Input your selection (1, 2, or 3) > ");
		return roleSelection;
	}
	
	// teacherVerification(teacherCredentialsInput(1), teacherCredentialsInput(2));
	/*
	private static String teacherCredentialsInput(int credentialSelection) {
		int inputTeacherId = Helper.readInt("Enter your ID > ");
		String inputTeacherPassword = Helper.readString("Enter your password > ");
		
		String[] items = {String.valueOf(inputTeacherId), inputTeacherPassword};
		
		String selectedMenu = ""; 
		if (credentialSelection == 1) {
			selectedMenu = items[0];
		} else if (credentialSelection == 2) {
			selectedMenu = items[1];
		}
		
		return selectedMenu;
	}*/
	
	private static boolean teacherVerification(){
		boolean isATeacher = false;
		
		int inputTeacherId = Helper.readInt("Enter your ID > ");
		String inputTeacherPassword = Helper.readString("Enter your password > ");
		
		
		int teacherId = 0;;
		String teacherPassword = "";
		
		try {
			String sql = "SELECT id, name, password FROM teacher_list";
			
			rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				teacherId = rs.getInt("id");
				String teacherName = rs.getString("name");
				teacherPassword = rs.getString("password");
				
				if (teacherId == inputTeacherId && teacherPassword.equals(inputTeacherPassword)) {
					isATeacher = true;
					nameOfTeacher = teacherName;
					break;
				} else {
					isATeacher = false;
				}
				
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		
		return isATeacher;
	}
	
	private static int teacherMenu() {
		
		System.out.println("Hi " + nameOfTeacher);
		System.out.println("1. View all students");
		System.out.println("2. View students with CCA");
		System.out.println("3. View students with no CCA");
		
		int teacherSelection = Helper.readInt("Please select (1, 2, or 3) > ");
		return teacherSelection;
	}
	
	private static void viewStudents(int teacherChoice) {
		String output = String.format("%-5s %-10s %-10s %-20s %-10s\n", "ID", "NAME", "CLASS", "CLASSROOM TEACHER", "SELECTED CCA");
		if (teacherChoice == 1) {
			try {
				
				String sql = "SELECT studentId, name, class, classroomTeacher, selectedCCA FROM student_list ORDER BY class ASC";
				rs = statement.executeQuery(sql);
				
				while (rs.next()) {
					int studentId = rs.getInt("studentId");
					String studentName = rs.getString("name");
					String studentClass = rs.getString("class");
					String classroomTeacher= rs.getString("classroomTeacher");
					String selectedCCA = rs.getString("selectedCCA");
					
					output += String.format("%-5d %-10s %-10s %-20s %-10s\n", studentId, studentName, studentClass, classroomTeacher, selectedCCA);
				}
				
				System.out.println(output);
				
			} catch (SQLException se) {
				se.printStackTrace();
			}
		} else if (teacherChoice == 2) {
			
		} else if (teacherChoice == 3) {
			
		}
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
