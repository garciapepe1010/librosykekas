package com.adnaloy.librosykekas.librosykekasJPA;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-01T10:12:44.074+0100")
@StaticMetamodel(Categoria.class)
public class Categoria_ {
	public static volatile SingularAttribute<Categoria, String> clave;
	public static volatile SingularAttribute<Categoria, String> nombre;
	public static volatile ListAttribute<Categoria, Item> items;
}
