package controladores;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MaterialDao;
import dao.GalponDao;
import model.Material;

/**
 * Servlet implementation class MaterialServlet
 */
@WebServlet("/material")
public class MaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaterialServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void solve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
			String ruta = "";
			int id, galpon  = 0;
			String descripcion ="";
			SimpleDateFormat simpleFecha = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaIngreso, fecha = null;
			int seleccion = Integer.parseInt(request.getParameter("seleccion"));
			
			switch (seleccion) {
			case 1: // Redireccionar al formulario de material
				try { 
					request.setAttribute("lista", new GalponDao().list());
					id = Integer.parseInt(request.getParameter("id"));
					request.setAttribute("objeto", new MaterialDao().find(id));
				} catch (Exception ex) { 
					request.setAttribute("lista", new GalponDao().list());
					ex.printStackTrace();
				}
				ruta = "/WEB-INF/galpon/registrar-material.jsp";
				break;
			case 2: // Consultar los materiales
				request.setAttribute("lista", new MaterialDao().list());
				ruta = "/WEB-INF/galpon/consultar-materiales.jsp";
				break;
			case 3: //Registrar Material
				try {
					descripcion = request.getParameter("descripcion");
					fecha = simpleFecha.parse(request.getParameter("fechaIngreso"));
					fechaIngreso = new Date(fecha.getYear(), fecha.getMonth(), fecha.getDate());
					galpon = Integer.parseInt(request.getParameter("galpon"));
					
					request.setAttribute("exito", new MaterialDao().insert(
							new Material(descripcion,fechaIngreso,
									new GalponDao().find(galpon))));
				} catch (ParseException e) {
					e.printStackTrace();
				}	
				request.setAttribute("lista", new MaterialDao().list());
				ruta = "/WEB-INF/galpon/consultar-materiales.jsp";
				break;
			case 4: //Actualizar Material
				try {
					id = Integer.parseInt(request.getParameter("id"));
					descripcion = request.getParameter("descripcion");
					fecha = simpleFecha.parse(request.getParameter("fechaIngreso"));
					galpon = Integer.parseInt(request.getParameter("galpon"));
					fechaIngreso = new Date(fecha.getYear(), fecha.getMonth(), fecha.getDate());
					
					request.setAttribute("exito",
							new MaterialDao().update(
									new Material(id,descripcion,fechaIngreso,
											new GalponDao().find(galpon))));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				request.setAttribute("lista", new MaterialDao().list());
				ruta = "/WEB-INF/galpon/consultar-materiales.jsp";
				break;
			case 5://Eliminar Material
				request.setAttribute("exito",new MaterialDao().delete(
						new MaterialDao().find(Integer.parseInt(request.getParameter("id")))));
				request.setAttribute("lista", new MaterialDao().list());
				ruta = "/WEB-INF/galpon/consultar-materiales.jsp";
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
