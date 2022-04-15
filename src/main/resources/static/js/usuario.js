$(document).ready(function(){

    $('body').on('click', '.editarUsuario', function(){

    $('#id').val($(this).attr('id'));

    $('#txtNombre').val($(this).attr('param1'));

    $('#txtDireccion').val($(this).attr('param2'));

    $('#editarUsuario').modal({show: true});

    return false;

  });

});