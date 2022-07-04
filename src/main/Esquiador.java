/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

public class Esquiador implements Runnable {

    Filas filas;
    long tempoEntrada;

    public Esquiador(Filas f) {
        this.filas = f;
    }

    public float tempoEmFila() {
        long tempoSaida = System.currentTimeMillis();

        return (float) (tempoSaida - tempoEntrada) / 1000;
    }

    @Override
    public synchronized void run() {
        if (filas.getLeftSingle().size() < filas.getRightSingle().size()
                && filas.getLeftSingle().size() < (filas.getLeftTriple().size() * 2)
                && filas.getLeftSingle().size() < (filas.getRightTriple().size() * 2)) {
            filas.getLeftSingle().add(this);
            tempoEntrada = System.currentTimeMillis();

            System.out.println("\nEsquiador entrou na fila -> LeftSingle");
        } else if (filas.getRightSingle().size() <= filas.getLeftSingle().size()
                && filas.getRightSingle().size() < (filas.getRightTriple().size() * 2)
                && filas.getRightSingle().size() < (filas.getLeftTriple().size() * 2)) {
            filas.getRightSingle().add(this);
            tempoEntrada = System.currentTimeMillis();

            System.out.println("\nEsquiador entrou na fila -> RightSingle");
        } else if (filas.getLeftTriple().size() <= filas.getRightTriple().size()) {
            filas.getLeftTriple().add(this);
            tempoEntrada = System.currentTimeMillis();

            System.out.println("\nEsquiador entrou na fila -> LeftTriple");
        } else {
            filas.getRightTriple().add(this);
            tempoEntrada = System.currentTimeMillis();

            System.out.println("\nEsquiador entrou na fila -> RightTriple");
        }

        System.out.println();
        System.out.println("Total de esquiadores por fila:");
        System.out.println("LeftSingle (LS): " + filas.getLeftSingle().size());
        System.out.println("RightSingle (RS): " + filas.getRightSingle().size());
        System.out.println("LeftTriple: (LT): " + filas.getLeftTriple().size());
        System.out.println("RightTriple: (RT): " + filas.getRightTriple().size());
    }
}
