/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.61
 * Generated at: 2021-05-21 00:37:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.owner;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class owner_005fmain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body{\r\n");
      out.write("\tbackground-color: #F2F2F2;\r\n");
      out.write("}\r\n");
      out.write(".iconBoard{\r\n");
      out.write("\theight: 12rem;\r\n");
      out.write("}\r\n");
      out.write(".mx-auto{\r\n");
      out.write("\tmargin-left: 10rem;\r\n");
      out.write("}\r\n");
      out.write(".top1{\r\n");
      out.write("\tmargin-top: 5rem;\r\n");
      out.write("}\r\n");
      out.write(".text-center{\r\n");
      out.write("\tmargin-top: 1rem;\r\n");
      out.write("}\r\n");
      out.write(".side_menu{\r\n");
      out.write("\tcolor: #000000;\r\n");
      out.write("}\r\n");
      out.write(".card-header{\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("a:hover{\r\n");
      out.write("\tcolor: #343a40;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write(".card{\r\n");
      out.write("\tmargin: 10px 20px;\r\n");
      out.write("\tpadding: 0px;\r\n");
      out.write("}\r\n");
      out.write(".card-title{\r\n");
      out.write("\tcolor: #343a40;\r\n");
      out.write("\tfont-size: 1rem;\r\n");
      out.write("}\r\n");
      out.write(".card-body{\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write(".ownerInfo{\r\n");
      out.write("\tcolor: #C63D3D;\r\n");
      out.write("\tfont-size: 1.5rem;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"row justify-content-center\">\r\n");
      out.write("\t\t\t<div class=\"text-center\">\r\n");
      out.write("\t\t\t\t<h1>My Page</h1>\r\n");
      out.write("\t\t\t</div>\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t<div class=\"row justify-content-center top1\">\r\n");
      out.write("\t\t<div class=\"card text-white col-2 iconBoard\">\r\n");
      out.write("\t\t\t<div class=\"card-header\"><a class=\"side_menu\" href=\"/owner/myPage?sideMenu=1\">프로필 조회 및 변경</a></div>\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t<h5 class=\"card-title\"><span class=\"span-red\">프로필 조회, 변경</span>을 할 수 있습니다</h5>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"card text-white col-2 iconBoard\">\r\n");
      out.write("\t\t\t<div class=\"card-header\"><a class=\"side_menu\" href=\"/owner/regCafe?sideMenu=2\">매장등록</a></div>\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t<h5 class=\"card-title\"><span class=\"span-red\">매장을 등록</span>할 수 있습니다</h5>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"card text-white col-2 iconBoard\">\r\n");
      out.write("\t\t\t<div class=\"card-header\"><a class=\"side_menu\" href=\"/owner/cafeManage?sideMenu=3\">매장관리</a></div>\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t<div><span class=\"ownerInfo\">관리중 : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${owners.oprtCafes }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("곳</span></div>\r\n");
      out.write("\t\t\t\t<div><span class=\"ownerInfo\">승인중 : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${owners.aprCafes }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("곳</span></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"row justify-content-center\">\t\t\r\n");
      out.write("\t\t<div class=\"card text-white col-2 iconBoard\">\r\n");
      out.write("\t\t\t<div class=\"card-header\"><a class=\"side_menu\" href=\"/owner/regMenu\">메뉴등록</a></div>\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t<h5 class=\"card-title\"><span class=\"span-red\">메뉴를 등록</span>할 수 있습니다</h5>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"card text-white  col-2 iconBoard\">\r\n");
      out.write("\t\t\t<div class=\"card-header\"><a class=\"side_menu\" href=\"/owner/menuManage\">메뉴관리</a></div>\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t<h5 class=\"card-title\"><span class=\"span-red\">메뉴를 관리</span>할 수 있습니다</h5>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"card text-white  col-2 iconBoard\">\r\n");
      out.write("\t\t\t<div class=\"card-header\"><a class=\"side_menu\" href=\"/owner/orderConfirm\">주문확인</a></div>\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t<span class=\"ownerInfo\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${owners.orders }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("건</span>\r\n");
      out.write("\t\t\t\t<h5 class=\"card-title\">진행중인 주문이 있습니다</h5>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"row justify-content-center\">\r\n");
      out.write("\t\t<div class=\"card text-white  col-2 iconBoard\">\r\n");
      out.write("\t\t\t<div class=\"card-header\"><a class=\"side_menu\" href=\"/owner/qnaOwner\">Q/A</a></div>\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t<span class=\"ownerInfo\">1건</span>\r\n");
      out.write("\t\t\t\t<h5 class=\"card-title\">의 답변이 완료된 질문이 있습니다</h5>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"card text-white col-2 iconBoard\">\r\n");
      out.write("\t\t\t<div class=\"card-header\"><a class=\"side_menu\" href=\"/owner/toDropOutForm\">회원탈퇴</a></div>\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t<h5 class=\"card-title\"><span class=\"span-red\">회원탈퇴</span>가 가능합니다</h5>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
