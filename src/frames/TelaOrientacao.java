package frames;

import javax.swing.*;
import java.awt.*;

public class TelaOrientacao extends JFrame {
    public TelaOrientacao(){
        setTitle("Orientação das filas");
        setResizable(false);
        setSize(420, 420);
        setVisible(true);
        setBackground(Color.darkGray);
        setLayout(null);

        getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel label = new JLabel("<html><body style='text:black'<h1>Orientação das filas</h1>" +
                "<h2>Left Single</h2>" +
                "<h2>Right Single</h2>" +
                "<h2>Left Triple</h2>" +
                "<h2>Right Single</h2>" +
                "</body></html>");
        getContentPane().add(label);
    }
}
