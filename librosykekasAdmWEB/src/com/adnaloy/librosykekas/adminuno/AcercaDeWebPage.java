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
import com.adnaloy.librosykekas.basics.interfaces.ParametersLocal;
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
	@EJB(mappedName="Parameters")
	ParametersLocal prm;
	@EJB(mappedName="ResizeAndCrop")
	ResizeAndCropLocal rac;
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
		
		request.setAttribute("inquietudesImg", ipw.getInquietudesImg());
		request.setAttribute("kekasImg", ipw.getKekasImg());
		request.setAttribute("librosImg", ipw.getLibrosImg());
		request.setAttribute("viajesImg", ipw.getViajesImg());

		prm.cargodatos();
		request.setAttribute("prm", prm);
		
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
			
			String acercade = null;
			String aunmas = null;
			String historia = null;
			String inquietudes = null;
			String kekas = null;
			String libros = null;
			String viajes = null;
			
			String inquietudesImg = null;
			String kekasImg = null;
			String librosImg = null;
			String viajesImg = null;
			

			
			int width = 350;
			int height = 275;
			
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
						if(name.equals("acercade")) {
							acercade = item.getString();
						}
						if(name.equals("aunmas")) {
							aunmas = item.getString();
						}
						if(name.equals("historia")) {
							historia = item.getString();
						}
						if(name.equals("inquietudes")) {
							inquietudes = item.getString();
						}
						if(name.equals("kekas")) {
							kekas = item.getString();
						}
						if(name.equals("libros")) {
							libros = item.getString();
						}
						if(name.equals("viajes")) {
							viajes = item.getString();
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
								
								if(item.getFieldName().equals("inquietudesImg")){
									inquietudesImg = finalimage;
								}
								if(item.getFieldName().equals("kekasImg")){
									kekasImg = finalimage;
								}
								if(item.getFieldName().equals("librosImg")){
									librosImg = finalimage;
								}
								if(item.getFieldName().equals("viajesImg")){
									viajesImg = finalimage;
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
			
			ipw.setAcercade(acercade);
			ipw.setAunmas(aunmas);
			ipw.setHistoria(historia);
			ipw.setInquietudes(inquietudes);
			ipw.setKekas(kekas);
			ipw.setLibros(libros);
			ipw.setViajes(viajes);
			
			ipw.setInquietudesImg(inquietudesImg);
			ipw.setKekasImg(kekasImg);
			ipw.setLibrosImg(librosImg);
			ipw.setViajesImg(viajesImg);
			
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
			
			request.setAttribute("inquietudesImg", ipw.getInquietudesImg());
			request.setAttribute("kekasImg", ipw.getKekasImg());
			request.setAttribute("librosImg", ipw.getLibrosImg());
			request.setAttribute("viajesImg", ipw.getViajesImg());
			
			request.setAttribute("resultadoOperacion", "Operaci&oacute;n realizada con exito");
			prm.cargodatos();
			request.setAttribute("prm", prm);
		
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AcercaDeWebPage.jsp");
			dispatcher.forward(request, response);
	}

}
