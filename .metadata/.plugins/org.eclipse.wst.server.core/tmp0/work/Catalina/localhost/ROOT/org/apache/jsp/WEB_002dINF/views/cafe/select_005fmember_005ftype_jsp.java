/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.61
 * Generated at: 2021-05-20 03:04:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.cafe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class select_005fmember_005ftype_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!-- 로고 폰트 -->\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" />\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Lobster&display=swap\" rel=\"stylesheet\" />\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".row{\r\n");
      out.write("\theight: 700px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("h1 {\r\n");
      out.write("\tfont-family: 'Lobster', cursive;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("p {\r\n");
      out.write("\tmargin: 40px 0;\r\n");
      out.write("\tfont-size: 15px;\r\n");
      out.write("}\r\n");
      out.write("body{\r\n");
      out.write("   background-image: linear-gradient( rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5) ), url(\"/resources/img/main/main_page.jpg\");\r\n");
      out.write("   background-size: cover;\r\n");
      out.write("}\r\n");
      out.write(".joinDiv{\r\n");
      out.write("\tpadding: 30px 0px;\r\n");
      out.write("    background-color: rgba( 0, 0, 0, 0.5 );\r\n");
      out.write("    color: #dddddd;\r\n");
      out.write("    border: 1px solid rgba( 255, 255, 255, 0.2 );\r\n");
      out.write("}\r\n");
      out.write(".btn-join{\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tborder: 2px solid #FF8200;\r\n");
      out.write("}\r\n");
      out.write(".btn:active,\r\n");
      out.write(".btn:focus,\r\n");
      out.write(".btn.active,\r\n");
      out.write(".btn:active:focus {\r\n");
      out.write("   background-image: none;\r\n");
      out.write("   outline: 0;\r\n");
      out.write("   -webkit-box-shadow: none;\r\n");
      out.write("   box-shadow: none;\r\n");
      out.write("}\r\n");
      out.write(".mainBtn{\r\n");
      out.write("\twidth: 9rem;\r\n");
      out.write("\tbackground-color: rgba( 0, 0, 0, 0.2 );\r\n");
      out.write("}\r\n");
      out.write(".mainBtn:hover{\r\n");
      out.write("\tcolor: rgba( 255, 255, 255, 0.5 );\r\n");
      out.write("}\r\n");
      out.write(".mainBtn{\r\n");
      out.write("\tmargin: 0px 15px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container-sm\">\r\n");
      out.write("\t<div class=\"row align-items-center justify-content-center\">\r\n");
      out.write("\t\t<div class=\"col-8 joinDiv\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<!-- 타이틀 -->\r\n");
      out.write("\t\t\t<h1>Da Java</h1>\r\n");
      out.write("\t\t\t<h3>다자바 회원가입을 환영합니다</h3>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 내용 -->\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t여러분을 환영합니다.<br>\r\n");
      out.write("\t\t\t다양한 다자바 서비스를 즐겨보세요.<br>\r\n");
      out.write("\t\t\t회원으로 가입하시면 다자바 서비스를 보다 편리하게 이용할 수 있습니다.<br>\r\n");
      out.write("\t\t\t여러분이 제공한 콘텐츠를 소중히 다룰 것입니다.<br>\r\n");
      out.write("\t\t\t여러분의 개인정보를 소중히 보호합니다.<br>\r\n");
      out.write("\t\t\t타인의 권리를 존중해 주세요.<br>\r\n");
      out.write("\t\t\t다자바 서비스 이용과 관련하여 몇 가지 주의사항이 있습니다.<br>\r\n");
      out.write("\t\t\t다자바에서 제공하는 다양한 포인트를 요긴하게 활용해 보세요.<br>\r\n");
      out.write("\t\t\t부득이 서비스 이용을 제한할 경우 합리적인 절차를 준수합니다.<br>\r\n");
      out.write("\t\t\t다자바의 잘못은 다자바가 책임집니다.<br>\r\n");
      out.write("\t\t\t언제든지 다자바 서비스 이용계약을 해지하실 수 있습니다.<br>\r\n");
      out.write("\t\t\t서비스 중단 또는 변경 시 꼭 알려드리겠습니다.<br>\r\n");
      out.write("\t\t\t주요 사항을 잘 안내하고 여러분의 소중한 의견에 귀 기울이겠습니다.<br>\r\n");
      out.write("\t\t\t여러분이 쉽게 알 수 있도록 약관 및 운영정책을 게시하며 사전 공지 후 개정합니다.<br>\r\n");
      out.write("\t\t    </p>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 버튼 -->\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-join mainBtn\" onclick=\"location.href='/owner/joinOwner';\">매장주</button>\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-join mainBtn\" onclick=\"location.href='/member/joinMember';\">일반회원</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
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
