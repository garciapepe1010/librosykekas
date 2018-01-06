package com.adnaloy.librosykekas.librosykekasJPA;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-01T10:12:44.159+0100")
@StaticMetamodel(EditorialFab.class)
public class EditorialFab_ {
	public static volatile SingularAttribute<EditorialFab, String> code;
	public static volatile SingularAttribute<EditorialFab, String> direccion;
	public static volatile SingularAttribute<EditorialFab, String> email;
	public static volatile SingularAttribute<EditorialFab, String> nombre;
	public static volatile ListAttribute<EditorialFab, Item> items;
}
