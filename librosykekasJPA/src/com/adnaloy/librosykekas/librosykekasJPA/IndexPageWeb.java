package com.adnaloy.librosykekas.librosykekasJPA;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the INDEX_PAGE_WEB database table.
 * 
 */
@Entity
@Table(name="INDEX_PAGE_WEB")
@NamedQuery(name="IndexPageWeb.findAll", query="SELECT i FROM IndexPageWeb i")
public class IndexPageWeb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INDEX_PAGE_WEB_CLAVE_GENERATOR", sequenceName="SEQUENCE_LIBROSYKEKAS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INDEX_PAGE_WEB_CLAVE_GENERATOR")
	@Column(unique=true, nullable=false, length=20)
	private String clave;

	@Column(name="COMENTARIO_1", length=250)
	private String comentario1;

	@Column(name="COMENTARIO_2", length=250)
	private String comentario2;

	@Column(name="COMENTARIO_3", length=250)
	private String comentario3;

	@Column(name="IMG_1", length=250)
	private String img1;

	@Column(name="IMG_2", length=250)
	private String img2;

	@Column(name="IMG_3", length=250)
	private String img3;

	@Column(name="IMG_4", length=250)
	private String img4;

	@Column(name="IMG_5", length=250)
	private String img5;

	@Column(length=250)
	private String presentacion;

	public IndexPageWeb() {
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getComentario1() {
		return this.comentario1;
	}

	public void setComentario1(String comentario1) {
		this.comentario1 = comentario1;
	}

	public String getComentario2() {
		return this.comentario2;
	}

	public void setComentario2(String comentario2) {
		this.comentario2 = comentario2;
	}

	public String getComentario3() {
		return this.comentario3;
	}

	public void setComentario3(String comentario3) {
		this.comentario3 = comentario3;
	}

	public String getImg1() {
		return this.img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return this.img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return this.img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public String getImg4() {
		return this.img4;
	}

	public void setImg4(String img4) {
		this.img4 = img4;
	}

	public String getImg5() {
		return this.img5;
	}

	public void setImg5(String img5) {
		this.img5 = img5;
	}

	public String getPresentacion() {
		return this.presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

}