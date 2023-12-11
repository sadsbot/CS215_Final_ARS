/**
* Class Description
*
* @author aross-sermons
* @version 1.0
* CS215; Lab #
* Fall 2023
*/

public class BinaryArray {
	private int[] binaryArray;
	
	/**
	 * Default Constructor
	 */
	public BinaryArray() {
		binaryArray = new int[0];
	}//end default constructor
	
	/**
	 * Preferred Constructor
	 * @param length
	 */
	public BinaryArray(int length) {
		binaryArray = new int[length];
	}//end preferred constructor
	
	/**
	 * Inverts all bits in the array.
	 */
	public void invert() {
		for(int i = 0; i < binaryArray.length; i++) {
			if(binaryArray[i] == 0) binaryArray[i] = 1;
			else binaryArray[i] = 0;
		}
	}//end invert
	
	/**
	 * Sets the bit at index according to an integer value.
	 * @param index
	 * @param bit
	 * @return true if successful
	 */
	public boolean setIndexAsInt(int index, int bit) {
		if(index > -1 && index < binaryArray.length) {
			if(bit > 0) binaryArray[index] = 1; // If bit is over 0, set to 1
			else if(bit <= 0) binaryArray[index] = 0; // If bit is 0 or less, set to 0
			return true;
		}else return false;
	}//end setIndexAsInt
	
	/**
	 * Returns the bit at index as an integer value.
	 * @param index
	 * @return the bit as an integer
	 */
	public int getIndexAsInt(int index) {
		if(index > -1 && index < binaryArray.length) { //If index is within binaryArray
			return(binaryArray[index]);
		}else return(-1);
	}//end getIndexAsInt
	
	/**
	 * Sets the bit at index according to a boolean value.
	 * @param index
	 * @param bit
	 * @return true if successful
	 */
	public boolean setIndexAsBool(int index, boolean bit) {
		if(index > -1 && index < binaryArray.length) {
			if(bit) binaryArray[index] = 1; // If bit is true, set to 1
			else if(!bit) binaryArray[index] = 0; // If bit is false, set to 0
			return true;
		}else return false;
	}//end setIndexAsBool
	
	/**
	 * Returns the bit at index as a boolean value.
	 * @param index
	 * @return the bit as a boolean
	 */
	public boolean getIndexAsBool(int index) {
		if(index > -1 && index < binaryArray.length) { //If index is within binaryArray
			if(binaryArray[index]==1) return true;
			else return false;
		}else {
			System.out.println("ERROR: indexAsBool() received index out of bounds: " + index);
			return false;
		}
	}//end getIndexAsBool
	
	/**
	 * @return the length
	 */
	public int getLength() {
		return binaryArray.length;
	}//end getLength
	
	/**
	 * Returns this object as a String of bits.
	 * @return the String
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i : binaryArray) {
			sb.append(i + " ");
		}
		return(sb.toString());
	}//end toString
	
}//end BinaryArray.java