package Example;
import javax.swing.*;

public class HelloWorld {
	public static void main(String[] args) {
		JFrame frame = new JFrame("EmptyFrame");
		// sets the height and width of the frame
		frame.setSize(600, 600);
		// makes the frame visible
		frame.setVisible(true);
		// allows the program to properly close when you click on x
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
