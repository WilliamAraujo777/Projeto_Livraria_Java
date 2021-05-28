<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@ page import= "model.beans.Livros" %> 
    <%@ page import= "java.util.ArrayList" %>
    <%
   		 @SuppressWarnings("unchecked")	
    	ArrayList<Livros> listaLivros = (ArrayList<Livros>) request.getAttribute("livros");
    
   %>
    
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Livros</title>
<link rel="icon" href="imagens/livros.png"> 
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Livros</h1>
	

	<a href="livro/novoLivro.jsp" action="editoras" class="botao1">Novo Livro</a>
	<a href="index.html" class="botao1">Menu</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>ISBN13</th>
				<th>Data Publicação</th>
				<th>Preço</th>
				<th>Qtd Paginas</th>
				<th>Editora</th>
				<th>Assunto</th>
				<th>Opções</th>
			</tr>
		</thead>
		
		<tbody>
			<%for (int i = 0; i < listaLivros.size(); i++){%>
		    	<tr>
		    		<td><%=listaLivros.get(i).getIdLivro()%></td>
		    		<td><%=listaLivros.get(i).getNomeLivro()%></td>
		    		<td><%=listaLivros.get(i).getIsbn13()%></td>
		    		<td><%=listaLivros.get(i).getDataPub()%></td>
		    		<td><%=listaLivros.get(i).getPreco()%></td>
		    		<td><%=listaLivros.get(i).getPaginas()%></td>
		    		<td><%=listaLivros.get(i).getEditora().getEditora()%></td>
		    		<td><%=listaLivros.get(i).getAssunto().getAssunto()%></td>
		    		<td><a href="selectLivro?idLivro=<%=listaLivros.get(i).getIdLivro()%>" class="botao1">Editar</a>
		    		<a href="javascript: confirmar(<%=listaLivros.get(i).getIdLivro()%>)" class="botao2">Excluir </a>
		    		</td>
		    	</tr>
		    <%}%>
		</tbody>		
	</table>
	<script src="scripts/validaLivro.js"></script>
	
</body>
</html>