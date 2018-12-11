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
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
    }
    
    protected void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  	
    	int seleccion = Integer.parseInt(request.getParameter("seleccion"));
    	UsuarioDao myDao = new UsuarioDao();
    	Usuario myU;
    	String url = "";
    	int id;
    	
    	if(seleccion == 1) { //Redireccionar a el formulario de usuarios (registrar y actualizar)
    		url ="/WEB-INF/usuario/registrar-usuario.jsp";
    	
    	}else if(seleccion == 2) { //Consultar todos los usuarios
    		
    		request.setAttribute("usuarios", myDao.list());
    		url ="/WEB-INF/Usuario/consultarTodos.jsp";
    		
    	}else if(seleccion == 3) { //Consultar usuario por id
    		
    		id = Integer.parseInt(request.getParameter("idUsuario"));
    		request.setAttribute("usuario", myDao.find(id));
    		url ="/WEB-INF/Usuario/consultar.jsp";
    		
    	}else if(seleccion == 4) { //Registrar usuario
    		
    		String contrasena = request.getParameter("contrasena");
    		String correo = request.getParameter("correo");
    		String nombre = request.getParameter("nombre");
    		int rol = Integer.parseInt(request.getParameter("rol"));
    		String username = request.getParameter("username");
    		
    		myU = new Usuario(contrasena, correo, nombre, rol, username);
    		request.setAttribute("req",myDao.insert(myU));
    		url ="/WEB-INF/Usuario/consultarTodos.jsp";
    		
    	}else if(seleccion == 5) { //Actualizar usuario
    		
    		id = Integer.parseInt(request.getParameter("idUsuario"));
    		String contrasena = request.getParameter("contrasena");
    		String correo = request.getParameter("correo");
    		String nombre = request.getParameter("nombre");
    		int rol = Integer.parseInt(request.getParameter("rol"));
    		String username = request.getParameter("username");
    		
    		myU = new Usuario(id,contrasena, correo, nombre,rol, username);
    		request.setAttribute("req", myDao.update(myU));
    		url ="/WEB-INF/Usuario/consultarTodos.jsp";
    		
    	}else if(seleccion == 6) { //Eliminar usuario
    		
    		id = Integer.parseInt(request.getParameter("idUsuario"));
    		
    		myU = myDao.find(id);
    		request.setAttribute("exito", myDao.delete(myU));
    		request.setAttribute("usuarios", myDao.list());    		
    		url ="/WEB-INF/Usuario/consultarTodos.jsp";
    		
    	}else {
    		
    		url ="index.html";
    		
    	}
    	request.getRequestDispatcher(url).forward(request, response);	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		procesar(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		procesar(request, response);
	}

}
