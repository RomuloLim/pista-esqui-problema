/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Schinwinkwinsky
 */
public class Filas {
    private Queue<Esquiador> leftSingle;
    private Queue<Esquiador> leftTriple;
    private Queue<Esquiador> rightTriple;
    private Queue<Esquiador> rightSingle;

    public Filas() {
        this.leftSingle = new LinkedList<>();
        this.leftTriple = new LinkedList<>();
        this.rightTriple = new LinkedList<>();
        this.rightSingle = new LinkedList<>();
    }

    public Queue<Esquiador> getLeftSingle() {
        return leftSingle;
    }

    public void setLeftSingle(Queue<Esquiador> leftSingle) {
        this.leftSingle = leftSingle;
    }

    public Queue<Esquiador> getLeftTriple() {
        return leftTriple;
    }

    public void setLeftTriple(Queue<Esquiador> leftTriple) {
        this.leftTriple = leftTriple;
    }

    public Queue<Esquiador> getRightTriple() {
        return rightTriple;
    }

    public void setRightTriple(Queue<Esquiador> rightTriple) {
        this.rightTriple = rightTriple;
    }

    public Queue<Esquiador> getRightSingle() {
        return rightSingle;
    }

    public void setRightSingle(Queue<Esquiador> rightSingle) {
        this.rightSingle = rightSingle;
    }

    public int getTotalFilas(){
        return leftSingle.size() + rightSingle.size() + leftTriple.size() + rightTriple.size();
    }

    public void reordena(){
        int rightTotal = rightTriple.size();
        if (rightTotal > 0){
            for (int i = 0; i < rightTotal; i++) {
                System.out.println(rightTriple);
            }
        }
    }
}
