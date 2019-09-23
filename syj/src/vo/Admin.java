package vo;

public class Admin extends Vo {
	
	private int no;
	private String nickname;
	
	public int getNo() { return no; }
	public String getNickname() { return nickname; }
	public void setNo(int no) { this.no = no; }
	public void setNickname(String nickname) { this.nickname = nickname; }
	
	@Override
	public String toString() {
		return "Admin [no=" + no + ", nickname=" + nickname + "]";
	} //toString();
	
} //class Admin;
