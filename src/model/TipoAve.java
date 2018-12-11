package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tipo_ave database table.
 * 
 */
@Entity
@Table(name = "tipo_ave")
@NamedQuery(name = "TipoAve.findAll", query = "SELECT t FROM TipoAve t")
public class TipoAve implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_ave")
	private int idTipoAve;

	private String nombre;

	// bi-directional many-to-one association to LineaG
	@OneToMany(mappedBy = "tipoAveBean")
	private List<LineaG> lineaGs;

	// bi-directional many-to-one association to Raza
	@OneToMany(mappedBy = "tipoAveBean")
	private List<Raza> razas;

	public TipoAve() {
		super();
	}

	public TipoAve(int id) {
		super();
		this.idTipoAve = id;
	}

	public TipoAve(String nombre) {
		super();
		this.nombre = nombre;
	}

	public TipoAve(int id, String nombre) {
		super();
		this.idTipoAve = id;
		this.nombre = nombre;
	}

	public int getIdTipoAve() {
		return this.idTipoAve;
	}

	public void setIdTipoAve(int idTipoAve) {
		this.idTipoAve = idTipoAve;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<LineaG> getLineaGs() {
		return this.lineaGs;
	}

	public void setLineaGs(List<LineaG> lineaGs) {
		this.lineaGs = lineaGs;
	}

	public LineaG addLineaG(LineaG lineaG) {
		getLineaGs().add(lineaG);
		lineaG.setTipoAveBean(this);

		return lineaG;
	}

	public LineaG removeLineaG(LineaG lineaG) {
		getLineaGs().remove(lineaG);
		lineaG.setTipoAveBean(null);

		return lineaG;
	}

	public List<Raza> getRazas() {
		return this.razas;
	}

	public void setRazas(List<Raza> razas) {
		this.razas = razas;
	}

	public Raza addRaza(Raza raza) {
		getRazas().add(raza);
		raza.setTipoAveBean(this);

		return raza;
	}

	public Raza removeRaza(Raza raza) {
		getRazas().remove(raza);
		raza.setTipoAveBean(null);

		return raza;
	}

}