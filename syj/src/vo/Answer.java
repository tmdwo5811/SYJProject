
package vo;

import java.sql.Timestamp;

public class Answer {
	
	private int no;	//답변글 번호
	private Post post;	//일반게시판의 게시물번호
	private _Login id;	//답변글의 작성자
	private String content;	//답변 글내용
	private Timestamp regdate;	//답변글 작성일
	
	public int getNo() { return no; }
	public Post getPost() { return post; }
	public _Login getId() { return id; }
	public String getContent() { return content; }
	public Timestamp getRegdate() { return regdate; }
	public void setNo(int no) { this.no = no; }
	public void setPost(Post post) { this.post = post; }
	public void setId(_Login _loguser) { this.id = _loguser; }
	public void setContent(String content) { this.content = content; }
	public void setRegdate(Timestamp regdate) { this.regdate = regdate; }
	
} //class Answer;
