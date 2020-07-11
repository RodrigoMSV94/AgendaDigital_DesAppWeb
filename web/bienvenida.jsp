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
            <div class="card">
                    <br>
                    <img class="card-img-top" src="Scripts/jswebapp/Logo-Colegios.png" 	width="304" height="330" />
                    <br>
                    <div class="card-body">
                      <p class="card-text">Somos una compañía de Tecnología de Información, especializada en brindar Soluciones Tecnológicas para Integración de Sistemas, 
                      Transferencia Electrónica de Fondos, Terminales de Pago y Autoservicio, Equipos Criptográficos, Banca Celular y Simulación de Sistemas Transaccionales. 
                      Ofrecemos Servicios de Gestión de Proyectos, Desarrollo y Testing de Software, Capacitación Empresarial y Soporte TIC para los sectores Retail, Financiero, 
                      Transporte, Salud, Servicios y Telecomunicaciones.</p>
                    </div>
                  </div>
                  <br>
          </div>
        </main>
        
        <%@include file="footer.jsp" %>
    </body>
    
</html>
