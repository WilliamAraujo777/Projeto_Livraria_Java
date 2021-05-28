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
	<h1>Editar Editora</h1>
	<form name="frmEditora" action="updateEditora">
		<table>
			<tr>
				<td><input type="number" name="idEditora" id="campos2" readonly 
				value="<%out.print(request.getAttribute("idEditora"));%>"></td>
			</tr>
			
			<tr>
				<td><input type="text" name="nomeEditora" class="campos" value="<%out.print(request.getAttribute("nomeEditora"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="botao1" onClick="validarEditora()">
		<a href="editoras" class="botao1">Voltar</a>
	</form>

	<script src="scripts/validaEditora.js">
		
	</script>

</body>
</html>