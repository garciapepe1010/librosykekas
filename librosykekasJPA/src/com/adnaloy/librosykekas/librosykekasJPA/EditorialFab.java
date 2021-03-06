package com.adnaloy.librosykekas.librosykekasJPA;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EDITORIAL_FAB database table.
 * 
 */
@Entity
@Table(name="EDITORIAL_FAB")
@NamedQuery(name="EditorialFab.findAll", query="SELECT e FROM EditorialFab e")
public class EditorialFab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EDITORIAL_FAB_CODE_GENERATOR", sequenceName="SEQUENCE_LIBROSYKEKAS",initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EDITORIAL_FAB_CODE_GENERATOR")
	@Column(unique=true, nullable=false, length=20)
	private String code;

	@Column(length=250)
	private String direccion;

	@Column(length=150)
	private String email;

	@Column(nullable=false, length=100)
	private String nombre;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="editorialFab")
	private List<Item> items;

	public EditorialFab() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setEditorialFab(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setEditorialFab(null);

		return item;
	}

}