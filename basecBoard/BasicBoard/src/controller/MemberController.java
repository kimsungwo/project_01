package controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberDTO;





@WebServlet("*.me")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO = new MemberDAO();

    public MemberController() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		doProcess(request, response);
		
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		doProcess(request, response);
		
		}
	public void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			boolean isRedirect = false;
			String path = "";//응답할 페이지
			//한글 인코딩
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8"); 
			
			
			//요청uri를 확인
			String requestURI = request.getRequestURI();
			String contextPath = request.getContextPath();
			String command = requestURI.substring(contextPath.length());
			System.out.println("봐도모름 : "+command);
			
			//회원가입 폼으로 이동
			if(command.equals("/joinForm.me")) {
				path = "joinForm.jsp";			
			}
			else if(command.equals("/join.me")) {
				String memberId = request.getParameter("memberId");				
				String password = request.getParameter("password");				
				String name = request.getParameter("name");
				//DTO에서 객체를 받아와야됨
				MemberDTO member = new MemberDTO();
				member.setMemberId(memberId);
				member.setPassword(password);
				member.setName(name);
				//만든 객체에 받아온 값을 넣고 그걸 매개변수로 보냄
				memberDAO.join(member);
				path = "loginForm.jsp";
				
			}
		       //회원가입
			else if(command.equals("/loginForm.me")) {
				String memberId = request.getParameter("memberId");
				path="loginForm.jsp";
			}
			//로그인처리
			else if(command.equals("/login.me")) {
				String id = request.getParameter("memberId");
				String ps = request.getParameter("password");
				
				MemberDTO member = new MemberDTO();
				member.setMemberId(id);
				member.setPassword(ps); 
				MemberDTO memberdto = memberDAO.login(member);//boolean은 데이터가 o,x뿐이라 다른자료가 필요하다.
				isRedirect = true;											//그래서 바꿔줌
				if(memberdto.getMemberId()!=null) {//로그인이 됬을때
					//세션에 로그인 정보 등록
					HttpSession session = request.getSession(); //세션쓰려면 세션에 접근후 세션객체를 만들어줘야핳
					session.setAttribute("loginInfo", memberdto);
					
					path="memberlist.bo";//세션은 어떤jsp에서도 불러쓸수있음.
				}
				else {
					
					path="loginForm.me";
				}
				
			}//로그아웃
			else if(command.equals("/logout.me")) {
				HttpSession session = request.getSession();
				session.removeAttribute("loginInfo"); //해당되는 세션기록을 지우겠따
				isRedirect = true;
				path="boardList.bo";
			}
		
			
			
			
			
			//응답해줄 페이지를 설정
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			
			
			//응답 할 페이지로 이동
			if(isRedirect) {
				response.sendRedirect(path);
			}
			else{
				dispatcher.forward(request, response);}	
			}

}
