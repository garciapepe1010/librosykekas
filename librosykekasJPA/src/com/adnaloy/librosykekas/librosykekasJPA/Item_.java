package com.adnaloy.librosykekas.librosykekasJPA;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-01T10:12:44.164+0100")
@StaticMetamodel(Item.class)
public class Item_ {
	public static volatile SingularAttribute<Item, String> code;
	public static volatile SingularAttribute<Item, String> comentario;
	public static volatile SingularAttribute<Item, String> resena;
	public static volatile SingularAttribute<Item, String> titulo;
	public static volatile SingularAttribute<Item, Categoria> categoria;
	public static volatile SingularAttribute<Item, EditorialFab> editorialFab;
}
