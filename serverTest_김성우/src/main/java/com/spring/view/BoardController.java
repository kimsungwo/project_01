package com.spring.view;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.biz.BoardService;
import com.spring.vo.BoardVO;


@Component /* 스프링에서 쓰는 어노테이션. 자동완성됨. 실행될때 자동으로 클래스생성해줌.얘도 상속을 하고있다. */
@Controller //해당@이 붙은 클래스는 스프링 구동시 자동으로 객체가 만들어진다.
			//단 ,자동객체생성위해선  servlet-context.xml(컨트롤러설정파일)에 component-scan태그가 있어야됨
			//@@Controller붙은 클래스는 스프링이 자동으로servlet으로 인식하여 컨트롤러역할수행함
			
			// servlet-context.xml에 component-scan존재시
			// @Component +@Controller 동시붙으면 아래클래스는 컨트롤러로 만들수있음


@RequestMapping(value="/board")
public class BoardController {
	@Resource(name="boardService")
	private BoardService boardService;
	
	@GetMapping(value="/boardList")
	public String boardList(Model model) {
		List<BoardVO> list =  boardService.selectBoardList();
		model.addAttribute("list" ,list);
		return "board_list";//  /WEB-INF/views/board_list.jsp
	}
	//@RequestParam 넘어오는 데이터를 의미하는 어노테이션
	//커맨드 객체를 사용하지않고 일반변수로 넘어오는 데이터를 받을 수 있다.
	//단, 넘어오는 데이터의 이름과 매개변수의 이름은 반드시 일치해야됨.
	@GetMapping("/detail")
	public String detail(@RequestParam(name ="boardNum") int boardNum, Model model) {  
		//@RequestParam jsp에서 넘어온 데이터를 받을때 사용함.
		//ex)@RequestParam(name="name") String myName
		//jsp에서 name으로 넘어온 데이터를 myName변수에 매핑시킨다는 의미
		//@RequestParam 속성으로 name
		//name : 넘어오는 데이터의 이름
		//required : 해당데이터가 무조건 넘어오면 true,  전달되지 않을때 false
		//defaultValue:데이터가 넘어오지 않을때 기본값설정
		//BoardVO boardInfo = boardService.selectBoard(boardNum);
		//model.addAttribute("boardInfo" , boardInfo);
		model.addAttribute("boardInfo" , boardService.selectBoard(boardNum));
		return "board_detail";
	}
	
	@RequestMapping("/write")
	public String write(BoardVO boardVO) { //커맨드객체임 굳이 모델.뭐시기 안해도 알아서 받은 데이터만 넘겨줌
		//boardService.deleteBoard(boardVO.getBoardNum());
		//return"redirect:/board/boardList";//controller로 보내기
		boardService.insertBoard(boardVO);
		
		return "redirect:boardList";
	}
	@GetMapping("/writeForm")
	public String writeForm() {
		return "board_write_form";
	}
}











/*
@RequestMapping(value="/page1") //요청에 대한 매핑
public String page1() {
	//메소드 하나 자체만으로도 else if역할을함
	System.out.println("page1() 메소드 실행 오타안났나보네?"); 
	return ""; // /WEB-INF/views/page2.jsp
				//이동할 페이지 파일명
				// /WEB-INF/views/.jsp
	/*
	 * <beans:property name="prefix" value="/WEB-INF/views/" /> 
	 * <beans:property name="suffix" value=".jsp" />
	 */
	
	//@RequestMapping 요청에 대한 처리진행
/*
}
//@RequestMapping(value="/page2") //요청에 대한 매핑
@GetMapping(value="/page2") 
public String page2() {
	//메소드 하나 자체만으로도 else if역할을함
	System.out.println("page2() 메소드 실행 오타안났나보네?"); 
	return "page2";
}
@PostMapping(value="/page3") 
public String page3() {
	//메소드 하나 자체만으로도 else if역할을함
	System.out.println("page3() 메소드 실행 오타안났나보네?"); 
	return "";
}
*/
