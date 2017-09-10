$('#modalConfirmDelete').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget)
  var id = button.data('id')
 
  var modal = $(this)

  var form = modal.find('form');
  var action = form.data('base-url');
  var c = button.data('model');
  
  if(!action.endsWith('/')){
	  action += '/';
  }
  
  form.attr('action', action + c + "/" + id);
  
})