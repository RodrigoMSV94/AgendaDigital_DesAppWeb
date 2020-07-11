$('#selectGrado').change(function(){
    var gradoSelect = $("#selectGrado").val();
    var urlCarCurso = "http://localhost:8084/AgendaDigital/AsistenciaController?" + "idGrado=" + gradoSelect;
    location.assign(urlCarCurso);
})


$(document).on("click","#btnGuardar",function(){
   var idsAlumnos = [];
   var nomsAlumnos = [];
   var asisAlumnos = [];
   var selectGrado = document.getElementById("selectGrado").value;
   var selectCurso = document.getElementById("selectCurso").value;
   var operacion = $("#operacion").val();

    $("#tabla tbody tr").each(function (index) {
        var idAlumno, nomAlumno, asistio,cod;
        
        $(this).children("td").each(function (index2) {
            
            
            switch (index2) {
                case 0:
                    idAlumno = $(this).text();
                    idsAlumnos.push(idAlumno);
                    break;
                case 1:
                    nomAlumno = $(this).text();
                    nomsAlumnos.push(nomAlumno);
                    break;
            }
        })
    })
    alert("Se registro la asistencia con exito");
    $("input[type=checkbox]").each(function(){
        if (this.checked) {

            asis = "1";
        }else{
            asis = "0";
        }
        asisAlumnos.push(asis);
    })

    $.ajax({
        type:"POST",
        url:"/AgendaDigital/AsistenciaController",
        dataType:"json",
        data: {idsAlumnos:idsAlumnos,nomsAlumnos:nomsAlumnos,asisAlumnos:asisAlumnos,selectGrado:selectGrado,selectCurso:selectCurso,operacion:operacion},
        success:function(data){
            alert(data);
        },
    });    


});

$(document).on("click","#btnTarea",function(){
    
    //var descripTarea = $("#txtDesTarea").text();
    var descripcionTarea = $("#txtDesTarea").val();
    var selectGrado = document.getElementById("selectGrado").value;
    var selectCurso = document.getElementById("selectCurso").value;
    var operTarea = $("#operTarea").val();
    alert("Se agrega la tarea con exitó");
    $.ajax({
        type:"POST",
        url:"/AgendaDigital/AsistenciaController",
        dataType:"json",
        data: {descripcionTarea:descripcionTarea,selectGrado:selectGrado,selectCurso:selectCurso,operTarea:operTarea},
        success:function(data){
            alert(data);
        }
    }); 
});