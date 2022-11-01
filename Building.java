import java.awt.*;

public class Building {
	public void paint(Graphics2D g) {
		//building
		g.setColor(Color.GRAY);
		g.fillRect(5, Math.round(640/3), (1020/5), Math.round(640*2/3));
		
		g.setColor(Color.BLACK);
		g.fillRect(5+10, Math.round(640/3) + 10, 30, 30);
		
		for (int i=15; i < 1020/5; i+=40) {
			
			for (int j=Math.round(640/3); j < Math.round(640*2/3); j+=40) {
				g.fillRect(15, j + 10, 30, 30);
				g.fillRect(i, Math.round(640/3) + 10, 30, 30);
			}
		}
		
		//g.fillRect(5+10+10+30, Math.round(640/3) + 10, 30, 30);
	}
}
