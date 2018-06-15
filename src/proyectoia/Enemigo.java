package proyectoia;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Enemigo implements Constantes,Runnable{
    
    public int filaEnemigo1;
    public int columnaEnemigo1;
    public Escenario escenario;
    public Celda[][] c;
    /*hilos*/
    public boolean corriendo;
    public Thread hilo;
    
    public Enemigo(Escenario escenario){
        this.filaEnemigo1=9;
        this.columnaEnemigo1=9;
        this.escenario= escenario;
        this.c=escenario.obtenerCeldas();
        
        this.hilo=new Thread(this);
        start();
    }
    
    public void moverEnemigoDerecha(){
    if(columnaEnemigo1+1 < CELDA_ANCHO_ESCENARIO){
        if(c[filaEnemigo1][columnaEnemigo1+1].obtenerTipo()!=TIPO_MURALLA &&
          c[filaEnemigo1][columnaEnemigo1+1].obtenerTipo()!=TIPO_RECOMPENSA &&
          c[filaEnemigo1][columnaEnemigo1+1].obtenerTipo()!=TIPO_JUGADOR){
            
            
                String tipo = escenario.obtenerCeldas()[this.filaEnemigo1][this.columnaEnemigo1+1].obtenerTipo();
                escenario.obtenerCeldas()[this.filaEnemigo1][this.columnaEnemigo1].TipoCelda(tipo);
                escenario.obtenerCeldas()[this.filaEnemigo1][this.columnaEnemigo1+1].TipoCelda(TIPO_ENEMIGO);
                this.columnaEnemigo1++;
            }
        }       
    }
    
    public void moverEnemigoIzquierda(){
    if(columnaEnemigo1-1 >= 0){
        if(c[filaEnemigo1][columnaEnemigo1-1].obtenerTipo()!=TIPO_MURALLA &&
            c[filaEnemigo1][columnaEnemigo1-1].obtenerTipo()!=TIPO_RECOMPENSA &&
            c[filaEnemigo1][columnaEnemigo1-1].obtenerTipo()!=TIPO_JUGADOR){
            
            
                String tipo = escenario.obtenerCeldas()[this.filaEnemigo1][this.columnaEnemigo1-1].obtenerTipo();
                escenario.obtenerCeldas()[this.filaEnemigo1][this.columnaEnemigo1].TipoCelda(tipo);
                escenario.obtenerCeldas()[this.filaEnemigo1][this.columnaEnemigo1-1].TipoCelda(TIPO_ENEMIGO);
                this.columnaEnemigo1--;
            }
        }       
    }
    
    
    public void moverEnemigoArriba(){
    if(filaEnemigo1-1 >=0){
        if(c[filaEnemigo1 -1][columnaEnemigo1].obtenerTipo()!=TIPO_MURALLA &&
           c[filaEnemigo1 -1][columnaEnemigo1].obtenerTipo()!=TIPO_RECOMPENSA &&
           c[filaEnemigo1 -1][columnaEnemigo1].obtenerTipo()!=TIPO_JUGADOR)
        {
            String tipo = escenario.obtenerCeldas()[this.filaEnemigo1 -1][this.columnaEnemigo1].obtenerTipo();
            escenario.obtenerCeldas()[this.filaEnemigo1][this.columnaEnemigo1].TipoCelda(tipo);
            escenario.obtenerCeldas()[this.filaEnemigo1 -1][this.columnaEnemigo1].TipoCelda(TIPO_ENEMIGO);
            this.filaEnemigo1--; 
           }
    }     
    }
    
    public void moverEnemigoAbajo(){
    
    if(filaEnemigo1+1 < CELDA_LARGO_ESCENARIO){
        if(c[filaEnemigo1 +1][columnaEnemigo1].obtenerTipo()!=TIPO_MURALLA &&
           c[filaEnemigo1 +1][columnaEnemigo1].obtenerTipo()!=TIPO_RECOMPENSA &&
           c[filaEnemigo1 +1][columnaEnemigo1].obtenerTipo()!=TIPO_JUGADOR)
        {   
            String tipo = escenario.obtenerCeldas()[this.filaEnemigo1 +1][this.columnaEnemigo1].obtenerTipo();
            escenario.obtenerCeldas()[this.filaEnemigo1][this.columnaEnemigo1].TipoCelda(tipo);
            escenario.obtenerCeldas()[this.filaEnemigo1 +1][this.columnaEnemigo1].TipoCelda(TIPO_ENEMIGO);
            this.filaEnemigo1++; 
        }
    }
        
    }
    
    
  private synchronized void start(){
        corriendo = true;
        hilo.start();
    }
    private synchronized void stop(){
        corriendo = false;
        try {
            hilo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        long ultimaVez = System.currentTimeMillis();
        int tiempoEspera = 1500;//1000 ms son 1 segundo
        double delta = 0.0;
        
        while(corriendo){//corriendo = a decir corriendo == true
            long ahora = System.currentTimeMillis();
            delta = delta + (ahora - ultimaVez);//se resta la ultima medicion
            ultimaVez = ahora;
            
            if(delta >=tiempoEspera){
                
                this.movimientoAleatorio();
                
                delta=0.0;           
            }
        }
        
    }
    
    public void movimientoAleatorio(){
        Random r = new Random();
        int direccion = r.nextInt(4);//genera numeros entre 0 y 3
        System.out.println("movimiento: "+direccion);
        switch(direccion){
            case 0: this.moverEnemigoArriba();
                break;
            case 1: this.moverEnemigoAbajo();
                break;
            case 2: this.moverEnemigoDerecha();
                break;
            case 3: this.moverEnemigoIzquierda();
                break;
        }
    }
    
}
