package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UsersDAO;
import vo.Login;
import vo.User;
import vo.UserSub;

@Service
public class UsersService {
	
	@Autowired
	private UsersDAO usersDAO;
	
	public boolean join(User user, Login login, UserSub userSub) {
		
		if(!usersDAO.insertUser(user)) return false;
		if(!usersDAO.insertLogin(login)) return false;
		if(!usersDAO.insertUserSub(userSub)) return false;
		
		return true;
		
	} //join();
	
	public boolean checkId(String id) { return usersDAO.selectId(id); }
	public Login getLogin(String id) { return usersDAO.selectLogin(id); }
	public User getUser(int no) { return usersDAO.selectUser(no); }
	
	public boolean changePassword(Login login) { return usersDAO.updateLogin(login); }
	public boolean changeAccount(User user, UserSub userSub) {
		
		if(!usersDAO.updateUser(user)) return false;
		if(!usersDAO.updateUserSub(userSub)) return false;
		
		return true;
		
	} //updateUser();
	
	public boolean deleteAccount(int no) { return usersDAO.deleteUser(no); }
	
} //class UsersService;
