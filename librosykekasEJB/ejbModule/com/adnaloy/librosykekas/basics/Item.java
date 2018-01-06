package com.adnaloy.librosykekas.basics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import com.adnaloy.librosykekas.basics.interfaces.CategoriaLocal;
import com.adnaloy.librosykekas.basics.interfaces.ItemLocal;

/**
 * Session Bean implementation class Libro
 */
@Stateless(mappedName = "libro")
@LocalBean
public class Item implements ItemLocal{
	
	@PersistenceContext(unitName="librosykekasJPA", type = PersistenceContextType.TRANSACTION)	
	private EntityManager manager;
	
	@EJB(mappedName="Categoria")
	Categoria cat;
	
	@EJB(mappedName="EditorialFab")
	EditorialFab ef;

    
	
	private String code;
	private String titulo;
	private String resena;
	private EditorialFab editorial;
	private String comentario;
	private Categoria categoria;
	
	
	/**
     * Default constructor. 
     */
	
	public Item() {
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

	public EditorialFab getEditorial() {
		return editorial;
	}

	public void setEditorial(EditorialFab editorial) {
		this.editorial = editorial;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	

	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	public void reset() {
		
		this.setCode(null);
		this.setTitulo(null);
		this.setResena(null);
		this.setEditorial(null);
		this.setComentario(null);
		this.setCategoria(null);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void anado() {
		
		com.adnaloy.librosykekas.librosykekasJPA.Item item = new com.adnaloy.librosykekas.librosykekasJPA.Item();

		item.setTitulo(this.getTitulo());
		item.setResena(this.getResena());
		
		com.adnaloy.librosykekas.librosykekasJPA.EditorialFab efjpa = new com.adnaloy.librosykekas.librosykekasJPA.EditorialFab();
		efjpa.setCode(this.getEditorial().getCode());
		efjpa.setDireccion(this.getEditorial().getDireccion());
		efjpa.setEmail(this.getEditorial().getEmail());
		efjpa.setNombre(this.getEditorial().getNombre());
		item.setEditorialFab(efjpa);
		
		item.setComentario(this.getComentario());
		
		com.adnaloy.librosykekas.librosykekasJPA.Categoria catjpa = new com.adnaloy.librosykekas.librosykekasJPA.Categoria();
		catjpa.setClave(this.getCategoria().getClave());
		catjpa.setNombre(this.getCategoria().getNombre());
		item.setCategoria(catjpa);
		
	    //tx.begin();
	    manager.persist(item);
	    //tx.commit();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void actualizo() {
		
		com.adnaloy.librosykekas.librosykekasJPA.Item uno = manager.find(com.adnaloy.librosykekas.librosykekasJPA.Item.class, code);
		uno.setTitulo(this.getTitulo());
		uno.setResena(this.getResena());
		
		com.adnaloy.librosykekas.librosykekasJPA.EditorialFab efjpa = new com.adnaloy.librosykekas.librosykekasJPA.EditorialFab();
		efjpa.setCode(this.getEditorial().getCode());
		efjpa.setDireccion(this.getEditorial().getDireccion());
		efjpa.setEmail(this.getEditorial().getEmail());
		efjpa.setNombre(this.getEditorial().getNombre());
		uno.setEditorialFab(efjpa);
		
		uno.setComentario(this.getComentario());
		
		com.adnaloy.librosykekas.librosykekasJPA.Categoria catjpa = new com.adnaloy.librosykekas.librosykekasJPA.Categoria();
		catjpa.setClave(this.getCategoria().getClave());
		catjpa.setNombre(this.getCategoria().getNombre());
		uno.setCategoria(catjpa);
		
	    //tx.begin();
	    manager.persist(uno);
	    //tx.commit();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void elimino() {
	
		com.adnaloy.librosykekas.librosykekasJPA.Item uno = manager.find(com.adnaloy.librosykekas.librosykekasJPA.Item.class, code);
		
	    //tx.begin();
	    manager.remove(uno);
	    //tx.commit();
	}
	
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public Item buscaEditorialFab() {
		com.adnaloy.librosykekas.librosykekasJPA.Item uno = manager.find(com.adnaloy.librosykekas.librosykekasJPA.Item.class, code);

		this.setCode(uno.getCode());
		this.setTitulo(uno.getTitulo());
		this.setResena(uno.getResena());
		ef.setCode(uno.getEditorialFab().getCode());
		ef.buscaEditorialFab();
		this.setEditorial(ef);
		this.setComentario(uno.getComentario());
		cat.setClave(uno.getCategoria().getClave());
		cat.buscaCategoria();
		this.setCategoria(cat);
		
		return this;
	}
	
	
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public List <Item> findAllItems() {
		
		ArrayList items = new ArrayList();
		
		//Atento pepe es el nombre de la clase no de la tabla
		
		Query query = manager.createQuery("Select a from Item a");
			//query.setParameter("clave", clave);
		Collection<com.adnaloy.librosykekas.librosykekasJPA.Item>  unos = query.getResultList();
		/*	
		Collection<com.adnaloy.librosykekas.librosykekasJPA.EditorialFab > unos = manager.createNamedQuery("findAllCustomersWithName")
	            									.getResultList();
	    */
		for(com.adnaloy.librosykekas.librosykekasJPA.Item uno:unos) {
			
			Item it = new Item();
			
			it.setCode(uno.getCode());
			it.setTitulo(uno.getTitulo());
			it.setResena(uno.getResena());
			
			ef.setCode(uno.getEditorialFab().getCode());
			ef.buscaEditorialFab();
			it.setEditorial(ef);
			
			it.setComentario(uno.getComentario());
			
			cat.setClave(uno.getCategoria().getClave());
			cat.buscaCategoria();
			it.setCategoria(cat);
			
			items.add(it);
			
		}
		 
		return items;
	}
}
