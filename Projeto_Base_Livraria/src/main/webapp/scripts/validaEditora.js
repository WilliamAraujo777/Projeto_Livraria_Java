
/**
 * Validação de formulário
	@author William Araujo
 */

function validarEditora(){
	let nomeEditora = frmEditora.nomeEditora.value
	
	if(nomeEditora === "" ){
		alert('Preencha o nome da editora!')
		frmEditora.nomeEditora.focus()
		return false
	}else{
		document.forms["frmEditora"].submit()
	}
}