package vo;

import java.sql.Date;

public class User {
	
	private int no;
	private char gender;
	private Date both;
	private Location location;
	private String credentialFile;
	
	public int getNo() { return no; }
	public char getGender() { return gender; }
	public Date getBoth() { return both; }
	public Location getLocation() { return location; }
	public String getCredentialFile() { return credentialFile; }
	public void setNo(int no) { this.no = no; }
	public void setGender(char gender) { this.gender = gender; }
	public void setBoth(Date both) { this.both = both; }
	public void setLocation(Location location) { this.location = location; }
	public void setCredentialFile(String credentialFile) { this.credentialFile = credentialFile; }
	
} //class User;
