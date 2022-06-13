/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import frames.MyFrame;
import frames.TelaOrientacao;

import javax.swing.*;
import java.awt.*;
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

        MyFrame frame = new MyFrame();

        Filas filas = new Filas();


        new Thread(new Elevador(filas, frame)).start();

        int countEsquiadores = 0;

        while(countEsquiadores < 120){
            try {
                //Cria um novo esquiador.
                new Thread(new Esquiador(filas, frame)).start();

                //Aguarda um intervalo entre ]0, 1]s para criar
                //um novo esquiador.
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(EsquiProblem.class.getName()).log(Level.SEVERE, null, ex);
            }

            countEsquiadores++;
        }
    }
}
