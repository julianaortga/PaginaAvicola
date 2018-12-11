package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the detalle_plan_a database table.
 * 
 */
@Entity
@Table(name="detalle_plan_a")
@NamedQuery(name="DetallePlanA.findAll", query="SELECT d FROM DetallePlanA d")
public class DetallePlanA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_detalle_p")
	private int idDetalleP;

	private int cantidad;

	private String dia;

	//bi-directional many-to-one association to Alimento
	@ManyToOne
	@JoinColumn(name="alimento")
	private Alimento alimentoBean;

	//bi-directional many-to-one association to EtapaProducc
	@ManyToOne
	@JoinColumn(name="e_producc")
	private EtapaProducc etapaProducc;

	//bi-directional many-to-one association to RegAlim
	@OneToMany(mappedBy="detallePlanABean")
	private List<RegAlim> regAlims;

	public DetallePlanA() {
	}


	public DetallePlanA(int cantidad, String dia, Alimento alimentoBean, EtapaProducc etapaProducc) {
		super();
		this.cantidad = cantidad;
		this.dia = dia;
		this.alimentoBean = alimentoBean;
		this.etapaProducc = etapaProducc;
	}
	
	public DetallePlanA(int idDetalleP, int cantidad, String dia, Alimento alimentoBean, EtapaProducc etapaProducc,
			List<RegAlim> regAlims) {
		super();
		this.idDetalleP = idDetalleP;
		this.cantidad = cantidad;
		this.dia = dia;
		this.alimentoBean = alimentoBean;
		this.etapaProducc = etapaProducc;
		this.regAlims = regAlims;
	}

	public DetallePlanA(int cantidad, String dia, Alimento alimentoBean, EtapaProducc etapaProducc,
			List<RegAlim> regAlims) {
		super();
		this.cantidad = cantidad;
		this.dia = dia;
		this.alimentoBean = alimentoBean;
		this.etapaProducc = etapaProducc;
		this.regAlims = regAlims;
	}

	public int getIdDetalleP() {
		return this.idDetalleP;
	}

	public void setIdDetalleP(int idDetalleP) {
		this.idDetalleP = idDetalleP;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDia() {
		return this.dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Alimento getAlimentoBean() {
		return this.alimentoBean;
	}

	public void setAlimentoBean(Alimento alimentoBean) {
		this.alimentoBean = alimentoBean;
	}

	public EtapaProducc getEtapaProducc() {
		return this.etapaProducc;
	}

	public void setEtapaProducc(EtapaProducc etapaProducc) {
		this.etapaProducc = etapaProducc;
	}

	public List<RegAlim> getRegAlims() {
		return this.regAlims;
	}

	public void setRegAlims(List<RegAlim> regAlims) {
		this.regAlims = regAlims;
	}

	public RegAlim addRegAlim(RegAlim regAlim) {
		getRegAlims().add(regAlim);
		regAlim.setDetallePlanABean(this);

		return regAlim;
	}

	public RegAlim removeRegAlim(RegAlim regAlim) {
		getRegAlims().remove(regAlim);
		regAlim.setDetallePlanABean(null);

		return regAlim;
	}

}