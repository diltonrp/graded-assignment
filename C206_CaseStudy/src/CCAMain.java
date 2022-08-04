import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CCAMain {

	//------------------------student 1 (Dilton)--------------------------------
	
	static Connection conn;
	static Statement statement;
	static ResultSet rs;
	
//	public static String nameOfTeacher = "";
	
	private static ArrayList<Student> studentList = new ArrayList<Student>();
	//private static ArrayList<parent> parentList = new ArrayList<parent>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			CCAMain ccaMain = new CCAMain();//on ic ah
			ccaMain.dbConnection();
			
			// initial array loading
			addStudentsToArray();
	
			// start of menu
			System.out.println("Welcome to Woodleys Primary School!");
			System.out.println("Select your CCA according to your preferences. Have fun!");
			Helper.line(80, "=");
			
			roleMenu();
		} catch (Exception e) {
			System.out.println(e);
		}

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
	
	//-------------------------------------Start of menu-----------------------------------------------
	
	private static void roleMenu() {
		System.out.println("I am a...");
		String[] menu = {"Teacher", "CCA Instructor", "Student", "Parent", "I want to quit"};
		int i = 1;
		for (String item : menu) {
			System.out.println(i + ". " + item);
			i++;
		}
		
		int roleSelection = Helper.readInt("Input your selection (1, 2, 3 or 4) > ");
		
		switch (roleSelection) {
		case 1: // teacher
			verifyRole("teacher");
			break;
			
		case 2: // cca instructors
			verifyRole("instructor");
			break;
			
		case 3: // students
			verifyRole("student");
			break;
			
		case 4: // parents
			verifyRole("parent");
			break;
			
		case 5:
			System.out.println("Thank you for using our app");
			System.exit(0);
			break;

		default:
			System.out.println("Invalid input. Please enter a valid number");
			roleMenu();
			break;
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
			System.out.println("Yea it is working");
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
			addStudentForCCA("teacher");
			break;
			
		case 12: // Back to home
			roleMenu();
			break;
			
		default:
			roleMenu();
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
		String[] menu = {"View all CCAs", "View all CCA catgories", "Login", "Add myself for CCA", "Back to home"};
		int i = 1;
		String sql;
		
		for (String item : menu) {
			System.out.println(i + ". " + item);
			i++;
		}
		
		int studentSelection = Helper.readInt("Please select your option in numbers > ");
		
		switch (studentSelection) {
		case 1: // View CCA Details
			viewAllCCA();
			break;
			
		case 2: // View All CCA Categories
			viewAllCCACategory();
			break;
			
		case 3: // Login
			studentLogin();
			break;
			
		case 4: // Add CCA for myself
			addStudentForCCA("student");
			break;
			
		case 5: // Back to home
			roleMenu();
			break;
			
		default:
			break;
		}
	}
	
	private static void parentMenu() {
		String[] menu = {"View all CCAs", "View all CCA categories", "Sign Up", "Login", "Add my child for CCA", "Back to home"};
		int i = 1;
		String sql;
		
		for (String item : menu) {
			System.out.println(i + ". " + item);
			i++;
		}
		
		int parentSelection = Helper.readInt("Please select your option in numbers > ");
		
		switch (parentSelection) {
		case 1: // View all CCAs
			viewAllCCA();
			break;
			
		case 2: // View all CCA categories
			viewAllCCACategory();
			break;
			
		case 3: // Parent sign up
			addParentAccount();
			break;
			
		case 4: // Parent login
			parentLogin();
			
		case 5: // Add my child for CCA
			addStudentForCCA("parent");
			break;
			
		case 6: // Back to home
			roleMenu();
			break;
			
		default:
			break;
		}
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
							incorrectChoice = Helper.readInt("Either your ID or password is incorrect.\nWould you like to try again (1) or go back to main menu (2)? > ");
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
//		try {
//			
//			String sql = "SELECT studentId, name, class, classroomTeacher, selectedCCA FROM student_list ORDER BY class ASC";
//			rs = statement.executeQuery(sql);
//			
//			while (rs.next()) {
//				int studentId = rs.getInt("studentId");
//				String studentName = rs.getString("name");
//				String studentClass = rs.getString("class");
//				String classroomTeacher= rs.getString("classroomTeacher");
//				String selectedCCA = rs.getString("selectedCCA");
//				
//				studentList.add(new Student(studentId, studentName, studentClass, classroomTeacher, selectedCCA));
//			}
//			
//			
//			
//		} catch (SQLException se) {
//			se.printStackTrace();
//		}
	
	}
	
	private static void viewStudents(int teacherChoice) {
		
		String output = String.format("%-5s %-10s %-10s %-20s %-10s\n", "ID", "NAME", "CLASS", "CLASSROOM TEACHER", "SELECTED CCA");
		for (Student sl : studentList) {
			
			output += String.format("%-5d %-10s %-10s %-20s %-10s\n", sl.getStudentId(), sl.getStudentName(), sl.getStudentClass(), sl.getClassroomTeacher(), sl.getSelectedCCA());
		
		}

		System.out.println(output);
	}
	
	
	

	public static void addStudent() {
		
		int studentId = 0;
		//while (!String.valueOf(studentId).matches("[0-9]+") && !(studentId > 0)) {
			studentId = Helper.readInt("Enter your student ID > ");
			if (studentId == 3) {
				roleMenu();
			}
		//}
		
		/*
		try {
			
			String sql = "INSERT INTO student_list (studentId, name, grade, class, classroomTeacher, selectedCCA, studentPassword, studentRegistration, parentId) VALUES ";
			rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				System.out.println(rs.getString("name"));
				
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		*/
	}
	
	public static void viewAllStudents() {
		String sql = "SELECT * FROM student_list";
		try {
			rs = statement.executeQuery(sql);
			String output = String.format("%-5s %-10s %-10s %-10s %-20s %-15s %-20s %-5s\n", "ID", "NAME", "GRADE", "CLASS", "CLASSROOM TEACHER", "SELECTED CCA", "REGISTRATION ID", "PARENT ID");
			
			while (rs.next()) {
				int id = rs.getInt("studentId");
				String name = rs.getString("name");
				String grade = rs.getString("grade");
				String classroom = rs.getString("class");
				String classroomTeacher = rs.getString("classroomTeacher");
				String selectedCCA = rs.getString("selectedCCA");
				int registrationID = rs.getInt("studentRegistrationId");
				int parentID = rs.getInt("parentId");
				
				output += String.format("%-5d %-10s %-10s %-10s %-20s %-15s %-20s %-5d\n", id, name, grade, classroom, classroomTeacher, selectedCCA, registrationID, parentID);
			}
			System.out.println(output);
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public static void deleteStudent() {
		int deleteID = Helper.readInt("Enter the student ID to delete");
		String sql = "DELETE FROM student_list WHERE studentId='" + deleteID + "'";
		
		try {
			rs = statement.executeQuery(sql);
			
			System.out.println("Removed Student with student ID " + deleteID);
		} catch (SQLException se) {
			se.printStackTrace();
		}
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

		String jdbcURL = "jdbc:mysql://localhost:3306/c206";
		String dbUsername = "root";
		String dbPassword = "";

		DBUtil.init(jdbcURL, dbUsername, dbPassword);

		System.out.println("ADDING PARENT ACCOUNT");
		Helper.line(40, "-");
		int parentId = Helper.readInt("Enter parent id > ");
		String name = Helper.readString("Enter name > ");
		String email = Helper.readString("Enter parent email > ");
		double contactNumber = Helper.readDouble("Enter contactNumber > ");
		String parentPassword = Helper.readString("Enter parent password > ");
		int childStudentId = Helper.readInt("Enter your children student id > ");
		int studentRegistrationId = Helper.readInt("Enter student registration id > ");
		
		String sql = "INSERT INTO parent_list(parentId, name, email, contact, parentPassword,"
				+ " childStudentId, studentRegistrationId) " 
					+ "VALUES ('" +parentId + "', '" +name + "', '" + email + "', '" + 
				contactNumber + "', '" + parentPassword + "', '" + childStudentId + "', '" + studentRegistrationId + ")";
		int rowsAffected = DBUtil.execSQL(sql);
		
		if (rowsAffected == 1) {
			System.out.println("Parent added!");
		} else {
			System.out.println("Insert failed!");
		}

		DBUtil.close();
	}
		
		
	
	
	public static void viewRegisteredParents() {
		try {
			
			String jdbcURL = "jdbc:mysql://localhost:3306/c206";
			String dbUsername = "root";
			String dbPassword = "";

			DBUtil.init(jdbcURL, dbUsername, dbPassword);

			String output = String.format("%-5s %-20s %-10s %-10s %-10s %-10s %-10s \n", "PARENT ID", "NAME", "EMAIL", "CONTACT NUMBER", "PATENT PASSWORD" , "CHILD STUDENT ID", "STUDENT REGISTRATION ID");

			String sql = "SELECT *FROM parent_list";
			ResultSet rs = DBUtil.getTable(sql);

			while (rs.next()) {
				
				int newParentId = rs.getInt("parentId");
				String newName = rs.getString("name");
				String newEmail = rs.getString("email");
				String newContact = rs.getString("contact");
				String newParentPassword = rs.getString("parentPassword");
				int newChildStudentId = rs.getInt("childStudentId");
				int newStudentRegistrationId = rs.getInt("studentRegistrationId");
				
				output = String.format("%-5d %-20s %-10s %-10d %-10s %-10d %-10d \n", newParentId, newName, newEmail, newContact, newParentPassword , newChildStudentId, newStudentRegistrationId);
				
			}
			System.out.println(output);

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public static void deleteParent() {
		String jdbcURL = "jdbc:mysql://localhost/c206";
		String dbUsername = "root";
		String dbPassword = "";

		DBUtil.init(jdbcURL, dbUsername, dbPassword);

		System.out.println("DELETING PARENT");
		Helper.line(40, "-");

		int parentId = Helper.readInt("Enter parent id > ");

		String deleteSQL = "DELETE FROM student WHERE parentId='" + parentId + "'";
		int rowsAffected = DBUtil.execSQL(deleteSQL);

		if (rowsAffected == 1) {
			System.out.println("Parent deleted!");
		} else {
			System.out.println("Delete failed!");
		}

		DBUtil.close();
	}
	//-------------------------end of student 4----------------------------
	//-------------------------student 5 (Ze Yu)-----------------------------------
	public static void studentLogin() { // login with student and CCA registration ID OK try again
		int idInput = Helper.readInt("Enter your Student ID");
		String passwordInput = Helper.readString("Enter your student Password");
		String sql = "SELECT studentPassword, studentId FROM student_list";
		
		try {
			rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				if (rs.getInt("studentId") == idInput && rs.getString("studentPassword").equals(passwordInput)) {
					studentMenu();
				}
				else {
					System.out.println("Wrong Student ID or Password!");//It says unable to find or execute CCAMain
				}
			}
		} catch (SQLException se){
			se.printStackTrace();
		}
 		
	}
	
	public static void parentLogin() {
		int idInput = Helper.readInt("Enter your Parent ID");
		String passwordInput = Helper.readString("Enter your student Password");
		String sql = "SELECT parentId, parentPassword FROM parent_list";
		
		try {
			rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				if (rs.getInt("parentId") == idInput && rs.getString("parentPassword").equals(passwordInput)) {
					parentMenu();
				}
				else {
					System.out.println("Wrong Parent ID or Password!");
				}
			}
		} catch (SQLException se){
			se.printStackTrace();
		}
	}
	
	public static void addStudentForCCA(String studentOrParent) {
		int studentId = 0;
		String joinCCA = Helper.readString("Enter the CCA you would like to join");
		String sql = "UPDATE student_list SET selectedCCA='" + joinCCA + "' WHERE studentId='" + studentId + "'";
		try {
			rs = statement.executeQuery(sql);
			
			System.out.println("CCA Selected Successful!");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public static void viewStudentsRegisteredForCCA() {
		String sql = "SELECT * FROM student_list WHERE selectedCCA IS NOT NULL";
		try {
			rs = statement.executeQuery(sql);
		
			String output = String.format("%-5s %-10s %-10s %-20s %-10s\n", 
					"ID", "NAME", "CLASS", "CLASSROOM TEACHER", "SELECTED CCA");
			while (rs.next()) {
				int id = rs.getInt("studentId");
				String name = rs.getString("name");
				String grade = rs.getString("grade");
				String classroom = rs.getString("class");
				String classroomTeacher = rs.getString("classroomTeacher");
				String selectedCCA = rs.getString("selectedCCA");
				String studentPassword = rs.getString("studentPassword");
				int registrationID = rs.getInt("studentRegistrationId");
				int parentID = rs.getInt("parentId");
				
				output += String.format("%-5d %-10s %-10s %-20s %-10s %-10s %-10s %-5d %-5d\n", 
						id, name, grade, classroom, classroomTeacher, selectedCCA, studentPassword, registrationID, parentID);
			}
			System.out.println(output);
		} catch (SQLException se) {s
			se.printStackTrace();
		}
	}
	//test zeyu
}