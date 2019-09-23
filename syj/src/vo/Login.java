package vo;

public class Login extends _Login {
	
	private User user;
	
	public User getUser() { return user; }
	public void setUser(User user) { this.user = user; }
	
	@Override
	public String toString() {
		return "Login [user=" + user + ", " + toString() + "]";
	} //toString();
	
} //class Login;
