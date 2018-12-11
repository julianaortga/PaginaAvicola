package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import model.Usuario;

/**
 * Servlet implementation class SeguridadServlet
 */
@WebServlet("/seguridad")
public class SeguridadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void procesar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hola, entre");

		String ruta = "";
		Usuario sesion = new UsuarioDao().iniciarSession(request.getParameter("correo"),
				request.getParameter("contrasena"));
		if (sesion != null) {
			
			// mira acá, cuando el logueo es exitoso se guarda el usuario que se logueó en la sesión, eso lo puedes tomar para poner el nombre
			
			request.getSession().setAttribute("sesion", sesion);
			ruta = "index?seleccion=1";
		} else {
			
			request.setAttribute("sesion", false);
			ruta = "login.jsp";
		}
		request.getRequestDispatcher(ruta).forward(request, response);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SeguridadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesar(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesar(request, response);
	}

}
