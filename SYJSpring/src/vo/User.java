package vo;

import java.sql.Date;

public class User {
	
	public static final User LOGIN_INFO;
	
	static {
		LOGIN_INFO = new User();
		LOGIN_INFO.setNo(1);
		LOGIN_INFO.setGender('M');
		LOGIN_INFO.setBoth(Date.valueOf("1999-12-06"));
		LOGIN_INFO.setLoc(4);
	} //static;
	
	private int no;
	private char gender;
	private Date both;
	private Location location;
	private Boolean credential;
	
	public User() {}
	public User(int no) { this.no = no; }
	
	public void setLoc(int no) { setLocation(new Location(no)); }
	
	public int getNo() { return no; }
	public char getGender() { return gender; }
	public Date getBoth() { return both; }
	public Location getLocation() { return location; }
	public Boolean getCredential() { return credential; }
	public void setNo(int no) { this.no = no; }
	public void setGender(char gender) { this.gender = gender; }
	public void setBoth(Date both) { this.both = both; }
	public void setLocation(Location location) { this.location = location; }
	public void setCredential(Boolean credential) { this.credential = credential; }
	
	@Override
	public String toString() {
		return "User [no=" + no + ", gender=" + gender + ", both=" + both + ", location=" + location + ", credential="
				+ credential + "]";
	} //toString();
	
} //class User;
