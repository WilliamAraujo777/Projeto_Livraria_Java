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
	<h1>Editar Autor</h1>
	<form name="frmEditora" action="updateEditora">
		<table>
			<tr>
				<td><input type="number" name="idAutor" id="campos2" readonly 
				value="<%out.print(request.getAttribute("idAutor"));%>"></td>
			</tr>
				<td><input type="text" name="nomeAutor" class="campos" value="<%out.print(request.getAttribute("nomeAutor"));%>"></td>
				<td><input type="text" name="SobrenomeAutor" class="campos" value="<%out.print(request.getAttribute("SobrenomeAutor"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="botao1" onClick="validarAutor()">
		<a href="autores" class="botao1">Voltar</a>
	</form>

	<script src="scripts/validaAutor.js">
		
	</script>

</body>
</html>