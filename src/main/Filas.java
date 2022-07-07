package main;

import java.util.LinkedList;
import java.util.Queue;

public class Filas {
    private Queue<Esquiador> leftSingle;
    private Queue<Esquiador> leftTriple;
    private Queue<Esquiador> rightTriple;
    private Queue<Esquiador> rightSingle;

    public Filas() {
        leftSingle = new LinkedList<>();
        leftTriple = new LinkedList<>();
        rightTriple = new LinkedList<>();
        rightSingle = new LinkedList<>();
    }

    public Queue<Esquiador> getLeftSingle() {
        return leftSingle;
    }

    public Queue<Esquiador> getLeftTriple() {
        return leftTriple;
    }

    public Queue<Esquiador> getRightTriple() {
        return rightTriple;
    }

    public Queue<Esquiador> getRightSingle() {
        return rightSingle;
    }

    public int getTotalFilas(){
        return leftSingle.size() + rightSingle.size() + leftTriple.size() + rightTriple.size();
    }

    public void reordena(){
        if (rightTriple.size() > 0){
            for (int i = -1; i < rightTriple.size(); i++) {
                rightSingle.add(rightTriple.element());
                rightTriple.remove();
            }
        }

        if (leftTriple.size() > 0){
            for (int i = 0; i <= leftTriple.size(); i++) {
                leftSingle.add(leftTriple.element());
                leftTriple.remove();
            }
        }

        System.out.println("*-===== As filas LT e RT estao bloqueadas por falta de esquiador.\nOs esquiadores *TRIPLE* foram movidos para as filas *SINGLE* =====-*");
    }
}
