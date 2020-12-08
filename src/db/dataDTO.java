package db;

public class dataDTO {
	private String cName;
	private String cRoadName;
	private String cBranchName;
	private String cPostal;
	private String cDivision;
	private String cPhone;
	private String cCleanName;
	private int flag = 1;
	public String getcPhone() {
		return cPhone;
	}
	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcRoadName() {
		return cRoadName;
	}
	public void setcRoadName(String cRoadName) {
		this.cRoadName = cRoadName;
	}
	public String getcBranchName() {
		return cBranchName;
	}
	public void setcBranchName(String cBranchName) {
		this.cBranchName = cBranchName;
	}
	public String getcPostal() {
		return cPostal;
	}
	public void setcPostal(String string) {
		this.cPostal = string;
	}
	public String getcDivision() {
		return cDivision;
	}
	public void setcDivision(String cDivision) {
		this.cDivision = cDivision;
	}
	public String getcCleanName() {
		return cCleanName;
	}
	public void setcCleanName(String cCleanName) {
		this.cCleanName = cCleanName;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
}
