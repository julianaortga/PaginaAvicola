package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LineaGDao;
import dao.TipoAveDao;
import model.LineaG;

@WebServlet("/linea-genetica")
public class LineaGeneticaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LineaGeneticaServlet() {
		super();
	}

	private void solve(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			int id = 0;
			String nombre = "";
			String observacion = "";
			
			String ruta = "";
			int seleccion = Integer.parseInt(request.getParameter("seleccion"));
			switch (seleccion) {
			case 1: // Formulario
				try { // Actualizar
					request.setAttribute("objeto", new LineaGDao().find(Integer.parseInt(request.getParameter("id"))));
				} catch (Exception ex) { // Registrar
					ex.printStackTrace();
				}
				request.setAttribute("lista", new TipoAveDao().list());
				ruta = "/WEB-INF/ave/registrar-linea-genetica.jsp";
				break;
			case 2: // Consultar
				request.setAttribute("lista", new LineaGDao().list());
				ruta = "/WEB-INF/ave/consultar-lineas-geneticas.jsp";
				break;
			case 3: // Registrar
				id =Integer.parseInt(request.getParameter("tipoAveId"));
				nombre = request.getParameter("nombre").toString();
				observacion = request.getParameter("observacion");
				
				request.setAttribute("exito",new LineaGDao().insert(
						new LineaG(nombre,observacion ,new TipoAveDao().find(id))));
				request.setAttribute("lista", new LineaGDao().list());
				ruta = "/WEB-INF/ave/consultar-lineas-geneticas.jsp";
				break;
			case 4: // Actualizar
				
				id = Integer.parseInt(request.getParameter("id"));
				int tipoAveId = Integer.parseInt(request.getParameter("tipoAveId"));
				nombre = request.getParameter("nombre").toString();
				observacion = request.getParameter("observacion");
				
				request.setAttribute("exito",new LineaGDao().update(
						new LineaG(id,nombre,observacion,new TipoAveDao().find(tipoAveId))));
				request.setAttribute("lista", new LineaGDao().list());
				ruta = "/WEB-INF/ave/consultar-lineas-geneticas.jsp";
				break;

			case 5: // Eliminar el tipo de ave
				request.setAttribute("exito",
						new LineaGDao().delete(new LineaGDao().find(Integer.parseInt(request.getParameter("id")))));
				request.setAttribute("lista", new LineaGDao().list());
				ruta = "/WEB-INF/ave/consultar-lineas-geneticas.jsp";
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		solve(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		solve(request, response);
	}

}
