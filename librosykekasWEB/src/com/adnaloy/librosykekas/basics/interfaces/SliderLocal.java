package com.adnaloy.librosykekas.basics.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;


public interface SliderLocal {
	
	public String getClave();
	public void setClave(String clave);
	public String getImagen();
	public void setImagen(String imagen);

    
	public void reset();
	public void anado();
	public void actualizo();
	public void elimino();
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public SliderLocal buscaSlider();
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public List <SliderLocal> findAllSliders();

}
