package vo;

import kr.co.hucloud.utilities.SHA256Util;

public class _Login {
	
	private String id, pw, salt;
	
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
