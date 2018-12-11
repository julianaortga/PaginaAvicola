package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GalponDao;
import dao.LoteDao;
import model.Galpon;



/**
 * Servlet implementation class GalponServlet
 */
@WebServlet("/galpon")
public class GalponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GalponServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void solve (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
			String ruta = "";
			String obsInicial, tipoGalpon, estado= "";
			int id, topeMax, lote= 0;
			float altura, anchura = 0.0f;
			int seleccion = Integer.parseInt(request.getParameter("seleccion"));
			switch (seleccion) {
			case 1: // Redireccionar al formulario de galpon
				try { 
					System.out.println("entro por modificar galpon");
				request.setAttribute("lista", new LoteDao().list());
				id = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("objeto", new GalponDao().find(id));
				} catch (Exception ex) { 
					System.out.println("entro por registrar galpon");
					request.setAttribute("lista", new LoteDao().list());
					ex.printStackTrace();
				}
				ruta = "/WEB-INF/galpon/registrar-galpon.jsp";
				break;
			case 2: // Consultar los galpones
				request.setAttribute("lista", new GalponDao().list());
				ruta = "/WEB-INF/galpon/consultar-galpones.jsp";
				break;
			case 3: //Registrar Galpon
				obsInicial = request.getParameter("obsInicial");
				tipoGalpon = request.getParameter("tipoGalpon");
				estado = request.getParameter("estado");
				topeMax = Integer.parseInt(request.getParameter("topeMax"));
				anchura = Float.parseFloat(request.getParameter("anchura"));
				altura = Float.parseFloat(request.getParameter("altura"));
				lote = Integer.parseInt(request.getParameter("lote"));
				
				request.setAttribute("exito", new GalponDao().insert(
						new Galpon(altura,anchura,estado, obsInicial,tipoGalpon, topeMax,
								new LoteDao().find(lote))));
				request.setAttribute("lista", new GalponDao().list());
				ruta = "/WEB-INF/galpon/consultar-galpones.jsp";
				break;
			case 4: //Actualizar Galpon
				id = Integer.parseInt(request.getParameter("id"));
				obsInicial = request.getParameter("obsInicial");
				tipoGalpon = request.getParameter("tipoGalpon");
				estado = request.getParameter("estado");
				topeMax = Integer.parseInt(request.getParameter("topeMax"));
				anchura = Float.parseFloat(request.getParameter("anchura"));
				altura = Float.parseFloat(request.getParameter("altura"));
				lote = Integer.parseInt(request.getParameter("lote"));
				
				request.setAttribute("exito",
						new GalponDao().update(
								new Galpon(id,altura,anchura,estado, obsInicial,tipoGalpon, topeMax,
										new LoteDao().find(lote))));
				request.setAttribute("lista", new GalponDao().list());
				ruta = "/WEB-INF/galpon/consultar-galpones.jsp";
				break;
			case 5://Eliminar Galpon
				request.setAttribute("exito",new GalponDao().delete(
						new GalponDao().find(Integer.parseInt(request.getParameter("id")))));
				request.setAttribute("lista", new GalponDao().list());
				ruta = "/WEB-INF/galpon/consultar-galpones.jsp";
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
