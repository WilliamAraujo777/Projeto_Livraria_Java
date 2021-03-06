
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@ page import= "model.beans.Editora" %> 
    <%@ page import= "model.beans.Assunto" %> 
     <%@ page import= "model.beans.Autores" %> 
    <%@ page import= "model.DAO.EditoraDAO" %> 
     <%@ page import= "model.DAO.AutorDAO" %> 
    <%@ page import= "model.DAO.AssuntoDAO" %> 
    <%@ page import= "java.util.ArrayList" %>
    <%
    EditoraDAO editDAO = new EditoraDAO();
                	AssuntoDAO assuntoDAO = new AssuntoDAO();
                	AutorDAO autorDAO = new AutorDAO();
    %>
    
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Livraria Projeto Base</title>
<link rel="icon" href="../imagens/livros.png">
<link rel="stylesheet" href="../style.css">
<link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
</head>
<body>
	<h1>Inserir um novo livro</h1>
	<form name="frmLivro" action="../insertLivro">
		<table>
			<tr>
				<td><input type="text" name="nomeLivro" placeholder="Nome do livro" class="campos"></td>
			</tr>
			<tr>
				<td><input type="number" name="isbn" placeholder="ISBN13" class="campos"></td>
			</tr>
			<tr>
				<td><input type="text" name="dataPub" class="campos"></td>
			</tr>
			<tr>
				<td><input type="number" step="0.01" name="preco" step="0.01" placeholder="Preco do Livro" class="campos"></td>
			</tr>
			
			<tr>
				<td><input type="number" name="qtdPag" placeholder="Quantidade de paginas" class="campos"></td>
			</tr>
			
			 <tr>
				<td>
				<select id="select2" name="nomeEdit">
				<option>
				<%for (Editora edit: editDAO.listarEditora()){%>
				<option value=<%=edit.getIdEditora()%>><%=edit.getEditora()%></option>
				<%}%> 
				</select>
				</td>
			</tr>
			
			<tr>
				<td>
				<select id="select3" name="nomeAssunto">
				<option>
				<%for (Assunto assunto: assuntoDAO.listarAssunto()){%>
				<option value=<%=assunto.getIdAssunto()%>><%=assunto.getAssunto()%></option>
				<%}%> 
				</select>		
				</td>
			</tr> 
		</table>
		<input type="button" value="Adicionar" class="botao1" onClick="validarLivro()">

		<a href="../livros" class="botao1">Voltar</a>
	</form>
	
<script src="../scripts/validaLivro.js"> </script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
<script>
$(document).ready(function() {
$('#select2').select2({
    placeholder: "Selecione uma editora",
    allowClear: true
 
})
$('#select3').select2({
    placeholder: "Selecione um assunto",
    allowClear: true
 
})
});
</script>

</body>
</html>