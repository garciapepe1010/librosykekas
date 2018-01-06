package com.adnaloy.librosykekas.librosykekasJPA;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@Table(name="USUARIO")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_CLAVE_GENERATOR", sequenceName="SEQUENCE_LIBROSYKEKAS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_CLAVE_GENERATOR")
	@Column(unique=true, nullable=false, length=20)
	private String clave;

	@Column(length=250)
	private String email;

	@Column(nullable=false, length=150)
	private String nombre;

	@Column(nullable=false, length=50)
	private String password;

	//bi-directional many-to-many association to Pantalla
	@ManyToMany
	@JoinTable(
		name="USUARIO_PANTALLA"
		, joinColumns={
			@JoinColumn(name="USUARIO", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="PANTALLA", nullable=false)
			}
		)
	private List<Pantalla> pantallas;

	public Usuario() {
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Pantalla> getPantallas() {
		return this.pantallas;
	}

	public void setPantallas(List<Pantalla> pantallas) {
		this.pantallas = pantallas;
	}

}