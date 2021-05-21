package com.spring.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.service.SampleService;

@Controller
@RequestMapping("/sample")
public class SampleController {
	@Resource(name="sampleService")
	private SampleService sampleService;
	
	@GetMapping("/first")
	public String first() {
		return "first/first";
	}
}
