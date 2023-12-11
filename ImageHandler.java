/**
* Class Description
*
* @author aross-sermons
* @version 1.0
* CS215; Lab #
* Fall 2023
*/

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Dimension;

public class ImageHandler {
	/**
	 * Returns an screenshot of the webcam
	 * @return the image
	 */
	public static BufferedImage getImage() {
		//Getting Webcam
		Webcam webcam = Webcam.getDefault();
		webcam.setViewSize(WebcamResolution.VGA.getSize());
		webcam.open();
		//Getting Image
		BufferedImage image = webcam.getImage();
		//Close Webcam
		webcam.close();
		//Return
		return image;
	}//end getImage
	
	/**
	 * Returns a scaled screenshot of the webcam
	 * @param width
	 * @param height
	 * @return the image
	 */
	public static BufferedImage getImage(int width, int height) {
		//Getting Webcam
		Webcam webcam = Webcam.getDefault();
		webcam.setViewSize(WebcamResolution.VGA.getSize());
		webcam.open();
		//Getting Image
		BufferedImage image = webcam.getImage();
		image = cropToSquare(image);
		image = scale(image, width, height);
		//Close Webcam
		webcam.close();
		//Return
		return image;
	}//end getImage
	
	/**
	 * Returns a scaled screenshot of the webcam
	 * @param width
	 * @param height
	 * @return the image
	 */
	public static BufferedImage getImage(Dimension size) {
		//Getting Webcam
		Webcam webcam = Webcam.getDefault();
		webcam.setViewSize(WebcamResolution.VGA.getSize());
		webcam.open();
		//Getting Image
		BufferedImage image = webcam.getImage();
		image = cropToSquare(image);
		image = scale(image, size.width, size.height);
		//Close Webcam
		webcam.close();
		//Return
		return image;
	}//end getImage
	
	/**
	 * Crops the given image to a square
	 * @param originalImage
	 * @return the image
	 */
	public static BufferedImage cropToSquare(BufferedImage originalImage) {
		// Determine the size of the square
        int size = Math.min(originalImage.getWidth(), originalImage.getHeight());
        // Create a new BufferedImage with the square size
        BufferedImage croppedImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = croppedImage.createGraphics();
        // Calculate the coordinates for cropping to the square
        int x = (originalImage.getWidth() - size) / 2;
        int y = (originalImage.getHeight() - size) / 2;
        // Crop and draw the original image onto the new image
        BufferedImage cropped = originalImage.getSubimage(x, y, size, size);
        g2d.drawImage(cropped, 0, 0, null);
        // Dispose of the Graphics2D object
        g2d.dispose();
        //Return
        return croppedImage;
	}//end cropToSquare
	
	/**
	 * Scales the given image to match the given dimensions
	 * @param originalImage
	 * @param newWidth
	 * @param newHeight
	 * @return
	 */
	public static BufferedImage scale(BufferedImage originalImage, int newWidth, int newHeight) {
		BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = scaledImage.createGraphics();
		
		g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
		g2d.dispose();
		
		return scaledImage;
	}//end scale
	
	/**
	 * Scales the given image to match the given dimensions
	 * @param originalImage
	 * @param newWidth
	 * @param newHeight
	 * @return
	 */
	public static BufferedImage scale(BufferedImage originalImage, Dimension newSize) {
		BufferedImage scaledImage = new BufferedImage(newSize.width, newSize.height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = scaledImage.createGraphics();
		
		g2d.drawImage(originalImage, 0, 0, newSize.width, newSize.height, null);
		g2d.dispose();
		
		return scaledImage;
	}//end scale
	
	/**
	 * Calculates the brightness of each pizel in the given image and adds it to an array.
	 * @param image
	 * @return the brightness array
	 */
	public static int[] getBrightnessValues(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[] pixels = new int[(width*height)];
        
        // Iterate through the pixels to calculate brightness
        for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				// Get rgb as encoded int
                int rgb = image.getRGB(x, y);
                // Separate rgb values
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;
                // Calculate brightness as an average of RGB values
                int brightness = (red + green + blue) / 3;
                pixels[x+(y*width)] = brightness;
			}
		}
        return pixels;
	}//end getBrightnessValues
	
}//end ImageHandler.java
