<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
