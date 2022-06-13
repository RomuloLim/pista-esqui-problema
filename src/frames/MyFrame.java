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
        label = new ArrayList<>();
        setTitle("Fila de esquiadores");
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(420, 420);
        setVisible(true);
        setBackground(Color.darkGray);
        setLayout(null);
        setLocationRelativeTo(null);

        jpanel = new JPanel();
        jpanel.setLayout(null);
        jpanel.setBackground(Color.darkGray);
        jpanel.setSize(420, 420);
        jpanel.setVisible(true);
        jpanel.setBounds(0, 0, 420, 420);

        add(jpanel);
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
        jpanel.remove(jpanel.getComponentAt(x, y));
        jpanel.revalidate();
        jpanel.repaint();
    }
}
