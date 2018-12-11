package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the etapa_producc database table.
 * 
 */
@Entity
@Table(name="etapa_producc")
@NamedQuery(name="EtapaProducc.findAll", query="SELECT e FROM EtapaProducc e")
public class EtapaProducc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_e_producc")
	private int idEProducc;

	private String descripcion;

	private int duracion;

	private String nombre;

	//bi-directional many-to-one association to DetallePlanA
	@OneToMany(mappedBy="etapaProducc")
	private List<DetallePlanA> detallePlanAs;

	public EtapaProducc() {
	}


	public EtapaProducc(String descripcion, int duracion, String nombre) {
		super();
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.nombre = nombre;
	}
	
	public EtapaProducc(int idEProducc,String descripcion, int duracion, String nombre) {
		super();
		this.idEProducc = idEProducc;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.nombre = nombre;
	}
	
	public EtapaProducc(int idEProducc, String descripcion, int duracion, String nombre,
			List<DetallePlanA> detallePlanAs) {
		super();
		this.idEProducc = idEProducc;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.nombre = nombre;
		this.detallePlanAs = detallePlanAs;
	}

	public EtapaProducc(String descripcion, int duracion, String nombre, List<DetallePlanA> detallePlanAs) {
		super();
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.nombre = nombre;
		this.detallePlanAs = detallePlanAs;
	}
	


	public int getIdEProducc() {
		return this.idEProducc;
	}

	public void setIdEProducc(int idEProducc) {
		this.idEProducc = idEProducc;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<DetallePlanA> getDetallePlanAs() {
		return this.detallePlanAs;
	}

	public void setDetallePlanAs(List<DetallePlanA> detallePlanAs) {
		this.detallePlanAs = detallePlanAs;
	}

	public DetallePlanA addDetallePlanA(DetallePlanA detallePlanA) {
		getDetallePlanAs().add(detallePlanA);
		detallePlanA.setEtapaProducc(this);

		return detallePlanA;
	}

	public DetallePlanA removeDetallePlanA(DetallePlanA detallePlanA) {
		getDetallePlanAs().remove(detallePlanA);
		detallePlanA.setEtapaProducc(null);

		return detallePlanA;
	}

}