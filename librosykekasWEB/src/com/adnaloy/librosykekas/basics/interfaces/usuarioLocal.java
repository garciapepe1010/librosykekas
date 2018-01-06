package com.adnaloy.librosykekas.basics.interfaces;

import java.util.ArrayList;

import javax.ejb.Local;

@Local
public interface usuarioLocal {
	
	public String getClave();
	public void setClave(String clave);
	public String getEmail();
	public void setEmail(String email);
	public String getNombre();
	public void setNombre(String nombre);
	public String getPassword();
	public void setPassword(String password);
	public ArrayList getPntlls();
	public void setPntlls(ArrayList pntlls);

	

	public usuarioLocal buscoUsuario();
	public boolean esUsuarioValido(String passwd);

}
