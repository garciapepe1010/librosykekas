package com.adnaloy.librosykekas.librosykekasJPA;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ITEM database table.
 * 
 */
@Entity
@Table(name="ITEM")
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ITEM_CODE_GENERATOR", sequenceName="SEQUENCE_LIBROSYKEKAS",initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ITEM_CODE_GENERATOR")
	@Column(unique=true, nullable=false, length=20)
	private String code;

	@Column(length=2000)
	private String comentario;

	@Column(length=250)
	private String resena;

	@Column(nullable=false, length=250)
	private String titulo;

	//bi-directional many-to-one association to Categoría
	@ManyToOne
	@JoinColumn(name="CATEGORIA", nullable=false)
	private Categoria categoria;

	//bi-directional many-to-one association to EditorialFab
	@ManyToOne
	@JoinColumn(name="EDITORIA_FAB")
	private EditorialFab editorialFab;

	public Item() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getResena() {
		return this.resena;
	}

	public void setResena(String resena) {
		this.resena = resena;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public EditorialFab getEditorialFab() {
		return this.editorialFab;
	}

	public void setEditorialFab(EditorialFab editorialFab) {
		this.editorialFab = editorialFab;
	}

}