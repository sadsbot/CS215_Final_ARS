/**
* Class Description
*
* @author aross-sermons
* @version 1.0
* CS215; Lab #
* Fall 2023
*/

import java.awt.Dimension;

public class DotMatrixDisplay {
	private BinaryArray bArray;
	private Dimension size;
	
	/**
	 * Default Constructor
	 */
	public DotMatrixDisplay() {
		bArray = new BinaryArray();
		size = new Dimension(0, 0);
	}//end default constructor
	
	/**
	 * Preferred Constructor
	 * @param width
	 * @param height
	 */
	public DotMatrixDisplay(int width, int height) {
		bArray = new BinaryArray(width*height);
		size = new Dimension(width, height);
	}//end preferred constructor
	
	/**
	 * Preferred Constructor
	 * @param size
	 */
	public DotMatrixDisplay(Dimension size) {
		bArray = new BinaryArray(size.width*size.height);
		this.size = size;
	}//end preferred constructor
	
	/**
	 * Gets this display's bArray
	 * @return the bArray
	 */
	public BinaryArray getbArray() {
		return bArray;
	}//end getbArray
	
	/**
	 * Sets this display's bArray
	 * @param bArray
	 */
	public void setbArray(BinaryArray bArray) {
		this.bArray = bArray;
	}//end setbArray
	
	/**
	 * Gets this display's width
	 * @return the width
	 */
	public int getWidth() {
		return size.width;
	}//end getWidth
	
	/**
	 * Sets this display's width
	 * @param width
	 */
	public void setWidth(int width) {
		size.width = width;
	}//end setWidth
	
	/**
	 * Gets this display's height
	 * @return the height
	 */
	public int getHeight() {
		return size.height;
	}//end getHeight
	
	/**
	 * Sets this display's height
	 * @param height
	 */
	public void setHeight(int height) {
		size.height = height;
	}//end setHeight
	
	/**
	 * Gets this display's size
	 * @return the size
	 */
	public Dimension getSize() {
		return size;
	}//end getSize
	
	/**
	 * Sets this display's size
	 * @param size
	 */
	public void setSize(Dimension size) {
		this.size = size;
	}//end setSize
	
	/**
	 * Returns a String representation of this object
	 * @return the toString
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(size.width + "x" + size.height + ", " + (size.width*size.height) + "px");
		return sb.toString();
	}
	
}//end DotMatrixDisplay.java
