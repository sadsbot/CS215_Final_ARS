/**
* Class Description
*
* @author aross-sermons
* @version 1.0
* CS215; Lab #
* Fall 2023
*/

public class LinkedList {
	private Node head;
	private Node tail;
	private int length;
	
	/**
	 * Default Constructor
	 */
	public LinkedList() {
		head = null;
		tail = null;
		length = 0;
	}//end default constructor
	
	/**
	 * Adds a new Node at the head or tail of this LinkedList
	 * @param newNode
	 */
	public void addNode(Node newNode) {
		Node tempNode = newNode;
		if(isEmpty()) { //If this LinkedList is empty
			head = tempNode;
			head.setNext(null);
			head.setPrevious(null);
			head.setIndex(length);
			tail = head;
			length++;
		}else { //If this LinkedList isn't empty
			tail.setNext(tempNode);
			tail = tail.getNext();
			tail.setNext(null);
			tail.setIndex(length);
			length++;
		}
	}//end addNode
	
	/**
	 * Determines if this LinkedList is empty
	 * @return true if empty
	 */
	public boolean isEmpty() {
		if(head == null) return true;
		else return false;
	}//end isEmpty

	/**
	 * @return the head
	 */
	public Node getHead() {
		return head;
	}//end getHead

	/**
	 * @param head the head to set
	 */
	public void setHead(Node head) {
		this.head = head;
	}//end setHead

	/**
	 * @return the tail
	 */
	public Node getTail() {
		return tail;
	}//end getTail

	/**
	 * @param tail the tail to set
	 */
	public void setTail(Node tail) {
		this.tail = tail;
	}//end setTail

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}//end getLength
	
	/**
	 * Returns the Node with index matching input
	 * @param index
	 * @return the Node
	 */
	public Node getAtIndex(int index) {
		Node tempNode = getHead();
		for(int node = 0; node < getLength(); node++) { //For each Node in this LinkedList
			if(tempNode.getIndex() == index) return tempNode; //If index of tempNode matches input index, return tempNode
			else tempNode = tempNode.getNext(); //else set tempNode to next Node
		}
		return null;
	}//end getAtIndex
	
	/**
	 * Returns a String representation of this object
	 * @return the toString
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("length=" + length);
		sb.append("\nhead=" + head.toString());
		sb.append("\ntail=" + tail.toString());
		return sb.toString();
	}//end toString

	
	
}//end LinkedList.java
