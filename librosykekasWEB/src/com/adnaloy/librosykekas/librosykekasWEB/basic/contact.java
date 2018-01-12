package com.adnaloy.librosykekas.librosykekasWEB.basic;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adnaloy.librosykekas.basics.interfaces.EditorialFabLocal;
import com.adnaloy.librosykekas.basics.interfaces.ParametersLocal;
import com.adnaloy.librosykekas.basics.interfaces.SendMailLocal;

/**
 * Servlet implementation class contact
 */
@WebServlet(description = "contact from the website", urlPatterns = { "/contact" })
public class contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(mappedName="SendMail")
	SendMailLocal sml;
	@EJB(mappedName="Parameters")
	ParametersLocal prm;
       
	private final static String MENSAJE_DE = "Mensaje de : ";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		prm.cargodatos();
		
		request.setAttribute("prm", prm);
		request.setAttribute("timestamp", new Date());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/contact.jsp");
        dispatcher.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String message = request.getParameter("message");
		
		sml.setFrom(prm.getE_MAIL_FROM());
		sml.setTo(prm.getE_MAIL_TO());
		sml.setPass(prm.getE_MAIL_PASS());
		
		sml.setSubject(MENSAJE_DE + firstname + " " + lastname);
		sml.setText(email + " " + phone + " " + message);
		
		sml.doIt();
		
		
		request.setAttribute("prm", prm);
		request.setAttribute("resultado", "Mensaje enviado");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/contact.jsp");
        dispatcher.forward(request, response); 

	}

}
