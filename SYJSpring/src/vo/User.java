package vo;

import java.sql.Date;
import java.sql.Timestamp;

public class User {
	
	private int no;
	private String id, pw, salt, addr, phone;
	private char gender;
	private Date both;
	private String email;
	private Location location;
	private Timestamp regdate;
	private String credentialFile;
	
	public int getNo() { return no; }
	public String getId() { return id; }
	public String getPw() { return pw; }
	public String getSalt() { return salt; }
	public String getAddr() { return addr; }
	public String getPhone() { return phone; }
	public char getGender() { return gender; }
	public Date getBoth() { return both; }
	public String getEmail() { return email; }
	public Location getLocation() { return location; }
	public Timestamp getegdate() { return regdate; }
	public String getCredentialFile() { return credentialFile; }
	public void setNo(int no) { this.no = no; }
	public void setId(String id) { this.id = id; }
	public void setPw(String pw) { this.pw = pw; }
	public void setSalt(String salt) { this.salt = salt; }
	public void setAddr(String addr) { this.addr = addr; }
	public void setPhone(String phone) { this.phone = phone; }
	public void setGender(char gender) { this.gender = gender; }
	public void setBoth(Date both) { this.both = both; }
	public void setEmail(String email) { this.email = email; }
	public void setLocation(Location location) { this.location = location; }
	public void setegdate(Timestamp regdate) { this.regdate = regdate; }
	public void setCredentialFile(String credentialFile) { this.credentialFile = credentialFile; }
	
} //class User;
