

public class Parent {
	int parentID;
	String parentName;
	String parentEmail;
	int parentContact;
	String parentPassword;
	int childStudentID;
	int studentRegistrationID;
	
	public Parent(int parentID, String parentName, String parentEmail, int parentContact, String parentPassword, int childStudentID, int studentRegistrationID) {
		this.parentID = parentID;
		this.parentName = parentName;
		this.parentContact = parentContact;
		this.parentPassword = parentPassword;
		this.childStudentID = childStudentID;
		this.studentRegistrationID = studentRegistrationID;
	}

	public int getParentID() {
		return parentID;
	}

	public String getParentName() {
		return parentName;
	}

	public String getParentEmail() {
		return parentEmail;
	}

	public int getParentContact() {
		return parentContact;
	}

	public String getParentPassword() {
		return parentPassword;
	}

	public int getChildStudentID() {
		return childStudentID;
	}

	public int getStudentRegistrationID() {
		return studentRegistrationID;
	}
}
