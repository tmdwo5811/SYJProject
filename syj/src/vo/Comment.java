package vo;

public class Comment {
	
	int no;
	Post post;
	User user;
	String content;
	
	public int getNo() { return no; }
	public Post getPost() { return post; }
	public User getUser() { return user; }
	public String getContent() { return content; }
	public void setNo(int no) { this.no = no; }
	public void setPost(Post post) { this.post = post; }
	public void setUser(User user) { this.user = user; }
	public void setContent(String content) { this.content = content; }
	
} //class Comment;
