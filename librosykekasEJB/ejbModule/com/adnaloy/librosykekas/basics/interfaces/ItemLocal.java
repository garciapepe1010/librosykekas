package com.adnaloy.librosykekas.basics.interfaces;



import java.util.List;

import javax.ejb.Local;


@Local
public interface ItemLocal {
	
    public String getCode() ;

	public void setCode(String code);

	public String getTitulo();

	public void setTitulo(String titulo);

	public String getResena();

	public void setResena(String resena);

	public EditorialFabLocal getEditorial();

	public void setEditorial(EditorialFabLocal editorial);

	public String getComentario();

	public void setComentario(String comentario);
	
	

	public CategoriaLocal getCategoria();


	public void setCategoria(CategoriaLocal categoria);
	
	

	public String getFiltroTitulo();
	public void setFiltroTitulo(String filtroTitulo);
	public String getFiltroResena();
	public void setFiltroResena(String filtroResena);
	public String getFiltroEditorial();
	public void setFiltroEditorial(String filtroEditorial);
	public String getFiltroCategoria();
	public void setFiltroCategoria(String filtroCategoria);
	
	

	public void reset();
	public void anado();
	public void actualizo();
	public void elimino();
	public ItemLocal buscaItem();
	public List <ItemLocal> findAllItems();
	public List <ItemLocal> findThreeItems();
	public List <ItemLocal> findItems();

}
