/**
 * 
 */
package com.china.gavin.game.qq;

/**
 * @author gauzhang
 *
 */
import java.awt.Image;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;

import javax.swing.JFrame;

public class CropImage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image = null;

	public CropImage(Image source,int startx,int starty,int width,int height) {

		image = createImage(new FilteredImageSource(source.getSource(), new CropImageFilter(startx, starty, width, height)));
	}

	public Image getImage() {
		return image;
	}
}
