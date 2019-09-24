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
	
	public Login getPassword(String id) { return usersDAO.selectPW(id); }
	public User getUser(int no) { return usersDAO.selectUser(no); }
	
} //class UsersService;
