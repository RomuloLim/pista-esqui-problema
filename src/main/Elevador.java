package main;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Elevador implements Runnable {
    Filas filas;

    int assentosRestantes = 4;
    int totalAssentos = 0;
    int assentosOcupados = 0;

    float somaTempoFila = 0;

    boolean vezDaLeftSingle;
    boolean vezDaLeftTriple;

    String elevador = "";
    String stringTempoFila = "";

    public Elevador(Filas f) {
        filas = f;
        vezDaLeftSingle = vezDaLeftTriple = new Random().nextInt(2) == 0;
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                this.wait(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Elevador.class.getName()).log(Level.SEVERE, null, ex);
            }

           if(filas.getTotalFilas() == 0){
                   System.out.println("*-===== FIM DO PROGRAMA =====-*");
                   System.out.println("Numero de assentos ocupados: "+assentosOcupados);
                   System.out.println("Numero total de assentos: "+totalAssentos*4);
                   System.out.println("Taxa de aproveitamento: "+ (float) assentosOcupados/(totalAssentos*4));
                   System.out.println("Tempo medio de espera na fila: "+ somaTempoFila / 120);
                   System.exit(0);
           }else{
               boolean leftTriple = false;
               boolean rightTriple = false;
               Esquiador esquiador;

               if ((vezDaLeftTriple || filas.getRightTriple().size() < 3)
                       && filas.getLeftTriple().size() > 2
                       && assentosRestantes > 2) {
                   for (int i = 2; i >= 0; i--) {
                       esquiador = filas.getLeftTriple().remove();
                       assentosRestantes--;

                       stringTempoFila = stringTempoFila
                               + "\nO tempo em fila do esquiador da LeftTriple foi: "
                               + esquiador.tempoEmFila() + " segundos.";
                       assentosOcupados++;
                       somaTempoFila = somaTempoFila + esquiador.tempoEmFila();
                   }

                   elevador = "LT LT LT";
                   leftTriple = true;
                   vezDaLeftTriple = false;
               } else if (filas.getRightTriple().size() > 2
                       && assentosRestantes > 2) {
                   for (int i = 2; i >= 0; i--) {
                       esquiador = filas.getRightTriple().remove();
                       assentosRestantes--;

                       stringTempoFila = stringTempoFila
                               + "\nTempo em fila de esquiador da RightTriple: "
                               + esquiador.tempoEmFila() + " segundos.";
                       assentosOcupados++;
                       somaTempoFila = somaTempoFila + esquiador.tempoEmFila();
                   }

                   elevador = "RT RT RT";
                   rightTriple = vezDaLeftTriple = true;
               }

               //Caso não tenha embarcado ninguém das filas anteriores.
               if (!leftTriple && !rightTriple) {

                   int random = new Random().nextInt(2);

                   //Utilizada para alternar as filas.
                   boolean chave = random == 0;

                   while (assentosRestantes > 0
                           && (filas.getLeftSingle().size() > 0
                           || filas.getRightSingle().size() > 0)) {

                       if (chave) {
                           if (filas.getLeftSingle().size() > 0) {
                               esquiador = filas.getLeftSingle().remove();
                               assentosRestantes--;

                               stringTempoFila = stringTempoFila
                                       + "\nTempo em fila de esquiador da LeftSingle: "
                                       + esquiador.tempoEmFila() + " segundos.";

                               elevador = "LS " + elevador;
                               assentosOcupados++;
                               somaTempoFila = somaTempoFila + esquiador.tempoEmFila();
                           }

                           chave = false;
                       } else {
                           if (filas.getRightSingle().size() > 0) {
                               esquiador = filas.getRightSingle().remove();
                               assentosRestantes--;

                               stringTempoFila = stringTempoFila
                                       + "\nTempo em fila de esquiador da RightSingle: "
                                       + esquiador.tempoEmFila() + " segundos.";

                               elevador = elevador + "RS ";
                               assentosOcupados++;
                               somaTempoFila = somaTempoFila + esquiador.tempoEmFila();
                           }

                           chave = true;
                       }
                   }
               } else {
                   if ((!vezDaLeftSingle || filas.getLeftSingle().size() == 0)
                           && filas.getRightSingle().size() > 0) {
                       esquiador = filas.getRightSingle().remove();
                       assentosRestantes--;

                       stringTempoFila = stringTempoFila + "\nTempo em fila de esquiador da RightSingle: "
                               + esquiador.tempoEmFila() + " segundos.";

                       elevador = elevador + " RS";
                       assentosOcupados++;
                       somaTempoFila = somaTempoFila + esquiador.tempoEmFila();
                       vezDaLeftSingle = true;
                   }else if (filas.getLeftSingle().size() > 0) {
                       esquiador = filas.getLeftSingle().remove();
                       assentosRestantes--;

                       stringTempoFila = stringTempoFila
                               + "\nTempo em fila de esquiador da LeftSingle: "
                               + esquiador.tempoEmFila() + " segundos.";

                       elevador = "LS " + elevador;
                       assentosOcupados++;
                       somaTempoFila = somaTempoFila + esquiador.tempoEmFila();
                       vezDaLeftSingle = false;
                   }
               }

               printDadosElevador();

               elevador = "";
               stringTempoFila = "";

               totalAssentos++;
               assentosRestantes = 4;
           }
        }
    }

    private void printDadosElevador() {
        System.out.println("------>\nElevador n: " + totalAssentos);
        System.out.println(elevador);

        System.out.println("\nFilas depois do elevador passar:");
        System.out.println("LeftSingle (LS): " + filas.getLeftSingle().size());
        System.out.println("RightSingle (RS): " + filas.getRightSingle().size());
        System.out.println("LeftTriple (LT): " + filas.getLeftTriple().size());
        System.out.println("RightTriple (RT): " + filas.getRightTriple().size());

        System.out.println("Tempo dos esquiadores na fila:");
        System.out.println(stringTempoFila);
    }
}