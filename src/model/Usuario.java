package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int idUsuario;

	private String contrasena;

	private String correo;

	private String nombre;

	private int rol;

	private String username;

	public Usuario() {
	}

	public Usuario(int idUsuario, String contrasena, String correo, String nombre, int rol, String username) {
		super();
		this.idUsuario = idUsuario;
		this.contrasena = contrasena;
		this.correo = correo;
		this.nombre = nombre;
		this.rol = rol;
		this.username = username;
	}

	public Usuario(String contrasena, String correo, String nombre, int rol, String username) {
		super();
		this.contrasena = contrasena;
		this.correo = correo;
		this.nombre = nombre;
		this.rol = rol;
		this.username = username;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRol() {
		return this.rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}