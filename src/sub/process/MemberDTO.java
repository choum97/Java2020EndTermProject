package sub.process;

public class MemberDTO {
	private String daoName;
	private String daoID;
	private String daoPW;
	private String daoEmail;
	
	public MemberDTO() {
		
	}
	
	public MemberDTO(String id, String pw) {
		
	}
	public String getDaoName() {
		return daoName;
	}
	public void setDaoName(String daoName) {
		this.daoName = daoName;
	}
	public String getDaoID() {
		return daoID;
	}
	public void setDaoID(String daoID) {
		this.daoID = daoID;
	}
	public String getDaoPW() {
		return daoPW;
	}
	public void setDaoPW(String daoPW) {
		this.daoPW = daoPW;
	}
	public String getDaoEmail() {
		return daoEmail;
	}
	public void setDaoEmail(String daoEmail) {
		this.daoEmail = daoEmail;
	}
}
