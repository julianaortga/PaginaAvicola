package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the galpon database table.
 * 
 */
@Entity
@NamedQuery(name="Galpon.findAll", query="SELECT g FROM Galpon g")
public class Galpon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_galpon")
	private int idGalpon;

	private float altura;

	private float anchura;

	private String estado;

	@Column(name="obs_inicial")
	private String obsInicial;

	@Column(name="tipo_galpon")
	private String tipoGalpon;

	@Column(name="tope_max")
	private int topeMax;

	//bi-directional many-to-one association to Ave
	@OneToMany(mappedBy="galponBean")
	private List<Ave> aves;

	//bi-directional many-to-one association to Lote
	@ManyToOne
	@JoinColumn(name="lote")
	private Lote loteBean;

	//bi-directional many-to-one association to Material
	@OneToMany(mappedBy="galpon")
	private List<Material> materials;

	public Galpon() {
	}

	public Galpon(int idGalpon, float altura, float anchura, String estado, String obsInicial, String tipoGalpon,
			int topeMax, List<Ave> aves, Lote loteBean, List<Material> materials) {
		super();
		this.idGalpon = idGalpon;
		this.altura = altura;
		this.anchura = anchura;
		this.estado = estado;
		this.obsInicial = obsInicial;
		this.tipoGalpon = tipoGalpon;
		this.topeMax = topeMax;
		this.aves = aves;
		this.loteBean = loteBean;
		this.materials = materials;
	}

	public Galpon(float altura, float anchura, String estado, String obsInicial, String tipoGalpon, int topeMax,
			List<Ave> aves, Lote loteBean, List<Material> materials) {
		super();
		this.altura = altura;
		this.anchura = anchura;
		this.estado = estado;
		this.obsInicial = obsInicial;
		this.tipoGalpon = tipoGalpon;
		this.topeMax = topeMax;
		this.aves = aves;
		this.loteBean = loteBean;
		this.materials = materials;
	}
	public Galpon(int idGalpon,float altura, float anchura, String estado, String obsInicial, String tipoGalpon, int topeMax,
			 Lote loteBean) {
		super();
		this.idGalpon = idGalpon;
		this.altura = altura;
		this.anchura = anchura;
		this.estado = estado;
		this.obsInicial = obsInicial;
		this.tipoGalpon = tipoGalpon;
		this.topeMax = topeMax;
		this.loteBean = loteBean;
	}
	
	public Galpon(float altura, float anchura, String estado, String obsInicial, String tipoGalpon, int topeMax,
			 Lote loteBean) {
		super();
		this.altura = altura;
		this.anchura = anchura;
		this.estado = estado;
		this.obsInicial = obsInicial;
		this.tipoGalpon = tipoGalpon;
		this.topeMax = topeMax;
		this.loteBean = loteBean;
	}

	

	public int getIdGalpon() {
		return this.idGalpon;
	}

	public void setIdGalpon(int idGalpon) {
		this.idGalpon = idGalpon;
	}

	public float getAltura() {
		return this.altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getAnchura() {
		return this.anchura;
	}

	public void setAnchura(float anchura) {
		this.anchura = anchura;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObsInicial() {
		return this.obsInicial;
	}

	public void setObsInicial(String obsInicial) {
		this.obsInicial = obsInicial;
	}

	public String getTipoGalpon() {
		return this.tipoGalpon;
	}

	public void setTipoGalpon(String tipoGalpon) {
		this.tipoGalpon = tipoGalpon;
	}

	public int getTopeMax() {
		return this.topeMax;
	}

	public void setTopeMax(int topeMax) {
		this.topeMax = topeMax;
	}

	public List<Ave> getAves() {
		return this.aves;
	}

	public void setAves(List<Ave> aves) {
		this.aves = aves;
	}

	public Ave addAve(Ave ave) {
		getAves().add(ave);
		ave.setGalponBean(this);

		return ave;
	}

	public Ave removeAve(Ave ave) {
		getAves().remove(ave);
		ave.setGalponBean(null);

		return ave;
	}

	public Lote getLoteBean() {
		return this.loteBean;
	}

	public void setLoteBean(Lote loteBean) {
		this.loteBean = loteBean;
	}

	public List<Material> getMaterials() {
		return this.materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public Material addMaterial(Material material) {
		getMaterials().add(material);
		material.setGalpon(this);

		return material;
	}

	public Material removeMaterial(Material material) {
		getMaterials().remove(material);
		material.setGalpon(null);

		return material;
	}

}