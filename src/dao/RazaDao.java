package dao;

import model.Raza;
import dao.GenericDao;
import util.Conexion;

public class RazaDao extends Conexion<Raza> implements GenericDao<Raza>  {

	public RazaDao () {
		super(Raza.class);
	}
}