package com.adnaloy.librosykekas.adminuno;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;
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



import com.adnaloy.librosykekas.basics.interfaces.IndexPageWEBLocal;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;

/**
 * Servlet implementation class IndexWebPage
 */
@WebServlet(description = "setup index page from librosykekasWEB", urlPatterns = { "/IndexWebPage" })
public class IndexWebPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(mappedName="IndexPageWEB")
	IndexPageWEBLocal ipw;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexWebPage() {
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
		ipw.buscoIndexPageWEB();
		
		request.setAttribute("comentario_1", ipw.getComentario1());
		request.setAttribute("comentario_2", ipw.getComentario2());
		request.setAttribute("comentario_3", ipw.getComentario3());
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indexWebPage.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		
		  
		
		if(request.getParameter("presentation")!=null && !"".equals(request.getParameter("presentation"))){
			String presentatiton = request.getParameter("presentation");
			
			String comentario1 = request.getParameter("comentario1");
			String comentario2 = request.getParameter("comentario2");
			String comentario3 = request.getParameter("comentario3");
			
			String img1 = "";
			String img2 = "";
			String img3 = "";
			String img4 = "";
			String img5 = "";
			
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			
			if (isMultipart) {
				
				String dirUpload = System.getProperty("was.server.data.dir");

				
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List items = null;

				try {
					items = upload.parseRequest(request);

				} catch (FileUploadException e) {
					e.printStackTrace();
				}
				
				Iterator itr = items.iterator();
				
				while (itr.hasNext()) {
					FileItem item = (FileItem) itr.next();
					if (item.isFormField()){
						//String name = item.getFieldName();
						//String value = item.getString();
						} else {
							String itemName = item.getName();
							Random generator = new Random();
							int r = Math.abs(generator.nextInt());
							
							
							String reg = "[.*]";
							String replacingtext = "";
							System.out.println("Text before replacing is:-" + itemName);
							Pattern pattern = Pattern.compile(reg);
							Matcher matcher = pattern.matcher(itemName);
							StringBuffer buffer = new StringBuffer();
							
							while (matcher.find()) {
								matcher.appendReplacement(buffer, replacingtext);
							} 
							
							int IndexOf = itemName.indexOf(".");
							String domainName = itemName.substring(IndexOf);
							System.out.println("domainName: "+domainName);

							String finalimage = buffer.toString()+"_"+r+domainName;
							System.out.println("Final Image==="+finalimage);

							File savedFile = new File(dirUpload +finalimage);
							if(item.getFieldName().equals("img1")){
								img1 = finalimage;
							}
							if(item.getFieldName().equals("img2")){
								img2 = finalimage;
							}
							if(item.getFieldName().equals("img3")){
								img3 = finalimage;
							}
							if(item.getFieldName().equals("img4")){
								img4 = finalimage;
							}
							if(item.getFieldName().equals("img5")){
								img5 = finalimage;
							}
						}
				}
			}
			
			ipw.setClave("1");
			
			ipw.buscoIndexPageWEB();
			
			ipw.setComentario1(comentario1);
			ipw.setComentario2(comentario2);
			ipw.setComentario3(comentario3);
			
			ipw.setPresentacion(presentatiton);
			
			ipw.setImg1(img1);
			ipw.setImg2(img2);
			ipw.setImg3(img3);
			ipw.setImg4(img4);
			ipw.setImg5(img5);
			
			ipw.actualizo();
			
			
			request.setAttribute("resultadoOperacion", "Operaci&oacute;n realizada con exito");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indexWebPage.jsp");
	        dispatcher.forward(request, response);
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indexWebPage.jsp");
        dispatcher.forward(request, response);
	}

}
