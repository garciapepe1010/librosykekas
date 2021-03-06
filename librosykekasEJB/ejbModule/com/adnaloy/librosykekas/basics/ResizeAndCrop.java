package com.adnaloy.librosykekas.basics;

import com.adnaloy.librosykekas.basics.interfaces.ResizeAndCropLocal;
import java.io.*;
import javax.imageio.*;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ResizeAnCrop
 */
@Stateless(mappedName = "ResizeAndCrop")
@LocalBean
public class ResizeAndCrop implements ResizeAndCropLocal {

    /**
     * Default constructor. 
     */
	private static final String UNDER_SCORE = "_";
	private static final String X = "x";
	private String destination;
	private String name;
	private String origen;
	private int width;
	private int height;

	
	
	
    public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}

	

	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}



	public ResizeAndCrop() {
        // TODO Auto-generated constructor stub
    }
    
	public void doIt() {
		
		try {
			BufferedImage originalImage = ImageIO.read(new File(origen + name));
			cropImageToGivenSize(originalImage, width, height);
		}catch (IOException e) {
			
		}
	}
    
	public void cropImageToGivenSize(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {

        float widthRatio = (float)originalImage.getWidth() / targetWidth;
        float heightRatio =(float)originalImage.getHeight() / targetHeight;

        BufferedImage resizedImage = originalImage;
        int resizedWidth = originalImage.getWidth();
        int resizedHeight = originalImage.getHeight();
        if(widthRatio > heightRatio){ //shrink to fixed height
            resizedWidth = Math.round(originalImage.getWidth() / heightRatio);
            resizedHeight = targetHeight;
        }else{ //shrink to fixed width
            resizedWidth = targetWidth;
            resizedHeight = Math.round(originalImage.getHeight() / widthRatio);
        }
        resizedImage = resizeImage(originalImage, originalImage.getType(), resizedWidth, resizedHeight);

        int startX = resizedWidth/2 - targetWidth/2;
        int startY = resizedHeight/2 - targetHeight/2;
        BufferedImage SubImage = resizedImage.getSubimage(startX, startY, targetWidth, targetHeight);
        System.out.println("Croppede Dimension: " + SubImage.getWidth() + "x" + SubImage.getHeight());

        File outputfile = new File(destination.concat(String.valueOf(width).concat(X).concat(String.valueOf(height))).concat(UNDER_SCORE.concat(name)));
        ImageIO.write(SubImage, "jpg", outputfile);

        System.out.println("Imageped successfully: "+outputfile.getPath());
    }

    public BufferedImage resizeImage(BufferedImage originalImage, int type,
                                             Integer img_width, Integer img_height)
    {
        BufferedImage resizedImage = new BufferedImage(img_width, img_height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, img_width, img_height, null);
        g.dispose();

        return resizedImage;
    }

}
