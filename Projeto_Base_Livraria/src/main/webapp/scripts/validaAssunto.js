
/**
 * Validação de formulário
	@author William Araujo
 */

function validarAssunto(){
	let nomeAssunto = frmAssunto.nomeAssunto.value
	
	if(nomeAssunto === "" ){
		alert('Preencha o nome do assunto!')
		frmAssunto.nomeAssunto.focus()
		return false
	}else{
		document.forms["frmAssunto"].submit()
	}
}