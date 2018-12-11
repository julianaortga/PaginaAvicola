package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EtapaProduccDao;
import model.EtapaProducc;

/**
 * Servlet implementation class EtapaProduccServlet
 */
@WebServlet("/etapa-produccion")
public class EtapaProduccServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EtapaProduccServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void solve(HttpServletRequest request, HttpServletResponse response) {
		try {
			String ruta = "";
			String descripcion, nombre = "";
			int duracion, id = 0;
			int seleccion = Integer.parseInt(request.getParameter("seleccion"));
			switch (seleccion) {
			case 1: // Redireccionar al formulario de la etapa de produccion
				try { 
					request.setAttribute("objeto", new EtapaProduccDao().find(Integer.parseInt(request.getParameter("id"))));
				} catch (Exception ex) { 
					ex.printStackTrace();
				}
				ruta = "/WEB-INF/produccion/registrar-etapa-produccion.jsp";
				break;
			case 2: // Consultar las etapas de produccion
				request.setAttribute("lista", new EtapaProduccDao().list());
				ruta = "/WEB-INF/produccion/consultar-etapas-produccion.jsp";
				break;
			case 3: // Registrar etapa de produccion
				descripcion = request.getParameter("descripcion");;
				duracion = Integer.parseInt(request.getParameter("duracion")); 
				nombre = request.getParameter("nombre");
				
				request.setAttribute("exito", new EtapaProduccDao().insert(
						new EtapaProducc(descripcion, duracion, nombre)));
				request.setAttribute("lista", new EtapaProduccDao().list());
				ruta = "/WEB-INF/produccion/consultar-etapas-produccion.jsp";
				break;
			case 4: // Actualizar la etapa de produccion
				id = Integer.parseInt(request.getParameter("id"));
				descripcion = request.getParameter("descripcion");;
				duracion = Integer.parseInt(request.getParameter("duracion")); 
				nombre = request.getParameter("nombre");
				
				request.setAttribute("exito",
						new EtapaProduccDao().update(
								new EtapaProducc(id,descripcion, duracion, nombre)));
				request.setAttribute("lista", new EtapaProduccDao().list());
				ruta = "/WEB-INF/produccion/consultar-etapas-produccion.jsp";
				break;
			case 5: // Eliminar la etapa de produccion
				request.setAttribute("exito",
						new EtapaProduccDao().delete(new EtapaProduccDao().find(Integer.parseInt(request.getParameter("id")))));
				request.setAttribute("lista", new EtapaProduccDao().list());
				ruta = "/WEB-INF/produccion/consultar-etapas-produccion.jsp";
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
