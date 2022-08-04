

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CCAMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addToArray();
		roleMenu();
	}
	
	private static void addToArray() {
		globalVariables.teacherList.add(new Teacher(1, "Jeremy", "Hello"));
		globalVariables.teacherList.add(new Teacher(2, "Julian", "Bye bye"));
		globalVariables.teacherList.add(new Teacher(3, "Aidil", "Ummm"));
		
		globalVariables.instructorList.add(new Instructor(1, "Robert", 8111222, "robert@gmail.com", "Bless you", "Badminton"));
		globalVariables.instructorList.add(new Instructor(2, "Lela", 81112223, "lela@gmail.com", "My Mac Is My Baby", "Girl Guides"));
		
		globalVariables.studentList.add(new Student(1, "Timus", 'A', "1A", "Jeremy", "Badminton", "I am scared", 0, 1));
		globalVariables.studentList.add(new Student(2, "Coby", 'B', "4B", "Aidil", "Badminton", "Oh no", 2, 0));
		
		globalVariables.parentList.add(new Parent(1, "Amran", "handsome@gmail.com", 91112222, "I am handsome", 1, 1));
		
		globalVariables.ccaList.add(new ccaCategory("Sports", 1));
		globalVariables.ccaList.add(new ccaCategory("Club", 2));
		globalVariables.ccaList.add(new ccaCategory("Uniformed Group", 3));
		
		globalVariables.ccaList.add(new ccaIndividual("Badminton", 1, "Sports", "Hit the shuttle cock here and there", 100, "Monday", "1600", "Badminton Court", "Robert"));
		globalVariables.ccaList.add(new ccaIndividual("Soccer", 2, "Sports", "Kick the ball here and there", 50, "Wednesday", "1700", "Field", "Jeremy"));
		globalVariables.ccaList.add(new ccaIndividual("Floorball", 3, "Sports", "Use stick and hit the ball", 35, "Thursday", "1400", "Hall", "Jeremy"));
		
	}
	
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
			globalVariables.output = String.format("%-10s %-10s %-10s %-15s %-20s %-20s %-25s %-10s\n", "STUDENT ID", "NAME", "GRADE", "CLASSROOM", "CLASSROOM TEACHER", "SELECTED CCA", "STUDENT REGISTRATION ID", "PARENT ID");
			
			for (Student student : globalVariables.studentList) {
				if (student.getSelectedCCA().equalsIgnoreCase(globalVariables.instructorCCA)) {
					globalVariables.output += String.format("%-10s %-10s %-10s %-15s %-20s %-20s %-25s %-10s\n", student.getStudentID(), student.getName(), student.getGrade(), student.getClassroom(), student.getClassroomTeacher(), student.getSelectedCCA(), student.getStudentRegistrationID(), student.getParentID());
				}
			}
			
			System.out.println(globalVariables.output);
			
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
			verifyRole("parent");
			
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
			
			if (role == "teacher") {
				for (Teacher teacher : globalVariables.teacherList) {
					while (incorrectChoice != 2) {
						if (teacher.getTeacherID() == idInput && teacher.getTeacherPassword().equals(passwordInput)) {
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
			}
		}
		
		//-------------------------------Adding to array lists--------------------------------------------
		
		
		public static void addStudent() {
			
			int studentId = 0;
			//while (!String.valueOf(studentId).matches("[0-9]+") && !(studentId > 0)) {
				studentId = Helper.readInt("Enter your student ID > ");
				if (studentId == 3) {
					roleMenu();
				}
			//}
		}
		
		public static void viewAllStudents() {
			globalVariables.output = String.format("%-10s %-10s %-10s %-15s %-20s %-20s %-25s %-10s\n", "STUDENT ID", "NAME", "GRADE", "CLASSROOM", "CLASSROOM TEACHER", "SELECTED CCA", "STUDENT REGISTRATION ID", "PARENT ID");
			
			for (Student student : globalVariables.studentList) {
				globalVariables.output += String.format("%-10d %-10s %-10s %-15s %-20s %-20s %-25d %-10d\n", student.getStudentID(), student.getName(), student.getGrade(), student.getClassroom(), student.getClassroomTeacher(), student.getSelectedCCA(), student.getStudentRegistrationID(), student.getParentID());
			}
			
			System.out.println(globalVariables.output);
		}
		
		public static void deleteStudent() {
			
			int studentToDelete = Helper.readInt("Enter the ID of the student you would like to delete > ");
			
			for (int i = 0; i < globalVariables.studentList.size(); i++) {
				Student student = globalVariables.studentList.get(i);
				if (student.getStudentID() == studentToDelete) {
					globalVariables.studentList.remove(i);
					
					globalVariables.friendlyFeedback = String.valueOf(studentToDelete) + " has been removed.";
				}
			}
			
			System.out.println(globalVariables.friendlyFeedback);
			
			
		}
		//-------------------------end of student 1----------------------------
		//-------------------------student 2 (Lela)-----------------------------------
		public static void addCCADetail() {
			String title = Helper.readString("Enter the name of the new CCA > ");
			int i = 1;
			
			for (cca cca : globalVariables.ccaList) {
				if (cca instanceof ccaCategory) {
					ccaCategory ccaCat = (ccaCategory)cca;
					globalVariables.output += "\n" + i + ". " + ccaCat.getCcaCategory();
				}
			}
			
			String category = Helper.readString("Enter the category in name > ");
			
			String description = Helper.readString("Enter the description of the CCA > ");
			int classSize = Helper.readInt("Enter class size > ");
			String dayOfWeek = Helper.readString("Enter day of week > ");
			String time = Helper.readString("Enter time > ");
			String venue = Helper.readString("Enter venue > ");
			String nameOfInstructor = Helper.readString("Enter name of instructor > ");
			
			int highestID = 0;
			
			for (cca cca : globalVariables.ccaList) {
				if (cca instanceof ccaIndividual) {
					ccaIndividual ccaName = (ccaIndividual)cca;
					if (ccaName.getCcaID() > highestID) {
						highestID = ccaName.getCcaID();
					}
				}
			}
			
			globalVariables.ccaList.add(new ccaIndividual(title, highestID, category, description, classSize, dayOfWeek, time, venue, nameOfInstructor));
		}
		
		public static void viewAllCCA() {
			
			globalVariables.output = String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "CCA ID", "CCA TITLE", "CCA CATEGORY", "CLASS SIZE", "DAY OF WEEK", "TIME", "VENUE", "NAME OF INSTRUCTOR");
			
			for (cca cca : globalVariables.ccaList) {
				if (cca instanceof ccaIndividual) {
					ccaIndividual ccaName = (ccaIndividual)cca;
					globalVariables.output += String.format("%-10d %-10s %-10s %-10d %-10s %-10s %-10s %-10s %-10s\n",ccaName.getCcaID(), ccaName.getCcaTitle(), ccaName.getCcaCat(), ccaName.getClassSize(), ccaName.getDayOfWeek(), ccaName.getTime(), ccaName.getVenue(), ccaName.getNameOfInstructor());
				}
			}
			
			System.out.println(globalVariables.output);
			
		}
		
		public static void deleteCCA() {
			int ccaToDelete = Helper.readInt("Enter the ID of the CCA you wish to remove > ");

			for (int i = 0; i < globalVariables.ccaList.size(); i++) {
				cca cca = globalVariables.ccaList.get(i);
				if (cca instanceof ccaIndividual) {
					ccaIndividual ccaName = (ccaIndividual)cca;
					
					if (ccaName.getCcaID() == ccaToDelete) {
						globalVariables.ccaList.remove(i);
					}
				}
			}
		}
		//-------------------------end of student 2----------------------------
		//-------------------------student 3 (Robert)-----------------------------------
		public static void addCCACategory() {
			String nameOfNewCategory = Helper.readString("Enter the name of the category that you would like to add > ");
			int highestId = 0;
			for (cca cca : globalVariables.ccaList) {
				if (cca instanceof ccaCategory) {
					ccaCategory ccaCat = (ccaCategory)cca;
					if (ccaCat.getId() > highestId) {
						highestId = ccaCat.getId();
					}
					globalVariables.ccaList.add(new ccaCategory(nameOfNewCategory, highestId));
				}
			}
		}
		
		public static void viewAllCCACategory() {
			globalVariables.output += String.format("%-5s %-10s\n", "ID", "CATEGORY");
					
			for (cca cca : globalVariables.ccaList) {
				if (cca instanceof ccaCategory) {
					ccaCategory ccaCat = (ccaCategory)cca;
					globalVariables.output += String.format("%-5d %-10s\n", ccaCat.getId(), ccaCat.getCcaCategory());
				}
			}
			
			System.out.println(globalVariables.output);
		}
		
		public static void deleteCCACategory() {
			int catToDelete = Helper.readInt("Enter the ID of the category you wish to remove > ");

			for (int i = 0; i < globalVariables.ccaList.size(); i++) {
				cca cca = globalVariables.ccaList.get(i);
				if (cca instanceof ccaCategory) {
					ccaCategory ccaCat = (ccaCategory)cca;
					
					if (ccaCat.getId() == catToDelete) {
						globalVariables.ccaList.remove(i);
					}
				}
			}
		}
		//-------------------------end of student 3----------------------------
		//-------------------------student 4 (Yung Jian)-----------------------------------
		public static void addParentAccount() { //remember to include student account
			
			System.out.println("ADDING PARENT ACCOUNT");
			Helper.line(40, "-");
			int parentId = Helper.readInt("Enter parent id > ");
			String parentName = Helper.readString("Enter name > ");
			String parentEmail = Helper.readString("Enter parent email > ");
			int parentContact = Helper.readInt("Enter contactNumber > ");
			String parentPassword = Helper.readString("Enter parent password > ");
			int childStudentId = Helper.readInt("Enter your children student id > ");
			int studentRegistrationId = Helper.readInt("Enter student registration id > ");
			
			globalVariables.parentList.add(new Parent(parentId, parentName, parentEmail, parentContact, parentPassword, childStudentId, studentRegistrationId));
		}
			
			
		
		
		public static void viewRegisteredParents() {
			
			globalVariables.output = String.format("%-5s %-10s %-15s %-15s %-10s %-15s\n", "PARENT ID", "PARENT NAME", "PARENT CONTACT", "CHILD STUDENT ID", "STUDENT REGISTRATION ID");
			
			for (Parent parent : globalVariables.parentList) {
				globalVariables.output += String.format("%-5d %-10s %-15s %-15d %-10d %-15d\n", parent.getParentID(), parent.getParentName(), parent.getParentEmail(), parent.getChildStudentID(), parent.getStudentRegistrationID());
				
			}
		}
		
		public static void deleteParent() {
			int parentToDelete = Helper.readInt("Enter the ID of the parent you would like to delete > ");
			
			for (int i = 0; i < globalVariables.parentList.size(); i++) {
				Parent parent = globalVariables.parentList.get(i);
				if (parent.getParentID() == parentToDelete) {
					globalVariables.studentList.remove(i);
					
					globalVariables.friendlyFeedback = String.valueOf(parentToDelete) + " has been removed.";
				}
			}
			
			System.out.println(globalVariables.friendlyFeedback);
		}
		//-------------------------end of student 4----------------------------
		//-------------------------student 5 (Ze Yu)-----------------------------------
		public static void studentLogin() { // login with student and CCA registration ID OK try again
			int idInput = Helper.readInt("\nEnter your id > ");
			int registrationIDInput = Helper.readInt("Enter your password > ");
			int incorrectChoice = -1;
			
			for (Student student : globalVariables.studentList) {
				while (incorrectChoice != 2) {
					if (student.getStudentID() == idInput && student.getStudentRegistrationID() == registrationIDInput) {
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
	 		
		}
		
		public static void addStudentForCCA(String studentOrParent) {
			
			int studentToAdd = Helper.readInt("Enter the ID of the student you would like to add CCA to > ");
			
			int i = 1;
			
			for (cca cca : globalVariables.ccaList) {
				System.out.println(i + ". " + cca);
			}
			
			int choiceOfCCA = Helper.readInt("Enter the choice of your CCA in number > ");
			int choiceToChange = -1;
			String nameOfCCA = "";
			
			for (cca cca : globalVariables.ccaList) {
				if (cca instanceof ccaIndividual) {
					ccaIndividual ccaName = (ccaIndividual)cca;
					nameOfCCA = ccaName.getCcaTitle();
				}
			}
			for (Student student : globalVariables.studentList) {
				while (choiceToChange != 2) {
					if (student.getStudentID() == studentToAdd) {
						if (student.getSelectedCCA().equals("")) {
							student.setSelectedCCA(nameOfCCA);
						} else {
							choiceToChange = Helper.readInt("You have already chosen your CCA. Would you like to change? Yes (1) or No (2) > ");
							
							if (choiceToChange == 1) {
								student.setSelectedCCA(nameOfCCA);
							} else {
								System.out.println("Thank you! We will bring you back to the previous page.");
								studentMenu();
							}
						}
					}
				}
			}
			
			
		}
		
		public static void viewStudentsRegisteredForCCA() {
			
			globalVariables.output = String.format("%-10s %-10s %-10s %-15s %-20s %-20s %-25s %-10s\n", "STUDENT ID", "NAME", "GRADE", "CLASSROOM", "CLASSROOM TEACHER", "SELECTED CCA", "STUDENT REGISTRATION ID", "PARENT ID");
			
			for (Student student : globalVariables.studentList) {
				if (student.getSelectedCCA() != "") {
					globalVariables.output += String.format("%-10s %-10s %-10s %-15s %-20s %-20s %-25s %-10s\n", student.getStudentID(), student.getName(), student.getGrade(), student.getClassroom(), student.getClassroomTeacher(), student.getSelectedCCA(), student.getStudentRegistrationID(), student.getParentID());
				}
			}
		}
	}
