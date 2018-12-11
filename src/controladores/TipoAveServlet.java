package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TipoAveDao;
import model.TipoAve;

@WebServlet("/tipo-ave")
public class TipoAveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TipoAveServlet() {
		super();
	}

	private void solve(HttpServletRequest request, HttpServletResponse response) {
		try {
			String ruta = "";
			int seleccion = Integer.parseInt(request.getParameter("seleccion"));
			switch (seleccion) {
			case 1: // Redireccionar al formulario de tipo de ave
				try { // Si existe id va a actualizar
					request.setAttribute("objeto", new TipoAveDao().find(Integer.parseInt(request.getParameter("id"))));
				} catch (Exception ex) { // Si no existe id va a registrar
					ex.printStackTrace();
				}
				ruta = "/WEB-INF/ave/registrar-tipo-ave.jsp";
				break;
			case 2: // Consultar los tipos de aves
				request.setAttribute("lista", new TipoAveDao().list());
				ruta = "/WEB-INF/ave/consultar-tipos-ave.jsp";
				break;
			case 3: // Registrar tipo ave
				request.setAttribute("exito", new TipoAveDao().insert(new TipoAve(request.getParameter("nombre"))));
				request.setAttribute("lista", new TipoAveDao().list());
				ruta = "/WEB-INF/ave/consultar-tipos-ave.jsp";
				break;
			case 4: // Actualizar el tipo de ave
				request.setAttribute("exito",
						new TipoAveDao().update(new TipoAve(Integer.parseInt(request.getParameter("id")),
								request.getParameter("nombre").toString())));
				request.setAttribute("lista", new TipoAveDao().list());
				ruta = "/WEB-INF/ave/consultar-tipos-ave.jsp";
				break;
			case 5: // Eliminar el tipo de ave
				request.setAttribute("exito",
						new TipoAveDao().delete(new TipoAveDao().find(Integer.parseInt(request.getParameter("id")))));
				request.setAttribute("lista", new TipoAveDao().list());
				ruta = "/WEB-INF/ave/consultar-tipos-ave.jsp";
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
