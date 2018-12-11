package dao;

import model.Material;
import dao.GenericDao;
import util.Conexion;

public class MaterialDao extends Conexion<Material> implements GenericDao<Material>  {

	public MaterialDao () {
		super(Material.class);
	}
}