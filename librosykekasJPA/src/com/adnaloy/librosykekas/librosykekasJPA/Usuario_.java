package com.adnaloy.librosykekas.librosykekasJPA;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-01T10:12:44.166+0100")
@StaticMetamodel(Usuario.class)
public class Usuario_ {
	public static volatile SingularAttribute<Usuario, String> clave;
	public static volatile SingularAttribute<Usuario, String> email;
	public static volatile SingularAttribute<Usuario, String> nombre;
	public static volatile SingularAttribute<Usuario, String> password;
	public static volatile ListAttribute<Usuario, Pantalla> pantallas;
}