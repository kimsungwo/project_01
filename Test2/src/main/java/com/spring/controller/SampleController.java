package com.spring.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.service.SampleService;
import com.spring.vo.SampleVO;
import com.spring.vo.SampleVO2;

@Controller
@RequestMapping("/sample")
public class SampleController {
	@Resource(name="sampleService")
	private SampleService sampleService;
	
	@GetMapping("/first")
	public String first() {
		return "first/first";
	}
	
	@GetMapping("/deptList")
	public String deptList(Model model) {
		List<SampleVO> list =  sampleService.selectDeptList();
		model.addAttribute("deptList",list);
		return "dept_manage/dept_manage";
	}

	@PostMapping("/deptInsert")
	public String deptInsert(SampleVO sampleVO) {
			sampleService.insertDept(sampleVO);
		return "redirect:deptList";
	}

	@GetMapping("/empNew")
	public String empNew(SampleVO sampleVO,Model model) {
		List<SampleVO> list =  sampleService.selectDeptNameList();
		model.addAttribute("deptNameList",list);
		return "emp_new/emp_new";
	}
	
	@PostMapping("/empInsert")
	public String empInsert(SampleVO2 sampleVO2,Model model) {
		sampleService.insertEmp(sampleVO2);
		model.addAttribute(sampleVO2);
		return "redirect:empList";
	}
	
	@GetMapping("/empList")
	public String empList(Model model) {
		List<SampleVO2> list =  sampleService.selectEmpList();
		model.addAttribute("empList",list);
		return "emp_list/emp_list";
	}
	
	
	
}
