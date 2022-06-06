package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Panel extends JPanel {
    int x,y;

    public Panel(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        Ellipse2D.Double circle = new Ellipse2D.Double(this.x, this.y, 20, 20);
        g2d.setColor(Color.blue);
        g2d.fill(circle);
    }
}
