package com.adnaloy.librosykekas.basics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import com.adnaloy.librosykekas.basics.interfaces.EditorialFabLocal;

@Stateless(mappedName = "EditorialFab")
@Local(EditorialFabLocal.class)
public class EditorialFab implements EditorialFabLocal {
	
	@PersistenceContext(unitName="librosykekasJPA", type = PersistenceContextType.TRANSACTION)	
	private EntityManager manager;


	//EntityManagerFactory emf = Persistence.createEntityManagerFactory("librosykekasJPA");
	//private EntityManager manager = emf.createEntityManager();
	//EntityTransaction tx = manager.getTransaction();

	
	
	private String code;
	private String direccion;
	private String email;
	private String nombre;
	
	
	/**
     * Default constructor. 
     */
	
	public EditorialFab() {
        // TODO Auto-generated constructor stub
    }
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public void reset() {
		
		this.setCode(null);
		this.setDireccion(null);
		this.setEmail(null);
		this.setNombre(null);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void anado() {
		
		com.adnaloy.librosykekas.librosykekasJPA.EditorialFab EdFabJPA = new com.adnaloy.librosykekas.librosykekasJPA.EditorialFab();
		EdFabJPA.setDireccion(direccion);
		EdFabJPA.setEmail(email);
		EdFabJPA.setNombre(nombre);
		
	    //tx.begin();
	    manager.persist(EdFabJPA);
	    //tx.commit();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void actualizo() {
		
		com.adnaloy.librosykekas.librosykekasJPA.EditorialFab uno = manager.find(com.adnaloy.librosykekas.librosykekasJPA.EditorialFab.class, code);
		uno.setDireccion(direccion);
		uno.setEmail(email);
		uno.setNombre(nombre);
		
	    //tx.begin();
	    manager.persist(uno);
	    //tx.commit();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void elimino() {
	
		com.adnaloy.librosykekas.librosykekasJPA.EditorialFab uno = manager.find(com.adnaloy.librosykekas.librosykekasJPA.EditorialFab.class, code);
		
	    //tx.begin();
	    manager.remove(uno);
	    //tx.commit();
	}
	
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public EditorialFabLocal buscaEditorialFab() {
		com.adnaloy.librosykekas.librosykekasJPA.EditorialFab uno = manager.find(com.adnaloy.librosykekas.librosykekasJPA.EditorialFab.class, code);

		this.setDireccion(uno.getDireccion());
		this.setEmail(uno.getEmail());
		this.setNombre(uno.getNombre());
		
		return this;
	}
	
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public List <EditorialFab> findAllEditorialFab() {
		
		ArrayList editsFab = new ArrayList();
		
		//Atento pepe es el nombre de la clase no de la tabla
		
		Query query = manager.createQuery("Select a from EditorialFab a");
			//query.setParameter("clave", clave);
		Collection<com.adnaloy.librosykekas.librosykekasJPA.EditorialFab>  unos = query.getResultList();
		/*	
		Collection<com.adnaloy.librosykekas.librosykekasJPA.EditorialFab > unos = manager.createNamedQuery("findAllCustomersWithName")
	            									.getResultList();
	    */
		for(com.adnaloy.librosykekas.librosykekasJPA.EditorialFab uno:unos) {
			
			EditorialFab ef = new EditorialFab();
			
			ef.setCode(uno.getCode());
			ef.setDireccion(uno.getDireccion());
			ef.setEmail(uno.getEmail());
			ef.setNombre(uno.getNombre());
			
			editsFab.add(ef);
			
		}
		 
		return editsFab;
	}
	
	
}
