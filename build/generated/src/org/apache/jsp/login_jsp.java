package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("        <!-- Los iconos tipo Solid de Fontawesome-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.0.8/css/solid.css\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"Content/bootstrap/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Nuestro css-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Content/css/login.css\" th:href=\"@{Content/css/login.css}\">\n");
      out.write("\n");
      out.write("        <link rel=\"icon\" type=\"image/jpg\" href=\"Content/img/login-avatar.png\">\n");
      out.write("        <title> Colegio - Inicio sesión</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"modal-dialog text-center \">\n");
      out.write("            <div class=\"col-sm-8 main-section\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"col-12 user-img\">\n");
      out.write("                        <img src=\"Content/img/login-avatar.png\" alt=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <form action=\"\" class=\"col-12\">\n");
      out.write("                        <div class=\"form-group\" >\n");
      out.write("                            <select class=\"browser-default custom-select \" id=\"select-group\">\n");
      out.write("\n");
      out.write("                                <option value=\"1\" selected>Alumno</option>\n");
      out.write("                                <option value=\"2\">Docente</option>\n");
      out.write("                                <option value=\"3\">Administrativo</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\" id=\"user-group\">\n");
      out.write("                            <input type=\"text\" class=\"form-control\" placeholder=\"Correo electrónico\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\" id=\"contrasena-group\">\n");
      out.write("                            <input type=\"password\" class=\"form-control\" placeholder=\"Contraseña\">\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-success\"><i class=\"fas fa-sign-in-alt\"></i>  Ingresar</button>\n");
      out.write("                    </form>\n");
      out.write("                    <div th:if=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"alert alert-danger\" role=\"alert\">\n");
      out.write("                        Correo o contraseña invalido.\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    <!-- jQuery first, then Popper.js, then Bootstrap JS, Fontawesome-->\n");
      out.write("    <script src=\"Scripts/jquery/jquery-3.5.1.slim.min.js\"></script>\n");
      out.write("    <script src=\"Scripts/bootstrap/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://use.fontawesome.com/releases/v5.0.7/js/all.js\"></script>\n");
      out.write("</html>");
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
