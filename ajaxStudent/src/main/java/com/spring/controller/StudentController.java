package com.spring.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.service.StudentService;
import com.spring.vo.ClassInfoVO;
import com.spring.vo.StudentVO;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Resource(name="studentService")
	private StudentService studentService; //객체만든이유 안에 리스트객체있음
	
	
	@GetMapping("/studentList")
	public String studentList(StudentVO studentVO , Model model) {
		if(studentVO.getClassCode() == null || studentVO.getClassCode().equals("")) {
			studentVO.setClassCode("CL_001");
		}
		
		//학급 리스트 조회
		model.addAttribute("classList",studentService.selectClassList()) ;
		//학생 리스트 조회
		model.addAttribute("studentList", studentService.selectStudentList(studentVO));
		model.addAttribute("classCode",studentVO.getClassCode());
		
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
	
	@ResponseBody //ajax로 인식시키는거임.
	@PostMapping("/selectStudentListAjax")
	public List<StudentVO> selectStudentListAjax(StudentVO studentVO){
	 	List<StudentVO> list = studentService.selectStudentList(studentVO);
		
		return list; //ajax의 success에 해당값을 넘겨줌
	}
	
	@ResponseBody 
	@PostMapping("/deleteAjax")
	public int deleteStudent(StudentVO studentVO) {
		 return studentService.deleteStudent(studentVO);
	}
	
	@ResponseBody 
	@PostMapping("/selectScore") //걍 스크립트에서 타입이 post라서 그런거임ㅅㄱ
	public StudentVO selectScore(StudentVO studentVO){
		StudentVO result =  studentService.studentDetailList(studentVO);
		return result;
	}
	
	
	
}
