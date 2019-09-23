package vo;

public class AdminLogin extends _Login {
	
	private Admin admin;
	
	public Admin getAdmin() { return admin; }
	public void setAdmin(Admin admin) { this.admin = admin; }
	
	@Override
	public String toString() {
		return "AdminLogin [admin=" + admin + ", "  + toString() + "]";
	} //toString();
	
} //class AdminLogin
