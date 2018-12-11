package dao;

import model.EtapaProducc;
import dao.GenericDao;
import util.Conexion;

public class EtapaProduccDao extends Conexion<EtapaProducc> implements GenericDao<EtapaProducc>  {

	public EtapaProduccDao () {
		super(EtapaProducc.class);
	}
}