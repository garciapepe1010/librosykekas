package com.adnaloy.librosykekas.basics.interfaces;

public interface SendMailLocal {
	
    public String getSubject();
	public void setSubject(String subject);
	public String getText();
	public void setText(String text);
	
	public String getFrom();
	public void setFrom(String from);
	public String getPass();
	public void setPass(String pass);
	public String getTo();
	public void setTo(String to);
	
	public void doIt() ;

}
