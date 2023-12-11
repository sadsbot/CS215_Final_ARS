/**
* Class Description
*
* @author aross-sermons
* @version 1.0
* CS215; Lab #
* Fall 2023
*/

public class Node {
	private DotMatrixDisplay data;
	private Node next;
	private Node previous;
	private int index;
	
	/**
	 * Default Constructor
	 */
	public Node() {
		data = null;
		next = null;
		previous = null;
		index = 0;
	}//end default constructor
	
	/**
	 * Determines if this Node has data
	 * @return true if data
	 */
	public boolean hasData() {
		if(data != null) return true;
		else return false;
	}//end hasData
	
	/**
	 * Determines if this Node has a next Node
	 * @return true if next
	 */
	public boolean hasNext() {
		if(next != null) return true;
		else return false;
	}//end hasNext
	
	/**
	 * Determines if this Node has a previous Node
	 * @return true if previous
	 */
	public boolean hasPrevious() {
		if(previous != null) return true;
		else return false;
	}//end hasPrevious

	/**
	 * @return the data
	 */
	public DotMatrixDisplay getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(DotMatrixDisplay data) {
		this.data = data;
	}

	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}//end getNext

	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}//end setNext

	/**
	 * @return the previous
	 */
	public Node getPrevious() {
		return previous;
	}//end getPrevious

	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(Node previous) {
		this.previous = previous;
	}//end setPrevious

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}//end getIndex

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}//end setIndex
	
	/**
	 * Returns a String representation of this object
	 * @return the toString
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("index=" + index + ", hasData=" + hasData()+ ", hasNext=" + hasNext()+ ", hasPrevious=" + hasPrevious());
		return sb.toString();
	}//end toString
	
}//end Node.java
