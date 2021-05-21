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


@WebServlet(urlPatterns = { "/AssuntoController","/assuntos","/insertAssunto" })
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
		}else{
			response.sendRedirect("index.html");
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
	
}
