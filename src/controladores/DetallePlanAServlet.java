package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlimentoDao;
import dao.DetallePlanADao;
import dao.EtapaProduccDao;
import model.DetallePlanA;

/**
 * Servlet implementation class DetallePlanAServlet
 */
@WebServlet("/detalle-plan-alimentacion")
public class DetallePlanAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetallePlanAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void solve(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			int id, cantidad, alimentoId, etapaPId= 0;
			String dia = "";
			
			String ruta = "";
			int seleccion = Integer.parseInt(request.getParameter("seleccion"));
			switch (seleccion) {
			case 1: 
				try { //Redirecciona al formulario de registrar detalle del plan de alimentacion
					request.setAttribute("objeto", new DetallePlanADao().find(Integer.parseInt(request.getParameter("id"))));
				} catch (Exception ex) { 
					ex.printStackTrace();
				}
				request.setAttribute("lista", new AlimentoDao().list());
				request.setAttribute("lista", new EtapaProduccDao().list());
				ruta = "/WEB-INF/alimento/registrar-detalle-plan.jsp";
				break;
			case 2: // Consultar
				request.setAttribute("lista", new DetallePlanADao().list());
				ruta = "/WEB-INF/alimento/consultar-detalles-plan.jsp";
				break;
			case 3: // Registrar
				cantidad = Integer.parseInt(request.getParameter("cantidad"));
				alimentoId = Integer.parseInt(request.getParameter("alimentoId"));
				etapaPId = Integer.parseInt(request.getParameter("etapaPId"));
				dia = request.getParameter("dia");
				
				request.setAttribute("exito",new DetallePlanADao().insert(
						new DetallePlanA(cantidad,dia,new AlimentoDao().find(alimentoId),
										 new EtapaProduccDao().find(etapaPId))));
				request.setAttribute("lista", new DetallePlanADao().list());
				ruta = "/WEB-INF/alimento/consultar-detalles-plan.jsp";
				break;
			case 4: // Actualizar
				id = Integer.parseInt(request.getParameter("id"));
				cantidad = Integer.parseInt(request.getParameter("cantidad"));
				alimentoId = Integer.parseInt(request.getParameter("alimentoId"));
				etapaPId = Integer.parseInt(request.getParameter("etapaPId"));
				dia = request.getParameter("dia");
				
				
				request.setAttribute("exito",new DetallePlanADao().update(
						new DetallePlanA(cantidad,dia,new AlimentoDao().find(alimentoId),
								 new EtapaProduccDao().find(etapaPId))));
				request.setAttribute("lista", new DetallePlanADao().list());
				ruta = "/WEB-INF/alimento/consultar-detalles-plan.jsp";
				break;

			case 5: // Eliminar el tipo de ave
				request.setAttribute("exito",
						new DetallePlanADao().delete(new DetallePlanADao().find(Integer.parseInt(request.getParameter("id")))));
				request.setAttribute("lista", new DetallePlanADao().list());
				ruta = "/WEB-INF/alimento/consultar-detalles-plan.jsp";
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
