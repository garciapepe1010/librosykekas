package com.adnaloy.librosykekas.basics.interfaces;

import java.util.List;
import javax.ejb.Local;
import com.adnaloy.librosykekas.basics.interfaces.CategoriaLocal;

@Local
public interface CategoriaLocal {
	
	
	public String getClave();
	public void setClave(String clave);
	public String getNombre();
	public void setNombre(String nombre);
	
	
	public List<ItemLocal> getItems();
	public void setItems(List<ItemLocal> items);
	
	
	public void reset();
	public void anado();
	public void actualizo();
	public void elimino();
	public CategoriaLocal buscaCategoria();
	public List <CategoriaLocal> findAllCategorias();
	

}