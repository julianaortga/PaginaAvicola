package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexServlet() {
		super();
	}

	private void solve(HttpServletRequest request, HttpServletResponse response) {
		try {
			String ruta = "";
			int seleccion = Integer.parseInt(request.getParameter("seleccion"));
			switch (seleccion) {
			case 1: // Redireccionar a Inicio
				ruta = "index.jsp";
				break;
			case 2: // Redireccionar a Aves
				ruta = "/WEB-INF/ave/modulo-ave.jsp";
				break;
			case 3: // Redireccionar a Lotes y Galpones
				ruta = "/WEB-INF/galpon/modulo-galpon.jsp";
				break;
			case 4: // Redireccionar a Alimentación
				ruta = "/WEB-INF/alimento/modulo-alimento.jsp";
				break;
			case 5: // Redireccionar a Produccion
				ruta = "/WEB-INF/produccion/modulo-produccion.jsp";
				break;
			default:
				ruta = "index.jsp";
				break;
			}
			request.getRequestDispatcher(ruta).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		;
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
