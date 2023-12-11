/**
* Class Description
*
* @author aross-sermons
* @version 1.0
* CS215; Lab #
* Fall 2023
*/

import java.awt.Dimension;

public class FullDisplay {
	public final int DEFAULT_SIZE = 4;
	public final int MIN_BRIGHTNESS = 110; //The value at which a pixel will be turned on or off
	
	private Dimension DMDResolution; //The width and height of each DMD
	private Dimension displayResolution; //The width and height in number of DMDs in full display
	private LinkedList displays;
	private int[] brightnessValues;
	
	/**
	 * Default Constructor
	 */
	public FullDisplay() {
		DMDResolution = new Dimension(DEFAULT_SIZE, DEFAULT_SIZE); //The size of each DMD
		displayResolution = new Dimension(DEFAULT_SIZE, DEFAULT_SIZE); //The size of the display in number of DMDs
		displays = new LinkedList();
		//Gets the brightness of each pixel of an image of size DMDSize*DMDResolution
		brightnessValues = ImageHandler.getBrightnessValues(ImageHandler.getImage((DMDResolution.width*DMDResolution.height), (DMDResolution.width*DMDResolution.height)));
	}//end default constructor
	
	/**
	 * Preferred Constructor
	 * @param DMDResolution
	 * @param displayResolution
	 */
	public FullDisplay(Dimension DMDResolution, Dimension displayResolution) {
		this.DMDResolution = DMDResolution; //The size of each DMD
		this.displayResolution = displayResolution; //The size of the display in number of DMDs
		displays = new LinkedList();
		//Gets the brightness of each pixel of an image of size DMDSize*DMDResolution
		brightnessValues = ImageHandler.getBrightnessValues(ImageHandler.getImage((DMDResolution.width*DMDResolution.height), (DMDResolution.width*DMDResolution.height)));
	}//end preferred constructor
	
//	public void getImageFromWebcam() {
//		DotMatrixDisplay tempDMD = new DotMatrixDisplay(DMDResolution.width, DMDResolution.height); //Make a temporary DMD
//		BinaryArray tempArray = new BinaryArray(DMDResolution.width * DMDResolution.height); //Make a temporary BinaryArray
//		Node tempNode = new Node(); //Make a temporary Node
//		
//		for(int node = 0; node < (displayResolution.width*displayResolution.height); node++) { //For each node of this FullDisplay
//			for(int pixel = 0; pixel < getSizeInPixels(); pixel++) { //For each pixel in current Node
//				System.out.println("node# " + node + ", pixel# " + pixel);
//				tempArray.setIndexAsInt(pixel, brightnessCheck(brightnessValues[pixel+(node*DMDResolution.height)]));
//			}
//			tempDMD.setbArray(tempArray);
//			tempNode.setData(tempDMD);
//			displays.addNode(tempNode);
//		}
//	}//end getImageFromWebcam
	
	public void getImageFromWebcam() {
		DotMatrixDisplay tempDMD = new DotMatrixDisplay(DMDResolution.width, DMDResolution.height); //Make a temporary DMD
		BinaryArray tempArray; //Make a temporary BinaryArray
		Node tempNode = new Node(); //Make a temporary Node
		
		for(int displayRow = 0; displayRow < DMDResolution.height; displayRow++) { //For each DMD row of the full display
			for(int DMDRow = 0; DMDRow < DMDResolution.height; DMDRow++) { //For each pixel row in the DMD
				for(int DMDInRow = 0; DMDInRow < displayResolution.width; DMDInRow++) { //For each DMD in current displayRow
					tempNode = displays.getAtIndex(DMDInRow + (displayRow * displayResolution.width));
					tempDMD = tempNode.getData();
					tempArray = new BinaryArray(DMDResolution.width*DMDResolution.height);
					for(int DMDCol = 0; DMDCol < DMDResolution.width; DMDCol++) { //For each pixel column in the tempNode DMDRow
						tempArray.setIndexAsInt((DMDCol + (DMDRow * DMDResolution.width)), 1);
						//int o = tempNode.getData().getbArray().getIndexAsInt(DMDCol + (DMDRow * DMDResolution.width));
					}
				}
			}
		}
	}
	
	public String getImageAsString() {
		StringBuilder sb = new StringBuilder();
		Node current;
		for(int displayRow = 0; displayRow < DMDResolution.height; displayRow++) { //For each DMD row of the full display
			for(int DMDRow = 0; DMDRow < DMDResolution.height; DMDRow++) { //For each pixel row in the DMD
				for(int DMDInRow = 0; DMDInRow < displayResolution.width; DMDInRow++) { //For each DMD in current displayRow
					current = displays.getAtIndex(DMDInRow + (displayRow * displayResolution.width));
					for(int DMDCol = 0; DMDCol < DMDResolution.width; DMDCol++) { //For each pixel column in the current DMDRow
						int o = current.getData().getbArray().getIndexAsInt(DMDCol + (DMDRow * DMDResolution.width));
						//if(o > 0) sb.append((DMDInRow + (displayRow * DMDResolution.width)) + " ");
						if(o > 0) sb.append("O ");
						else sb.append("  ");
					}
				}
				sb.append("\n"); //New line for each row of the full display.
			}
		}
		return sb.toString();
	}
	
	/**
	 * Returns the total number of pixels in this FullDisplay
	 * @return
	 */
	public int getSizeInPixels() {
		//total = DMDResolution * displayResolution
		//total = #of pixels in DMD * #of DMD's
		return((DMDResolution.width*DMDResolution.height)*(displayResolution.width*displayResolution.height));
	}//end getSizeInPizels
	
	/**
	 * Checks if the brightness of the input is within the threshold set by MIN_BRIGHTNESS
	 * @param input
	 * @return 1 if above, else 0
	 */
	public int brightnessCheck(int input) {
		if(input > MIN_BRIGHTNESS) return 1;
		else return 0;
	}//end brightnessCheck
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("DMDResolution=" + DMDResolution.width + "x" + DMDResolution.height + ", displayResolution=" + displayResolution.width + "x" + displayResolution.height);
		return sb.toString();
	}
}
