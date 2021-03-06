package com.adnaloy.librosykekas.basics.interfaces;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.ejb.Local;
import javax.imageio.ImageIO;

@Local
public interface ResizeAndCropLocal {
	
    public String getDestination();
	public void setDestination(String destination);
	public String getName();
	public void setName(String name);
	public String getOrigen();
	public void setOrigen(String origen);
	public int getWidth();
	public void setWidth(int width);
	public int getHeight();
	public void setHeight(int height);



    
	public void doIt();
    
	public void cropImageToGivenSize(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException ;

	public BufferedImage resizeImage(BufferedImage originalImage, int type,
                                             Integer img_width, Integer img_height);

}
