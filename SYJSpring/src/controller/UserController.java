package controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.UsersService;
import vo.Login;
import vo.User;
import vo.UserSub;

@Controller
public class UserController {
	
	@Autowired
	private UsersService usersService;
	
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder) { dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true)); }
	
	@RequestMapping("join") public void join() {}
	@RequestMapping("login") public void login() {}
	
	@RequestMapping(path = "doJoin", params = { "id", "pw", "rrn1", "rrn2", "loc", "addr", "phone", "email" })
	public String doJoin(@ModelAttribute User user, @ModelAttribute Login login, @ModelAttribute UserSub userSub, String rrn1, int rrn2) {
		
		user.setGender(rrn2 % 2 == 1 ? 'M' : 'F');
		user.setBoth(Date.valueOf((rrn2 < 3 ? "19" : "20") + rrn1.substring(0, 2) + "-" + rrn1.substring(2, 4) + "-" + rrn1.substring(4, 6)));
		
		login.setPasswordWithEncrypt(login.getPw());
		
		usersService.join(user, login, userSub);
		
		return "redirect:/";
		
	} //doJoin();
	
	@RequestMapping(path = "doLogin", params = { "id", "pw" })
	public String doLogin(HttpSession session, @ModelAttribute Login login) {
		
		Login pw = usersService.getPassword(login.getId());
		
		if(pw.isPassword(login.getPw()))
			session.setAttribute("loginInfo", usersService.getUser(pw.getUser().getNo()));
		
		return "redirect:/";
		
	} //doLogin();
	
} //class UserController;
