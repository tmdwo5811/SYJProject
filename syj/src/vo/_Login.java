package vo;

import kr.co.hucloud.utilities.SHA256Util;

public class _Login extends Vo {
	
	private String id, pw, salt;
	
	public static void main(String[] args) {
		
		_Login login = new _Login();
		login.setPasswordWithEncrypt("1234");
		
		System.out.println(login.getPw());
		System.out.println(login.getSalt());
		
		System.out.println(login.isPassword("1234"));
		System.out.println(login.isPassword("1235"));
		
	}
	
	public void setPasswordWithEncrypt(String password) {
		
		setSalt(SHA256Util.generateSalt());
		setPw(SHA256Util.getEncrypt(password, getSalt()));
		
	} //setPasswordWithEncrypt();
	
	public boolean isPassword(String password) {
		
		boolean result = getPw().equals(SHA256Util.getEncrypt(password, getSalt()));
		return result;
		
	} //isPassword();
	
	public String getId() { return id; }
	public String getPw() { return pw; }
	public String getSalt() { return salt; }
	public void setId(String id) { this.id = id; }
	public void setPw(String pw) { this.pw = pw; }
	public void setSalt(String salt) { this.salt = salt; }
	
	@Override
	public String toString() {
		return "_Login [id=" + id + ", pw=" + pw + ", salt=" + salt + "]";
	} //toString();
	
} //class _Login
