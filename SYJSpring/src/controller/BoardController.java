package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.BoardService;
import vo.Page;

@Controller @RequestMapping("petition")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping({ "write", "loc" })
	public void noneAction() {}
	
	private ModelAndView getPetitionModelAndView(Page page) { return new ModelAndView("petition").addObject("page", page); }
	
	@RequestMapping({ "", "/{p}" })
	public ModelAndView petition(@PathVariable(required = false) Integer p) {
		if(p == null) p = 1;
		
		Page page = new Page(p, 5, 5);
		
		return getPetitionModelAndView(page)
				.addObject("title", "청원 전체 목록 [최신순]")
				.addObject("postList", boardService.getPostList(page));
		
	} //petition();
	
} //class BoardController;
