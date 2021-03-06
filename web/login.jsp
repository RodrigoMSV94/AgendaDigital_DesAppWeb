<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Los iconos tipo Solid de Fontawesome-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="Content/bootstrap/bootstrap.min.css">

        <!-- Nuestro css-->
        <link rel="stylesheet" type="text/css" href="Content/css/login.css" th:href="@{Content/css/login.css}">

        <link rel="icon" type="image/jpg" href="Content/img/login-avatar.png">
        <title> Colegio - Inicio sesión</title>
    </head>
    <body>
        <div class="modal-dialog text-center ">
            <div class="col-sm-8 main-section">
                <div class="modal-content">
                    <div class="col-12 user-img">
                        <img src="Content/img/login-avatar.png" alt="">
                    </div>
                    <form action="" class="col-12">
                        <div class="form-group" >
                            <select class="browser-default custom-select " id="select-group">

                                <option value="1" selected>Alumno</option>
                                <option value="2">Docente</option>
                                <option value="3">Administrativo</option>
                            </select>
                        </div>
                        <div class="form-group" id="user-group">
                            <input type="text" class="form-control" placeholder="Correo electrónico">
                        </div>
                        <div class="form-group" id="contrasena-group">
                            <input type="password" class="form-control" placeholder="Contraseña">
                        </div>
                        <button type="submit" class="btn btn-success"><i class="fas fa-sign-in-alt"></i>  Ingresar</button>
                    </form>
                    <div th:if="${param.error}" class="alert alert-danger" role="alert">
                        Correo o contraseña invalido.
                    </div>
                </div>
            </div>
        </div>
    </body>
    <!-- jQuery first, then Popper.js, then Bootstrap JS, Fontawesome-->
    <script src="Scripts/jquery/jquery-3.5.1.slim.min.js"></script>
    <script src="Scripts/bootstrap/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
</html>