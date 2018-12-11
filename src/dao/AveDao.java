package dao;

import model.Ave;
import dao.GenericDao;
import util.Conexion;

public class AveDao extends Conexion<Ave> implements GenericDao<Ave>  {

	public AveDao () {
		super(Ave.class);
	}
}