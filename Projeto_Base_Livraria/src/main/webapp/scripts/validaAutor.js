
/**
 * Validação de formulário
	@author William Araujo
 */

function validarAutor(){
	let nomeAutor = frmAutor.nomeAutor.value

	
	if(nomeAutor === "" ){
		alert('Preencha o nome do autor!')
		frmAutor.nomeAutor.focus()
		return false
	}else{
		document.forms["frmAutor"].submit()
	}
}