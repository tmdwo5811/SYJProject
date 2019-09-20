package vo;

import java.sql.Timestamp;

public class UserSub {
	
	private User user;
	private String addr, phone, email;
	private Timestamp regdate;
	
	public User getUser() { return user; }
	public String getAddr() { return addr; }
	public String getPhone() { return phone; }
	public String getEmail() { return email; }
	public Timestamp getRegdate() { return regdate; }
	public void setUser(User user) { this.user = user; }
	public void setAddr(String addr) { this.addr = addr; }
	public void setPhone(String phone) { this.phone = phone; }
	public void setEmail(String email) { this.email = email; }
	public void setRegdate(Timestamp regdate) { this.regdate = regdate; }
	
} //class User2;
