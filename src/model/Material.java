package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the material database table.
 * 
 */
@Entity
@NamedQuery(name="Material.findAll", query="SELECT m FROM Material m")
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_material")
	private int idMaterial;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	//bi-directional many-to-one association to Galpon
	@ManyToOne
	@JoinColumn(name="id_galpon")
	private Galpon galpon;

	public Material() {
	}

	public Material(int idMaterial, String descripcion, Date fechaIngreso, Galpon galpon) {
		super();
		this.idMaterial = idMaterial;
		this.descripcion = descripcion;
		this.fechaIngreso = fechaIngreso;
		this.galpon = galpon;
	}

	public Material(String descripcion, Date fechaIngreso, Galpon galpon) {
		super();
		this.descripcion = descripcion;
		this.fechaIngreso = fechaIngreso;
		this.galpon = galpon;
	}
	

	public int getIdMaterial() {
		return this.idMaterial;
	}

	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Galpon getGalpon() {
		return this.galpon;
	}

	public void setGalpon(Galpon galpon) {
		this.galpon = galpon;
	}

}