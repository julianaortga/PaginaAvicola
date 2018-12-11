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

import dao.DetallePlanADao;
import dao.LoteDao;
import dao.RegAlimDao;
import model.RegAlim;

/**
 * Servlet implementation class RegAlimServlet
 */
@WebServlet("/registro-alimentacion")
public class RegAlimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegAlimServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void solve(HttpServletRequest request, HttpServletResponse response) {
		try {
			String ruta = "";
			int seleccion = Integer.parseInt(request.getParameter("seleccion"));

			int id, LoteId, DetallePlanAId, cantidad = 0;
			String observacion = "";
			SimpleDateFormat simpleFecha = new SimpleDateFormat("yyyy-MM-dd");
			Date fecha1, fecha = null;

			switch (seleccion) {
			case 1:
				try { // Redireccionamiento al formulario registrar alimentación
					request.setAttribute("lista1", new LoteDao().list());
					request.setAttribute("lista2", new DetallePlanADao().list());
					request.setAttribute("objeto", new RegAlimDao().find(
							Integer.parseInt(request.getParameter("id"))));
				} catch (Exception ex) { 
					request.setAttribute("lista1", new LoteDao().list());
					request.setAttribute("lista2", new DetallePlanADao().list());
					ex.printStackTrace();
				}
				ruta = "/WEB-INF/alimento/registrar-alimentacion.jsp";
				break;
			case 2: // Consultar los registros de alimentacion
				request.setAttribute("lista", new RegAlimDao().list());
				ruta = "/WEB-INF/alimento/consultar-registro-alimentacion.jsp";
				break;
			case 3: // Registrar
				try {	
					cantidad = Integer.parseInt(request.getParameter("cantidad")); 
					LoteId = Integer.parseInt(request.getParameter("LoteId")); 
					DetallePlanAId = Integer.parseInt(request.getParameter("DetallePlanAId")); 
					observacion = request.getParameter("nombre").toString();
					fecha = simpleFecha.parse(request.getParameter("fecha"));
					fecha1 = new Date(fecha.getYear(), fecha.getMonth(), fecha.getDate());
					
					request.setAttribute("exito", new RegAlimDao().insert(
							new RegAlim(cantidad,fecha1,observacion, 
									new LoteDao().find(LoteId ),
									new DetallePlanADao().find(DetallePlanAId))));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				request.setAttribute("lista", new RegAlimDao().list());
				ruta = "/WEB-INF/alimento/consultar-registro-alimentacion.jsp";
				break;
			case 4: // Actualizar
				try {	
					id = Integer.parseInt(request.getParameter("id"));
					cantidad = Integer.parseInt(request.getParameter("cantidad")); 
					LoteId = Integer.parseInt(request.getParameter("LoteId")); 
					DetallePlanAId = Integer.parseInt(request.getParameter("DetallePlanAId")); 
					observacion = request.getParameter("nombre").toString();
					fecha = simpleFecha.parse(request.getParameter("fecha"));
					fecha1 = new Date(fecha.getYear(), fecha.getMonth(), fecha.getDate());
					
					request.setAttribute("exito", new RegAlimDao().update(
							new RegAlim(id,cantidad,fecha1,observacion, 
									new LoteDao().find(LoteId ),
									new DetallePlanADao().find(DetallePlanAId))));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				request.setAttribute("lista", new RegAlimDao().list());
				ruta = "/WEB-INF/alimento/consultar-registro-alimentacion.jsp";
				break;
			case 5:
				request.setAttribute("exito",
						new RegAlimDao().delete(new RegAlimDao().find(Integer.parseInt(request.getParameter("id")))));
				request.setAttribute("lista", new RegAlimDao().list());
				ruta = "/WEB-INF/alimento/consultar-registro-alimentacion.jsp";
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
