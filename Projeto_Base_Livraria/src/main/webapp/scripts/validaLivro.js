
/**
 * Validação de formulário
 * @author William Araujo
 */

function validar(){
	let nomeLivro = frmLivro.nomeLivro.value
	let isbn = frmLivro.isbn.value
	let dataPub = frmLivro.dataPub.value
	let precoLivro = frmLivro.preco.value
	let qtdPag = frmLivro.qtdPag.value
	let nomeEdit = frmLivro.nomeEdit.value
	let nomeAssunto = frmLivro.nomeAssunto.value
	
	if(nomeLivro === "" ){
		alert('Preencha o nome do livro!')
		frmLivro.nomeLivro.focus()
		return false
	}else if (isbn === ""){
		alert('Preencha o campo ISBN13!')
		frmLivro.isbn.focus()
		return false
	} else if (dataPub === ""){
		alert('Preencha o campo data de publicação!')
		frmLivro.dataPub.focus()
		return false
	}else if (precoLivro === ""){
		alert('Preencha o campo preço do livro!')
		frmLivro.precoLivro.focus()
		return false
	}else if (qtdPag === ""){
		alert('Preencha as quantidades de páginas!')
		frmLivro.qtdPag.focus()
		return false
	}else if (nomeEdit === ""){
		alert('Preencha o campo de editora!')
		frmLivro.nomeEdit.focus()
		return false
	}else if (nomeAssunto === ""){
		alert('Preencha o campo de assunto!')
		frmLivro.nomeAssunto.focus()
		return false
	}else{
		document.forms["frmLivro"].submit()
	}
}

function confirmar(idLivro){
	let resposta = confirm("Confirma a exclusão deste livro?")
	if(resposta === true){
		window.location.href = "deleteLivro?idLivro=" + idLivro
	}
	
}