package controller;

import java.io.IOException;
import java.lang.reflect.Member;
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

import dao.BoardDAO;
import dao.MemberDAO;
import dto.BoardDTO;
import dto.MemberDTO;





@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardDAO boardDAO = new BoardDAO();



    public BoardController() {super();}

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
			System.out.println("본다고 알까? : "+command);
			
			//게시글목록페이지
			if(command.equals("/boardList.bo")) {
				List<BoardDTO> list = boardDAO.selectBoardList();//list를 같은자료명으로 받음
				request.setAttribute("list", list);

				path = "boardList.jsp";			
			}
			//게시글쓰기
			else if(command.equals("/boardWriteForm.bo")) {
				path="boardWriteForm.jsp";
			}
			//글작성후 게시글목록페이지 이동
			if(command.equals("/boardWrite.bo")) {
				String title= request.getParameter("title");
				String content = request.getParameter("content");
				
				HttpSession session = request.getSession();
				MemberDTO member =(MemberDTO)session.getAttribute("loginInfo");//로그인할때 지정한 가명으로 불러오기
															//.getAttribute()이건 오브젝트 자료형이라 형변환 해줘야됨
				//BoardDAO에 대한 객체를 만들어야 접근가능
				BoardDTO board = new BoardDTO();
				board.setTitle(title);
				board.setContent(content);
				board.setMemberId(member.getMemberId()); 
				
				boardDAO.insertBoard(board);//제목,내용,작성자
				isRedirect = true;
				path = "boardList.bo";  //같은컨트롤내 이동시 redirect: 이걸 붙여야됨. 새로고침중복방지			
			}
			//상세조회
			else if(command.equals("/boardDetail.bo")) {
				int boardNum = Integer.parseInt(request.getParameter("boardNum"));//2.리스트에서 글번호가져옴. 
 				//조회수 증가
				boardDAO.read_cnt(boardNum);
				
				//BoardDTO board1 = boardDAO.selectBoardDetail(boardNum);//어떤걸 볼건지 매개변수를 가져와야됨 1.
 				request.setAttribute("board", boardDAO.selectBoardDetail(boardNum)); 
				
				path = "boardDetail.jsp";	
			}
			//삭제
			else if(command.equals("/delete.bo")) {
				int boardNum = Integer.parseInt(request.getParameter("boardNum"));
				boardDAO.delete(boardNum);
				isRedirect = true;
				path = "boardlist.bo";
			}
			//글수정 양식
			else if(command.equals("/updateForm.bo")) {
				int boardNum = Integer.parseInt(request.getParameter("boardNum"));
				request.setAttribute("board", boardDAO.selectBoardDetail(boardNum));//몇번째글인지 정보를 매개변수로 받아와줘야됨
				path = "updateBoard.jsp";
			}
			//게시글수정
			else if (command.equals("/updateBoard.bo")) {
				int boardnum = Integer.parseInt(request.getParameter("boardNum"));
				String title= request.getParameter("title");
				String content = request.getParameter("content");
				
				BoardDTO board1 = new BoardDTO();
				board1.setBoardNum(boardnum);
				board1.setContent(content);
				board1.setTitle(title);
				
				boardDAO.updateBoard(board1); 
				isRedirect = true;  //같은 컨트롤러로 넘어갈땐 true값을 준후  path에 값을 넣어서 넘겨야됨
				path = "boardDetail.bo?boardNum=" +boardnum;
			}
			
			//응답해줄 페이지를 설정
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			
			//응답 할 페이지로 이동 응답과반응값 둘다가져감
			if(isRedirect) {
				response.sendRedirect(path);
			}else {
				dispatcher.forward(request, response);
			}
			
			}	

}
