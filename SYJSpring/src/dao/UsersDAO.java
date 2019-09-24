package dao;

import vo.Login;
import vo.User;
import vo.UserSub;

public interface UsersDAO {

	public boolean insertUser(User user);
	public boolean insertLogin(Login login);
	public boolean insertUserSub(UserSub userSub);
	
	public Login selectPW(String id);
	public User selectUser(int no);
	
} //interface UsersDAO;
