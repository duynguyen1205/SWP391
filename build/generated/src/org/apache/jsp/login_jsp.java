package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dtos.UserError;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" href=\"css/styles.css\">\n");
      out.write("        <title>Login</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("            <div class=\"title-text\">\n");
      out.write("                <div class=\"title login\">Login Form</div>\n");
      out.write("                <div class=\"title signup\">Signup Form</div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-container\">\n");
      out.write("                <div class=\"slide-controls\">\n");
      out.write("                    <input type=\"radio\" name=\"slide\" id=\"login\" checked>\n");
      out.write("                    <input type=\"radio\" name=\"slide\" id=\"signup\">\n");
      out.write("                    <label for=\"login\" class=\"slide login\">Login</label>\n");
      out.write("                    <label for=\"signup\" class=\"slide signup\">Sign Up</label>\n");
      out.write("                    <div class=\"slider-tab\"></div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-inner\">\n");
      out.write("                    <form action=\"MainController\" class=\"login\" method=\"post\">\n");
      out.write("                        <div class=\"field\">\n");
      out.write("                            <input type=\"text\" name=\"userID\" placeholder=\"Email Address\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"field\">\n");
      out.write("                            <input type=\"password\" name=\"password\" placeholder=\"Password\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"pass-link\"><a href=\"#\">Forgot password?</a></div>\n");
      out.write("                        <div class=\"field btn\">\n");
      out.write("                            <div class=\"btn-layer\"></div>\n");
      out.write("                            <input type=\"submit\" name=\"action\" value=\"Login\">\n");
      out.write("                        </div>\n");
      out.write("                        ");

                            String error = (String) request.getAttribute("ERROR");
                            if (error == null) {
                                error = "";
                            }
                        
      out.write("\n");
      out.write("                        <p style=\"color: red\">");
      out.print(error);
      out.write("</p>\n");
      out.write("                        <div class=\"signup-link\">Not a member? <a href=\"\">Signup now</a></div>\n");
      out.write("                    </form>\n");
      out.write("                    ");

                        UserError userError = (UserError) request.getAttribute("USER_ERROR");
                        if (userError == null) {
                            userError = new UserError();
                        }
                    
      out.write("\n");
      out.write("\n");
      out.write("                    <form action=\"MainController1\" class=\"signup\" id=\"formSWP\" method=\"post\">\n");
      out.write("                        <div class=\"field\">\n");
      out.write("                            <input type=\"text\" name=\"userID\" id=\"userID\" placeholder=\"Tên tài khoản\" required>\n");
      out.write("                            <span class=\"form-message\"></span>\n");
      out.write("                            <p style=\"color: red\">");
      out.print( userError.getUserID());
      out.write("</p>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"field\">\n");
      out.write("                            <input type=\"text\" name=\"email\" id=\"email\" placeholder=\"Email Address\" required>\n");
      out.write("                            <span class=\"form-message\"></span>\n");
      out.write("                            <p style=\"color: red\"> ");
      out.print( userError.getEmail());
      out.write("</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"field\">\n");
      out.write("                            <input type=\"text\" name=\"phone\" id=\"phone\" placeholder=\"Phone\" required>\n");
      out.write("                            <span class=\"form-message\"></span>\n");
      out.write("                            <p style=\"color: red\">");
      out.print( userError.getPhone());
      out.write("</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"field\">\n");
      out.write("                            <input type=\"password\" name=\"password\" id=\"password\" placeholder=\"Password\" required>\n");
      out.write("                            <span class=\"form-message\"></span>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"field\">\n");
      out.write("                            <input type=\"password\" id=\"password_confirm\" placeholder=\"Confirm password\" required>\n");
      out.write("                            <span class=\"form-message\"></span>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"field btn\">\n");
      out.write("                            <div class=\"btn-layer\"></div>\n");
      out.write("                            <input type=\"submit\" name=\"action\" value=\"Signup\">\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--js-->\n");
      out.write("        <script src=\"js/scripts.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            document.addEventListener('DOMContentLoaded', function () {\n");
      out.write("                // Mong muốn của chúng ta\n");
      out.write("                Validator({\n");
      out.write("                    form: '#formSWP',\n");
      out.write("                    errorSelector: '.form-message',\n");
      out.write("                    rules: [\n");
      out.write("                        Validator.isRequired('#userID', 'Vui lòng nhập lại Tên tài khoản'),\n");
      out.write("                        Validator.isEmail('#email', 'Email chưa chính xác'),\n");
      out.write("                        Validator.minLength('#password', 6, 'Nhập vào tối thiểu 6 ký tự'),\n");
      out.write("                        Validator.isPhone('#phone', 'vui lòng nhập lại số điện thoại'),\n");
      out.write("                        Validator.isConfirmed('#password_confirm', function () {\n");
      out.write("                            return document.querySelector('#formSWP #password').value;\n");
      out.write("                        }, 'Mật khẩu nhập lại không chính xác')\n");
      out.write("                    ],\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
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
