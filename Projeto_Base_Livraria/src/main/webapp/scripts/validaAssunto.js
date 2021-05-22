
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

function confirmar(idAssunto){
	let resposta = confirm("Confirma a exclusão deste assunto? (LEMBRANDO QUE TODOS OS LIVROS RELACIONADOS A ESTE ASSUNTO TAMBÉM SERÃO APAGADOS!!)")
	if(resposta === true){
		window.location.href = "deleteAssunto?idAssunto=" + idAssunto
	}
	
}