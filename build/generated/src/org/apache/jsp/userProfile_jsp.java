package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dtos.UserDTO;

public final class userProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/userprofile.css\">\n");
      out.write("        <title>My profile</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null) {
                response.sendRedirect("login.jsp");
                return;
            }
        
      out.write("\n");
      out.write("        ");

            String update = (String) session.getAttribute("UPDATE");
            if (update == null) {
                update = "";
            }
        
      out.write("\n");
      out.write("        <div class=\"container bootstrap snippets bootdey\">\n");
      out.write("            <h1 class=\"text-primary\">My Profile</h1>\n");
      out.write("            <hr>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <!-- left column -->\n");
      out.write("                <div class=\"col-md-3\">\n");
      out.write("                    <div class=\"text-center\">\n");
      out.write("                        <img src=\"icon/cv__29__generated.jpg\" class=\"avatar img-circle img-thumbnail\" alt=\"avatar\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- edit form column -->\n");
      out.write("                <div class=\"col-md-9 personal-info\">\n");
      out.write("                    <h3>Personal info</h3>\n");
      out.write("\n");
      out.write("                    <form action=\"MainController\" class=\"form-horizontal\" role=\"form\" method=\"post\">\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"col-lg-3 control-label\">Tên của bạn:</label>\n");
      out.write("                            <div class=\"col-lg-8\">\n");
      out.write("                                <input class=\"form-control\" type=\"text\" name=\"name\" value=\"");
      out.print(loginUser.getUserName());
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"col-lg-3 control-label\">Email</label>\n");
      out.write("                            <div class=\"col-lg-8\">\n");
      out.write("                                <input class=\"form-control\" type=\"text\" name=\"email\" value=\"");
      out.print(loginUser.getEmail());
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"col-lg-3 control-label\">Số điện thoại:</label>\n");
      out.write("                            <div class=\"col-lg-8\">\n");
      out.write("                                <input class=\"form-control\" type=\"text\" name=\"phone\" value=\"");
      out.print(loginUser.getPhone());
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <input name=\"roleID\" value=\"");
      out.print(loginUser.getRoleID());
      out.write("\" hidden=\"\">\n");
      out.write("                        <input name=\"userID\" value=\"");
      out.print(loginUser.getUserID());
      out.write("\" hidden=\"\">\n");
      out.write("                        <div class=\"form-row\">\n");
      out.write("                            <button type=\"submit\" name=\"action\" value=\"Edit\" class=\"btn btn-primary\">Save</button>\n");
      out.write("                        </div>\n");
      out.write("                        <h3>");
      out.print(update);
      out.write("</h3>\n");
      out.write("                </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("                <button class=\"btn btn-success\">\n");
      out.write("                    <a  href=\"user.jsp\" > Back</a>\n");
      out.write("                </button>\n");
      out.write("    <hr>\n");
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
