package com.remarkable.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.remarkable.Utils.Pages;
import com.remarkable.model.BoardDTO;
import com.remarkable.service.BoardService;
import com.remarkable.service.ReBoardService;


@Controller
public class ListController {
	
	BoardDTO dto;

	@Resource(name="sqlSession")
	private SqlSession sqlsession;
	
	@Resource(name="re_sqlSession")
	private SqlSession re_sqlsession;

	@Autowired
	private Pages pages;
	
	
	@RequestMapping(value = "/{current_num}")
	public String current_page(@PathVariable int current_num, Model model){
		BoardService bService = sqlsession.getMapper(BoardService.class);
		pages.setTotal_num(bService.getTotal());
		pages.car(current_num);
		if(pages.getEnd_num()<pages.getPage())
			model.addAttribute("true");
		model.addAttribute("pages", pages);
		model.addAttribute("list", bService.listPage(current_num*5-5));
		return "listview";
	}
	
	@RequestMapping(value = "/")
	public String default_main(Model model){
		BoardService bService = sqlsession.getMapper(BoardService.class);
		pages.setTotal_num(bService.getTotal());
		pages.car(1);
		if(pages.getEnd_num()<pages.getPage())
			model.addAttribute("true");
		model.addAttribute("pages", pages);
		model.addAttribute("list", bService.listPage(1*5-5));
		return "listview";
	}
	
	
	@RequestMapping(value="/form", params = "writeview")
	public ModelAndView write_View(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("writeview");
		return mv;
	}

	
	@RequestMapping(value="/contentsview", method=RequestMethod.GET)
	public String contents_view(@RequestParam int bNum, Model model){
		BoardService bService = sqlsession.getMapper(BoardService.class);
		bService.hitcount(bNum);
		ReBoardService reService = re_sqlsession.getMapper(ReBoardService.class);
		model.addAttribute("reply", reService.re_listAll(bNum));
		model.addAttribute("contents", bService.contents(bNum));
		return "contentsview";
	}
	

	
	
	@RequestMapping(value="/write")
	public String create_succes(HttpServletRequest request, Model model){
		BoardService bService = sqlsession.getMapper(BoardService.class);
		bService.write(request.getParameter("bTitle"), request.getParameter("bContents"),request.getParameter("bUser_id"));
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/write", params = "cancel")
	public String write_reset(Model model){
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/contents", params ="contents_modify")
	public String contents_modify(HttpServletRequest request, Model model){
		BoardService bService = sqlsession.getMapper(BoardService.class);
		model.addAttribute("modify", bService.modify(Integer.parseInt(request.getParameter("bNum"))));
		return "modify";
	}
	
	@RequestMapping(value="/contents", params ="contents_reset")
	public String contents_cancel(){
		return "redirect:/";
	}
	
	@RequestMapping(value="/contents", params = "contents_delete")
	public String contents_delete(HttpServletRequest request, Model model){
		BoardService bService = sqlsession.getMapper(BoardService.class);
		bService.delete_contents(Integer.parseInt(request.getParameter("bNum")));
		return "redirect:/";
	}
	
	@RequestMapping(value="/contents", params = "contents_reply")
	public String contents_reply_add(HttpServletRequest request, Model model){
		int bNumber = Integer.parseInt(request.getParameter("bNum"));
		ReBoardService reService = re_sqlsession.getMapper(ReBoardService.class);
		reService.re_create(Integer.parseInt(request.getParameter("bNum")), request.getParameter("bReply"));
		BoardService bService = sqlsession.getMapper(BoardService.class);
		model.addAttribute("reply", reService.re_listAll(bNumber));
		model.addAttribute("contents", bService.contents(bNumber));
		return "redirect:/contentsview?bNum="+bNumber;
	}
	
	@RequestMapping(value="/modify", params = "modify")
	public String modify_apply(HttpServletRequest request, Model model){
		BoardService bService = sqlsession.getMapper(BoardService.class);
		bService.modify_apply(request.getParameter("bTitle"), request.getParameter("bContents"),request.getParameter("bUser_id"), 
				Integer.parseInt(request.getParameter("bNum")));
		return "redirect:/";
	}
	
	@RequestMapping(value="/modify", params = "cancel")
	public String modify_cancel(){
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String contents_apply_delete(@RequestParam int bNum,@RequestParam int re_Num , Model model){
		ReBoardService reService = re_sqlsession.getMapper(ReBoardService.class);
		reService.re_delete(re_Num);
		BoardService bService = sqlsession.getMapper(BoardService.class);
		model.addAttribute("reply", reService.re_listAll(bNum));
		model.addAttribute("contents", bService.contents(bNum));
		return "redirect:/contentsview?bNum="+bNum;
	}
}
