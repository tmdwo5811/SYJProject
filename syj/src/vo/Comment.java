package vo;

import java.sql.Timestamp;

public class Comment extends Vo {
	
	private int no;
	private Post post;
	private User user;
	private String content;
	private Timestamp regdate;
	
	public int getNo() { return no; }
	public Post getPost() { return post; }
	public User getUser() { return user; }
	public String getContent() { return content; }
	public Timestamp getRegdate() { return regdate; }
	public void setNo(int no) { this.no = no; }
	public void setPost(Post post) { this.post = post; }
	public void setUser(User user) { this.user = user; }
	public void setContent(String content) { this.content = content; }
	public void setRegdate(Timestamp regdate) { this.regdate = regdate; }
	
	@Override
	public String toString() {
		return "Comment [no=" + no + ", post=" + post + ", user=" + user + ", content=" + content + "]";
	} //toString();
	
} //class Comment;
