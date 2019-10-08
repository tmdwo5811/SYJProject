package dao;

import vo.Login;
import vo.User;
import vo.UserSub;

public interface UsersDAO {
	
	public boolean insertUser(User user);
	public boolean insertLogin(Login login);
	public boolean insertUserSub(UserSub userSub);
	
	public boolean selectId(String id);
	public Login selectLogin(String id);
	public User selectUser(int no);
	
	public boolean updateUser(User user);
	public boolean updateLogin(Login login);
	public boolean updateUserSub(UserSub userSub);
	
	public boolean deleteUser(int no);
	
} //interface UsersDAO;
