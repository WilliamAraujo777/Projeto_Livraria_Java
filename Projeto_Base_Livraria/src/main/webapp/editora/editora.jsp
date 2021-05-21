<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@ page import= "model.beans.Editora" %> 
    <%@ page import= "java.util.ArrayList" %>
    <%
    	@SuppressWarnings("unchecked")	
    	ArrayList<Editora> listaEditoras = (ArrayList<Editora>) request.getAttribute("editoras");
    %>
    
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Editoras</title>
<link rel="icon" href="imagens/livros.png"> 
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editoras</h1>
	
	
	<a href="editora/novaEditora.html" class="botao1">Nova Editora</a>
	<a href="main" class="botao1">Menu</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome da editora</th>
			</tr>
		</thead>
		
		<tbody>
			<%for (int i = 0; i < listaEditoras.size(); i++){%>
		    	<tr>
		    		<td><%=listaEditoras.get(i).getIdEditora()%></td>
		    		<td><%=listaEditoras.get(i).getEditora()%></td>
		 
		    	</tr>
		    <%}%>
		</tbody>		
	</table>
	
	
</body>
</html>