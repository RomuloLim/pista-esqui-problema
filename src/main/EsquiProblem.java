/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EsquiProblem {
    public static void main(String[] args) throws InterruptedException {
        Filas filas = new Filas();

        boolean reordena = false;

        new Thread(new Elevador(filas)).start();

        int countEsquiadores = 0;

        while(countEsquiadores < 120){
            try {
                //Cria um novo esquiador.
                new Thread(new Esquiador(filas)).start();

                //Aguarda um intervalo entre ]0, 1]s para criar
                //um novo esquiador.
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(EsquiProblem.class.getName()).log(Level.SEVERE, null, ex);
            }

            countEsquiadores++;
        }


        while (!reordena){
            if(filas.getLeftTriple().size() < 3 && filas.getRightTriple().size() < 3){
                filas.reordena();
                reordena = true;
            }
            Thread.sleep(5000);
        }
    }
}
