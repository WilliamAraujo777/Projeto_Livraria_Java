<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Livraria Projeto Base</title>
<link rel="icon" href="imagens/livros.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar Livro</h1>
	<form name="frmLivro" action="updateLivro">
		<table>
			<tr>
				<td><input type="number" name="idLivro" id="campos2" readonly 
				value="<%out.print(request.getAttribute("idLivro"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nomeLivro" class="campos" value="<%out.print(request.getAttribute("nomeLivro"));%>"></td>
			</tr>
			<tr>
				<td><input type="number" name="isbn" class="campos" value="<%out.print(request.getAttribute("isbn"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="dataPub" class="campos" value="<%out.print(request.getAttribute("dataPub"));%>"></td>
			</tr>
			<tr>
				<td><input type="number" step="0.01" name="preco" step="0.01" class="campos" value="<%out.print(request.getAttribute("preco"));%>"></td>
			</tr>

			<tr>
				<td><input type="number" name="qtdPag" class="campos" value="<%out.print(request.getAttribute("qtdPag"));%>"> </td>
			</tr> 
		</table>
		<input type="button" value="Salvar" class="botao1" onClick="validarLivro()">
		<a href="livros" class="botao1">Voltar</a>
	</form>

	<script src="scripts/validaLivro.js"></script>

</body>
</html>