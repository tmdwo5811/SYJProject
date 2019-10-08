package vo;

import java.sql.Timestamp;

public class UserSub extends Vo {
	
	private User user;
	private String phone, email;
	private Timestamp regdate;
	
	public User getUser() { return user; }
	public String getPhone() { return phone; }
	public String getEmail() { return email; }
	public Timestamp getRegdate() { return regdate; }
	public void setUser(User user) { this.user = user; }
	public void setPhone(String phone) { this.phone = phone; }
	public void setEmail(String email) { this.email = email; }
	public void setRegdate(Timestamp regdate) { this.regdate = regdate; }
	
	@Override
	public String toString() {
		return "UserSub [user=" + user + ", phone=" + phone + ", email=" + email + ", regdate="
				+ regdate + "]";
	} //toString();
	
} //class User2;
