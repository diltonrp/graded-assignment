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
		
		int inputTeacherId = Helper.readInt("\nEnter your ID > ");
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
		System.out.println("\nI am a...");
		System.out.println("1. Teacher");
		System.out.println("2. CCA Instructor");
		System.out.println("3. Student");
		System.out.println("4. Parent");
		System.out.println("5. I want to quit");
		int roleSelection = Helper.readInt("Input your selection (1, 2, 3 or 4) > ");
		
		while (roleSelection != 4) {
			if (roleSelection == 1) { // teacher
				verifyRole("teacher");
			} else if (roleSelection == 2) { // cca instructor
				verifyRole("instructor");
			} else if (roleSelection == 3) { // student
				verifyRole("student");
			} else if (roleSelection == 4) { // parent
				verifyRole("parent");
			} else if (roleSelection == 5) { // quit
				System.out.println("Thank you for using our app!");
				roleSelection = Helper.readInt("");
			} else { // friendly error message
				System.out.println("Please enter a valid input");
				System.out.println("I am a...");
				System.out.println("1. Teacher");
				System.out.println("2. CCA Instructor");
				System.out.println("3. Student");
				System.out.println("4. Parent");
				System.out.println("5. I want to quit");
				roleSelection = Helper.readInt("Input your selection (1, 2, 3 or 4) > ");
			}
		}
		
	}
	
	private static void teacherMenu() {
		
		String[] menuItems = {"View all students", "View all students with CCA", "Add student", "Delete student", "View all CCA categories", "Add CCA category", "Delete CCA category", "View registered parents", "Add parent", "Delete parent", "Add student for CCA", "Back to home"};

		int i = 1;
		for (String item : menuItems) {
			System.out.println(i + ". " + item);
			i++;
		}
		
		int teacherSelection = Helper.readInt("Please select your option > ");
		
		switch (teacherSelection) {
		case 1: // View all students
			viewAllStudents();
			break;
		
		case 2: // View all students with CCA
			viewStudentsRegisteredForCCA();
			break;
			
		case 3: // Add student
			addStudent();
			break;
			
		case 4: // Delete student 
			deleteStudent();
			break;
			
		case 5: // View all CCA categories
			viewAllCCACategory();
			break;
			
		case 6: // Add CCA category
			addCCACategory();
			break;
			
		case 7: // Delete CCA category
			deleteCCACategory();
			break;
			
		case 8: // View registered parents
			viewRegisteredParents();
			break;
			
		case 9: // Add parents
			addParentAccount();
			break;
			
		case 10: // Delete parents
			deleteParent();
			break;
			
		case 11: // Add students for CCA
			addStudentForCCA();
			break;
			
		case 12: // Back to home
			roleMenu();
			break;
			
		default:
			break;
		}
	}
	
	private static void instructorMenu() {
		String[] menu = {"View students for your CCA", "Delete students", "View registered parents for your CCA", "Back to home"};
		int i = 1;
		String sql;
		
		for (String item : menu) {
			System.out.println(i + ". " + item);
			i++;
		}
		
		int instructorSelection = Helper.readInt("Please select your option > ");
		
		
		switch (instructorSelection) {
		case 1: // View students for their CCA
			
			try {
				//sql = "SELECT sl.name FROM student_list sl INNER JOIN instructor_list il ON il.CCA = sl.selectedCCA";
				sql = "SELECT name FROM student_list";
				rs = statement.executeQuery(sql);
				
				while (rs.next()) {
					System.out.println(rs.getString("name"));
					
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			break;
			
		case 2: // Delete students
			deleteStudent();
			break;
				
		case 3: // View registered parents for your CCA
			viewRegisteredParents();
			break;
			
		case 4: // Back to home
			roleMenu();
			break;

		default:
			break;
		}
	}
	
	private static void studentMenu() {
		
	}
	
	private static void parentMenu() {
		
	}
	
	//-------------------------------------------Verification-------------------------------------
	private static void verifyRole(String role) {
		int idInput = Helper.readInt("\nEnter your id > ");
		String passwordInput = Helper.readString("Enter your password > ");
		int incorrectChoice = -1;
		
		
		try {
			
			String sql;
			
			if (role == "teacher") {
				sql = "SELECT id, password FROM teacher_list";
				rs = statement.executeQuery(sql);
				
				while (rs.next()) {
					while (incorrectChoice != 2) {
						if (rs.getInt("id") == idInput && rs.getString("password").equals(passwordInput)) {
							teacherMenu();
						} else {
							incorrectChoice = Helper.readInt("Either your ID or password is incorrect.\nWould you like to try again (1) or go back to main menu (2)?");
							if (incorrectChoice == 1) {
								verifyRole("teacher");
							} else if (incorrectChoice == 2) {
								roleMenu();
							}
						}
					}
				}
				
			} else if (role == "instructor") {
				sql = "SELECT instructorId, instructorPassword FROM instructor_list";
				rs = statement.executeQuery(sql);
				
				while (rs.next()) {
					while (incorrectChoice != 2) {
						if (rs.getInt("instructorId") == idInput && rs.getString("instructorPassword").equals(passwordInput)) {
							instructorMenu();
						} else {
							incorrectChoice = Helper.readInt("Either your ID or password is incorrect.\nWould you like to try again (1) or go back to main menu (2)? > ");
							if (incorrectChoice == 1) {
								verifyRole("instructor");
							} else if (incorrectChoice == 2) {
								roleMenu();
							}
						}
					}
				}
				
			} else if (role == "student") {
				sql = "SELECT studentId, studentPassword FROM student_list";
				rs = statement.executeQuery(sql);
				
				while (rs.next()) {
					while (incorrectChoice != 2) {
						if (rs.getInt("studentId") == idInput && rs.getString("studentPassword").equals(passwordInput)){
							studentMenu();
						} else {
							incorrectChoice = Helper.readInt("Either your ID or password is incorrect.\nWould you like to try again (1) or go back to main menu (2)? > ");
							if (incorrectChoice == 1) {
								verifyRole("student");
							} else if (incorrectChoice == 2) {
								roleMenu();
							}
						}
					}
				}
				
			} else if (role == "parent") {
				sql = "SELECT parentId, parentPassword FROM parent_list";
				rs = statement.executeQuery(sql);
				
				while (rs.next()) {
					while (incorrectChoice != 2) {
						if (rs.getInt("parentId") == idInput && rs.getString("parentPassword").equals(passwordInput)){
							parentMenu();
						} else {
							incorrectChoice = Helper.readInt("Either your ID or password is incorrect.\nWould you like to try again (1) or go back to main menu (2)? > ");
							if (incorrectChoice == 1) {
								verifyRole("parent");
							} else if (incorrectChoice == 2) {
								roleMenu();
							}
						}
					}
				}
			}
			
			
			
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
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
	
	public static void viewAllStudents() {
		
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
	
	public static void deleteCCACategory() {
		
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