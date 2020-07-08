<%@page import="com.colegio.model.Curso"%>
<%@page import="com.colegio.model.PeriodoEscolar"%>
<%@page import="com.colegio.model.Calificacion"%>
<%@page import="com.colegio.model.Grado"%>
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
        <script src="Scripts/jquery/jquery-3-5-1.js" type="text/javascript"></script>
        
        <!-- Nuestro css-->
        <link rel="stylesheet" type="text/css" href="Content/css/estilos.css" th:href="@{Content/css/estilos.css}">
        <link rel="icon" type="image/jpg" href="Content/img/login-avatar.png">
        <title>Colegio</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main role="main" class="flex-shrink-0">
            <div class="container">
                <%
                String operacion = (String)request.getAttribute("operacion"); 
                %>
                <input type="hidden" id="operacion" name="operacion" value="<%=operacion%>"/>
                <br>
                <form action="CalificacionController" method="post">
                    <div class="form-row justify-content-start form-inline">
                        <div class="col-auto my-1">
                            Selec. Grado:
                            <%
                            List<Grado> listaGrados = (List<Grado>)request.getAttribute("listaGrados"); 
                            %>
                            <select class="form-control" id="selectGradoCal" name="idGrado" required>
                                <option value="-1">Selec. grado</option> 
                                <%
                                for (Grado objGrado : listaGrados) {
                                    String idGrado = (String)request.getAttribute("idGrado");
                                    if(idGrado.equals(objGrado.getId_grado())){ 

                                %>
                                        <option value="<%=objGrado.getId_grado()%>" selected><%=objGrado.getGrado()%></option>
                                    <%
                                    } else {
                                    %>
                                        <option value="<%=objGrado.getId_grado()%>"><%=objGrado.getGrado()%></option>
                                    <%
                                    }
                                    %>   
                                <%
                                }
                                %>
                            </select>
                        </div>
                        <div class="col-auto my-1">
                            Selec. Curso:
                            <select class="form-control" id="selectCurso" name="txtIdCurso" required>
                            <%
                            if(request.getAttribute("listaCursoGrado")!= null){
                                List<Curso> listaCursoGrado = (List<Curso>)request.getAttribute("listaCursoGrado");
                            %>
                                        <option value="-1">Selec. curso</option> 
                                    <%
                                    for (Curso objCurso : listaCursoGrado) {
                                        String idCurso = (String)request.getAttribute("idCurso");
                                        if(idCurso.equals(objCurso.getId_curso())){
                                    %>
                                           
                                            <option value="<%=objCurso.getId_curso()%>" selected=""><%=objCurso.getNombre()%></option>
                                        <%
                                        } else {
                                        %>
                                            <option value="<%=objCurso.getId_curso()%>"><%=objCurso.getNombre()%></option>
                                        <%
                                        }
                                        %> 
                                    <%
                                    }
                                    %>
                            </select>
                            <%
                            }else{
                            %>
                                <option value="-1">Seleccionar curso</option>    
                            <%
                            }
                            %>
                            </select>
                        </div>
                        <div class="col-auto my-1">
                            Selec. Trimestre:
                            <select class="form-control" id="selectTrimestre" name="idPerEscolar" required>
                            <%
                            if(request.getAttribute("listaPerEscolar")!= null){
                                List<PeriodoEscolar> listaPerEscolar = (List<PeriodoEscolar>)request.getAttribute("listaPerEscolar"); 
                            %>
                                        <option value="-1">Selec. Trimestre</option> 
                                    <%
                                    for (PeriodoEscolar objPerEscolar : listaPerEscolar) {
                                        Integer idPerEscolar = Integer.parseInt((request.getParameter("idPerEscolar") != null)?request.getParameter("idPerEscolar"):"0");
                                        if(idPerEscolar == objPerEscolar.getId_periodoEscolar()){
                                    %>
                                            <option value="<%=objPerEscolar.getId_periodoEscolar()%>" selected><%=objPerEscolar.getNombre()%></option>
                                        <%
                                        } else {
                                        %>
                                            <option value="<%=objPerEscolar.getId_periodoEscolar()%>"><%=objPerEscolar.getNombre()%></option>
                                        <%
                                        }
                                        %> 
                                    <%
                                    }
                                    %>
                            </select>
                            <%
                            }else{
                            %>
                                <option value="-1">Seleccionar Trimestre</option>    
                            <%
                            }
                            %>
                            </select>
                        </div>    
                        <div class="col-auto my-1 ml-auto">
                            <button type="submit" class="btn btn-dark">
                                <i class="fas fa-search"></i>Buscar
                            </button>
                        </div>
                    </div>
                </form>
                <br>
                <br>
                
            </div>
        </main>
        <script src="Scripts/jswebapp/frmCalificacion.js" type="text/javascript"></script>
        <%@include file="footer.jsp" %>
    </body>
</html>