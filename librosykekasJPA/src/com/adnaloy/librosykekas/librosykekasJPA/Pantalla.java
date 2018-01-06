package com.adnaloy.librosykekas.librosykekasJPA;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PANTALLA database table.
 * 
 */
@Entity
@Table(name="PANTALLA")
@NamedQuery(name="Pantalla.findAll", query="SELECT p FROM Pantalla p")
public class Pantalla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PANTALLA_CLAVE_GENERATOR", sequenceName="SEQUENCE_LIBROSYKEKAS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PANTALLA_CLAVE_GENERATOR")
	@Column(unique=true, nullable=false, length=20)
	private String clave;

	@Column(nullable=false, length=125)
	private String nombre;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="pantallas")
	private List<Usuario> usuarios;

	public Pantalla() {
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}