package db;

public class MemberDTO {
	private String uName;
	private String uID;
	private String uPW;
	private String uEmail;
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuID() {
		return uID;
	}
	public void setuID(String uID) {
		this.uID = uID;
	}
	public String getuPW() {
		return uPW;
	}
	public void setuPW(String uPW) {
		this.uPW = uPW;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
}
