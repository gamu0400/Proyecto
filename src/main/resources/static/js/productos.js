$(document).ready(function(){
	$('body').on('click', '.editarProductos', function(){
    $('#id').val($(this).attr('id'));
    $('#txtMarca').val($(this).attr('param1'));
    $('#txtNombre').val($(this).attr('param2'));
    $('#txtModelo').val($(this).attr('param3'));    
    $('#txtGenero').val($(this).attr('param4'));
    $('#txtPrecio').val($(this).attr('param5'));
    $('#txtDescripcion').val($(this).attr('param6'));
 	$('#cbocategoria option:selected').removeAttr('selected');
    $('#cbocategoria option[value='+$(this).attr('param7')+']').attr("selected",true);
    $('#editarProductos').modal({show: true});
    return false;
  });
});