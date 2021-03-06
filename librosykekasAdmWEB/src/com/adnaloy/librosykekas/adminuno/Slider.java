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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.adnaloy.librosykekas.basics.interfaces.CategoriaLocal;
import com.adnaloy.librosykekas.basics.interfaces.ParametersLocal;
import com.adnaloy.librosykekas.basics.interfaces.ResizeAndCropLocal;
import com.adnaloy.librosykekas.basics.interfaces.SliderLocal;

/**
 * Servlet implementation class Slider
 */
@WebServlet(description = "Mant Slider", urlPatterns = { "/Slider" })
public class Slider extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(mappedName="Slider")
	SliderLocal ef;
	@EJB(mappedName="Parameters")
	ParametersLocal prm;
	@EJB(mappedName="ResizeAndCrop")
	ResizeAndCropLocal rac;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Slider() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List efs = ef.findAllSliders();
		
		request.setAttribute("ListaSlider", efs);
		
		prm.cargodatos();
		request.setAttribute("prm", prm);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SliderListWebPage.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String destino = "/SliderListWebPage.jsp";
		
		String accion = null;
		String cod = null;
		
		String img1 = "";
		int width = 980;
		int height = 380;
		
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
					if(name.equals("accion")) {
						accion = item.getString();
					}
					if(name.equals("clave")) {
						cod = item.getString();
					}
				}else {
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
						
						if(item.getFieldName().equals("imagen")){
							img1 = finalimage;

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
		
		if("E".equals(accion)) {
			
			ef.setClave(cod);
			ef.buscaSlider();
			
			request.setAttribute("Slider", ef);
			request.setAttribute("SliderAccion","E");
			
			destino = "/SliderEditWebPage.jsp";
			
		}else if("A".equals(accion)) {
			
			request.setAttribute("Slider", ef);
			request.setAttribute("SliderAccion","A");
			
			destino = "/SliderEditWebPage.jsp";
			
		}else if("X".equals(accion)) {
			
			ef.setClave(cod);
			ef.buscaSlider();
			
			request.setAttribute("Slider", ef);
			request.setAttribute("SliderAccion","X");
			
			destino = "/SliderEditWebPage.jsp";
			
		}else if("D".equals(accion)) {
			
			ef.setClave(cod);
			ef.buscaSlider();
			
			request.setAttribute("Slider", ef);
			request.setAttribute("SliderAccion","D");
			
			destino = "/SliderEditWebPage.jsp";
			
		}else if("XE".equals(accion)) {
			
			ef.setClave(cod);
			ef.buscaSlider();
			
			ef.setImagen(img1);
			
			ef.actualizo();
			
			ef.reset();
			
			List efs = ef.findAllSliders();
			
			request.setAttribute("ListaSlider", efs);
			
			destino = "/SliderListWebPage.jsp";
			
		}else if("XA".equals(accion)) {
			
			ef.setImagen(img1);
			
			ef.anado();
			
			ef.reset();
			
			List efs = ef.findAllSliders();
			
			request.setAttribute("ListaSlider", efs);
			
			destino = "/SliderListWebPage.jsp";
			
		}else if("XX".equals(accion)) {
			
			ef.setClave(cod);
			ef.buscaSlider();
			ef.elimino();
			
			ef.reset();
			
			List efs = ef.findAllSliders();
			
			request.setAttribute("ListaSlider", efs);
			
			destino = "/SliderListWebPage.jsp";
			
		}else if("XD".equals(accion)) {
			
			ef.setImagen(img1);
			
			ef.actualizo();
			
			List efs = ef.findAllSliders();
			
			request.setAttribute("ListaSlider", efs);
			
			destino = "/SliderListWebPage.jsp";
		}
		
		prm.cargodatos();
		request.setAttribute("prm", prm);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destino);
        dispatcher.forward(request, response);
	}

}
