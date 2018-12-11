package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoteDao;
import model.Lote;

/**
 * Servlet implementation class LoteServlet
 */
@WebServlet("/lote")
public class LoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void solve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
			String ruta = "";
			String obsInicial = "";
			String ubicacion = "";
			int id = 0;
			int seleccion = Integer.parseInt(request.getParameter("seleccion"));
			switch (seleccion) {
			case 1: // Redireccionar al formulario de lote
				try { 
				id = Integer.parseInt(request.getParameter("id"));
					request.setAttribute("objeto", new LoteDao().find(id));
				} catch (Exception ex) { 
					ex.printStackTrace();
				}
				ruta = "/WEB-INF/galpon/registrar-lote.jsp";
				break;
			case 2: // Consultar los lotes
				request.setAttribute("lista", new LoteDao().list());
				ruta = "/WEB-INF/galpon/consultar-lotes.jsp";
				break;
			case 3: //Registrar Lote
				obsInicial = request.getParameter("obsInicial");
				ubicacion = request.getParameter("ubicacion");
				request.setAttribute("exito", new LoteDao().insert(new Lote(obsInicial,ubicacion)));
				request.setAttribute("lista", new LoteDao().list());
				ruta = "/WEB-INF/galpon/consultar-lotes.jsp";
				break;
			case 4: //Actualizar Lote
				id = Integer.parseInt(request.getParameter("id"));
				obsInicial = request.getParameter("obsInicial");
				ubicacion = request.getParameter("ubicacion");
				request.setAttribute("exito",
						new LoteDao().update(new Lote(id, obsInicial,ubicacion)));
				request.setAttribute("lista", new LoteDao().list());
				ruta = "/WEB-INF/galpon/consultar-lotes.jsp";
				break;
			case 5://Eliminar Lote
				request.setAttribute("exito",new LoteDao().delete(new LoteDao().find(Integer.parseInt(request.getParameter("id")))));
				request.setAttribute("lista", new LoteDao().list());
				ruta = "/WEB-INF/galpon/consultar-lotes.jsp";
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
