/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.61
 * Generated at: 2021-05-20 03:01:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.owner;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class order_005fconfirm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/D:/submit/workspaceSTS/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/TeamCoffee/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1616474463678L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("  \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script src=\"/resources/js/owner/order_confirm.js?ver=89\" type=\"text/javascript\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".table th{\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write(".form-control[id=selectCafeList] {\r\n");
      out.write("\tborder: none;\r\n");
      out.write("}\r\n");
      out.write(".form-control[type=date]{\r\n");
      out.write("\twidth: 35%;\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tfont-size: 1.2rem;\r\n");
      out.write("}\r\n");
      out.write("#dateMargin{\r\n");
      out.write("\tmargin: 0px 10px;\r\n");
      out.write("}\r\n");
      out.write("#searchDateBtn{\r\n");
      out.write("\tpadding: 8px 40px;\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("\tmargin-right: 30px;\r\n");
      out.write("}\r\n");
      out.write(".reserveTable{\r\n");
      out.write("\tmargin-top: 20px;\r\n");
      out.write("}\r\n");
      out.write("a{\r\n");
      out.write("\tcolor: #212529;\r\n");
      out.write("}\r\n");
      out.write("a:hover{\r\n");
      out.write("\tcolor: #212529;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write(".buyDate{\r\n");
      out.write("\tcolor: #585858;\r\n");
      out.write("\tfont-size: 0.85rem;\r\n");
      out.write("}\r\n");
      out.write("#buyDetailLabel{\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write(".buyDateModal{\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("}\r\n");
      out.write(".buyRequestsModal, .memTelModal, .orderMessage{\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("\tfont-size: 0.9rem;\r\n");
      out.write("}\r\n");
      out.write(".totalPriceModal{\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("\tcolor: red;\r\n");
      out.write("}\r\n");
      out.write(".detailTitle{\r\n");
      out.write("\tfont-size: 0.95rem;\r\n");
      out.write("}\r\n");
      out.write(".subDetailTitle{\r\n");
      out.write("\tfont-size: 0.85rem;\r\n");
      out.write("}\r\n");
      out.write(".buyMenuDetail{\r\n");
      out.write("\tfont-size: 0.9rem;\r\n");
      out.write("\tpadding: 0px 5px;\r\n");
      out.write("}\r\n");
      out.write(".buyMenuName{\r\n");
      out.write("\tfont-size: 0.85rem;\r\n");
      out.write("}\r\n");
      out.write(".menuOption{\r\n");
      out.write("\tfont-size: 0.8rem;\r\n");
      out.write("\tcolor: #848484;\r\n");
      out.write("\tpadding-left: 7px;\r\n");
      out.write("}\r\n");
      out.write(".allPrice{\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("}\r\n");
      out.write(".usedPoint{\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("\tcolor: #FAAC58;\r\n");
      out.write("}\r\n");
      out.write("textarea{\r\n");
      out.write("\tresize: none;\r\n");
      out.write("}\r\n");
      out.write("#reserveList td:first-of-type{\r\n");
      out.write("\tcolor: #848484;\r\n");
      out.write("\tfont-size: 1rem;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"row justify-content-center\">\r\n");
      out.write("\t\t\t<div class=\"col\">\r\n");
      out.write("\t\t\t\t<h1>주문확인</h1>\r\n");
      out.write("\t\t\t\t<table class=\"table table-bordered\">\r\n");
      out.write("\t\t\t\t\t<colgroup>\r\n");
      out.write("\t\t\t\t\t\t<col width=\"30%\">\r\n");
      out.write("\t\t\t\t\t\t<col width=\"*\">\r\n");
      out.write("\t\t\t\t\t</colgroup>\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope=\"col\">매장명</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${buyVO.cafeCode }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" id=\"searchCafeCode\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select class=\"form-control form-control-sm\" id=\"selectCafeList\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t<div class=\"row justify-content-center\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col text-center\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"date\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${buyVO.preDate }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" id=\"preDate\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"dateMargin\">~</span>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"date\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${buyVO.nowDate }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" id=\"nowDate\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-dark btn-sm\" id=\"searchDateBtn\" onclick=\"searchDateBtn();\">\r\n");
      out.write("\t\t\t\t\t\t\t<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-search\" viewBox=\"0 0 16 16\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<path d=\"M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</svg>\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"row justify-content-center\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col text-center\">\r\n");
      out.write("\t\t\t\t\t\t<table class=\"table reserveTable\">\r\n");
      out.write("\t\t\t\t\t\t\t<colgroup>\r\n");
      out.write("\t\t\t\t\t\t\t\t<col width=\"25%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<col width=\"*\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<col width=\"12%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<col width=\"12%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<col width=\"12%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<col width=\"12%\">\r\n");
      out.write("\t\t\t\t\t\t\t</colgroup>\r\n");
      out.write("\t\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>주문일자</th>\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>주문정보</th>\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>총 가격</th>\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>주문승인</th>\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>주문취소</th>\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>주문상태</th>\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t<tbody id=\"reserveList\">\r\n");
      out.write("\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 구매 상세정보 Modal -->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"orderDetail\" tabindex=\"-1\" aria-labelledby=\"orderDetailLabel\" aria-hidden=\"true\">\r\n");
      out.write("\t\t<div class=\"modal-dialog modal-dialog-centered\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<h4 class=\"modal-title\" id=\"orderDetailLabel\"></h4>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("\t\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t<div><h5 class=\"cafeNameModal\"></h5></div><hr>\r\n");
      out.write("\t\t\t\t\t<div class=\"buyDate\">주문시간<span class=\"buyDateModal\"></span></div><hr>\r\n");
      out.write("\t\t\t\t\t<div class=\"buyDetails\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"detailTitle\">주문내역</span>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row justify-content-center buyMenuDetail\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div><hr>\r\n");
      out.write("\t\t\t\t\t<div class=\"allPriceDiv\"><span class=\"detailTitle\">총 가격</span><span class=\"allPrice\"></span></div><hr>\r\n");
      out.write("\t\t\t\t\t<div><span class=\"detailTitle\">포인트사용</span><span class=\"usedPoint\"></span></div><hr>\r\n");
      out.write("\t\t\t\t\t<div><span class=\"detailTitle\">결제금액</span><span class=\"totalPriceModal\"></span></div><hr>\r\n");
      out.write("\t\t\t\t\t<div><span class=\"detailTitle\">요청사항</span><span class=\"buyRequestsModal\"></span></div><hr>\r\n");
      out.write("\t\t\t\t\t<div><span class=\"detailTitle\">주문메시지</span><span class=\"orderMessage\"></span></div><hr>\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"detailTitle\">주문자 정보</span>\r\n");
      out.write("\t\t\t\t\t\t<div><span class=\"subDetailTitle\">연락처</span><span class=\"memTelModal\">123</span></div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 주문 승인 Modal -->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"orderApr\" tabindex=\"-1\" aria-labelledby=\"orderAprLabel\" aria-hidden=\"true\">\r\n");
      out.write("\t\t<div class=\"modal-dialog modal-dialog-centered\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<h5 class=\"modal-title\" id=\"orderAprLabel\">주문 승인</h5>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("\t\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t<textarea rows=\"3\" cols=\"\" class=\"form-control\" placeholder=\"메뉴 준비 예상 시간을 적어주세요\" id=\"orderAprMessage\"></textarea>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary btn-block orderAprModal\">주문 승인</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 주문 취소 Modal -->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"orderCancel\" tabindex=\"-1\" aria-labelledby=\"orderCancelLabel\" aria-hidden=\"true\">\r\n");
      out.write("\t\t<div class=\"modal-dialog modal-dialog-centered\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<h5 class=\"modal-title\" id=\"orderCancelLabel\">주문 취소</h5>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("\t\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t<textarea rows=\"3\" cols=\"\" class=\"form-control\" placeholder=\"주문 취소 사유를 적어주세요\" id=\"orderCancelMessage\"></textarea>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-danger btn-block orderCancelModal\" >주문 취소</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/views/owner/order_confirm.jsp(109,9) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/owner/order_confirm.jsp(109,9) '${selectCafeList }'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${selectCafeList }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/views/owner/order_confirm.jsp(109,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("cafeListInfo");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cafeListInfo.cafeCode }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cafeListInfo.cafeName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</option>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}
