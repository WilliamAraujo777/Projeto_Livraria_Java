package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.assuntoDAO;
import model.beans.Assunto;


@WebServlet(urlPatterns = { "/AssuntoController","/assuntos","/insertAssunto","/selectAssunto","/updateAssunto","/deleteAssunto" })
public class AssuntoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	assuntoDAO assuntoDAO = new assuntoDAO();
	Assunto assunto = new Assunto();
	

	public AssuntoController() {
		super(); 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/assuntos")) {
			assuntos(request, response);
		}else if (action.equals("/insertAssunto")) {
			novoAssunto(request, response);
		}else if (action.equals("/selectAssunto")) {
			listarAssunto(request, response);
		}else if (action.equals("/updateAssunto")) {
			editarAssunto(request, response);
		}else if (action.equals("/deleteAssunto")) {
			deletarAssunto(request, response);
		}
	}


	// Listar assuntos
	protected void assuntos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Assunto> listaAssuntos = assuntoDAO.listarAssunto();
		// Encaminhar a lista ao documento assunto.jsp
		request.setAttribute("assuntos", listaAssuntos);
		RequestDispatcher rd = request.getRequestDispatcher("assunto/assuntos.jsp");
		rd.forward(request, response);
	}

	// Novo assunto
	protected void novoAssunto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		assunto.setAssunto(request.getParameter("nomeAssunto"));
		assuntoDAO.save(assunto);

		response.sendRedirect("assuntos");
	}
	//Editar assunto
	protected void listarAssunto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//recebendo id do assunto a ser editado
		int idAssunto = (Integer.parseInt(request.getParameter("idAssunto")));
		
		assunto.setIdAssunto(idAssunto);
		
		assuntoDAO.selecionarAssunto(assunto);
		
		//setando atributo do formulario com o conteudo do assunto
		request.setAttribute("idAssunto",assunto.getIdAssunto());
		request.setAttribute("nomeAssunto",assunto.getAssunto());
		
		//Encaminhar ao documento editaAssunto.jsp
		RequestDispatcher rd = request.getRequestDispatcher("assunto/editaAssunto.jsp");
		rd.forward(request,response);
	
	}
	
	protected void editarAssunto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		
		assunto.setIdAssunto(Integer.parseInt(request.getParameter("idAssunto")));
		
		assunto.setAssunto(request.getParameter("nomeAssunto"));
		
		
		//executar método do assuntoDAO
		assuntoDAO.update(assunto);
		
		//redirecionar a pagina assuntos.jsp, mostrando todas as alterações
		response.sendRedirect("assuntos");

	}
	
	//Remover assunto
	protected void deletarAssunto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//recebendo id do livro a ser excluído
		String idAssunto = request.getParameter("idAssunto");
		//setar variavel na classe beans de livro
		assunto.setIdAssunto(Integer.parseInt(idAssunto));
		
		//executar método delete da classe livro DAO passando o objeto de livro como parâmetro
		assuntoDAO.delete(assunto);
		
		//encaminha para a pagina dos livros 
		response.sendRedirect("assuntos");
		
	}
}
