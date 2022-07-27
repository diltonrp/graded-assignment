/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20034695, Jul 25, 2022 4:56:31 PM
 */

/**
 * @author 20034695
 *
 */
public class Student {
	public int sId;
	public String sIc;
	public String sName;
	public String sEmail;
	public int sContactNumber;
	public String moduleSelected;
	public String sClass;
	public String sCCA;
	
	public Student(int sId, String sIc, String sName, String sEmail, int sContactNumber, String moduleSelected,
			String sClass, String sCCA) {
		super();
		this.sId = sId;
		this.sIc = sIc;
		this.sName = sName;
		this.sEmail = sEmail;
		this.sContactNumber = sContactNumber;
		this.moduleSelected = moduleSelected;
		this.sClass = sClass;
		this.sCCA = sCCA;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsIc() {
		return sIc;
	}

	public void setsIc(String sIc) {
		this.sIc = sIc;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public int getsContactNumber() {
		return sContactNumber;
	}

	public void setsContactNumber(int sContactNumber) {
		this.sContactNumber = sContactNumber;
	}

	public String getModuleSelected() {
		return moduleSelected;
	}

	public void setModuleSelected(String moduleSelected) {
		this.moduleSelected = moduleSelected;
	}

	public String getsClass() {
		return sClass;
	}

	public void setsClass(String sClass) {
		this.sClass = sClass;
	}
	
	public String getsCCA() {
		return sCCA;
	}
	
	public void setsCCA(String sCCA) {
		this.sCCA = sCCA;
	}
	
	
	
	
	
}
