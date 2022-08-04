

public class Teacher {
	private int teacherID;
	private String teacherName;
	private String teacherPassword;
	
	public Teacher(int teacherID, String teacherName, String teacherPassword) {
		this.teacherID = teacherID;
		this.teacherName = teacherName;
		this.teacherPassword = teacherPassword;
	}

	public int getTeacherID() {
		return teacherID;
	}
	
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public String getTeacherName() {
		return teacherName;
	}
	
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherPassword() {
		return teacherPassword;
	}
	
	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}
	
	
}

