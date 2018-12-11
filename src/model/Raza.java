package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the raza database table.
 * 
 */
@Entity
@NamedQuery(name = "Raza.findAll", query = "SELECT r FROM Raza r")
public class Raza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_raza")
	private int idRaza;

	private String nombre;

	// bi-directional many-to-one association to Ave
	@OneToMany(mappedBy = "razaBean")
	private List<Ave> aves;

	// bi-directional many-to-one association to TipoAve
	@ManyToOne
	@JoinColumn(name = "tipo_ave")
	private TipoAve tipoAveBean;

	public Raza() {
		super();
	}

	public Raza(int id) {
		super();
		this.idRaza = id;
	}
	
	public Raza(String nombre, List<Ave> aves, TipoAve tipoAveBean) {
		super();
		this.nombre = nombre;
		this.aves = aves;
		this.tipoAveBean = tipoAveBean;
	}

	public Raza(int idRaza, String nombre, List<Ave> aves, TipoAve tipoAveBean) {
		super();
		this.idRaza = idRaza;
		this.nombre = nombre;
		this.aves = aves;
		this.tipoAveBean = tipoAveBean;
	}

	public Raza(String nombre, TipoAve tipoAveBean) {
		super();
		this.nombre = nombre;
		this.tipoAveBean = tipoAveBean;
	}

	public Raza(int id, String nombre, TipoAve tipoAveBean) {
		super();
		this.idRaza = id;
		this.nombre = nombre;
		this.tipoAveBean = tipoAveBean;
	}

	public int getIdRaza() {
		return this.idRaza;
	}

	public void setIdRaza(int idRaza) {
		this.idRaza = idRaza;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ave> getAves() {
		return this.aves;
	}

	public void setAves(List<Ave> aves) {
		this.aves = aves;
	}

	public Ave addAve(Ave ave) {
		getAves().add(ave);
		ave.setRazaBean(this);

		return ave;
	}

	public Ave removeAve(Ave ave) {
		getAves().remove(ave);
		ave.setRazaBean(null);

		return ave;
	}

	public TipoAve getTipoAveBean() {
		return this.tipoAveBean;
	}

	public void setTipoAveBean(TipoAve tipoAveBean) {
		this.tipoAveBean = tipoAveBean;
	}

}