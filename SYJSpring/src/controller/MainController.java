package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.UsersService;

@Controller
public class MainController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/")
	public ModelAndView main() {
		
		ModelAndView model = new ModelAndView("main");
		
		
		
		return model;
		
	} //main();
	
} //class MainController;
