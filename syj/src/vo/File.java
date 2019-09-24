package vo;

public class File extends Vo {
	
	private Post post;
	private String name;
	private char type;
	
	public Post getPost() { return post; }
	public String getName() { return name; }
	public char getType() { return type; }
	public void setPost(Post post) { this.post = post; }
	public void setName(String name) { this.name = name; }
	public void setType(char type) { this.type = type; }
	
	@Override
	public String toString() {
		return "File [post=" + post + ", name=" + name + ", type=" + type + "]";
	} //toString();
	
} //class File;
