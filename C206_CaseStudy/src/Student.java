

public class Student {
	int studentID;
	String name;
	char grade;
	String classroom;
	String classroomTeacher;
	String selectedCCA;
	String studentPassword;
	int studentRegistrationID;
	int parentID;
	
	public Student(int studentID, String name, char grade, String classroom, String classroomTeacher, String selectedCCA, String studentPassword, int studentRegistrationID, int parentID) {
		this.studentID = studentID;
		this.name = name;
		this.grade = grade;
		this.classroom = classroom;
		this.classroomTeacher = classroomTeacher;
		this.selectedCCA = selectedCCA;
		this.studentPassword = studentPassword;
		this.studentRegistrationID = studentRegistrationID;
		this.parentID = parentID;
	}

	public int getStudentID() {
		return studentID;
	}

	public String getName() {
		return name;
	}

	public char getGrade() {
		return grade;
	}

	public String getClassroom() {
		return classroom;
	}

	public String getClassroomTeacher() {
		return classroomTeacher;
	}

	public String getSelectedCCA() {
		return selectedCCA;
	}
	
	public void setSelectedCCA(String selectedCCA) {
		this.selectedCCA = selectedCCA;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public int getStudentRegistrationID() {
		return studentRegistrationID;
	}

	public int getParentID() {
		return parentID;
	}
}
