package dao;

import model.Galpon;
import dao.GenericDao;
import util.Conexion;

public class GalponDao extends Conexion<Galpon> implements GenericDao<Galpon>  {

	public GalponDao () {
		super(Galpon.class);
	}
}