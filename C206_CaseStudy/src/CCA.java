

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20034695, Jul 25, 2022 4:56:40 PM
 */

/**
 * @author 20034695
 *
 */
public class CCA {
	private int id;
	private String ccaNames;
	private String ccaDescription;
	private String ccaStartTime;
	private String ccaDay;
	private String category;
	
	public CCA(int id, String ccaNames, String ccaDescription, String ccaStartTime, String ccaDay, String category) {
		super();
		this.id = id;
		this.ccaNames = ccaNames;
		this.ccaDescription = ccaDescription;
		this.ccaStartTime = ccaStartTime;
		this.ccaDay = ccaDay;
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCcaNames() {
		return ccaNames;
	}
	public void setCcaNames(String ccaNames) {
		this.ccaNames = ccaNames;
	}
	public String getCcaDescription() {
		return ccaDescription;
	}
	public void setCcaDescription(String ccaDescription) {
		this.ccaDescription = ccaDescription;
	}
	public String getCcaStartTime() {
		return ccaStartTime;
	}
	public void setCcaStartTime(String ccaStartTime) {
		this.ccaStartTime = ccaStartTime;
	}
	public String getccaDay() {
		return ccaDay;
	}
	public void setccaDay(String ccaDay) {
		this.ccaDay = ccaDay;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
