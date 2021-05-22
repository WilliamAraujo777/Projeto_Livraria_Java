
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

function confirmar(idAutor){
	let resposta = confirm("Confirma a exclusão deste autor?")
	if(resposta === true){
		window.location.href = "deleteAutor?idAutor=" + idAutor
	}
	
}