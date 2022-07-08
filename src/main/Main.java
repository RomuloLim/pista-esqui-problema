package main;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Filas filas = new Filas();

        boolean reordena = false;

        new Thread(new Elevador(filas)).start();

        int countEsquiadores = 0;

        while(countEsquiadores < 120){
            try {
                new Thread(new Esquiador(filas)).start();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
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
