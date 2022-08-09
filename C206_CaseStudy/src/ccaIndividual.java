
public class ccaIndividual extends cca {
	
	int ccaID;
	String ccaTitle;
	String ccaCat;
	String ccaDescription;
	int classSize;
	String dayOfWeek;
	String time;
	String venue;
	String nameOfInstructor;

	public ccaIndividual(String ccaCategory, int ccaID, String ccaTitle, String ccaDescription, int classSize, String dayOfWeek, String time, String venue, String nameOfInstructor) {
		super(ccaCategory);
		this.ccaID = ccaID;
		this.ccaTitle = ccaTitle;
		this.ccaDescription = ccaDescription;
		this.classSize = classSize;
		this.dayOfWeek = dayOfWeek;
		this.time = time;
		this.venue = venue;
		this.nameOfInstructor = nameOfInstructor;
	}

	public int getCcaID() {
		return ccaID;
	}

	public String getCcaTitle() {
		return ccaTitle;
	}

	public String getCcaCat() {
		return ccaCat;
	}

	public String getCcaDescription() {
		return ccaDescription;
	}

	public int getClassSize() {
		return classSize;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public String getTime() {
		return time;
	}

	public String getVenue() {
		return venue;
	}

	public String getNameOfInstructor() {
		return nameOfInstructor;
	}

}
