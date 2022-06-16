package com.javaex.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Controller
public class GuestBookController {

		//필드 
	
		//생성자 
	
		//메소드 gs
	
		//메소드 일반 
	
	
	
	@RequestMapping(value="/List", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) { 
		System.out.println("GuestbookController>list");
		
		GuestBookDao guestbookDao = new GuestBookDao();
		List<GuestBookVo> gList = guestbookDao.guestbookList();
		
		
		model.addAttribute("gList", gList);
		return "/WEB-INF/views/addList.jsp";
	}
	
	
	
	
	//등록
	@RequestMapping(value="/add", method= {RequestMethod.POST, RequestMethod.GET})
	public String add@ModelAttribute GuestbookVo vo) {
		System.out.println("GuestbookController>add");
		

		GuestBookDao guestbookDao = new GuestBookDao();
		int count = guestDao.insert(vo);
		
		
		System.out.println(count);
		return "redirect:List";
	}
	
	//삭제
	@RequestMapping(value="/deleteForm", method= {RequestMethod.POST, RequestMethod.GET})
	public String deleteForm("no") int no, Model model) { 
	
		
		System.out.println("deleteForm");
		return"/WEB-INF/views/deleteForm.jsp";
	}
	//삭제
	@RequestMapping(value="/delete", method = {RequestMethod.POST, RequestMethod.GET})
	public String delete(@RequestParam("no") int no,
						@RequestParam("password") String password) {
		System.out.println("delete");
		GuestBookDao guestbookDao = new GuestBookDao();
		GuestBookVo guestbookVo = guestbookDao.getGuest(no);
		
		if(guestbookVo.getPassword().equals(password)) {
			guestbookDao.delete(guestbookVo);
			
		}
		return "redirect:/List";
		
	}
}