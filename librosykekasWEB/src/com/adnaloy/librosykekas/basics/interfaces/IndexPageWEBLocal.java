package com.adnaloy.librosykekas.basics.interfaces;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

public interface IndexPageWEBLocal {
	
	
	public String getClave();
	public void setClave(String clave);
	public String getComentario1();
	public void setComentario1(String comentario1);
	public String getComentario2();
	public void setComentario2(String comentario2);
	public String getComentario3();
	public void setComentario3(String comentario3);
	public String getImg1();
	public void setImg1(String img1);
	public String getImg2();
	public void setImg2(String img2);
	public String getImg3();
	public void setImg3(String img3);
	public String getImg4();
	public void setImg4(String img4);
	public String getImg5();
	public void setImg5(String img5);
	public String getPresentacion();
	public void setPresentacion(String presentacion);
	
	
	public com.adnaloy.librosykekas.basics.interfaces.IndexPageWEBLocal buscoIndexPageWEB();
	public void actualizo();

}
