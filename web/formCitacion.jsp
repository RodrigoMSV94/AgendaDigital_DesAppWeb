<%@page import="com.colegio.model.Citacion"%>
<%@page import="com.colegio.model.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Fonts Google -->
        <link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300;400;600&display=swap" rel="stylesheet">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="Content/bootstrap/bootstrap.min.css">

        <!-- Nuestro css-->
        <link rel="stylesheet" type="text/css" href="Content/css/estilos.css" th:href="@{Content/css/estilos.css}">
        <link rel="icon" type="image/jpg" href="Content/img/login-avatar.png">
        <title>Colegio</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        
        <main role="main" class="flex-shrink-0">
            <div class="container">
                <br>
                <div class="card" >
                    <div class="card-header">
                        Registrar Inciencia
                    </div>
                    <div class="card-body">
                        <form method="post" action="CitacionController">
                            <%
                            if(request.getAttribute("objCitacion") == null){
                            %>
                                <div class="form-row">
                                    <div class="col">
                                        <label for="idAlumno">Estado de Registro:</label>
                                        <%
                                        List<Alumno> listaAlumnos = (List<Alumno>)request.getAttribute("listaAlumnos"); 
                                        %>
                                        <select class="form-control" id="idAlumno" name="idAlumno" required>
                                            <%
                                            for (Alumno objAlum : listaAlumnos) {
                                            %>
                                                <option value="<%=objAlum.getId_alumno()%>"><%=objAlum.getNombre()%> <%=objAlum.getApellido()%></option>
                                            <%
                                            }
                                            %>
                                        </select>
                                    </div>
                                    <div class="col">
                                    </div>
                                </div>
                                <br>
                                <div class="form-row">
                                    <div class="col">
                                        <label for="txtMotivo">Motivo de citación</label>
                                        <textarea class="form-control" id="txtMotivo" name="txtMotivo" rows="3"></textarea>
                                    </div>
                                    <div class="col">
                                         <label for="txtFechaCita">Fecha de citación:</label>
                                        <input type="Date" class="form-control" id="txtFechaCita" name="txtFechaCita" required>

                                        </select>
                                    </div>
                                </div>
                                <br>
                                <input type="hidden" id="operacion" name="operacion" value="Registrar"/>
                            <%
                            } else {
                                Citacion objCitacion = (Citacion)request.getAttribute("objCitacion");
                            %>
                                <div class="form-row">
                                    <div class="col">
                                        <label for="idAlumno">Estado de Registro:</label>
                                        <%
                                        List<Alumno> listaAlumnos = (List<Alumno>)request.getAttribute("listaAlumnos"); 
                                        %>
                                        <select class="form-control" id="idAlumno" name="idAlumno" required>
                                            <%
                                            for (Alumno objAlum : listaAlumnos) {
                                                if(objCitacion.getId_alumno().equals(objAlum.getId_alumno())){ 
                                            %>
                                                    <option value="<%=objAlum.getId_alumno()%>" selected><%=objAlum.getNombre()%> <%=objAlum.getApellido()%></option>
                                                <%
                                                } else {
                                                %>
                                                    <option value="<%=objAlum.getId_alumno()%>"><%=objAlum.getNombre()%> <%=objAlum.getApellido()%></option>
                                                <%
                                                }
                                                %>
                                            <%
                                            }
                                            %>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <input type="hidden" id="txtIdCita" name="txtIdCita" value="<%=objCitacion.getId_cita()%>"/>
                                    </div>
                                </div>
                                <br>
                                <div class="form-row">
                                    <div class="col">
                                        <label for="txtMotivo">Motivo de citación:</label>
                                        <textarea class="form-control" id="txtMotivo" name="txtMotivo" rows="3" value=""><%=objCitacion.getMotivo()%></textarea>
                                    </div>
                                    <div class="col">
                                        <label for="txtFechaCita">Fecha de citación</label>
                                        <input type="Date" class="form-control" id="txtFechaCita" name="txtFechaCita" value="<%=objCitacion.getFecha_cita()%>" required>
                                        </select>
                                    </div>
                                </div>
                                <br>
                                <input type="hidden" id="operacion" name="operacion" value="Actualizar"/>
                            <%
                            }    
                            %>
                            <br>
                            <button type="submit" class="btn btn-primary">Guardar</button>
                            <a class="btn btn-secondary" href="CitacionController?accion=0">Volver a lista</a>
                        </form>
                    </div>
                    <div class="container">
                    <%
                    if(request.getAttribute("respuesta") != null){
                        String colorAlert = (String)request.getAttribute("colorAlert");
                    %>
                        <div class="alert alert-<%=colorAlert%>" role="alert">
                            <%=request.getAttribute("respuesta")%>
                        </div>
                    <%
                    }
                    %>
                    </div>
                </div>
                <br>
            </div>
        </main>

        <%@include file="footer.jsp" %>
    </body>
</html>
