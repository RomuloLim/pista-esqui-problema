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

    public void removerEsquiador(String pos, int tamanhoFila) {
        switch (pos) {
            case "LS" -> findEsquiador(tamanhoFila * 20, 20);
            case "RS" -> findEsquiador(tamanhoFila * 20, 60);
            case "LT" -> findEsquiador(tamanhoFila * 20, 100);
            case "RT" -> findEsquiador(tamanhoFila * 20, 140);
        }
    }

    protected void findEsquiador(int x, int y){
//        for(int i = 0; i < this.(); i++){
//            System.out.println(this.getComponent(i).getY());
//            if (this.getComponent(i).getX() == 7 && this.getComponent(i).getY() == y + 10){
                this.getContentPane().remove(this.findComponentAt(20, y));
                this.revalidate();
                this.repaint();
//                break;
//            }
//        }
    }
}
