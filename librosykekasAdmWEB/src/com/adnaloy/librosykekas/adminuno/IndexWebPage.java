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



import com.adnaloy.librosykekas.basics.interfaces.IndexPageWEBLocal;
import com.adnaloy.librosykekas.basics.interfaces.ParametersLocal;
import com.adnaloy.librosykekas.basics.interfaces.ResizeAndCropLocal;

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
	@EJB(mappedName="ResizeAndCrop")
	ResizeAndCropLocal rac;
	@EJB(mappedName="Parameters")
	ParametersLocal prm;

       
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
		
		request.setAttribute("presentation", ipw.getPresentacion());
		request.setAttribute("comentario_1", ipw.getComentario1());
		request.setAttribute("comentario_2", ipw.getComentario2());
		request.setAttribute("comentario_3", ipw.getComentario3());
		
		request.setAttribute("imagen_1", ipw.getImg1());
		request.setAttribute("imagen_2", ipw.getImg2());
		request.setAttribute("imagen_3", ipw.getImg3());
		request.setAttribute("imagen_4", ipw.getImg4());
		request.setAttribute("imagen_5", ipw.getImg5());
		
		
		prm.cargodatos();
		request.setAttribute("prm", prm);
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indexWebPage.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

			String presentation = null;
			
			String comentario1 = null;
			String comentario2 = null;
			String comentario3 = null;
			
			String img1 = "";
			String img2 = "";
			String img3 = "";
			String img4 = "";
			String img5 = "";
			
			int width = 100;
			int height = 100;
			
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			
			if (isMultipart) {
				
				String dirUpload = prm.getDIR_STATIC_FILES();

				
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
						String name = item.getFieldName();
						if(name.equals("presentation")) {
							presentation = item.getString();
						}
						if(name.equals("Comentarios_1")) {
							comentario1 = item.getString();
						}
						if(name.equals("Comentarios_2")) {
							comentario2 = item.getString();
						}
						if(name.equals("Comentarios_3")) {
							comentario3 = item.getString();
						}
					} else {
							String itemName = item.getName();
							if(itemName!= null && !"".equals(itemName)) {
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
								System.out.println("destination file : "+ dirUpload +finalimage);
								if(item.getFieldName().equals("imagen_1")){
									img1 = finalimage;
									width = 850;
									height = 915;
								}
								if(item.getFieldName().equals("imagen_2")){
									img2 = finalimage;
									width = 900;
									height = 1000;
								}
								if(item.getFieldName().equals("imagen_3")){
									img3 = finalimage;
									width = 975;
									height = 915;
								}
								if(item.getFieldName().equals("imagen_4")){
									img4 = finalimage;
									width = 910;
									height = 1620;
								}
								if(item.getFieldName().equals("imagen_5")){
									img5 = finalimage;
									width = 1650;
									height = 925;
								}
								
								if(".gif".equalsIgnoreCase(domainName)) {
									response.setContentType("image/gif");	
								}else if(".jpg".equalsIgnoreCase(domainName)) {
									response.setContentType("image/jpeg");
								}else if(".jpeg".equalsIgnoreCase(domainName)) {
									response.setContentType("image/jpeg");
								}else if(".tiff".equalsIgnoreCase(domainName)) {
									response.setContentType("image/tiff");
								}else if(".svg".equalsIgnoreCase(domainName)) {
									response.setContentType("image/svg+xml");
								}else if(".png".equalsIgnoreCase(domainName)) {
									response.setContentType("image/png");
								}
								
								
								try {
									item.write(savedFile);
								}catch(Exception ex) {
									
								}
								
								rac.setOrigen(dirUpload);
								rac.setName(finalimage);
								rac.setWidth(width);
								rac.setHeight(height);
								rac.setDestination(dirUpload);
								rac.doIt();
								
							}
							
					}
				}
			}
			
			ipw.setClave("1");
			
			ipw.buscoIndexPageWEB();
			
			ipw.setComentario1(comentario1);
			ipw.setComentario2(comentario2);
			ipw.setComentario3(comentario3);
			
			ipw.setPresentacion(presentation);
			
			if(img1!= null && !img1.equals(""))
				ipw.setImg1(img1);
			if(img2!= null && !img2.equals(""))
				ipw.setImg2(img2);
			if(img3!= null && !img3.equals(""))
				ipw.setImg3(img3);
			if(img4!= null && !img4.equals(""))
				ipw.setImg4(img4);
			if(img5!= null && !img5.equals(""))
				ipw.setImg5(img5);
			
			ipw.actualizo();
			
			
			ipw.setClave("1");
			ipw.buscoIndexPageWEB();
			
			request.setAttribute("presentation", ipw.getPresentacion());
			request.setAttribute("comentario_1", ipw.getComentario1());
			request.setAttribute("comentario_2", ipw.getComentario2());
			request.setAttribute("comentario_3", ipw.getComentario3());
			
			request.setAttribute("imagen_1", ipw.getImg1());
			request.setAttribute("imagen_2", ipw.getImg2());
			request.setAttribute("imagen_3", ipw.getImg3());
			request.setAttribute("imagen_4", ipw.getImg4());
			request.setAttribute("imagen_5", ipw.getImg5());
			
			request.setAttribute("resultadoOperacion", "Operaci&oacute;n realizada con exito");
			
			prm.cargodatos();
			request.setAttribute("prm", prm);
		
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indexWebPage.jsp");
			dispatcher.forward(request, response);
	}

}
