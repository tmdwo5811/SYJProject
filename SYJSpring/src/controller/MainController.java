package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	
//	@Autowired
//	private UsersService usersService;
	
	@RequestMapping("/")
	public ModelAndView main() {
		
		ModelAndView model = new ModelAndView("main");
		
		
		
		return model;
		
	} //main();
	
} //class MainController;
