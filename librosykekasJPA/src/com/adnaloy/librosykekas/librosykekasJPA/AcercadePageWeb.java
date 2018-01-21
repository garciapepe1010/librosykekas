package com.adnaloy.librosykekas.librosykekasJPA;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ACERCADE_PAGE_WEB database table.
 * 
 */
@Entity
@Table(name="ACERCADE_PAGE_WEB")
@NamedQuery(name="AcercadePageWeb.findAll", query="SELECT a FROM AcercadePageWeb a")
public class AcercadePageWeb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACERCADE_PAGE_WEB_CLAVE_GENERATOR", sequenceName="SEQUENCE_LIBROSYKEKAS",initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACERCADE_PAGE_WEB_CLAVE_GENERATOR")
	private String clave;

	private String acercade;

	private String aunmas;

	private String historia;

	private String inquietudes;

	@Column(name="INQUIETUDES_IMG")
	private String inquietudesImg;

	private String kekas;

	@Column(name="KEKAS_IMG")
	private String kekasImg;

	private String libros;

	@Column(name="LIBROS_IMG")
	private String librosImg;

	private String viajes;

	@Column(name="VIAJES_IMG")
	private String viajesImg;

	public AcercadePageWeb() {
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getAcercade() {
		return this.acercade;
	}

	public void setAcercade(String acercade) {
		this.acercade = acercade;
	}

	public String getAunmas() {
		return this.aunmas;
	}

	public void setAunmas(String aunmas) {
		this.aunmas = aunmas;
	}

	public String getHistoria() {
		return this.historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public String getInquietudes() {
		return this.inquietudes;
	}

	public void setInquietudes(String inquietudes) {
		this.inquietudes = inquietudes;
	}

	public String getInquietudesImg() {
		return this.inquietudesImg;
	}

	public void setInquietudesImg(String inquietudesImg) {
		this.inquietudesImg = inquietudesImg;
	}

	public String getKekas() {
		return this.kekas;
	}

	public void setKekas(String kekas) {
		this.kekas = kekas;
	}

	public String getKekasImg() {
		return this.kekasImg;
	}

	public void setKekasImg(String kekasImg) {
		this.kekasImg = kekasImg;
	}

	public String getLibros() {
		return this.libros;
	}

	public void setLibros(String libros) {
		this.libros = libros;
	}

	public String getLibrosImg() {
		return this.librosImg;
	}

	public void setLibrosImg(String librosImg) {
		this.librosImg = librosImg;
	}

	public String getViajes() {
		return this.viajes;
	}

	public void setViajes(String viajes) {
		this.viajes = viajes;
	}

	public String getViajesImg() {
		return this.viajesImg;
	}

	public void setViajesImg(String viajesImg) {
		this.viajesImg = viajesImg;
	}

}