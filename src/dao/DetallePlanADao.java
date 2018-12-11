package dao;

import model.DetallePlanA;
import dao.GenericDao;
import util.Conexion;

public class DetallePlanADao extends Conexion<DetallePlanA> implements GenericDao<DetallePlanA>  {

	public DetallePlanADao () {
		super(DetallePlanA.class);
	}
}