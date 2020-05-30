<%-- 
    Document   : horario
    Created on : 29-may-2020, 2:33:30
    Author     : AnrrydMW
--%>

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
        <title>Horario</title>
    </head>
    <body>
        
       <%@include file="header.jsp" %>

        <%@include file="bienvenida.jsp" %>

        <br>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th scope="col"class="text-light badge-dark text-center">HORA</th>
                    <th scope="col"class="text-light badge-dark text-center">LUNES</th>
                    <th scope="col"class="text-light badge-dark text-center">MARTES</th>
                    <th scope="col"class="text-light badge-dark text-center">MIERCOLES</th>
                    <th scope="col"class="text-light badge-dark text-center">JUEVES</th>
                    <th scope="col"class="text-light badge-dark text-center">VIERNES</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="text-center">08:00 - 9:00</td>
                    <td class="text-center">Matematica</td>
                    <td class="text-center">Religion</td>
                    <td class="text-center">Educacion Fisica</td>
                    <td class="text-center">Computacion</td>
                    <td class="text-center">Ciencias</td>
                </tr>
                <tr>
                    <td class="text-center">09:00 - 10:00</td>
                    <td class="text-center">Matematica</td>
                    <td class="text-center">Lenguaje</td>
                    <td class="text-center">Educacion Fisica</td>
                    <td class="text-center">Matematica</td>
                    <td class="text-center">Lenguaje</td>

                </tr>
                <tr>
                   <td class="text-center">10:00 - 11:00</td>
                    <td class="text-center">Lenguajea</td>
                    <td class="text-center">Lenguaje</td>
                    <td class="text-center">Ingles</td>
                    <td class="text-center">Matematica</td>
                    <td class="text-center">Matematica</td>
                </tr>
                <tr>
                    <td class="text-center">11:00 - 11:30</td>
                    <td class="text-center">Recreo</td>
                    <td class="text-center">Recreo</td>
                    <td class="text-center">Recreo</td>
                    <td class="text-center">Recreo</td>
                    <td class="text-center">Recreo</td>
                </tr>
                <tr>
                    <td class="text-center">11:30 - 12:30</td>
                    <td class="text-center">Ingles</td>
                    <td class="text-center">Ciencias</td>
                    <td class="text-center">Tutotia</td>
                    <td class="text-center">Aleman</td>
                    <td class="text-center">Matematica</td>
                </tr>
                <tr>
                    <td class="text-center">12:30 - 13:00</td>
                    <td class="text-center">Ingles</td>
                    <td class="text-center">Ciencias</td>
                    <td class="text-center">Computacion</td>
                    <td class="text-center">Aleman</td>
                    <td class="text-center">Matematica</td>
                </tr>
                
            </tbody>
        </table>
        
         <%@include file="footer.jsp" %>
        
    </body>
    <!-- jQuery first, then Popper.js, then Bootstrap JS, Fontawesome -->
    <script src="Scripts/jquery/jquery-3.5.1.slim.min.js"></script>
    <script src="Scripts/bootstrap/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/709cccdb82.js" crossorigin="anonymous"></script>
</html>
