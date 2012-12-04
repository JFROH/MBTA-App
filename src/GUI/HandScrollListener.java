package GUI;

/* *
 * Original code from: 	http://stackoverflow.com/questions/10243257/java-scroll-image-by-mouse-dragging
 * Modifications by: 	Cosimo Leone
 * */

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JViewport;

public class HandScrollListener extends MouseAdapter
{
    private final Cursor defCursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
    private final Cursor handCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
    private final Point pp = new Point();
    private JLabel image;

    public HandScrollListener(JLabel image)
    {
        this.image = image;
    }
    
    public void mouseEntered(MouseEvent e){
    	image.setCursor(handCursor);
    	pp.setLocation(e.getPoint());
    }

    public void mouseDragged(final MouseEvent e)
    {
        JViewport vport = (JViewport)e.getSource();
        Point cp = e.getPoint();
        Point vp = vport.getViewPosition();
        vp.translate(pp.x-cp.x, pp.y-cp.y);
        image.scrollRectToVisible(new Rectangle(vp, vport.getSize()));
        pp.setLocation(cp);
    }

    public void mousePressed(MouseEvent e)
    {
        image.setCursor(handCursor);
        pp.setLocation(e.getPoint());
    }

    public void mouseReleased(MouseEvent e)
    {
        image.repaint();
    }
}