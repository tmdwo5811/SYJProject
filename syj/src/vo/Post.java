package vo;

import java.sql.Timestamp;

public class Post {
	
	int no;
	Location location;
	String subject;
	User user;
	String content;
	int view;
	Timestamp regdate;
	byte status;
	
	public int getNo() { return no; }
	public Location getLocation() { return location; }
	public String getSubject() { return subject; }
	public User getUser() { return user; }
	public String getContent() { return content; }
	public int getView() { return view; }
	public Timestamp getRegdate() { return regdate; }
	public byte getStatus() { return status; }
	public void setNo(int no) { this.no = no; }
	public void setLocation(Location location) { this.location = location; }
	public void setSubject(String subject) { this.subject = subject; }
	public void setUser(User user) { this.user = user; }
	public void setContent(String content) { this.content = content; }
	public void setView(int view) { this.view = view; }
	public void setRegdate(Timestamp regdate) { this.regdate = regdate; }
	public void setStatus(byte status) { this.status = status; }
	
} //class Post;
