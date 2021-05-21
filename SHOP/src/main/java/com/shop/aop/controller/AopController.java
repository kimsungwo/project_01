package com.shop.aop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.aop.service.AopService;

@Controller
@RequestMapping("/aop")
public class AopController {
	
	@Resource(name="aopService")//aopServiceimpl가져오는거임 
	private AopService service;
	
	
	@GetMapping("/test")
	public String test() {
		service.insertBoard("자바");
		service.updateBoard(10);
		service.selectBoard();
		service.deleteBoard();
		return "";
	}
}
