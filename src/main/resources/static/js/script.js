$(document).ready(function () {
    listar();

});
function listar() {
    $.ajax({
        url: "/editorial/all",
        type: 'GET',
        success: function (x) {
            
            $("#tablita tbody tr").remove();
            for (var i = 0; i < x.length; i++) {
                $("#tablita").append(
                        "<tr><td>" + (i + 1) + "</td><td>" + x[i].id + "</td><td>" + x[i].nombre
                        + "</td><td>" + x[i].pais + "</td><td>" + x[i].estado + "</td><td> <a href='#' \n\
                        onclick='editar(" + x[i].id + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].id + ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");
            }
        }
    });
}
function editar(id) {
    $.ajax({
        url: "/editorial/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_nombre").val(w.nombre);
            $("#editar_pais").val(w.pais);
            $("#editar_estado").val(w.estado);
            $("#ideditorial").val(w.ideditorial);
        }
    });
    $("#modalEditar").modal('show');
}
function eliminar(id) {

    bootbox.confirm({
        message: "Realmente desea Eliminar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/editorial/" + id,
                    type: 'DELETE',
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro eliminado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        listar();
                    }
                });
            } else {
                bootbox.alert({
                    message: "Registro no eliminado!",
                    size: 'small'
                });
            }
        }
    });
}
$("#guardar").click(function () {
    var nombre = $("#nombre").val();
    var pais = $("#pais").val();
    var estado = $("#estado").val();
    
    $.ajax({
        url: "/editorial/add",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({'nombre': nombre, 'pais': pais,'estado': estado }),
        cache: false,
        success: function (w) {
            bootbox.alert({
                message: "Registro guardado correctamente...!",
                callback: function () {
                    console.log('This was logged in the callback!');
                }
            });
            limpiar();
            listar();
        }
    });
    $("#modalGuardar").modal('hide');
});
function limpiar() {
    $("#nombre").val("");
    $("#pais").val("");
    $("#estado").val("");
}
$("#modificar").click(function () {
    var nombre = $("#editar_nombre").val();
    var pais = $("#editar_pais").val();
    var estado = $("#editar_estado").val();
    var id = $("#ideditorial").val();
    bootbox.confirm({
        message: "Realmente desea Modificar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/editorial/edit",
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({'ideditorial': id, 'nombre': nombre, 'pais': pais, 'estado': estado}),
                    cache: false,
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro Modificado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        limpiar();
                        listar();
                    }
                });
                $("#modalEditar").modal('hide');
            } else {
                bootbox.alert({
                    message: "Registro no Modificado!",
                    size: 'small'
                });
            }
        }
    });
});