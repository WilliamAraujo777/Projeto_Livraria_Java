<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@ page import= "model.beans.Assunto" %> 
    <%@ page import= "java.util.ArrayList" %>
    <%
    @SuppressWarnings("unchecked")	
    ArrayList<Assunto> listaAssuntos = (ArrayList<Assunto>) request.getAttribute("assuntos");
    %>
    
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Assuntos</title>
<link rel="icon" href="imagens/livros.png"> 
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Assuntos</h1>
	
	
	<a href="assunto/novoAssunto.html" class="botao1">Novo Assunto</a>
	<a href="main" class="botao1">Menu</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome do assunto</th>
			</tr>
		</thead>
		
		<tbody>
			<%for (int i = 0; i < listaAssuntos.size(); i++){%>
		    	<tr>
		    		<td><%=listaAssuntos.get(i).getIdAssunto()%></td>
		    		<td><%=listaAssuntos.get(i).getAssunto()%></td>
		 
		    	</tr>
		    <%}%>
		</tbody>		
	</table>
	
	
</body>
</html>