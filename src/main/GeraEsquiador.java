package main;

public class GeraEsquiador implements Runnable{

    Filas filas;
    
    public GeraEsquiador(Filas f){
        this.filas = f;
    }

    public Filas getFilas() {
        return filas;
    }

    public void setFilas(Filas filas) {
        this.filas = filas;
    }
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
