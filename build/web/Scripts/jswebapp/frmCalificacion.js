$('#selectGradoCal').change(function(){
    console.log("Entro aca");
    var gradoSelect = $("#selectGradoCal").val();
    var urlCarCurso = "http://localhost:8084/AgendaDigital/CalificacionController?";
    //var gradoSelect = $("#selectGrado").val();
    
    urlCarCurso += "idGrado=" + gradoSelect;
    alert("idGrado: " + gradoSelect)
    location.assign(urlCarCurso);
});

$(document).on("click","#btnGuardarCal",function(){
   var idsAlumnos = [];
   var nomsAlumnos = [];
   var notaPc1s = [];
   var notaPc2s = [];
   var notaPc3s = [];
   var notaExFins = [];
   var selectTrimestre = document.getElementById("selectTrimestre").value;
   var selectCurso = document.getElementById("selectCurso").value;
   var operacion = $("#operacion").val();

    $("#tabla tbody tr").each(function (index) {
        var idAlumno,nomAlumno,pc1,pc2,pc3,exfinal;
        
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
    
    $("tr").each(function() {
        var pc1 = $(this).find("input.pc1").val(); 
        notaPc1s.push(pc1);
    });

    $("tr").each(function() {
        var pc2 = $(this).find("input.pc2").val(); 
        notaPc2s.push(pc2);
    });
    
    $("tr").each(function() {
        var pc3 = $(this).find("input.pc3").val(); 
        notaPc3s.push(pc3);
    });
    
    $("tr").each(function() {
        var exfinal = $(this).find("input.exf").val(); 
        notaExFins.push(exfinal);
    });
    
    var n1 = notaPc1s.filter(Boolean);
    var n2 = notaPc2s.filter(Boolean);
    var n3 = notaPc3s.filter(Boolean);
    var nef = notaExFins.filter(Boolean);
    
    notaPc1s = n1;
    notaPc2s = n2;
    notaPc3s = n3;
    notaExFins = nef;

    alert(idsAlumnos);
    alert(nomsAlumnos);
    alert(notaPc1s);
    alert(notaPc2s);
    alert(notaPc3s);
    alert(notaExFins);
    
    $.ajax({
        type:"POST",
        url:"/AgendaDigital/CalificacionController",
        dataType:"json",
        data: {idsAlumnos:idsAlumnos,notaPc1s:notaPc1s,notaPc2s:notaPc2s,notaPc3s:notaPc3s,notaExFins:notaExFins,selectTrimestre:selectTrimestre,selectCurso:selectCurso,operacion:operacion},
        success:function(data){
            alert(data);
        },
    });    

});
