<%-- 
    Document   : rolexamenes
    Created on : 29-may-2020, 1:58:34
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
        <title>RolExamenes</title>
    </head>
    <body>

        <%@include file="header.jsp" %>

        <%@include file="bienvenida.jsp" %>

        <br>
        <section class="active">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link text-dark" href="#">Bimestre: <span class="sr-only"></span></a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                Primero
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Segundo</a>
                                <a class="dropdown-item" href="#">Tercero</a> 
                                <a class="dropdown-item" href="#">Cuarto</a>
                            </div>

                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Buscar" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
                    </form>
                </div>
            </nav>
        </section>
        <br>

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th scope="col"class="text-light badge-dark text-center">FECHA</th>
                    <th scope="col"class="text-light badge-dark text-center">CURSO</th>
                    <th scope="col"class="text-light badge-dark text-center">HORA</th>
                    <th scope="col"class="text-light badge-dark text-center">PROFESOR</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="text-center">05/MAY/2020</td>
                    <th class="text-center" scope="row">Matematica</th>
                    <td class="text-center">08:30 a.m.</td>
                    <td class="text-center">Mario Hernandez</td>
                </tr>
                <tr>
                    <td class="text-center">06/MAY/2020</td>
                    <th class="text-center" scope="row">Lenguaje</th>
                    <td class="text-center">09:30 a.m.</td>
                    <td class="text-center">Claudia Cortez</td>
                </tr>
                <tr>
                    <td class="text-center">07/MAY/2020</td>
                    <th class="text-center" scope="row">Ciencias</th>
                    <td class="text-center">10:30 a.m.</td>
                    <td class="text-center">Pablo Mendoza</td>
                </tr>
                <tr>
                    <td class="text-center">08/MAY/2020</td>
                    <th class="text-center" scope="row">Personal Social</th>
                    <td class="text-center">11:30 a.m.</td>
                    <td class="text-center">Jaime Alba</td>
                </tr>
                <tr>
                    <td class="text-center">09/MAY/2020</td>
                    <th class="text-center" scope="row">Ingles</th>
                    <td class="text-center">12:30 a.m.</td>
                    <td class="text-center">Roberto Herrera</td>
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
