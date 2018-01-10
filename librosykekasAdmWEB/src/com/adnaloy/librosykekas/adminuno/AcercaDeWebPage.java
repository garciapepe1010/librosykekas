package com.adnaloy.librosykekas.adminuno;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adnaloy.librosykekas.basics.interfaces.AcercaDePageWebLocal;
import com.adnaloy.librosykekas.basics.interfaces.IndexPageWEBLocal;
import com.adnaloy.librosykekas.basics.interfaces.ResizeAndCropLocal;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;

/**
 * Servlet implementation class IndexWebPage
 */
@WebServlet(description = "setup index page from librosykekasWEB", urlPatterns = { "/AcercaDeWebPage" })
public class AcercaDeWebPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(mappedName="AcercaDePageWeb")
	AcercaDePageWebLocal ipw;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcercaDeWebPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ipw.setClave("1");
		ipw.buscoAcercaDePageWEB();
		
		request.setAttribute("acercade", ipw.getAcercade());
		request.setAttribute("aunmas", ipw.getAunmas());
		request.setAttribute("clave", ipw.getClave());
		request.setAttribute("historia", ipw.getHistoria());
		request.setAttribute("inquietudes", ipw.getInquietudes());
		request.setAttribute("kekas", ipw.getKekas());
		request.setAttribute("libros", ipw.getLibros());
		request.setAttribute("viajes", ipw.getViajes());


		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AcercaDeWebPage.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);


			
			ipw.setClave("1");
			
			ipw.buscoAcercaDePageWEB();
			
			String acercade = (String)request.getParameter("acercade");
			String aunmas = (String)request.getParameter("aunmas");
			String historia = (String)request.getParameter("historia");
			String inquietudes = (String)request.getParameter("inquietudes");
			String kekas = (String)request.getParameter("kekas");
			String libros = (String)request.getParameter("libros");
			String viajes = (String)request.getParameter("viajes");
			
			ipw.setAcercade(acercade);
			ipw.setAunmas(aunmas);
			ipw.setHistoria(historia);
			ipw.setInquietudes(inquietudes);
			ipw.setKekas(kekas);
			ipw.setLibros(libros);
			ipw.setViajes(viajes);

			
			ipw.actualizo();
			
			
			ipw.setClave("1");
			ipw.buscoAcercaDePageWEB();
			
			request.setAttribute("acercade", ipw.getAcercade());
			request.setAttribute("aunmas", ipw.getAunmas());
			request.setAttribute("clave", ipw.getClave());
			request.setAttribute("historia", ipw.getHistoria());
			request.setAttribute("inquietudes", ipw.getInquietudes());
			request.setAttribute("kekas", ipw.getKekas());
			request.setAttribute("libros", ipw.getLibros());
			request.setAttribute("viajes", ipw.getViajes());
			
			request.setAttribute("resultadoOperacion", "Operaci&oacute;n realizada con exito");
		
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AcercaDeWebPage.jsp");
			dispatcher.forward(request, response);
	}

}
