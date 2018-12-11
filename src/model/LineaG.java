package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the linea_g database table.
 * 
 */
@Entity
@Table(name = "linea_g")
@NamedQuery(name = "LineaG.findAll", query = "SELECT l FROM LineaG l")
public class LineaG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_linea_g")
	private int idLineaG;

	private String nombre;

	private String observacion;

	// bi-directional many-to-one association to TipoAve
	@ManyToOne
	@JoinColumn(name = "tipo_ave")
	private TipoAve tipoAveBean;

	public LineaG() {
		super();
	}

	public LineaG(int id) {
		super();
		this.idLineaG = id;
	}

	public LineaG(String nombre, String observacion, TipoAve tipoAveBean) {
		super();
		this.nombre = nombre;
		this.observacion = observacion;
		this.tipoAveBean = tipoAveBean;
	}

	public LineaG(int idLineaG, String nombre, String observacion, TipoAve tipoAveBean) {
		super();
		this.idLineaG = idLineaG;
		this.nombre = nombre;
		this.observacion = observacion;
		this.tipoAveBean = tipoAveBean;
	}

	public int getIdLineaG() {
		return this.idLineaG;
	}

	public void setIdLineaG(int idLineaG) {
		this.idLineaG = idLineaG;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public TipoAve getTipoAveBean() {
		return this.tipoAveBean;
	}

	public void setTipoAveBean(TipoAve tipoAveBean) {
		this.tipoAveBean = tipoAveBean;
	}

}