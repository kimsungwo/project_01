package com.spring.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.service.StudentService;
import com.spring.vo.ClassInfoVO;
import com.spring.vo.StudentVO;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Resource(name="studentService")
	private StudentService studentService; //객체만든이유 안에 리스트객체있음
	
	
	@GetMapping("/studentList")
	public String studentList(StudentVO studentVO , ClassInfoVO classVO, Model model) {
		if(classVO.getClassCode() == null || classVO.getClassCode().equals("")) {
			classVO.setClassCode("all");
		}
		studentVO.setClassVO(classVO);
		
		

		
		System.out.println(studentVO);
		
		
		
		//학급 리스트 조회
		model.addAttribute("classList",studentService.selectClassList()) ;
		//학생 리스트 조회
		model.addAttribute("studentList", studentService.selectStudentList(studentVO));
		model.addAttribute("classCode",studentVO.getClassVO().getClassCode());
		
		return "studentList";
	}
	@GetMapping("/studentDetail")
	public String studentDetail(StudentVO studentVO ,Model model) {
		//학생 상세정보조회
		model.addAttribute("detail",studentService.studentDetailList(studentVO) );
		return "studentDetail";
	}
	
	@PostMapping("/update")
	public String studentUpdate(StudentVO studentVO , Model model ) {
		studentService.updateScore(studentVO);
		model.addAttribute("stuNum", studentVO.getStuNum());
		return "redirect:/student/studentDetail";
	}
}
