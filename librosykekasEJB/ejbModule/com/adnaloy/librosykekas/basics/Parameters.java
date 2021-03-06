package com.adnaloy.librosykekas.basics;

import com.adnaloy.librosykekas.basics.interfaces.ParametersLocal;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Session Bean implementation class Parameters
 */
@Stateless(mappedName = "Parameters")
@Local(ParametersLocal.class)
@LocalBean
public class Parameters implements ParametersLocal {

    /**
     * Default constructor. 
     */
	
	
    private String HOST_STATIC_FILES = "";
    private String DIR_STATIC_FILES = "";
    private String E_MAIL_FROM = "";
    private String E_MAIL_TO = "";
    private String E_MAIL_PASS = "";
	
    

    public String getHOST_STATIC_FILES() {
		return HOST_STATIC_FILES;
	}

	public void setHOST_STATIC_FILES(String hOST_STATIC_FILES) {
		HOST_STATIC_FILES = hOST_STATIC_FILES;
	}

	public String getDIR_STATIC_FILES() {
		return DIR_STATIC_FILES;
	}

	public void setDIR_STATIC_FILES(String dIR_STATIC_FILES) {
		DIR_STATIC_FILES = dIR_STATIC_FILES;
	}

	public String getE_MAIL_FROM() {
		return E_MAIL_FROM;
	}

	public void setE_MAIL_FROM(String e_MAIL_FROM) {
		E_MAIL_FROM = e_MAIL_FROM;
	}

	public String getE_MAIL_TO() {
		return E_MAIL_TO;
	}

	public void setE_MAIL_TO(String e_MAIL_TO) {
		E_MAIL_TO = e_MAIL_TO;
	}

	public String getE_MAIL_PASS() {
		return E_MAIL_PASS;
	}

	public void setE_MAIL_PASS(String e_MAIL_PASS) {
		E_MAIL_PASS = e_MAIL_PASS;
	}

	public Parameters() {
        // TODO Auto-generated constructor stub
    }
    
    public void cargodatos() {
    	Context ctx = null;
		try {
			ctx = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Object jndiConstant = null;
		try {
			jndiConstant = ctx.lookup("myProp/HOST_STATIC_FILES");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	HOST_STATIC_FILES = (String) jndiConstant;
    	
    	try {
			jndiConstant = ctx.lookup("myProp/DIR_STATIC_FILES");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	DIR_STATIC_FILES = (String) jndiConstant;
    	try {
			jndiConstant = ctx.lookup("myProp/E_MAIL_FROM");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	E_MAIL_FROM = (String) jndiConstant;
    	try {
			jndiConstant = ctx.lookup("myProp/E_MAIL_TO");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	E_MAIL_TO = (String) jndiConstant;
    	try {
			jndiConstant = ctx.lookup("myProp/E_MAIL_PASS");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	E_MAIL_PASS = (String) jndiConstant;
    }

}
