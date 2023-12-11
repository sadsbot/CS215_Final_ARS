/**
* Class Description
*
* @author aross-sermons
* @version 1.0
* CS215; Lab #
* Fall 2023
*/

public class Application {
	public static void main(String[] args) {
		FullDisplay myDisplay = new FullDisplay();
		myDisplay.getImageFromWebcam();
		System.out.println(myDisplay.getImageAsString());
	}
}
