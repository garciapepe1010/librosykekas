package com.adnaloy.librosykekas.basics;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.adnaloy.librosykekas.basics.interfaces.PantallaLocal;

/**
 * Session Bean implementation class Pantalla
 */
@Stateless(mappedName = "Pantalla")
@LocalBean
public class Pantalla implements PantallaLocal {

    /**
     * Default constructor. 
     */
	
	private String clave;
	private String nombre;
	
	
    public Pantalla() {
        // TODO Auto-generated constructor stub
    }


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
    
    

}
