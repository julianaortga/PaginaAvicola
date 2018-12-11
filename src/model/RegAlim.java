package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reg_alim database table.
 * 
 */
@Entity
@Table(name="reg_alim")
@NamedQuery(name="RegAlim.findAll", query="SELECT r FROM RegAlim r")
public class RegAlim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_reg_alim")
	private int idRegAlim;

	private int cantidad;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String observacion;

	//bi-directional many-to-one association to Lote
	@ManyToOne
	@JoinColumn(name="lote")
	private Lote loteBean;

	//bi-directional many-to-one association to DetallePlanA
	@ManyToOne
	@JoinColumn(name="detalle_plan_a")
	private DetallePlanA detallePlanABean;

	public RegAlim() {
	}

	public RegAlim(int idRegAlim, int cantidad, Date fecha, String observacion, Lote loteBean,
			DetallePlanA detallePlanABean) {
		super();
		this.idRegAlim = idRegAlim;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.observacion = observacion;
		this.loteBean = loteBean;
		this.detallePlanABean = detallePlanABean;
	}

	public RegAlim(int cantidad, Date fecha, String observacion, Lote loteBean, DetallePlanA detallePlanABean) {
		super();
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.observacion = observacion;
		this.loteBean = loteBean;
		this.detallePlanABean = detallePlanABean;
	}

	public int getIdRegAlim() {
		return this.idRegAlim;
	}

	public void setIdRegAlim(int idRegAlim) {
		this.idRegAlim = idRegAlim;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Lote getLoteBean() {
		return this.loteBean;
	}

	public void setLoteBean(Lote loteBean) {
		this.loteBean = loteBean;
	}

	public DetallePlanA getDetallePlanABean() {
		return this.detallePlanABean;
	}

	public void setDetallePlanABean(DetallePlanA detallePlanABean) {
		this.detallePlanABean = detallePlanABean;
	}

}