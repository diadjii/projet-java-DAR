package flux.assoc.listener;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class LisetenerFenetre extends MouseAdapter {

	private final JFrame frame;
	private Point mouseCood = null;

	public LisetenerFenetre(JFrame frame) {
		this.frame = frame;
	}

	public void mouseReleased(MouseEvent e) {
		mouseCood = null;
		frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	public void mousePressed(MouseEvent e) {
		mouseCood = e.getPoint();
	}

	public void mouseDragged(MouseEvent e) {
		Point currCoord = e.getLocationOnScreen();
		frame.setLocation(currCoord.x - mouseCood.x, currCoord.y - mouseCood.y);
		frame.setCursor(new Cursor(Cursor.MOVE_CURSOR));
	}

}
