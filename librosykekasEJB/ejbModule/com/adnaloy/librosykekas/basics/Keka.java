package com.adnaloy.librosykekas.basics;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateless(mappedName = "keka")
@LocalBean
public class Keka {
	
	@PersistenceContext(unitName="librosykekasJPA", type = PersistenceContextType.TRANSACTION)	
	private EntityManager manager;
	
	
	private String code;
	private String titulo;
	private String resena;
	private String fabrica;
	private String comentario;
	
	/**
     * Default constructor. 
     */
	
	public Keka() {
        // TODO Auto-generated constructor stub
    }
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResena() {
		return resena;
	}
	public void setResena(String resena) {
		this.resena = resena;
	}
	public String getFabrica() {
		return fabrica;
	}
	public void setFabrica(String fabrica) {
		this.fabrica = fabrica;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	

}
