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


@WebServlet(urlPatterns = { "/EditoraController","/chamarNovaEditora","/editoras","/insertEditora","/selectEditora","/updateEditora","/deleteEditora" })
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
		}else if (action.equals("/chamarNovaEditora")) {
			chamaEdit(request, response);
		}else if (action.equals("/insertEditora")) {
			novaEditora(request, response);
		}else if (action.equals("/selectEditora")) {
			listarEditora(request, response);
		}else if (action.equals("/updateEditora")) {
			editarEditora(request, response);
		}else if (action.equals("/deleteEditora")) {
			deletarEditora(request, response);
		}
	}

	// Listar editoras
	protected void chamaEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.sendRedirect("editora/novaEditora.html");
		String url = request.getHeader ("referer");
		System.out.println(url); 

	}
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
		String url = request.getHeader ("referer");
		
		System.out.println(url);
		
		
		edit.setEditora(request.getParameter("nomeEditora"));
		editDAO.save(edit);
		
		if(url == "http://localhost:8080/Projeto_Base_Livraria/editoras") {
			response.sendRedirect("editoras");
		} else {
			System.out.println("vish");
		}
		

	}
	
	//Editar editora
		protected void listarEditora(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			//recebendo id da editora a ser alterada
			int idEditora = (Integer.parseInt(request.getParameter("idEditora")));
			
			edit.setIdEditora(idEditora);
			
			editDAO.selecionarEditora(edit);
			
			//setando atributo do formulario com o conteudo da editora
			request.setAttribute("idEditora",edit.getIdEditora());
			request.setAttribute("nomeEditora",edit.getEditora());
			
			//Encaminhar ao documento editaEditora.jsp
			RequestDispatcher rd = request.getRequestDispatcher("editora/editaEditora.jsp");
			rd.forward(request,response);
			
		}
		
		protected void editarEditora(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
		
			
			edit.setIdEditora(Integer.parseInt(request.getParameter("idEditora")));
			
			edit.setEditora(request.getParameter("nomeEditora"));
			
			
			//executar método do editoraDAO
			editDAO.update(edit);
			
			//redirecionar a pagina editoras.jsp, mostrando todas as alterações
			response.sendRedirect("editoras");

		}
		
		//Remover editora
		protected void deletarEditora(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			//recebendo id da editora a ser excluída
			String idEdit = request.getParameter("idEditora");
				
			//setar variavel na classe beans de editora
			edit.setIdEditora(Integer.parseInt(idEdit));
			
			//executar método delete da classe editora DAO passando o objeto de editora como parâmetro
			editDAO.delete(edit);
			
			//encaminha para a pagina das editoras 
			response.sendRedirect("editoras");

		}
	
	
}
