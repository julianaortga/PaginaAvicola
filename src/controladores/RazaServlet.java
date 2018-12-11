package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RazaDao;
import dao.TipoAveDao;
import model.Raza;

@WebServlet("/raza")
public class RazaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RazaServlet() {
		super();
	}

	private void solve(HttpServletRequest request, HttpServletResponse response) {
		try {
			String ruta = "";
			int seleccion = Integer.parseInt(request.getParameter("seleccion"));

			int id = 0;
			String nombre = "";

			switch (seleccion) {
			case 1:
				try { // Formulario Actualizar
					request.setAttribute("lista", new TipoAveDao().list());
					request.setAttribute("objeto", new RazaDao().find(Integer.parseInt(request.getParameter("id"))));
				} catch (Exception ex) { // Formulario Registrar
					request.setAttribute("lista", new TipoAveDao().list());
					ex.printStackTrace();
				}
				ruta = "/WEB-INF/ave/registrar-raza.jsp";
				break;
			case 2: // Consultar
				request.setAttribute("lista", new RazaDao().list());
				ruta = "/WEB-INF/ave/consultar-razas.jsp";
				break;
			case 3: // Registrar
				id = Integer.parseInt(request.getParameter("tipoAveId")); 
				nombre = request.getParameter("nombre").toString();
				request.setAttribute("exito", new RazaDao().insert(new Raza(nombre, new TipoAveDao().find(id))));
				request.setAttribute("lista", new RazaDao().list());
				ruta = "/WEB-INF/ave/consultar-razas.jsp";
				break;
			case 4: // Actualizar
				id = Integer.parseInt(request.getParameter("id"));
				nombre = request.getParameter("nombre");
				int tipoAveId = Integer.parseInt(request.getParameter("tipoAveId"));
				request.setAttribute("exito",
						new RazaDao().update(new Raza(id, nombre, new TipoAveDao().find(tipoAveId))));
				request.setAttribute("lista", new RazaDao().list());
				ruta = "/WEB-INF/ave/consultar-razas.jsp";
				break;
			case 5:
				request.setAttribute("exito",
						new RazaDao().delete(new RazaDao().find(Integer.parseInt(request.getParameter("id")))));
				request.setAttribute("lista", new RazaDao().list());
				ruta = "/WEB-INF/ave/consultar-razas.jsp";
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
