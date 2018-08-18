package proyectoia;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Jugador implements Constantes{
    
    public int filaJugador;
    public int columnaJugador;
    public Escenario escenario;
    public Tiempo t;

    public Jugador(Escenario escenario,Tiempo t){
        this.t=t;
        this.filaJugador = 5;
        this.columnaJugador = 5;
        this.escenario = escenario;
        
    }
    
    public void moverJugadorDerecha(){
       if(columnaJugador+1< CELDA_ANCHO_ESCENARIO){//no se pasa las celdas
          if(escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador+1].obtenerTipo()== TIPO_VACIO){
              
            String tipo= escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador + 1].obtenerTipo();
            escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador].TipoCelda(tipo);
            escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador+1].TipoCelda(TIPO_JUGADOR);
            this.columnaJugador++;
          }else{
              if(escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador+1].obtenerTipo()== TIPO_RECOMPENSA){
                    escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador].TipoCelda(TIPO_VACIO);
                    escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador+1].TipoCelda(TIPO_JUGADOR);
                    this.columnaJugador++;
                    escenario.nuevaRecompensa();
                    //escenario.t.tiempoRestante=escenario.t.tiempoRestante+6;
                    escenario.t.sumarTiempo(6);
              }else
              if(escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador+1].obtenerTipo()== TIPO_ENEMIGO){
                   escenario.pararEnemigos();
                   t.stop();
                   JOptionPane.showMessageDialog(null,"PERDISTE TU TIEMPO ES: "+t.labelTiempoTotal.getText()+" SEGUNDOS");
                   
                   //escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador].obtenerTipo()
              }
          }
           
       } 
    }
    
    public void moverJugadorIzquierda(){
        if(columnaJugador-1 >= 0){
            if(escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador-1].obtenerTipo()== TIPO_VACIO){
            
                String tipo = escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador -1].obtenerTipo();
                escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador].TipoCelda(tipo);
                escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador-1].TipoCelda(TIPO_JUGADORI);
                this.columnaJugador--;
            }else{
                if(escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador-1].obtenerTipo()== TIPO_RECOMPENSA){
                    escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador].TipoCelda(TIPO_VACIO);
                    escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador-1].TipoCelda(TIPO_JUGADORI);
                    this.columnaJugador--;
                    escenario.nuevaRecompensa();
                    //escenario.t.tiempoRestante=escenario.t.tiempoRestante+6;
                    escenario.t.sumarTiempo(6);
                   
                }else
                if(escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador-1].obtenerTipo()== TIPO_ENEMIGO){
                    escenario.pararEnemigos();
                    t.stop();
                    JOptionPane.showMessageDialog(null,"PERDISTE TU TIEMPO ES: "+t.labelTiempoTotal.getText()+" SEGUNDOS");
                    
                }
            }
            
        }
    }
    
    public void moverJugadorArriba(){
        if(filaJugador-1 >=0){
            if(escenario.obtenerCeldas()[this.filaJugador-1][this.columnaJugador].obtenerTipo()== TIPO_VACIO){
                 String tipo = escenario.obtenerCeldas()[this.filaJugador -1][this.columnaJugador].obtenerTipo();
                escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador].TipoCelda(tipo);
                escenario.obtenerCeldas()[this.filaJugador -1][this.columnaJugador].TipoCelda(TIPO_JUGADORAR);
                this.filaJugador--;  
            }else{
                if(escenario.obtenerCeldas()[this.filaJugador-1][this.columnaJugador].obtenerTipo()== TIPO_RECOMPENSA){
                     escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador].TipoCelda(TIPO_VACIO);
                     escenario.obtenerCeldas()[this.filaJugador -1][this.columnaJugador].TipoCelda(TIPO_JUGADORAR);
                     this.filaJugador--;
                     escenario.nuevaRecompensa();
                     //escenario.t.tiempoRestante=escenario.t.tiempoRestante+6;
                     escenario.t.sumarTiempo(6);
                }else
                if(escenario.obtenerCeldas()[this.filaJugador-1][this.columnaJugador].obtenerTipo()== TIPO_ENEMIGO){
                    escenario.pararEnemigos();
                    t.stop();
                    JOptionPane.showMessageDialog(null,"PERDISTE TU TIEMPO ES: "+t.labelTiempoTotal.getText()+" SEGUNDOS");
                }
            }
        }
    }
    
    public void moverJugadorAbajo(){
        if(filaJugador +1 <CELDA_LARGO_ESCENARIO){
            if(escenario.obtenerCeldas()[this.filaJugador+1][this.columnaJugador].obtenerTipo()== TIPO_VACIO){
                String tipo= escenario.obtenerCeldas()[this.filaJugador +1][this.columnaJugador].obtenerTipo();
                escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador].TipoCelda(tipo);
                escenario.obtenerCeldas()[this.filaJugador +1][this.columnaJugador].TipoCelda(TIPO_JUGADORAB);
                this.filaJugador++;
            }else{
               if(escenario.obtenerCeldas()[this.filaJugador+1][this.columnaJugador].obtenerTipo()== TIPO_RECOMPENSA){
                    escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador].TipoCelda(TIPO_VACIO);
                    escenario.obtenerCeldas()[this.filaJugador +1][this.columnaJugador].TipoCelda(TIPO_JUGADORAB);
                    this.filaJugador++;
                    escenario.nuevaRecompensa();
                    //escenario.t.tiempoRestante=escenario.t.tiempoRestante+6;
                    escenario.t.sumarTiempo(6);
               }else
               if(escenario.obtenerCeldas()[this.filaJugador+1][this.columnaJugador].obtenerTipo()== TIPO_ENEMIGO){
                   escenario.pararEnemigos();
                   t.stop(); 
                   JOptionPane.showMessageDialog(null,"PERDISTE TU TIEMPO ES: "+t.labelTiempoTotal.getText()+" SEGUNDOS");
               }
            }
            
        }
    }
    
    public int getFilaJugador(){
       
        return this.filaJugador;
    }
    public int getColumnaJugador(){

        return this.columnaJugador;
    }
}
