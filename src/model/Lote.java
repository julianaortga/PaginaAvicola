package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lote database table.
 * 
 */
@Entity
@NamedQuery(name="Lote.findAll", query="SELECT l FROM Lote l")
public class Lote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_lote")
	private int idLote;

	@Column(name="obs_inicial")
	private String obsInicial;

	private String ubicacion;

	//bi-directional many-to-one association to Galpon
	@OneToMany(mappedBy="loteBean")
	private List<Galpon> galpons;

	//bi-directional many-to-one association to RegAlim
	@OneToMany(mappedBy="loteBean")
	private List<RegAlim> regAlims;

	public Lote() {
	}
	
	public Lote(int idLote,String obsInicial, String ubicacion) {
		super();
		this.idLote = idLote;
		this.obsInicial = obsInicial;
		this.ubicacion = ubicacion;
	} 
	
	public Lote(String obsInicial, String ubicacion) {
		super();
		this.obsInicial = obsInicial;
		this.ubicacion = ubicacion;
	}

	public Lote(int idLote, String obsInicial, String ubicacion, List<Galpon> galpons, List<RegAlim> regAlims) {
		super();
		this.idLote = idLote;
		this.obsInicial = obsInicial;
		this.ubicacion = ubicacion;
		this.galpons = galpons;
		this.regAlims = regAlims;
	}

	public Lote(String obsInicial, String ubicacion, List<Galpon> galpons, List<RegAlim> regAlims) {
		super();
		this.obsInicial = obsInicial;
		this.ubicacion = ubicacion;
		this.galpons = galpons;
		this.regAlims = regAlims;
	}

	public int getIdLote() {
		return this.idLote;
	}

	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}

	public String getObsInicial() {
		return this.obsInicial;
	}

	public void setObsInicial(String obsInicial) {
		this.obsInicial = obsInicial;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Galpon> getGalpons() {
		return this.galpons;
	}

	public void setGalpons(List<Galpon> galpons) {
		this.galpons = galpons;
	}

	public Galpon addGalpon(Galpon galpon) {
		getGalpons().add(galpon);
		galpon.setLoteBean(this);

		return galpon;
	}

	public Galpon removeGalpon(Galpon galpon) {
		getGalpons().remove(galpon);
		galpon.setLoteBean(null);

		return galpon;
	}

	public List<RegAlim> getRegAlims() {
		return this.regAlims;
	}

	public void setRegAlims(List<RegAlim> regAlims) {
		this.regAlims = regAlims;
	}

	public RegAlim addRegAlim(RegAlim regAlim) {
		getRegAlims().add(regAlim);
		regAlim.setLoteBean(this);

		return regAlim;
	}

	public RegAlim removeRegAlim(RegAlim regAlim) {
		getRegAlims().remove(regAlim);
		regAlim.setLoteBean(null);

		return regAlim;
	}

}