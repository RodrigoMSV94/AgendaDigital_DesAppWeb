package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.colegio.model.Perfil;

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Los iconos tipo Solid de Fontawesome-->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.0.8/css/solid.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Bootstrap CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"Content/bootstrap/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Nuestro css-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Content/css/login.css\" th:href=\"@{Content/css/login.css}\">\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"icon\" type=\"image/jpg\" href=\"Content/img/icon_carrito.png\">\r\n");
      out.write("        <title> Colegio - Inicio sesión</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"modal-dialog text-center \">\r\n");
      out.write("            <div class=\"col-sm-8 main-section\">\r\n");
      out.write("                <div class=\"modal-content\">\r\n");
      out.write("                    <div class=\"col-12 user-img\">\r\n");
      out.write("                        <img src=\"Content/img/login-avatar.png\" alt=\"\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <form action=\"LoginController\" class=\"col-12\" method=\"post\">\r\n");
      out.write("                        <div class=\"form-group\" >\r\n");
      out.write("                            ");

                                //List<Perfil> listaPerfiles = (List<Perfil>) request.getAttribute("listaPerfiles");
                                
                                List<Perfil> listaPerfiles = (List<Perfil>) session.getAttribute("listaPerfiles"); 
                            
      out.write("\r\n");
      out.write("                            <select class=\"browser-default custom-select \" id=\"select-group\" name=\"idPerfilUsu\">\r\n");
      out.write("                                ");

                                    for (Perfil objPerfil : listaPerfiles) {
                                
      out.write("\r\n");
      out.write("                                <option value=\"");
      out.print(objPerfil.getId_perfil());
      out.write('"');
      out.write('>');
      out.print(objPerfil.getTipo());
      out.write("</option>\r\n");
      out.write("                                ");

                                    }
                                
      out.write("\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group\" id=\"user-group\">\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"txtCorreo\" placeholder=\"Correo electrónico\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group\" id=\"contrasena-group\">\r\n");
      out.write("                            <input type=\"password\" class=\"form-control\" name=\"txtContrasena\" placeholder=\"Contraseña\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-success\"><i class=\"fas fa-sign-in-alt\"></i>  Ingresar</button>\r\n");
      out.write("                    </form>\r\n");
      out.write("                    \r\n");
      out.write("                    ");

                    if(request.getAttribute("respuesta") != null){
                    
      out.write("\r\n");
      out.write("                        <div th:if=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"alert alert-danger\" role=\"alert\">\r\n");
      out.write("                            Correo o contraseña invalido.\r\n");
      out.write("                        </div>\r\n");
      out.write("                    ");

                    }
                    
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("    <!-- jQuery first, then Popper.js, then Bootstrap JS, Fontawesome-->\r\n");
      out.write("    <script src=\"Scripts/jquery/jquery-3.5.1.slim.min.js\"></script>\r\n");
      out.write("    <script src=\"Scripts/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://use.fontawesome.com/releases/v5.0.7/js/all.js\"></script>\r\n");
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
