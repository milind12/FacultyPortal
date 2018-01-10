package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sttp_005fworkshop_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.html");
    _jspx_dependants.add("/footer.html");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("    <style>\n");
      out.write("        #id {\n");
      out.write("            margin: 10px 10px;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("    </style>\n");
      out.write("<title>DDU Portal</title>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");
      out.write("\r\n");
      out.write("<link href=\"css/newstyle.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <body>\r\n");
      out.write("        <!--<form action=\"finallogin.html\" method=\"post\" name=\"frm1\">-->\r\n");
      out.write("        <div class=\"header\">\r\n");
      out.write("            <div class=\"header_resize\">\r\n");
      out.write("\r\n");
      out.write("                <table border=\"0\" style=\"float:left;\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td><div ><img src=\"images/ddu_logo.jpg\" height=\"100\" width=\"100\" />&nbsp;&nbsp;&nbsp;</div></td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <h1 style=\"color:#28ecfa; margin-top: -18%;\">Faculty<span style=\"color:white;\">Portal</span></h1>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                </table>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\n");
      out.write("    <c:choose>\n");
      out.write("    <c:when test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user !=null && sessionScope.user.userType eq 'admin_sp'}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar_sp.html", out, false);
      out.write("\n");
      out.write("    </c:when>\n");
      out.write("    <c:when test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user !=null && sessionScope.user.userType eq 'admin'}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar_admin.html", out, false);
      out.write("\n");
      out.write("    </c:when>\n");
      out.write("    <c:otherwise>\n");
      out.write("          ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar.html", out, false);
      out.write("\n");
      out.write("    </c:otherwise>\n");
      out.write("    </c:choose>\n");
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "login_check.jsp", out, false);
      out.write("\n");
      out.write("    \n");
      out.write("    <div class=\"container\">\n");
      out.write("            ");
      out.write("\n");
      out.write("  </center><font color=\"indianred\"><h2>Hello, \n");
      out.write("        <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user!= null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.userName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</c:if></h2></font></center>\n");
      out.write("        \n");
      out.write("     \n");
      out.write("            <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user!= null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                <c:choose>\n");
      out.write("                <c:when test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.message == null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                    </center><font color=\"black\"><h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3></font></center>\n");
      out.write("                </c:when>\n");
      out.write("                <c:otherwise>\n");
      out.write("                        <center><font color=\"black\"><h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3></font></center>\n");
      out.write("                </c:otherwise>\n");
      out.write("                </c:choose>\n");
      out.write("            </c:if>\n");
      out.write("                <h3 style=\"margin:10px 10px\"><strong >Program Information</strong></h3>\n");
      out.write("                <form action=\"Sttp\" >\n");
      out.write("                    <table>\n");
      out.write("                        \n");
      out.write("                        <tr><td>                    <div id=\"id\">\n");
      out.write("                                    Type:</td><td><<select name=\"select\" >\n");
      out.write("                    <option value=\"seminar\">Seminar</option>\n");
      out.write("                    <option value=\"workshop\">Workshop</option>\n");
      out.write("                    <option value=\"training\">Training</option>\n");
      out.write("                    <option value=\"others\">Others</option>\n");
      out.write("                </select> \n");
      out.write("                                </div></td></tr>\n");
      out.write("                        <tr><td>     <div id=\"id\">\n");
      out.write("                Start Date:</td><td><input type=\"date\" name=\"date1\" required>\n");
      out.write("                    </div></td></tr>\n");
      out.write("                  \n");
      out.write("                      <tr><td><div id=\"id\">\n");
      out.write("                End Date:</td><td><input type=\"date\" name=\"date2\" required>\n");
      out.write("                    </div></td></tr>\n");
      out.write("                  \n");
      out.write("                        <tr><td>   <div id=\"id\">\n");
      out.write("                    Organized By:</td><td> <input type=\"text\" name=\"organizer\" required>\n");
      out.write("                         </div></td></tr>\n");
      out.write("                        \n");
      out.write("                         <tr><td>   <div id=\"id\">\n");
      out.write("                        Sponsored By:</td><td><input type=\"text\" name=\"sponsorer\" >\n");
      out.write("                          </div></td></tr>\n");
      out.write("                           \n");
      out.write("                          <tr><td>  <div id=\"id\">\n");
      out.write("                            Approved By:</td><td><input type=\"text\" name=\"approved\" >\n");
      out.write("                          </div></td></tr>\n");
      out.write("                       \n");
      out.write("                                </form>    \n");
      out.write("    \n");
      out.write("    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("   \n");
      out.write("                               \n");
      out.write("</div>\n");
      out.write("<div class=\"footer\" >\n");
      out.write("           <div class=\"footer_resize\">\n");
      out.write("               ");
      out.write("  \r\n");
      out.write("<p class=\"lf\">Copyright &copy; <a href=\"#\">DDU</a>. All Rights Reserved</p>\r\n");
      out.write("<div style=\"float:right;\"><p class=\"rf\" >Designed by <a target=\"\" href=\"#\">JEEL BHENSDADIA & KINJAL JHA & ADITI CHAUHAN</a></p></div>\r\n");
      out.write("      ");
      out.write("\n");
      out.write("\n");
      out.write("           </div>\n");
      out.write("       </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
