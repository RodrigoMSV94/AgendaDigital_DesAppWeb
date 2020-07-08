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
   var idsCursos = [];
   var nomsCursos = [];
   var notaPc1s = [];
   var notaPc2s = [];
   var notaPc3s = [];
   var notaExFins = [];
   //var selectGrado = document.getElementById("selectGrado").value;
   //var selectCurso = document.getElementById("selectCurso").value;
   //var operacion = $("#operacion").val();

    $("#tabla tbody tr").each(function (index) {
        var idCurso,nomCurso,pc1,pc2,pc3,exfinal;
        
        $(this).children("td").each(function (index2) {
            switch (index2) {
                case 0:
                    idCurso = $(this).text();
                    idsCursos.push(idCurso);
                    break;
                case 1:
                    nomCurso = $(this).text();
                    nomsCursos.push(nomCurso);
                    break;
                case 2:
                    pc1 = $(this).text();
                    notaPc1s.push(pc1);
                    break;
                case 3:
                    pc2 = $(this).text();
                    notaPc2s.push(pc2);
                    break;
                case 4:
                    pc3 = $(this).text();
                    notaPc3s.push(pc3);
                    break;
                case 5:
                    exfinal = $(this).text();
                    notaExFins.push(exfinal);
                    break; 
            }
        })
    })

    alert(idsCursos);
    alert(nomsCursos);
    alert(notaPc1s);
    alert(notaPc2s);
    alert(notaPc3s);
    alert(notaExFins);
});
