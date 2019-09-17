package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UsersDAO;

@Service
public class UsersService {
	
	@Autowired
	private UsersDAO usersDAO;
	
	
	
} //class UsersService;
