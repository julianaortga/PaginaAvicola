package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the alimento database table.
 * 
 */
@Entity
@NamedQuery(name="Alimento.findAll", query="SELECT a FROM Alimento a")
public class Alimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_alimento")
	private int idAlimento;

	private String nombre;

	private String tipo;

	//bi-directional many-to-one association to DetallePlanA
	@OneToMany(mappedBy="alimentoBean")
	private List<DetallePlanA> detallePlanAs;

	public Alimento() {
	}
	
	public Alimento(int idAlimento,String nombre, String tipo) {
		super();
		this.idAlimento = idAlimento;
		this.nombre = nombre;
		this.tipo = tipo;
	}	
	
	public Alimento(String nombre, String tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}	

	public Alimento(int idAlimento, String nombre, String tipo, List<DetallePlanA> detallePlanAs) {
		super();
		this.idAlimento = idAlimento;
		this.nombre = nombre;
		this.tipo = tipo;
		this.detallePlanAs = detallePlanAs;
	}

	public Alimento(String nombre, String tipo, List<DetallePlanA> detallePlanAs) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.detallePlanAs = detallePlanAs;
	}

	public int getIdAlimento() {
		return this.idAlimento;
	}

	public void setIdAlimento(int idAlimento) {
		this.idAlimento = idAlimento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<DetallePlanA> getDetallePlanAs() {
		return this.detallePlanAs;
	}

	public void setDetallePlanAs(List<DetallePlanA> detallePlanAs) {
		this.detallePlanAs = detallePlanAs;
	}

	public DetallePlanA addDetallePlanA(DetallePlanA detallePlanA) {
		getDetallePlanAs().add(detallePlanA);
		detallePlanA.setAlimentoBean(this);

		return detallePlanA;
	}

	public DetallePlanA removeDetallePlanA(DetallePlanA detallePlanA) {
		getDetallePlanAs().remove(detallePlanA);
		detallePlanA.setAlimentoBean(null);

		return detallePlanA;
	}

}