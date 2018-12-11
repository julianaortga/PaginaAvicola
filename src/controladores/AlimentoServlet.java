package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlimentoDao;
import model.Alimento;

/**
 * Servlet implementation class AlimentoServlet
 */
@WebServlet("/alimento")
public class AlimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlimentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void solve(HttpServletRequest request, HttpServletResponse response) {
		try {
			String ruta = "";
			int id = 0;
			String nombre, tipo = "";
			int seleccion = Integer.parseInt(request.getParameter("seleccion"));
			switch (seleccion) {
			case 1: // Redireccionar al formulario de alimento
				try { 
					request.setAttribute("objeto", new AlimentoDao().find(Integer.parseInt(request.getParameter("id"))));
				} catch (Exception ex) { 
					ex.printStackTrace();
				}
				ruta = "/WEB-INF/alimento/registrar-alimento.jsp";
				break;
			case 2: // Consultar los alimentos
				request.setAttribute("lista", new AlimentoDao().list());
				ruta = "/WEB-INF/alimento/consultar-alimentos.jsp";
				break;
			case 3: // Registrar alimento
				nombre = request.getParameter("nombre");
				tipo = request.getParameter("tipo");
				
				request.setAttribute("exito", new AlimentoDao().insert(new Alimento(nombre,tipo)));
				request.setAttribute("lista", new AlimentoDao().list());
				ruta = "/WEB-INF/alimento/consultar-alimentos.jsp";
				break;
			case 4: // Actualizar alimento
				id = Integer.parseInt(request.getParameter("id"));
				nombre = request.getParameter("nombre");
				tipo = request.getParameter("tipo");
				
				request.setAttribute("exito", new AlimentoDao().update(new Alimento(id,nombre,tipo)));
				request.setAttribute("lista", new AlimentoDao().list());
				ruta = "/WEB-INF/alimento/consultar-alimentos.jsp";
				break;
			case 5: // Eliminar alimento
				request.setAttribute("exito",
						new AlimentoDao().delete(new AlimentoDao().find(Integer.parseInt(request.getParameter("id")))));
				request.setAttribute("lista", new AlimentoDao().list());
				ruta = "/WEB-INF/alimento/consultar-alimentos.jsp";
				break;
			default:
				ruta = "index.jsp";
				break;
			}
			request.getRequestDispatcher(ruta).forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		solve(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		solve(request, response);
	}

}
