package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class ElevadorLabel extends JLabel {
    @Override
    public void paintComponent(Graphics g){
        Line2D elevador = new Line2D.Float(0, 0, 0, 160);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.setStroke(new BasicStroke(30));
        g2d.draw(elevador);
        }
}
