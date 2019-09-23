package vo;

public class Credential extends Vo {
	
	private User user;
	private String credentialFile;
	
	public User getUser() { return user; }
	public String getCredentialFile() { return credentialFile; }
	public void setUser(User user) { this.user = user; }
	public void setCredentialFile(String credentialFile) { this.credentialFile = credentialFile; }
	
	@Override
	public String toString() {
		return "Credential [user=" + user + ", credentialFile=" + credentialFile + "]";
	} //toString();
	
} //class Credential
