$(document).ready(function(){

	$('body').on('click', '.editarEmpleado', function(){

    $('#id').val($(this).attr('id'));

    $('#txtNombre').val($(this).attr('param1'));

    $('#txtDescripcion').val($(this).attr('param2'));
    
    $('#txtTelefono').val($(this).attr('param3'));



    $('#editarEmpleado').modal({show: true});

    return false;

  });

});