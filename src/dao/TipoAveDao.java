package dao;

import model.TipoAve;
import dao.GenericDao;
import util.Conexion;

public class TipoAveDao extends Conexion<TipoAve> implements GenericDao<TipoAve>  {

	public TipoAveDao () {
		super(TipoAve.class);
	}
}