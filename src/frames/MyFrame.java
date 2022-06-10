package frames;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyFrame extends JFrame {
    List<EsquiadorLabel> label;
    JPanel jpanel;
    public MyFrame(){
        this.label = new ArrayList<>();
        this.setTitle("teste");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(420, 420);
        this.setVisible(true);
        this.setBackground(Color.darkGray);
        this.setLayout(null);

        jpanel = new JPanel();
        jpanel.setLayout(null);
        jpanel.setBackground(Color.red);
        jpanel.setSize(420, 420);
        jpanel.setVisible(true);
        jpanel.setBounds(0, 0, 420, 420);
        add(jpanel);
    }

    public void adicionarEsquiador(int x, int y){
        EsquiadorLabel novoEsquiador = new EsquiadorLabel(x, y);
        novoEsquiador.setVisible(true);
        novoEsquiador.setBounds(x, y, 20, 20);
        label.add(novoEsquiador);
        jpanel.add(label.get(label.size()-1));
        jpanel.revalidate();
        jpanel.repaint();
//        System.out.println(label.get(0));
    }

    public void removerEsquiador(String pos, int tamanhoFila) {
        switch (pos) {
            case "LS" -> findEsquiador(tamanhoFila * 20, 20);
            case "RS" -> findEsquiador(tamanhoFila * 20, 60);
            case "LT" -> findEsquiador(tamanhoFila * 20, 100);
            case "RT" -> findEsquiador(tamanhoFila * 20, 140);
        }
    }

    protected void findEsquiador(int x, int y){
        System.out.println(jpanel.getComponents()[3].getX());
//        jpanel.remove(jpanel.findComponentAt(x, y));
//        jpanel.revalidate();
//        jpanel.repaint();

//        label.remove(label.get(0));
//            System.out.println(getContentPane().getComponentCount());
//            System.out.println(getContentPane().getComponents());
//            System.out.println(getContentPane().getComponent(1).);
//        for(int i = 0; i < getContentPane().getComponentCount(); i++){
//            System.out.println(this.getContentPane().getComponentCount());
//            if (this.getComponent(i).getX() == 7 && this.getComponent(i).getY() == y + 10){
//                this.getContentPane().remove(getContentPane().findComponentAt(x, y));
//                this.revalidate();
//                this.repaint();
//                break;
//            }
//        }
    }
}
