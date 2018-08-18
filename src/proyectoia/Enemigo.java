package proyectoia;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Enemigo implements Constantes,Runnable{
    
    public int filaEnemigo;
    public int columnaEnemigo;
    public Escenario escenario;
    public Celda[][] c;
    /*hilos*/
    public boolean corriendo;
    public Thread hilo;
    public IANoInformada ia;
    public Tiempo t;
    public Lienzo l;
    public ArrayList<Character> solucion;
    public int filaTemporal;
    public int columnaTemporal;
    public Jugador jugador;
    public int fi,col;
    
    public Enemigo(Escenario escenario, int filaEnemigo, int columnaEnemigo,Tiempo t, Lienzo l,Jugador jugador){
        this.l = l;
        this.t=t;
        this.filaEnemigo=filaEnemigo;
        this.columnaEnemigo=columnaEnemigo;
        

        this.escenario= escenario;
        this.c=escenario.obtenerCeldas();
        this.jugador = jugador;
        
        this.fi=jugador.filaJugador;
        this.col=jugador.columnaJugador;
        /*para que funcione la ia */
        this.ia=new IANoInformada(this.escenario);
        this.solucion= ia.busquedaPorAnchura(this.filaEnemigo,this.columnaEnemigo,jugador.filaJugador,jugador.getColumnaJugador());
        
        this.hilo=new Thread(this);
        start();
    }
    
    public void correrHilos(){
         start();
    }
    
    public void moverEnemigoDerecha(){
        if(columnaEnemigo+1 < CELDA_ANCHO_ESCENARIO){
            if(c[filaEnemigo][columnaEnemigo+1].obtenerTipo()==TIPO_VACIO)
            {
                String tipo = escenario.obtenerCeldas()[this.filaEnemigo][this.columnaEnemigo+1].obtenerTipo();
                escenario.obtenerCeldas()[this.filaEnemigo][this.columnaEnemigo].TipoCelda("V");
                escenario.obtenerCeldas()[this.filaEnemigo][this.columnaEnemigo+1].TipoCelda(TIPO_ENEMIGO);
                this.columnaEnemigo++;
            }else{
                if(c[filaEnemigo][columnaEnemigo+1].obtenerTipo()==TIPO_JUGADOR || c[filaEnemigo][columnaEnemigo+1].obtenerTipo()==TIPO_JUGADORAB ||
                   c[filaEnemigo][columnaEnemigo+1].obtenerTipo()==TIPO_JUGADORAR || c[filaEnemigo][columnaEnemigo+1].obtenerTipo()==TIPO_JUGADORI)
                { 
                    JOptionPane.showMessageDialog(null,"PERDISTE TU TIEMPO ES: "+t.labelTiempoTotal.getText()+" SEGUNDOS");
                    l.stop();
                    t.stop();
                    l.estado=1;
                    this.stop();   
                }
            }       
        }
    }
    
    public void moverEnemigoIzquierda(){
        if(columnaEnemigo-1 >= 0){
            if(c[filaEnemigo][columnaEnemigo-1].obtenerTipo()==TIPO_VACIO)
            {
                String tipo = escenario.obtenerCeldas()[this.filaEnemigo][this.columnaEnemigo-1].obtenerTipo();
                escenario.obtenerCeldas()[this.filaEnemigo][this.columnaEnemigo].TipoCelda("V");
                escenario.obtenerCeldas()[this.filaEnemigo][this.columnaEnemigo-1].TipoCelda(TIPO_ENEMIGO);
                this.columnaEnemigo--;
            }else{
                if(c[filaEnemigo][columnaEnemigo-1].obtenerTipo()==TIPO_JUGADOR || c[filaEnemigo][columnaEnemigo-1].obtenerTipo()==TIPO_JUGADORAB ||
                   c[filaEnemigo][columnaEnemigo-1].obtenerTipo()==TIPO_JUGADORAR || c[filaEnemigo][columnaEnemigo-1].obtenerTipo()==TIPO_JUGADORI)
                {
                 JOptionPane.showMessageDialog(null,"PERDISTE TU TIEMPO ES: "+t.labelTiempoTotal.getText()+" SEGUNDOS");   
                 l.stop();
                 t.stop();
                 l.estado=1;
                 this.stop();
                }
            }
        }       
    }
    
    public void moverEnemigoArriba(){
        if(filaEnemigo-1 >=0){
            if(c[filaEnemigo -1][columnaEnemigo].obtenerTipo()== TIPO_VACIO)
            {
                String tipo = escenario.obtenerCeldas()[this.filaEnemigo -1][this.columnaEnemigo].obtenerTipo();
                escenario.obtenerCeldas()[this.filaEnemigo][this.columnaEnemigo].TipoCelda("V");
                escenario.obtenerCeldas()[this.filaEnemigo -1][this.columnaEnemigo].TipoCelda(TIPO_ENEMIGO);
                this.filaEnemigo--; 
           }else{
                
                if(c[filaEnemigo -1][columnaEnemigo].obtenerTipo()== TIPO_JUGADOR || c[filaEnemigo -1][columnaEnemigo].obtenerTipo()== TIPO_JUGADORAB ||
                   c[filaEnemigo -1][columnaEnemigo].obtenerTipo()== TIPO_JUGADORAR || c[filaEnemigo -1][columnaEnemigo].obtenerTipo()== TIPO_JUGADORI)
                {
                    
                 JOptionPane.showMessageDialog(null,"PERDISTE TU TIEMPO ES: "+t.labelTiempoTotal.getText()+" SEGUNDOS");   
                 l.stop();
                 t.stop();
                 l.estado=1;
                 this.stop();
                }
            }
        }     
    }
    
    public void moverEnemigoAbajo(){
        if(filaEnemigo+1 < CELDA_LARGO_ESCENARIO){
            if(c[filaEnemigo +1][columnaEnemigo].obtenerTipo()==TIPO_VACIO)
            {   
                String tipo = escenario.obtenerCeldas()[this.filaEnemigo +1][this.columnaEnemigo].obtenerTipo();
                escenario.obtenerCeldas()[this.filaEnemigo][this.columnaEnemigo].TipoCelda(tipo);
                escenario.obtenerCeldas()[this.filaEnemigo +1][this.columnaEnemigo].TipoCelda(TIPO_ENEMIGO);
                this.filaEnemigo++; 
            }else{
                if(c[filaEnemigo +1][columnaEnemigo].obtenerTipo()==TIPO_JUGADOR || c[filaEnemigo +1][columnaEnemigo].obtenerTipo()==TIPO_JUGADORAB ||
                   c[filaEnemigo +1][columnaEnemigo].obtenerTipo()==TIPO_JUGADORAR || c[filaEnemigo +1][columnaEnemigo].obtenerTipo()==TIPO_JUGADORI)
                {
                    JOptionPane.showMessageDialog(null,"PERDISTE TU TIEMPO ES: "+t.labelTiempoTotal.getText()+" SEGUNDOS");
                    l.stop();
                    t.stop();
                    l.estado=1;
                    this.stop(); 
                }
            }
        }   
    }
    
    public synchronized void start(){
        corriendo = true;
        hilo.start();
    }
    public synchronized void stop(){
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
                if(fi != escenario.jugador.getFilaJugador() || col != escenario.jugador.getColumnaJugador()){
                    this.solucion= ia.busquedaPorAnchura(this.filaEnemigo,this.columnaEnemigo,
                          jugador.getFilaJugador(),jugador.getColumnaJugador());
                    fi=escenario.jugador.getFilaJugador();
                    col=escenario.jugador.getColumnaJugador();
                }
                if(this.solucion.size()>0){
                   this.movimientoIA(this.solucion.get(0));
                    this.solucion.remove(0);
                }
               delta=0.0;           
            }
            if(t.tiempoRestante ==0){
                JOptionPane.showMessageDialog(null, "SE TE ACABO EL TIEMPO TU TIEMPO TOTAL ES DE:" 
                        +t.labelTiempoTotal.getText()+" SEGUNDOS");
                stop();
            }
        }        
    }
    
    public void movimientoIA(Character operacion){
        switch(operacion){
            case 'U': this.moverEnemigoArriba(); break;
            case 'D': this.moverEnemigoAbajo(); break;
            case 'L': this.moverEnemigoIzquierda(); break;
            case 'R': this.moverEnemigoDerecha(); break;
        }
    }
}
