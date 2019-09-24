package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.UsersService;
import vo.Location;
import vo.Login;
import vo.User;
import vo.UserSub;

@Controller
public class UserController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("join") public void join() {}
	@RequestMapping("login") public void login() {}
	
	@RequestMapping(path = "doJoin", params = { "id", "pw", "gender", "both", "location", "phone" })
	public String doJoin(@ModelAttribute Login login, @ModelAttribute User user, @ModelAttribute UserSub userSub, @RequestParam int location) {
		
		user.setLocation(new Location(location));
		
		
		
		return "redirect:/";
		
	} //doJoin();
	
} //class UserController;
