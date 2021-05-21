package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.DAO.editoraDAO;

import model.beans.Editora;


@WebServlet(urlPatterns = { "/EditoraController","/editoras","/insertEditora"})
public class EditoraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	editoraDAO editDAO = new editoraDAO();
	Editora edit = new Editora();

	public EditoraController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		 if (action.equals("/editoras")) {
			editoras(request, response);
		}else if (action.equals("/insertEditora")) {
			novaEditora(request, response);
		}else{
			response.sendRedirect("index.html");
		}
	}

	// Listar editoras
	protected void editoras(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Editora> listaEditoras = editDAO.listarEditora();
		// Encaminhar a lista ao documento editora.jsp
		request.setAttribute("editoras", listaEditoras);
		RequestDispatcher rd = request.getRequestDispatcher("editora/editora.jsp");
		rd.forward(request, response);
	}

	// Nova editora
	protected void novaEditora(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		edit.setEditora(request.getParameter("nomeEditora"));
		editDAO.save(edit);

		response.sendRedirect("editoras");
	}
	
	
}
