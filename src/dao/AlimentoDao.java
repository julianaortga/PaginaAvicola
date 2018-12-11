package dao;

import model.Alimento;
import dao.GenericDao;
import util.Conexion;

public class AlimentoDao extends Conexion<Alimento> implements GenericDao<Alimento>  {

	public AlimentoDao () {
		super(Alimento.class);
	}
}