

public class Instructor {
	int instructorID;
	String instructorName;
	int instructorContact;
	String instructorEmail;
	String instructorPassword;
	String cca;
	
	public Instructor(int instructorID, String instructorName, int instructorContact, String instructorEmail, String instructorPassword, String cca) {
		this.instructorID = instructorID;
		this.instructorName = instructorName;
		this.instructorContact = instructorContact;
		this.instructorEmail = instructorEmail;
		this.instructorPassword = instructorPassword;
		this.cca = cca;
	}

	public int getInstructorID() {
		return instructorID;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public int getInstructorContact() {
		return instructorContact;
	}

	public String getInstructorEmail() {
		return instructorEmail;
	}

	public String getInstructorPassword() {
		return instructorPassword;
	}

	public String getCca() {
		return cca;
	}
}
