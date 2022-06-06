package frames;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    Panel painel;
    public MyFrame(){
        this.setTitle("teste");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(420, 420);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(123, 50, 250));
    }

    public void adicionarEsquiador(int x, int y){
        painel = new Panel(x, y);

        add(painel);

        setBackground(Color.LIGHT_GRAY);
        setVisible(true);
    }
}
