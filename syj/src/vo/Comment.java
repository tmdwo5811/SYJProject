package vo;

public class Comment extends Vo {
	
	private int no;
	private Post post;
	private User user;//
	private String content;
	
	
	public int getNo() { return no; }//댓글번호
	public Post getPost() { return post; }//게시글
	public User getUser() { return user; }//댓글작성자 String -> User 변경
	public String getContent() { return content; }//댓글내용
	//댓글 작성일
	
	public void setNo(int no) { this.no = no; }
	public void setPost(Post post) { this.post = post; }
	public void setUser(User user) { this.user = user; }
	public void setContent(String content) { this.content = content; }
	
	@Override
	public String toString() {
		return "Comment [no=" + no + ", post=" + post + ", user=" + user + ", content=" + content + "]";
	} //toString();
	
} //class Comment;
