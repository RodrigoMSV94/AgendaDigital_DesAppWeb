package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/agenda.jsp");
    _jspx_dependants.add("/footer.jsp");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Fonts Google -->\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300;400;600&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Bootstrap CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"Content/bootstrap/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Nuestro css-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Content/css/estilos.css\" th:href=\"@{Content/css/estilos.css}\">\r\n");
      out.write("        <link rel=\"icon\" type=\"image/jpg\" href=\"Content/img/login-avatar.png\">\r\n");
      out.write("        <title>Colegio</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<header>\r\n");
      out.write("    <section class=\"bienvenido\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <a class=\"navbar-brand\">Bienvenido, Nombre Apellido</a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </section>\r\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-light\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\"\r\n");
      out.write("                    data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\"\r\n");
      out.write("                    aria-label=\"Toggle navigation\">\r\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\r\n");
      out.write("                    <li class=\"nav-item active\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"#\" id=\"colegio\">Colegio</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"#\" id=\"agenda\">Agenda</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"#\" id=\"calificaciones\">Calificaciones</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"#\" id=\"examenes\">Rol Examenes</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"#\" id=\"ssistencias\">Asistencias</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"#\" id=\"horario\">Horario</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"#\" id=\"pensiones\">Pensiones</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <form class=\"form-inline my-2 my-lg-0\">\r\n");
      out.write("                    <button class=\"btn btn-outline-danger my-2 my-sm-0\" type=\"submit\"><i\r\n");
      out.write("                            class=\"fas fa-sign-out-alt\"></i> Cerrar Sesión</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("</header>");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        ");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<main role=\"main\" class=\"flex-shrink-0\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        \n");
      out.write("    </div>\n");
      out.write("</main>\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<footer>\r\n");
      out.write("    <div class=\"footer-cuerpo container\">\r\n");
      out.write("        <img src=\"Content/img/login-avatar.png\" />\r\n");
      out.write("        <div class=\"footer-izq-titulo\">\r\n");
      out.write("            Contactanos en:\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"footer-izq-contenido\">\r\n");
      out.write("            <i class=\"fas fa-globe\"></i>\r\n");
      out.write("            http://colegio.com.pe\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"footer-izq-contenido\">\r\n");
      out.write("            <i class=\"fas fa-mobile-alt\"></i>\r\n");
      out.write("            +51 (01) 612 6123\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"footer-izq-contenido\">\r\n");
      out.write("            <i class=\"fas fa-at\"></i>\r\n");
      out.write("            innovacionacademica@colegio.com.pe\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</footer>");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("    <!-- jQuery first, then Popper.js, then Bootstrap JS, Fontawesome -->\r\n");
      out.write("    <script src=\"Scripts/jquery/jquery-3.5.1.slim.min.js\"></script>\r\n");
      out.write("    <script src=\"Scripts/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://kit.fontawesome.com/709cccdb82.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("</html>\r\n");
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
