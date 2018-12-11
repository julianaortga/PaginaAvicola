package dao;

import model.RegAlim;
import dao.GenericDao;
import util.Conexion;

public class RegAlimDao extends Conexion<RegAlim> implements GenericDao<RegAlim>  {

	public RegAlimDao () {
		super(RegAlim.class);
	}
}