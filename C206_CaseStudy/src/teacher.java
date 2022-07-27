/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20034695, Jul 25, 2022 4:56:21 PM
 */

/**
 * @author 20034695
 *
 */
public class teacher {
	public int tId;
	public String tName;
	public String tPassword;
	public String tEmail;
	public int tContactNumber;
	
	public teacher(int tId, String tName, String tPassword, String tEmail, int tContactNumber) {
		super();
		this.tId = tId;
		this.tName = tName;
		this.tPassword = tPassword;
		this.tEmail = tEmail;
		this.tContactNumber = tContactNumber;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettPassword() {
		return tPassword;
	}

	public void settPassword(String tPassword) {
		this.tPassword = tPassword;
	}

	public String gettEmail() {
		return tEmail;
	}

	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}

	public int gettContactNumber() {
		return tContactNumber;
	}

	public void settContactNumber(int tContactNumber) {
		this.tContactNumber = tContactNumber;
	}

	
	
	
}
