package dao;

import model.LineaG;
import dao.GenericDao;
import util.Conexion;

public class LineaGDao extends Conexion<LineaG> implements GenericDao<LineaG>  {

	public LineaGDao () {
		super(LineaG.class);
	}
}