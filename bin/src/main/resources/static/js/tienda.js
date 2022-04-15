$(document).ready(function(){

	$('body').on('click', '.editarTienda', function(){

    $('#id').val($(this).attr('id'));

    $('#txtNombre').val($(this).attr('param1'));

    $('#txtDireccion').val($(this).attr('param2'));
	
	$('#txtTelefono').val($(this).attr('param3'));
	
	$('#txtDescripcion').val($(this).attr('param4'));

    $('#editarTienda').modal({show: true});

    return false;

  });

});