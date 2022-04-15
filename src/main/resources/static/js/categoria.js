$(document).ready(function(){

	$('body').on('click', '.editarCategoria', function(){

    $('#id').val($(this).attr('id'));

    $('#txtcategoria_nombre').val($(this).attr('param1'));

    $('#editarCategoria').modal({show: true});

    return false;

  });

});