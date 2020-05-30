<%-- 
    Document   : pensiones
    Created on : 29-may-2020, 2:47:06
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
        <title>Pensiones</title>
    </head>
    <body>
        <%@include file="header.jsp" %>

        <%@include file="bienvenida.jsp" %>

        <br>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th scope="col"class="text-light badge-dark text-center">ITEM</th>
                    <th scope="col"class="text-light badge-dark text-center">DESCRIPCION</th>
                    <th scope="col"class="text-light badge-dark text-center">MONTO</th>
                    <th scope="col"class="text-light badge-dark text-center">VENCIMIENTO</th>
                    <th scope="col"class="text-light badge-dark text-center">ESTADO</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="text-center">00000001</td>
                    <td class="text-center">Cuota 01</td>
                    <td class="text-center">S/. 400.00</td>
                    <td class="text-center">31/03/2020</td>
                    <td class="text-center">Pagado</td>
                </tr>
                <tr>
                    <td class="text-center">00000002</td>
                    <td class="text-center">Cuota 02</td>
                    <td class="text-center">S/. 400.00</td>
                    <td class="text-center">30/04/2020</td>
                    <td class="text-center">Pagado</td>
                </tr>
                <tr>
                    <td class="text-center">00000003</td>
                    <td class="text-center">Cuota 03</td>
                    <td class="text-center">S/. 400.00</td>
                    <td class="text-center">31/05/2020</td>
                    <td class="text-center">Pendiente</td>
                </tr>
                <tr>
                    <td class="text-center">00000004</td>
                    <td class="text-center">Cuota 04</td>
                    <td class="text-center">S/. 400.00</td>
                    <td class="text-center">30/06/2020</td>
                    <td class="text-center">Pendiente</td>
                </tr>
                <tr>
                    <td class="text-center">00000005</td>
                    <td class="text-center">Cuota 05</td>
                    <td class="text-center">S/. 400.00</td>
                    <td class="text-center">31/07/2020</td>
                    <td class="text-center">Pendiente</td>
                </tr>
                <tr>
                    <td class="text-center">00000006</td>
                    <td class="text-center">Cuota 06</td>
                    <td class="text-center">S/. 400.00</td>
                    <td class="text-center">30/08/2020</td>
                    <td class="text-center">Pendiente</td>
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
