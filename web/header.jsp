<%@page import="com.colegio.model.BarraNavegacion"%>
<%@page import="java.util.List"%>
<%@page import="com.colegio.model.Alumno"%>
<%@page import="com.colegio.model.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header>
    <section class="bienvenido">
        <div class="container">
            <%
                Integer idPerfil = (Integer)session.getAttribute("idPerfilUsu");
                if(idPerfil == 1 | idPerfil == 2){
                    Empleado usuario = (Empleado)session.getAttribute("usuario");

            %>
                <a class="navbar-brand">Bienvenido, <%=usuario.getNombre()%> <%=usuario.getApellido()%></a>
            <%
                } else {
            %>
            <%
                Alumno usuario = (Alumno)session.getAttribute("usuario");
            %>
                
                <a class="navbar-brand">Bienvenido, <%=usuario.getNombre()%> <%=usuario.getApellido()%></a>
            <%
                }
            %>
            
        </div>
    </section>
    <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container">
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <%
                    
                    Integer opcSelect = (Integer)session.getAttribute("opcSelect");
                    int select = 1;

                    List<BarraNavegacion> barraNav = (List<BarraNavegacion>) session.getAttribute("barraNav");

                    for (BarraNavegacion objBarNav : barraNav) {
                        if(select == opcSelect){
                    %>
                            <li class="nav-item active">
                        <%
                        } else {
                            
                        %>
                            <li class="nav-item">
                        <%
                        }
                        %>
                                <a class="nav-link" href="<%=objBarNav.getNomControlador()%>"><%=objBarNav.getNomOpcion()%></a>
                            </li>
                    <%
                        select++;
                    } 
                    %>
                </ul>
                <form class="form-inline my-2 my-lg-0" method="post" action="LoginController">
                    <input type="hidden" id="hddidCurso" name="cerrarSesion" value="1"/>

                    <button class="btn btn-outline-danger my-2 my-sm-0" type="submit">
                            <i class="fas fa-sign-out-alt"></i> Cerrar Sesión
                    </button>

                </form>
            </div>
        </div>
    </nav>
</header>