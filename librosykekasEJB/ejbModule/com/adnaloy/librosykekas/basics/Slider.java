package com.adnaloy.librosykekas.basics;

import com.adnaloy.librosykekas.basics.interfaces.SliderLocal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 * Session Bean implementation class Slider
 */
@Stateless(mappedName = "slider")
@Local(SliderLocal.class)
@LocalBean
public class Slider implements SliderLocal {
	
	@PersistenceContext(unitName="librosykekasJPA", type = PersistenceContextType.TRANSACTION)	
	private EntityManager manager;
	
	private String clave;
	
	private String imagen;
	
	
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	

    /**
     * Default constructor. 
     */
    public Slider() {
        // TODO Auto-generated constructor stub
    }
    
	public void reset() {
		
		this.setClave(null);
		this.setImagen(null);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void anado() {
		
		com.adnaloy.librosykekas.librosykekasJPA.Slider sdr = new com.adnaloy.librosykekas.librosykekasJPA.Slider();
		sdr.setImagen(imagen);

	    manager.persist(sdr);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void actualizo() {
		
		com.adnaloy.librosykekas.librosykekasJPA.Slider uno = manager.find(com.adnaloy.librosykekas.librosykekasJPA.Slider.class, clave);
		uno.setImagen(imagen);

	    manager.persist(uno);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void elimino() {
	
		com.adnaloy.librosykekas.librosykekasJPA.Slider uno = manager.find(com.adnaloy.librosykekas.librosykekasJPA.Slider.class, clave);
		
	    manager.remove(uno);

	}
	
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public SliderLocal buscaSlider() {
		com.adnaloy.librosykekas.librosykekasJPA.Slider uno = manager.find(com.adnaloy.librosykekas.librosykekasJPA.Slider.class, clave);

		this.setImagen(uno.getImagen());

		
		return this;
	}
	
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public List <SliderLocal> findAllSliders() {
		
		ArrayList sldrs = new ArrayList();
		
		//Atento pepe es el nombre de la clase no de la tabla
		
		Query query = manager.createQuery("Select a from Slider a");
			//query.setParameter("clave", clave);
		Collection<com.adnaloy.librosykekas.librosykekasJPA.Slider>  unos = query.getResultList();
		/*	
		Collection<com.adnaloy.librosykekas.librosykekasJPA.EditorialFab > unos = manager.createNamedQuery("findAllCustomersWithName")
	            									.getResultList();
	    */
		for(com.adnaloy.librosykekas.librosykekasJPA.Slider uno:unos) {
			
			Slider ef = new Slider();
			
			ef.setClave(uno.getClave());
			ef.setImagen(uno.getImagen());
			
			sldrs.add(ef);
			
		}
		 
		return sldrs;
	}

}