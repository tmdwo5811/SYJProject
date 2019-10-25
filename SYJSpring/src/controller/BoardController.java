package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.BoardService;
import vo.Login;
import vo.Page;
import vo.Post;

@Controller @RequestMapping("petition")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping({ "write", "loc" })
	public void noneAction() {}
	
	@RequestMapping("doWrite")
	public String doWrite(HttpSession session, Post post) {
		
		post.setUser(((Login)session.getAttribute("loginInfo")).getUser());
		boardService.writePost(post);
		
		return "redirect:../petition";
		
	} //doWrite();
	
	@RequestMapping
	public ModelAndView petition(@RequestParam(defaultValue = "1") Integer p, @RequestParam(required = false) Integer l,
			@RequestParam(required = false) Boolean e, @RequestParam(required = false) String q , @RequestParam(defaultValue = "0") Integer o) {
		Page page = new Page(p, 5, 7);
		
		String order = null;
		switch(o) {
		case 0: order = BoardService.ORDER_RECOMMEND; break;
		case 1: order = BoardService.ORDER_COMMENT; break;
		case 2: order = BoardService.ORDER_REGDATE;
		}
		
		return new ModelAndView()
				.addObject("postList", boardService.getPostList(page, l, e, q, order))
				.addObject("page", page);
		
	} //petition();
	
} //class BoardController;
