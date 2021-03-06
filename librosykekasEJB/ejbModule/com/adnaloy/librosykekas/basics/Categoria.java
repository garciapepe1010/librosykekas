package com.adnaloy.librosykekas.basics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import com.adnaloy.librosykekas.basics.interfaces.CategoriaLocal;


@Stateless(mappedName = "Categoria")
@LocalBean
public class Categoria implements  CategoriaLocal{
	
	@PersistenceContext(unitName="librosykekasJPA", type = PersistenceContextType.TRANSACTION)	
	private EntityManager manager;
	
	/**
     * Default constructor. 
     */
	
	public Categoria() {
        // TODO Auto-generated constructor stub
    }
	
	private String clave;
	private String nombre;
	private List items;



	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public List getItems() {
		return items;
	}
	public void setItems(List items) {
		this.items = items;
	}
	
	
	public void reset() {
		
		this.setClave(null);
		this.setNombre(null);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void anado() {
		
		com.adnaloy.librosykekas.librosykekasJPA.Categoria categoria = new com.adnaloy.librosykekas.librosykekasJPA.Categoria();

		categoria.setNombre(nombre);
		
	    //tx.begin();
	    manager.persist(categoria);
	    //tx.commit();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void actualizo() {
		
		com.adnaloy.librosykekas.librosykekasJPA.Categoria uno = manager.find(com.adnaloy.librosykekas.librosykekasJPA.Categoria.class, clave);
		uno.setNombre(nombre);
		
	    //tx.begin();
	    manager.persist(uno);
	    //tx.commit();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void elimino() {
	
		com.adnaloy.librosykekas.librosykekasJPA.Categoria uno = manager.find(com.adnaloy.librosykekas.librosykekasJPA.Categoria.class, clave);
		
	    //tx.begin();
	    manager.remove(uno);
	    //tx.commit();
	}
	
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public CategoriaLocal buscaCategoria() {
		com.adnaloy.librosykekas.librosykekasJPA.Categoria uno = manager.find(com.adnaloy.librosykekas.librosykekasJPA.Categoria.class, clave);

		this.setNombre(uno.getNombre());
		this.setItems(uno.getItems());
		
		return this;
	}
	
	
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public List findAllCategorias() {
		
		ArrayList categorias = new ArrayList();
		
		//Atento pepe es el nombre de la clase no de la tabla
		
		Query query = manager.createQuery("Select a from Categoria a");
			//query.setParameter("clave", clave);
		Collection<com.adnaloy.librosykekas.librosykekasJPA.Categoria>  unos = query.getResultList();
		/*	
		Collection<com.adnaloy.librosykekas.librosykekasJPA.EditorialFab > unos = manager.createNamedQuery("findAllCustomersWithName")
	            									.getResultList();
	    */
		for(com.adnaloy.librosykekas.librosykekasJPA.Categoria uno:unos) {
			
			Categoria ef = new Categoria();
			
			ef.setClave(uno.getClave());
			ef.setNombre(uno.getNombre());
			ef.setItems(uno.getItems());
			
			categorias.add(ef);
			
		}
		 
		return categorias;
	}
	
	

}
