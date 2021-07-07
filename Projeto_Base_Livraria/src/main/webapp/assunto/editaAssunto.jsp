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
	<h1>Editar Assunto</h1>
	<form name="frmAssunto" action="updateAssunto">
		<table>
			<tr>
				<td><input type="number" name="idAssunto" id="campos2" readonly 
				value="<%out.print(request.getAttribute("idAssunto"));%>"></td>
			</tr>
			
			<tr>
				<td><input type="text" name="nomeAssunto" class="campos" value="<%out.print(request.getAttribute("nomeAssunto"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="botao1" onClick="validarAssunto()">
		<a href="assuntos" class="botao1">Voltar</a>
	</form>

	<script src="scripts/validaAssunto.js">
		
	</script>

</body>
</html>