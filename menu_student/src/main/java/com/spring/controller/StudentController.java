package com.spring.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.service.ClassService;
import com.spring.service.StudentService;
import com.spring.vo.ClassVO;
import com.spring.vo.PageVO;
import com.spring.vo.StudentVO;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Resource(name="studentService")
	private StudentService studentService; //객체만든이유 안에 리스트객체있음
	
	//학생정보관리 페이지 이동
	@GetMapping("/studentManage")
	public String studentManage(PageVO pageVO,StudentVO studentVO, Model model) {
		if(studentVO.getClassCode()==null||studentVO.getClassCode().equals("")) {
			studentVO.setClassCode("all");
		}
		
		
		
		
		//학급 리스트 조회
		model.addAttribute("classList", studentService.selectClassList());
		//학생 리스트 조회
		model.addAttribute("studentList", studentService.selectStudentList(studentVO));
		model.addAttribute("classCode",studentVO.getClassCode());		
		return "template";	
	}
	//학생 점수관리페이지이동
	@GetMapping("/studentInfo")
	public String studentInfo(PageVO pageVO) {
		
		return "template";	
	}
}
