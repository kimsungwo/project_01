package com.spring.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.service.ClassService;
import com.spring.vo.ClassVO;
import com.spring.vo.PageVO;


@Controller
@RequestMapping("/class")
public class ClassController {
	@Resource(name="classService")
	private ClassService classService;
	
	//학급 관리페이지이동
	@GetMapping("/classManage")
	public String classManage(PageVO pageVO,Model model, ClassVO classVO) {
		
		if(pageVO.getSideMenu() == null) {pageVO.setSideMenu("class_side");}
		if(pageVO.getContent() == null) {pageVO.setContent("class_manage");}
		
		model.addAttribute("classList", classService.selectClassList());
		return "template";
	}
	
	@PostMapping("/insertClass")
	public String insertList(ClassVO classVO) {
		classService.insertClass(classVO);
		
		
		return "redirect:/class/classManage";
	}
	@GetMapping("/deleteClass")
	public String deleteClass(ClassVO classVO) {
		classService.deleteClass(classVO);
		return "redirect:/class/classManage";
	}
}
