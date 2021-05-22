
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

function confirmar(idEditora){
	let resposta = confirm("Confirma a exclusão deste assunto? (LEMBRANDO QUE TODOS OS LIVROS RELACIONADOS A ESTA EDITORA TAMBÉM SERÃO APAGADOS!!)")
	if(resposta === true){
		window.location.href = "deleteEditora?idEditora" + idEditora
	}
	
}