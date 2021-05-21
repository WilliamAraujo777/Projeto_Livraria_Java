<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@ page import= "model.beans.Autores" %> 
    <%@ page import= "java.util.ArrayList" %>
    <%
    @SuppressWarnings("unchecked")		
    ArrayList<Autores> listaAutores = (ArrayList<Autores>) request.getAttribute("autores");
    %>
    
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Autores</title>
<link rel="icon" href="imagens/livros.png"> 
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Autores</h1>
	
	
	<a href="autor/novoAutor.html" class="botao1">Novo Autor</a>
	<a href="main" class="botao1">Menu</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome do autor</th>
				<th>Sobrenome do autor</th>
			</tr>
		</thead>
		
		<tbody>
			<%for (int i = 0; i < listaAutores.size(); i++){%>
		    	<tr>
		    		<td><%=listaAutores.get(i).getIdAutor()%></td>
		    		<td><%=listaAutores.get(i).getNomeAutor()%></td>
		    		<td><%=listaAutores.get(i).getSobrenomeAutor()%></td>
		 
		    	</tr>
		    <%}%>
		</tbody>		
	</table>
	
	
</body>
</html>