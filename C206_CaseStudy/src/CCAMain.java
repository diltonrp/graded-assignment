import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CCAMain {

	static Connection conn;
	static Statement statement;
	static ResultSet rs;
	
	public static String nameOfTeacher = "";
	
	private static ArrayList<Student> studentList = new ArrayList<Student>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CCAMain ccaMain = new CCAMain();
		ccaMain.dbConnection();
		
		// initial array loading
		addStudentsToArray();

		// start of menu
		System.out.println("Welcome to Woodleys Primary School!");
		System.out.println("Select your CCA according to your preferences. Have fun!");
		Helper.line(80, "=");
		
		roleMenu();

		/*
		if (roleMenu() == 1) { // teacher

			if (teacherVerification()) {
				
				while (teacherMenu() != 4) {
					System.out.println("Test working");
					
					System.out.println("Student printed");
					viewStudents(teacherMenu());
					
					if (teacherMenu() == 4) {
						roleMenu();
						break;
					}
				}
				
				
			} else {
				System.out.println("You have entered the wrong id or password. What would you like to do?\n1. Return to home page\n2.Try entering id and password again");
				int wrongTeacherPasswordChoice = Helper.readInt("Enter your option (1 or 2) > ");
				if (wrongTeacherPasswordChoice == 1) {
					roleMenu();
				}
			}
			
			
			
		} else if (roleMenu() == 2) { // student
			System.out.println("Welcome student!");
		} else if (roleMenu() == 3) { // parent
			System.out.println("Welcome parent!");
		} else {
			System.out.println("Please input a valid number");
		}
		*/
	
	}
	
	private void dbConnection() {
		try {
			String connectionString = "jdbc:mysql://localhost:3306/c206";
			String userId = "root";
			String password = "";
			
			conn = DriverManager.getConnection(connectionString, userId, password);
			statement = conn.createStatement();
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	}
	
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
	
	//-------------------------------------Start of menu-----------------------------------------------
	
	private static void roleMenu() {
		System.out.println("I am a...");
		System.out.println("1. Teacher");
		System.out.println("2. Student");
		System.out.println("3. Parent");
		System.out.println("4. I want to quit");
		int roleSelection = Helper.readInt("Input your selection (1, 2, 3 or 4) > ");
		
		while (roleSelection != 4) {
			if (roleSelection == 1) {
				teacherMenu();
			} else if (roleSelection == 2) {
				
			}
		}
		
	}
	
	private static void teacherMenu() {
		//
		System.out.println("Hi " + nameOfTeacher);
		System.out.println("1. View all students");
		System.out.println("2. View students with CCA");
		System.out.println("3. View students with no CCA");
		System.out.println("4. Logout");
		
		int teacherSelection = Helper.readInt("Please select (1, 2, 3 or 4) > ");
		
		if (teacherSelection == 1)
	}
	
	//-------------------------------Adding to array lists--------------------------------------------
	
	private static void addStudentsToArray() {
		try {
			
			String sql = "SELECT studentId, name, class, classroomTeacher, selectedCCA FROM student_list ORDER BY class ASC";
			rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				int studentId = rs.getInt("studentId");
				String studentName = rs.getString("name");
				String studentClass = rs.getString("class");
				String classroomTeacher= rs.getString("classroomTeacher");
				String selectedCCA = rs.getString("selectedCCA");
				
				studentList.add(new Student(studentId, studentName, studentClass, classroomTeacher, selectedCCA));
			}
			
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
	
	}
	
	private static void viewStudents(int teacherChoice) {
		
		String output = String.format("%-5s %-10s %-10s %-20s %-10s\n", "ID", "NAME", "CLASS", "CLASSROOM TEACHER", "SELECTED CCA");
		for (Student sl : studentList) {
			
			output += String.format("%-5d %-10s %-10s %-20s %-10s\n", sl.getStudentId(), sl.getStudentName(), sl.getStudentClass(), sl.getClassroomTeacher(), sl.getSelectedCCA());
		
		}

		System.out.println(output);
	}
	
	
	
	//------------------------student 1 (Dilton)--------------------------------
	public static void addStudent() {
		
	}
	
	public static void viewStudent() {
		
	}
	
	public static void deleteStudent() {
		
	}
	//-------------------------end of student 1----------------------------
	//-------------------------student 2 (Lela)-----------------------------------
	public static void addCCADetail() {
		
	}
	
	public static void viewAllCCA() {
		
	}
	
	public static void deleteCCA() {
		
	}
	//-------------------------end of student 2----------------------------
	//-------------------------student 3 (Robert)-----------------------------------
	public static void addCCACategory() {
		
	}
	
	public static void viewAllCCACategory() {
		
	}
	
	public static void deleteAllCCACategory() {
		
	}
	//-------------------------end of student 3----------------------------
	//-------------------------student 4 (Yung Jian)-----------------------------------
	public static void addParentAccount() { //remember to include student account
		
	}
	
	public static void viewRegisteredParents() {
		
	}
	
	public static void deleteParent() {
		
	}
	//-------------------------end of student 4----------------------------
	//-------------------------student 5 (Ze Yu)-----------------------------------
	public static void studentLogin() { // login with student and CCA registration ID
		
	}
	
	public static void addStudentForCCA() {
		
	}
	
	public static void viewStudentsRegisteredForCCA() {
		
	}
	
}
