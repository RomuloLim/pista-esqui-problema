package main;

public class Esquiador implements Runnable {

    Filas filas;
    long tempoEntrada;

    public Esquiador(Filas f) {
        filas = f;
    }

    public float tempoEmFila() {
        long tempoSaida = System.currentTimeMillis();

        return (float) (tempoSaida - tempoEntrada) / 1000;
    }

    @Override
    public synchronized void run() {
        //condição para adicionar esquiador na LS
        if (filas.getLeftSingle().size() < filas.getRightSingle().size()
                && filas.getLeftSingle().size() < (filas.getLeftTriple().size() * 2)
                && filas.getLeftSingle().size() < (filas.getRightTriple().size() * 2)) {
            filas.getLeftSingle().add(this);
            tempoEntrada = System.currentTimeMillis();
            System.out.println("\nEntrou -> LeftSingle");

        //condição para adicionar esquiador na RS
        } else if (filas.getRightSingle().size() <= filas.getLeftSingle().size()
                && filas.getRightSingle().size() < (filas.getRightTriple().size() * 2)
                && filas.getRightSingle().size() < (filas.getLeftTriple().size() * 2)) {
            filas.getRightSingle().add(this);
            tempoEntrada = System.currentTimeMillis();
            System.out.println("\nEntrou -> RightSingle");

            //condição para adicionar esquiador na LT
        } else if (filas.getLeftTriple().size() <= filas.getRightTriple().size()) {
            filas.getLeftTriple().add(this);
            tempoEntrada = System.currentTimeMillis();
            System.out.println("\nEntrou -> LeftTriple");

        } else {
            //condição para adicionar esquiador na RT
            filas.getRightTriple().add(this);
            tempoEntrada = System.currentTimeMillis();

            System.out.println("\nEntrou -> RightTriple");
        }

        System.out.println("\nTotal de esquiadores por fila:");
        System.out.println("- LeftSingle (LS): " + filas.getLeftSingle().size());
        System.out.println("- RightSingle (RS): " + filas.getRightSingle().size());
        System.out.println("- LeftTriple: (LT): " + filas.getLeftTriple().size());
        System.out.println("- RightTriple: (RT): " + filas.getRightTriple().size());
    }
}
