import java.util.ArrayList;
import java.time.LocalTime;



/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20034695, Jul 25, 2022 11:43:46 PM
 */

/**
 * @author 20034695
 *
 */
public class CCAapp {
	
	public static ArrayList<Student> studentList = new ArrayList<Student>();
	public static ArrayList<teacher> teacherList = new ArrayList<teacher>();
	public static ArrayList<CCA> ccaList = new ArrayList<CCA>();
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}
	
	public static void addingToArrayList() {
		studentList.add(new Student(21000000, "T0123456A", "Mark", "mark@gmail.com", 88888888, "DIT", "W67N", ""));
		studentList.add(new Student(21000001, "T0184637B", "Jack", "jack@gmail.com", 88888887, "DIT", "W67N", ""));
		studentList.add(new Student(21000002, "T0128475C", "Mary", "mary@gmail.com", 88888886, "DIT", "W67N", ""));
		teacherList.add(new teacher(123, "Dilton", "Republ!c01", "dilton@gmail.com", 99999999));
		teacherList.add(new teacher(124, "Yong Jian", "Republ!c01", "yongjian@gmail.com", 99999998));
		teacherList.add(new teacher(125, "Robert", "Republ!c01", "lela@gmail.com", 99999997));
		ccaList.add(new CCA(1, "Badminton", "Able to play badminton and have fun!", "15:00", "Monday", "Sports"));
		ccaList.add(new CCA(2, "Red Cross", "Save people when they are in need!", "16:00", "Friday", "Uniform Groups"));
		ccaList.add(new CCA(3, "Chorale", "Sing on stage!", "16:00", "Monday", "Performing Arts"));
		ccaList.add(new CCA(4, "Basketball", "Play basketball!", "15:00", "Monday", "Sports"));
		ccaList.add(new CCA(5, "Orchestra", "Play your desired instrument", "15:30", "Wednesday", "Performing Arts"));
	}
	
	public static void introduction() {
		Helper.line(80, "=");
		System.out.println("CCA APP");
		Helper.line(80, "=");
	}
	
	public static int role() {
		System.out.println("Please select your role");
		System.out.println("Students Enter 1");
		System.out.println("Teachers Enter 2");
		int roleOption = Helper.readInt("Student (1) or Teacher (2) > ");
		return roleOption;
	}
	
	private static void start() {	
		// TODO Auto-generated method stub
		
		addingToArrayList();
		introduction();
		
		int roleOption = role();
		
		if (roleOption == 1) {
			
			studentMenu();
			int studentOption = -1;
			studentOption = Helper.readInt("Enter an option > ");
			
			while (studentOption != 4) {
				
				if (studentOption == 1) {
					viewAll(ccaList);
				} else if (studentOption == 2) {
					viewByCCACategory(ccaList);
				} else if (studentOption == 3) {
					selectCCA(ccaList, studentList);
				} else if (studentOption == 4) {
					System.out.println("Good bye!");
				} else {
					System.out.println("Please choose a valid input");
				}
				
				studentMenu();
				studentOption = Helper.readInt("Enter an option > ");
			}	
		}
		else if (roleOption == 2) {
			Helper.line(80, "=");
			System.out.println("ENTER ID AND PASSWORD");
			Helper.line(80, "=");
			int teacherId = Helper.readInt("Enter Teacher's ID > ");
			String teacherPassword = Helper.readString("Enter Teacher's Password > ");
			for (int i = 0; i < teacherList.size(); i++) {
				if (teacherId == teacherList.get(i).gettId() || teacherPassword == teacherList.get(i).gettPassword()) {
					int opt2 = 0;
					while (opt2 != 8) {
						teacherMenu();
						opt2 = Helper.readInt("Enter an option > ");
						if (opt2 == 1) {
							viewAll(ccaList);
						} 
						else if (opt2 == 2){
							viewByCCACategory(ccaList);
						}
						else if (opt2 == 3) {
							addCCA(ccaList);
						}
						else if (opt2 == 4) {
							removeCCA(ccaList);
						}
						else if (opt2 == 5) {
							broadCastEmail(ccaList);
						}
						else if (opt2 == 6) {
							broadCastMessage(ccaList);
						}
						else if (opt2 == 7) {
							viewStudent(studentList);
						}
					}
					break;
				}
				else {
					System.out.println("Wrong ID or Password!");
				}
			}
	
			
		}
		
		
		
	}

	private static void teacherMenu() {
		Helper.line(80, "=");
		System.out.println("WELCOME TEACHERS!");
		Helper.line(80, "=");
		System.out.println("1. View All CCA Category");
		System.out.println("2. View CCA by Category");
		System.out.println("3. Add New CCA");
		System.out.println("4. Remove CCA");
		System.out.println("5. broadCastEmail");
		System.out.println("6. broadCastMessage");
		System.out.println("7. View All Students");
		System.out.println("8. Quit");
	}
	private static void studentMenu() {
		Helper.line(80, "=");
		System.out.println("WELCOME STUDENTS!");
		Helper.line(80, "=");
		System.out.println("1. View All CCA");
		System.out.println("2. View CCA by Category");
		System.out.println("3. Select a CCA");
		System.out.println("4. Quit");
	}
	
	private static void viewAll(ArrayList<CCA> ccaList) {
		String output = String.format("%-5s %-10s %-40s %-10s %-15s %-10s\n", "ID", "NAME", "DESCRIPTION", "START TIME", "CCA DAY", "CATEGORY");
		for (int i = 0; i < ccaList.size(); i++) {
			output += String.format("%-5d %-10s %-40s %-10s %-15s %-10s\n", ccaList.get(i).getId(), ccaList.get(i).getCcaNames(),
					ccaList.get(i).getCcaDescription(), ccaList.get(i).getCcaStartTime(), ccaList.get(i).getccaDay(), ccaList.get(i).getCategory());
		}
		System.out.println(output);
	}
	
	private static void viewByCCACategory(ArrayList<CCA> ccaList) {
		String cat = Helper.readString("Enter a category you want to search for > ");
		String output = "";
		output += String.format("%-5s %-10s %-40s %-10s %-15s %-10s\n", "ID", "NAME", "DESCRIPTION", "START TIME", "CCA DAY", "CATEGORY");
		for (int i = 0; i < ccaList.size(); i++) {
			if (cat.equalsIgnoreCase(ccaList.get(i).getCategory())) {
				output += String.format("%-5d %-10s %-40s %-10s %-15s %-10s\n", ccaList.get(i).getId(), ccaList.get(i).getCcaNames(),
							ccaList.get(i).getCcaDescription(), ccaList.get(i).getCcaStartTime(), ccaList.get(i).getccaDay(), ccaList.get(i).getCategory());
			}
		}
		System.out.println(output);
	}
	
	private static void addCCA(ArrayList<CCA> ccaList) {
		int id = Helper.readInt("Enter the id of the CCA > ");
		String name = Helper.readString("Enter the name of the CCA > ");
		String desc = Helper.readString("Enter the description of the CCA > ");
		String time = Helper.readString("Enter the start time of the CCA > ");
		String day = Helper.readString("Enter the day of the CCA > ");
		String cate = Helper.readString("Enter the category of the CCA > ");
		ccaList.add(new CCA(id, name, desc, time, day, cate));
		System.out.println("CCA Added!");
	}
	
	private static void removeCCA(ArrayList<CCA> ccaList) {
		int id = Helper.readInt("Enter the ID of the CCA you want to remove > ");
		for (int i = 0; i < ccaList.size(); i++) {
			if (id == ccaList.get(i).getId()) {
				ccaList.remove(id);
				System.out.println("CCA Removed!");
			}
			else {
				System.out.println("Unable to find the CCA with ID "+ id);
			}
		}
	}
	
	private static void broadCastEmail(ArrayList<CCA> ccaList) {
		System.out.println("Email send to all parents!");
	}
	
	private static void broadCastMessage(ArrayList<CCA> ccaList) {
		System.out.println("Message send to all parents!");
	}
	
	private static void selectCCA(ArrayList<CCA> ccaList, ArrayList<Student> studentList) {
		int studentId = Helper.readInt("Enter your student ID > ");
		
		for (int x = 0; x < studentList.size(); x++) {
			if (studentId == studentList.get(x).getsId()) {
				
				int ccaId = Helper.readInt("Enter the ID of the CCA you wish to select > ");
				
				for (int i = 0; i < ccaList.size(); i++) {
					if (ccaId == ccaList.get(i).getId()) {
						studentList.get(i).setsCCA(ccaList.get(i).getCcaNames());
						//studentList.add(new Student( sId, sIc,sName,sEmail,sContactNumber,moduleSelected,sClass,sCCA));
						System.out.println("CCA Selected!");
					}
				}
			}
		}
	}
	
	private static void viewStudent(ArrayList<Student> studentList) {
		String output = "";
		output += String.format("%-10s %-10s %-15s %-30s %-10s %-10s %-10s %-15s\n", "ID", "IC", "NAME", "EMAIL", "NUMBER", "MODULE", "CLASS", "CCA");
		for (int i = 0; i < studentList.size(); i++) {
			output += String.format("%-10d %-10s %-15s %-30s %-10d %-10s %-10s %-15s\n", studentList.get(i).getsId(), studentList.get(i).getsIc(), studentList.get(i).getsName(),
					studentList.get(i).getsEmail(), studentList.get(i).getsContactNumber(), studentList.get(i).getModuleSelected(), studentList.get(i).getsClass(), studentList.get(i).getsCCA());
		}
		System.out.println(output);
	}
}
