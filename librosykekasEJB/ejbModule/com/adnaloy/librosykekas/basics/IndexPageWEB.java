package com.adnaloy.librosykekas.basics;

import com.adnaloy.librosykekas.basics.interfaces.IndexPageWEBLocal;
import com.adnaloy.librosykekas.basics.interfaces.usuarioLocal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 * Session Bean implementation class IndexPageWEB
 */
@Stateless(mappedName = "IndexPageWEB")
//@TransactionManagement(TransactionManagementType.BEAN)
@Local(IndexPageWEBLocal.class)
public class IndexPageWEB implements IndexPageWEBLocal {
	@PersistenceContext(unitName="librosykekasJPA", type = PersistenceContextType.TRANSACTION)	
	private EntityManager manager;

    /**
     * Default constructor. 
     */
	
	private String clave;
	private String comentario1;
	private String comentario2;
	private String comentario3;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private String img5;
	private String presentacion;
	
	private String url1;
	private String url2;
	private String url3;
	private String url4;
	private String url5;
	
	
    public IndexPageWEB() {
        // TODO Auto-generated constructor stub
    }


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getComentario1() {
		return comentario1;
	}


	public void setComentario1(String comentario1) {
		this.comentario1 = comentario1;
	}


	public String getComentario2() {
		return comentario2;
	}


	public void setComentario2(String comentario2) {
		this.comentario2 = comentario2;
	}


	public String getComentario3() {
		return comentario3;
	}


	public void setComentario3(String comentario3) {
		this.comentario3 = comentario3;
	}


	public String getImg1() {
		return img1;
	}


	public void setImg1(String img1) {
		this.img1 = img1;
	}


	public String getImg2() {
		return img2;
	}


	public void setImg2(String img2) {
		this.img2 = img2;
	}


	public String getImg3() {
		return img3;
	}


	public void setImg3(String img3) {
		this.img3 = img3;
	}


	public String getImg4() {
		return img4;
	}


	public void setImg4(String img4) {
		this.img4 = img4;
	}


	public String getImg5() {
		return img5;
	}


	public void setImg5(String img5) {
		this.img5 = img5;
	}


	public String getPresentacion() {
		return presentacion;
	}


	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	
    
	public String getUrl1() {
		return url1;
	}


	public void setUrl1(String url1) {
		this.url1 = url1;
	}


	public String getUrl2() {
		return url2;
	}


	public void setUrl2(String url2) {
		this.url2 = url2;
	}


	public String getUrl3() {
		return url3;
	}


	public void setUrl3(String url3) {
		this.url3 = url3;
	}


	public String getUrl4() {
		return url4;
	}


	public void setUrl4(String url4) {
		this.url4 = url4;
	}


	public String getUrl5() {
		return url5;
	}


	public void setUrl5(String url5) {
		this.url5 = url5;
	}


	@TransactionAttribute(TransactionAttributeType.NEVER)
	public com.adnaloy.librosykekas.basics.interfaces.IndexPageWEBLocal buscoIndexPageWEB() {
			/*
			Query query = manager
		         .createQuery("Select a from INDEX_PAGE_WEB a where a.clave = :clave");
			query.setParameter("clave", clave);
			com.adnaloy.librosykekas.librosykekasJPA.IndexPageWeb uno = (com.adnaloy.librosykekas.librosykekasJPA.IndexPageWeb) query.getSingleResult();
			*/
			com.adnaloy.librosykekas.librosykekasJPA.IndexPageWeb uno = manager.find(com.adnaloy.librosykekas.librosykekasJPA.IndexPageWeb.class, clave);
			
			this.setClave(uno.getClave());
			
			this.setComentario1(uno.getComentario1());
			this.setComentario2(uno.getComentario2());
			this.setComentario3(uno.getComentario3());

			this.setImg1(uno.getImg1());
			this.setImg2(uno.getImg2());
			this.setImg3(uno.getImg3());
			this.setImg4(uno.getImg4());
			this.setImg5(uno.getImg5());
			
			
			this.setPresentacion(uno.getPresentacion());
			

			return this;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void actualizo() {

		
		com.adnaloy.librosykekas.librosykekasJPA.IndexPageWeb IPWJPA = manager.find(com.adnaloy.librosykekas.librosykekasJPA.IndexPageWeb.class, this.getClave());

	
		
		IPWJPA.setComentario1(this.getComentario1());
		IPWJPA.setComentario2(this.getComentario2());
		IPWJPA.setComentario3(this.getComentario3());

		IPWJPA.setImg1(this.getImg1());
		IPWJPA.setImg2(this.getImg2());
		IPWJPA.setImg3(this.getImg3());
		IPWJPA.setImg4(this.getImg4());
		IPWJPA.setImg5(this.getImg5());
		
		
		IPWJPA.setPresentacion(this.getPresentacion());
		
	    //tx.begin();
	    manager.persist(IPWJPA);
	    //tx.commit();
	}

}
