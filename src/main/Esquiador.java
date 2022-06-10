/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import frames.MyFrame;

/**
 *
 * @author Schinwinkwinsky
 */
public class Esquiador implements Runnable {

    Filas filas;
    MyFrame frame;
    long tempoEntrada;

    public Esquiador(Filas f, MyFrame frame) {
        this.filas = f;
        this.frame = frame;
    }

    public Filas getFilas() {
        return filas;
    }

    public void setFilas(Filas filas) {
        this.filas = filas;
    }

    public long tempoEmFila() {
        long tempoSaida = System.currentTimeMillis();

        return tempoSaida - tempoEntrada;
    }

    @Override
    public synchronized void run() {
        int y = 0;
        int x = 0;
        if (filas.getLeftSingle().size() < filas.getRightSingle().size()
                && filas.getLeftSingle().size() < (filas.getLeftTriple().size() * 2)
                && filas.getLeftSingle().size() < (filas.getRightTriple().size() * 2)) {
            filas.getLeftSingle().add(this);
            tempoEntrada = System.currentTimeMillis();

            System.out.println();
            System.out.println("Esquiador entrou na fila: LeftSingle");
            x = filas.getLeftSingle().size() * 20;
            y = 20;

        } else if (filas.getRightSingle().size() <= filas.getLeftSingle().size()
                && filas.getRightSingle().size() < (filas.getRightTriple().size() * 2)
                && filas.getRightSingle().size() < (filas.getLeftTriple().size() * 2)) {
            filas.getRightSingle().add(this);
            tempoEntrada = System.currentTimeMillis();

            System.out.println();
            System.out.println("Esquiador entrou na fila: RightSingle");
            x = filas.getRightSingle().size() * 20;
            y = 60;
        } else if (filas.getLeftTriple().size() <= filas.getRightTriple().size()) {
            filas.getLeftTriple().add(this);
            tempoEntrada = System.currentTimeMillis();

            System.out.println();
            System.out.println("Esquiador entrou na fila: LeftTriple");
            x = filas.getLeftTriple().size() * 20;
            y = 100;
        } else {
            filas.getRightTriple().add(this);
            tempoEntrada = System.currentTimeMillis();

            System.out.println();
            System.out.println("Esquiador entrou na fila: RightTriple");
            x = filas.getRightTriple().size() * 20;
            y = 140;
        }

        System.out.println();
        System.out.println("Total de esquiadores por fila:");
        System.out.println("LeftSingle: " + filas.getLeftSingle().size());
        System.out.println("RightSingle: " + filas.getRightSingle().size());
        System.out.println("LeftTriple: " + filas.getLeftTriple().size());
        System.out.println("RightTriple: " + filas.getRightTriple().size());
        this.frame.adicionarEsquiador(x, y);
    }
}
