package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class MyFrame extends JFrame {
    List<EsquiadorLabel> label;
    JPanel jpanel;
    JLabel elevador;
    public MyFrame(){
        this.label = new ArrayList<>();
        this.setTitle("Fila de esquiadores");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(420, 420);
        this.setVisible(true);
        this.setBackground(Color.darkGray);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        jpanel = new JPanel();
        jpanel.setLayout(null);
        jpanel.setBackground(Color.darkGray);
        jpanel.setSize(420, 420);
        jpanel.setVisible(true);
        jpanel.setBounds(0, 0, 420, 420);
        add(jpanel);

        elevador = new ElevadorLabel();
    }

    public void adicionarEsquiador(int x, int y){
        EsquiadorLabel novoEsquiador = new EsquiadorLabel();
        novoEsquiador.setVisible(true);
        novoEsquiador.setBounds(x, y, 20, 20);
        label.add(novoEsquiador);
        jpanel.add(label.get(label.size()-1));
        jpanel.revalidate();
        jpanel.repaint();
    }

    public void removerEsquiador(String pos, int tamanhoFila) {
        tamanhoFila = tamanhoFila + 1;
        switch (pos) {
            case "LS" -> findEsquiador(tamanhoFila * 20, 20);
            case "RS" -> findEsquiador(tamanhoFila * 20, 60);
            case "LT" -> findEsquiador(tamanhoFila * 20, 100);
            case "RT" -> findEsquiador(tamanhoFila * 20, 140);
        }
    }

    protected void findEsquiador(int x, int y){
        System.out.println(jpanel.getComponentAt(x, y));
        jpanel.remove(jpanel.getComponentAt(x, y));
        jpanel.revalidate();
        jpanel.repaint();
    }
}
