package vo;

import java.sql.Timestamp;

public class Comment extends Vo {
	
	private int no;//댓글 번호
	private Post post;//게시글 번호
	private User user;//작성자
	private String content;//내용
	private Timestamp regdate;//작성일자
	
	
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
