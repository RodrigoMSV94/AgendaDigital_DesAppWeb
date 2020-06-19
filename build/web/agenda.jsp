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
                <form>
                    <div class="form-row justify-content-start">
                        <div class="col-auto my-1">
                            <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Preference</label>
                            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                                <option value="1" selected>Marzo</option>
                                <option value="2">Abril</option>
                                <option value="3">Mayo</option>
                            </select>
                        </div>
                        <div class="col-auto my-1">
                            <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Preference</label>
                            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                                <option value="1" selected>1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
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
                <div class="card">
                    <div class="card-header">
                        TAREAS EN LOS CURSOS:
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">Curso:</h5>
                        <p class="card-text">Nota: </p>
                    </div>

                </div>
                <br>
                <div class="card">
                    <div class="card-header">
                        INCIDENCIAS EN LOS CURSOS:
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">Curso:</h5>
                        <p class="card-text">Observación: </p>
                    </div>
                </div>
                <br>
                <div class="card">
                    <div class="card-header">
                        CITACIONES EN LOS CURSOS:
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">Curso:</h5>
                        <p class="card-text">Tema a tratar: </p>
                    </div>
                </div>
                <br>
            </div>
        </main>

        <%@include file="footer.jsp" %>
    </body>
    <!-- jQuery first, then Popper.js, then Bootstrap JS, Fontawesome -->
    <script src="Scripts/jquery/jquery-3.5.1.slim.min.js"></script>
    <script src="Scripts/bootstrap/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/709cccdb82.js" crossorigin="anonymous"></script>
</html>