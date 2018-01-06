package com.adnaloy.librosykekas.librosykekasJPA;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-01T10:12:44.165+0100")
@StaticMetamodel(Pantalla.class)
public class Pantalla_ {
	public static volatile SingularAttribute<Pantalla, String> clave;
	public static volatile SingularAttribute<Pantalla, String> nombre;
	public static volatile ListAttribute<Pantalla, Usuario> usuarios;
}
