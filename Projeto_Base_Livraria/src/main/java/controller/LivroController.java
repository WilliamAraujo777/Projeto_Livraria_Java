package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.DAO.livroDAO;
import model.beans.Assunto;

import model.beans.Editora;
import model.beans.Livros;

@WebServlet(urlPatterns = { "/LivroController", "/livros","/insertLivro","/main","/selectLivro"})
public class LivroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	livroDAO livroDao = new livroDAO();
	Livros livro = new Livros();
	Editora edit = new Editora();
	Assunto assunto = new Assunto();

	public LivroController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/livros")) {
			livros(request, response);
		}else if (action.equals("/insertLivro")) {
			novoLivro(request, response);
		}else if (action.equals("/selectLivro")) {
			listarLivro(request, response);
		}else{
			response.sendRedirect("index.html");
		}
	}

	//Listar livros
	protected void livros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Livros> listaLivros = livroDao.listarLivros();
		// Encaminhar a lista ao documento livro.jsp
		request.setAttribute("livros", listaLivros);
		RequestDispatcher rd = request.getRequestDispatcher("livro/livros.jsp");
		rd.forward(request, response);
	}

	//Novo livro
	protected void novoLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar variaveis javabeans
		edit.setIdEditora(Integer.parseInt(request.getParameter("nomeEdit")));
		assunto.setIdAssunto(Integer.parseInt(request.getParameter("nomeAssunto")));

		livro.setNomeLivro(request.getParameter("nomeLivro"));
		livro.setIsbn13(request.getParameter("isbn"));
		livro.setDataPub(request.getParameter("dataPub"));
		livro.setPreco(Double.parseDouble(request.getParameter("preco")));
		livro.setPaginas(Integer.parseInt(request.getParameter("qtdPag")));
		livro.setEditora(edit);
		livro.setAssunto(assunto);
		livroDao.save(livro);

		response.sendRedirect("livros");
	}
	
	//Editar Livro
	protected void listarLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//recebendo id do livro a ser editado
		int idLivro = (Integer.parseInt(request.getParameter("idLivro")));
		
		livro.setIdLivro(idLivro);
		
		livroDao.selecionarLivro(livro);
		
		//setando atributo do formulario com o conteudo do Livro
		request.setAttribute("idLivro",livro.getIdLivro());
		request.setAttribute("nomeLivro",livro.getNomeLivro());
		request.setAttribute("isbn",livro.getIsbn13());
		request.setAttribute("dataPub",livro.getDataPub());
		request.setAttribute("preco",livro.getPreco());
		request.setAttribute("qtdPag",livro.getPaginas());
		request.setAttribute("nomeEdit",livro.getEditora().getIdEditora());
		request.setAttribute("nomeAssunto",livro.getAssunto().getIdAssunto());
		
		//Encaminhar ao documento editaLivro.jsp
		RequestDispatcher rd = request.getRequestDispatcher("livro/editaLivro.jsp");
		rd.forward(request,response);
	
	}

	
}
