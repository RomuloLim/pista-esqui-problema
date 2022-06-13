package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class EsquiadorLabel extends JLabel {
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        Ellipse2D.Double circle = new Ellipse2D.Double(0,0,20,20);
        g2d.setColor(new Color(67, 94, 210));
        g2d.fill(circle);
    }
}
