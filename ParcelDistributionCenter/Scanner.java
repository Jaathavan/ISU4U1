import java.awt.*;
import javax.swing.*;

public class Scanner {
	private boolean scan;

	public Scanner() {
		this.scan = false;
	}

	private boolean getScan() {
		return scan;
	}

	private void setScan(boolean scan) {
		this.scan = scan;
	}
	
	public void move(int x) {
		if (x >= 200 && x <= 300) {
			setScan(true);
		}
		else {
			setScan(false);
		}
	}

	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(200, 300-20, 100, 100);

		if (getScan() == true) {
			g.setColor(Color.YELLOW);
		} else {
			g.setColor(Color.RED);
		}

		g.fillOval(200+10, 300-20+10, 10, 10);

		g.setColor(Color.BLACK);
		g.drawOval(200+10, 300-20+10, 10, 10);
	}
}
