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
	@SequenceGenerator(name="INDEX_PAGE_WEB_CLAVE_GENERATOR", sequenceName="SEQUENCE_LIBROSYKEKAS",initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INDEX_PAGE_WEB_CLAVE_GENERATOR")
	private String clave;

	@Column(name="COMENTARIO_1")
	private String comentario1;

	@Column(name="COMENTARIO_2")
	private String comentario2;

	@Column(name="COMENTARIO_3")
	private String comentario3;

	@Column(name="IMG_1")
	private String img1;

	@Column(name="IMG_2")
	private String img2;

	@Column(name="IMG_3")
	private String img3;

	@Column(name="IMG_4")
	private String img4;

	@Column(name="IMG_5")
	private String img5;

	private String presentacion;

	@Column(name="URL_1")
	private String url1;

	@Column(name="URL_2")
	private String url2;

	@Column(name="URL_3")
	private String url3;

	@Column(name="URL_4")
	private String url4;

	@Column(name="URL_5")
	private String url5;

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

	public String getUrl1() {
		return this.url1;
	}

	public void setUrl1(String url1) {
		this.url1 = url1;
	}

	public String getUrl2() {
		return this.url2;
	}

	public void setUrl2(String url2) {
		this.url2 = url2;
	}

	public String getUrl3() {
		return this.url3;
	}

	public void setUrl3(String url3) {
		this.url3 = url3;
	}

	public String getUrl4() {
		return this.url4;
	}

	public void setUrl4(String url4) {
		this.url4 = url4;
	}

	public String getUrl5() {
		return this.url5;
	}

	public void setUrl5(String url5) {
		this.url5 = url5;
	}

}