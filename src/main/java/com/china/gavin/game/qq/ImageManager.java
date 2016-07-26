/**
 * 
 */
package com.china.gavin.game.qq;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;



 

/**
 * @author gauzhang
 * 
 */
public class ImageManager {

	private static final String IMAGE_URL_PREFIX = "/com/china/gavin/game/qq/images/";

	public static String getImageURL(String imageName) {
		return IMAGE_URL_PREFIX + imageName;
	}

	public static Image getImageWithImgName(String imageName) {
		try {
			return new ImageIcon(ClassLoader.class.getResource(getImageURL(imageName))).getImage();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static Image getImageWithImgURL(String imageURL) {
		try {
			return new ImageIcon(ClassLoader.class.getResource(imageURL)).getImage();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static ImageIcon getIconWithName(String iconName) {
		return new ImageIcon(ClassLoader.class.getResource(getImageURL(iconName)));
	}

	public static ImageIcon getIconWithURL(String iconURL) {
		return new ImageIcon(ClassLoader.class.getResource(iconURL));
	}

	public static TexturePaint createTexturePaint(String imageURL) {
		return createTexturePaint(ImageManager.getImageWithImgURL(imageURL));
	}
	public static TexturePaint createTexturePaintWithImage(Image image) {
		System.out.println(image.getHeight(null));
		return createTexturePaint(image);
	}
	public static TexturePaint createTexturePaint(Image image) {
		int imageWidth = image.getWidth(null);
		int imageHeight = image.getHeight(null);
		BufferedImage bi = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = bi.createGraphics();
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();
		return new TexturePaint(bi, new Rectangle(0, 0, imageWidth, imageHeight));
	}


	

	public static JButton createTransparentButton(ImageIcon icon, ImageIcon roverIcon, ImageIcon pressedIcon) {
		JButton button = new JButton();
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//button.setBounds(110, 20, 40, 20);
		button.setBorder(null);
		button.setMargin(null);
		button.setOpaque(false);
		button.setIcon(icon);
		button.setRolloverEnabled(true);
		button.setRolloverIcon(roverIcon);
		button.setPressedIcon(pressedIcon);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.setRequestFocusEnabled(false);

		return button;
	}
	
	
	
	
	public static final Insets ZERO_INSETS = new Insets(0, 0, 0, 0);
	public static final Font FONT_12_BOLD = new Font("Calibri", Font.BOLD, 12);
	public static final Color TAB_BOTTOM_LINE_COLOR = new Color(167, 173, 175);
	public static final Color DEFAULT_TEXT_COLOR = new Color(37, 81, 54);
}
