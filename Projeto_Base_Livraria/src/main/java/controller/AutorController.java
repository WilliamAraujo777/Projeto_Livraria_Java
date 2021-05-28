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


@WebServlet(urlPatterns = { "/AutorController","/autores","/insertAutor","/selectAutor","/updateAutor","/deleteAutor"})
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
		}else if (action.equals("/selectAutor")) {
			listarAutor(request, response);
		}else if (action.equals("/updateAutor")) {
			editarAutor(request, response);
		}else if (action.equals("/deleteAutor")) {
			deletarAutor(request, response);
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

	//Editar autor
			protected void listarAutor(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				//recebendo id do autor a ser alterado
				int idAutor = (Integer.parseInt(request.getParameter("idAutor")));
				
				autor.setIdAutor(idAutor);
				
				autorDAO.selecionarAutor(autor);
				
				//setando atributo do formulario com o conteudo do autor
				request.setAttribute("idAutor",autor.getIdAutor());
				request.setAttribute("nomeAutor",autor.getNomeAutor());
				request.setAttribute("sobrenomeAutor",autor.getSobrenomeAutor());
				
				//Encaminhar ao documento editaAutor.jsp
				RequestDispatcher rd = request.getRequestDispatcher("autor/editaAutor.jsp");
				rd.forward(request,response);
			
			}
			
			protected void editarAutor(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				
			
				
				autor.setIdAutor(Integer.parseInt(request.getParameter("idAutor")));
				
				autor.setNomeAutor(request.getParameter("nomeAutor"));
				autor.setSobrenomeAutor(request.getParameter("sobrenomeAutor"));
				
				
				//executar método do autorDAO
				autorDAO.update(autor);
				
				//redirecionar a pagina autor.jsp, mostrando todas as alterações
				response.sendRedirect("autores");

			}
			
			//Remover autor
			protected void deletarAutor(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				
				//recebendo id do autor a ser excluído
				String idAutor = request.getParameter("idAutor");
					
				//setar variavel na classe beans de autor
				autor.setIdAutor(Integer.parseInt(idAutor));
				
				//executar método delete da classe editora DAO passando o objeto de editora como parâmetro
				autorDAO.delete(autor);
				
				//encaminha para a pagina dos autores
				response.sendRedirect("autores");

			}
		
		
	}
