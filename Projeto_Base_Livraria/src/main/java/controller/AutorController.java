package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.autorDAO;
import model.beans.Autores;


@WebServlet(urlPatterns = { "/AutorController","/autores","/insertAutor"})
public class AutorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Autores     autor = new Autores ();
	autorDAO autorDAO = new autorDAO();

	public AutorController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		
		 if (action.equals("/insertAutor")) {
			novoAutor(request, response);
		}else if (action.equals("/autores")) {
			autores(request, response);
		}
	}
	
	//listar autores
	protected void autores(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Autores> listaAutores = autorDAO.listarAutor();
		// Encaminhar a lista ao documento autor.jsp
		request.setAttribute("autores", listaAutores);
		RequestDispatcher rd = request.getRequestDispatcher("autor/autor.jsp");
		rd.forward(request, response);
	}

	// novo autor
	protected void novoAutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		autor.setNomeAutor(request.getParameter("nomeAutor"));
		autor.setSobrenomeAutor(request.getParameter("sobrenomeAutor"));
		autorDAO.save(autor);

		response.sendRedirect("autores");
	}

}