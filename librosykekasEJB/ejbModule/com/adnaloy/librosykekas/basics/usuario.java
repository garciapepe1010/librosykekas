package com.adnaloy.librosykekas.basics;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.adnaloy.librosykekas.basics.interfaces.usuarioLocal;

/**
 * Session Bean implementation class usuario
 */
@Stateful(mappedName="usuario")
@LocalBean
public class usuario implements usuarioLocal {
	
	@PersistenceContext(unitName="librosykekasJPA", type = PersistenceContextType.TRANSACTION)	
	private EntityManager manager;

    /**
     * Default constructor. 
     */
	private String clave;
	private String email;
	private String nombre;
	private String password;
	private ArrayList<Pantalla> pntlls;
	

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Pantalla> getPntlls() {
		return pntlls;
	}

	public void setPntlls(ArrayList pntlls) {
		this.pntlls = pntlls;
	}

	
	//@TransactionAttribute(TransactionAttributeType.NEVER)
	public usuarioLocal buscoUsuario() {

		com.adnaloy.librosykekas.librosykekasJPA.Usuario uno = manager.find(com.adnaloy.librosykekas.librosykekasJPA.Usuario.class, clave);
		
		this.setClave(uno.getClave());
		
		this.setEmail(uno.getEmail());
		this.setNombre(uno.getNombre());
		
		ArrayList pntlls = new ArrayList();
		List<com.adnaloy.librosykekas.librosykekasJPA.Pantalla> pantlls = uno.getPantallas();
		
		for(Object pnt:pantlls ) {
			Pantalla ef = new Pantalla();
			
			ef.setClave(((com.adnaloy.librosykekas.librosykekasJPA.Pantalla)pnt).getClave());
			ef.setNombre(((com.adnaloy.librosykekas.librosykekasJPA.Pantalla)pnt).getNombre());
			
			pntlls.add(ef);
		}
		this.setPntlls(pntlls);

		return this;
	}
	
	public boolean esUsuarioValido(String passwd) {
		boolean esValido = false;
		
		if(passwd.equals(this.getPassword())) {
			return true;
		}
		
		return esValido;
	}
    
    
}
