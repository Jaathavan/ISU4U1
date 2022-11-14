import java.awt.*;
import java.awt.event.*;

public class Switch {
    private boolean on;

    public Switch () {
        this.on = true;
    }

    public boolean getOn() {
        return on;
    }
    
    public void setOn(boolean on) {
    	this.on = on;
    }
    
    public void keyPressed(KeyEvent e) {
    	if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			setOn(!getOn());
		}
    }
    
    public void paint (Graphics2D g) {
    	g.setColor(Color.GRAY);
    	g.fillRect(200, 385, 60, 30);
    	g.setColor(Color.GRAY.darker());
    	g.fillPolygon(new int[] {200-20, 260-60, 260-60}, new int[] {385, 385, 415}, 3);
    	if (getOn()) {
    		g.setColor(Color.GREEN);
    	}
    	else {
    		g.setColor(Color.GRAY.darker());
    	}
    	g.fill3DRect(200+4, 385+3, 27, 30-3-3, on);
    	
    	if (getOn()) {
    		g.setColor(Color.GRAY.darker());
    	}
    	else {
    		g.setColor(Color.RED);
    	}
    	g.fill3DRect(200+4+27, 385+3, 27, 30-3-3, on);
    	
    	g.setColor(Color.BLACK);
    	g.draw3DRect(200+4, 385+3, 27, 30-3-3, on);
    	g.draw3DRect(200+4+27, 385+3, 27, 30-3-3, on);
    	g.drawRect(200, 385, 60, 30);
    	g.drawPolygon(new int[] {200-20, 260-60, 260-60}, new int[] {385, 385, 415}, 3);
    }
}