/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import frames.MyFrame;

import javax.swing.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Schinwinkwinsky
 */
public class EsquiProblem {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        

        int posicaoFinal = 420;
        Filas filas = new Filas();

        new Thread(new Elevador(filas)).start();

        Random gerador = new Random();

        MyFrame frame = new MyFrame();

//        frame.adicionarEsquiador(150, 20);

        while(true){
            try {
                posicaoFinal -= 20;
                //Cria um novo esquiador.
                new Thread(new Esquiador(filas)).start();

                //Aguarda um intervalo entre ]0, 1]s para criar
                //um novo esquiador.
                Thread.sleep(gerador.nextInt(1000) + 1);
                frame.adicionarEsquiador(posicaoFinal, 20);
            } catch (InterruptedException ex) {
                Logger.getLogger(EsquiProblem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}