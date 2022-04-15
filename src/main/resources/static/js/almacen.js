$(document).ready(function(){
	$('body').on('click', '.editarAlmacen', function(){
    $('#id').val($(this).attr('id'));
    $('#cbotienda option:selected').removeAttr('selected');
    $('#cbotienda option[value='+$(this).attr('param1')+']').attr("selected",true);
    $('#txtNombrealmacen').val($(this).attr('param2'));
    $('#txtDireccionAlmacen').val($(this).attr('param3'));
    $('#txttelefono').val($(this).attr('param4'));    
    $('#txttipo').val($(this).attr('param5'));
 	
    $('#editarAlmacen').modal({show: true});
    return false;
  });
});