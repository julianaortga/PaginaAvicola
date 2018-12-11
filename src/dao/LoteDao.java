package dao;

import model.Lote;
import dao.GenericDao;
import util.Conexion;

public class LoteDao extends Conexion<Lote> implements GenericDao<Lote>  {

	public LoteDao () {
		super(Lote.class);
	}
}