package com.adnaloy.librosykekas.basics.interfaces;

import javax.ejb.Local;

@Local

public interface AcercaDePageWebLocal {

	public String getClave();
	public void setClave(String clave);
	public String getAcercade();
	public void setAcercade(String acercade);
	public String getAunmas();
	public void setAunmas(String aunmas);
	public String getHistoria();
	public void setHistoria(String historia);
	public String getInquietudes();
	public void setInquietudes(String inquietudes);
	public String getKekas();
	public void setKekas(String kekas);

	public String getLibros();

	public void setLibros(String libros);
	public String getViajes();
	public void setViajes(String viajes);
	
	
	public String getInquietudesImg();
	public void setInquietudesImg(String inquietudesImg);
	public String getKekasImg();
	public void setKekasImg(String kekasImg);
	public String getLibrosImg();
	public void setLibrosImg(String librosImg);
	public String getViajesImg();
	public void setViajesImg(String viajesImg);
	
	
	public com.adnaloy.librosykekas.basics.interfaces.AcercaDePageWebLocal buscoAcercaDePageWEB();
	public void actualizo();

}
