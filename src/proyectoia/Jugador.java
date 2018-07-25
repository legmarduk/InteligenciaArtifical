package proyectoia;

import javax.swing.JOptionPane;

public class Jugador implements Constantes{
    
    public int filaJugador;
    public int columnaJugador;
    public Escenario escenario;
   

    public Jugador(Escenario escenario){
        this.filaJugador = 4;
        this.columnaJugador = 4;
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
                    escenario.t.tiempoRestante=escenario.t.tiempoRestante+5;
              }
              if(escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador+1].obtenerTipo()== TIPO_ENEMIGO){
                   JOptionPane.showMessageDialog(null,"PERDISTE PO COMPRADRE");
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
                    escenario.t.tiempoRestante=escenario.t.tiempoRestante+5;
                   
                }
                if(escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador-1].obtenerTipo()== TIPO_ENEMIGO){
                    JOptionPane.showMessageDialog(null,"PERDISTE PO COMPRADRE");
                    
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
                     escenario.t.tiempoRestante=escenario.t.tiempoRestante+5;
                }
                if(escenario.obtenerCeldas()[this.filaJugador-1][this.columnaJugador].obtenerTipo()== TIPO_ENEMIGO){
                    JOptionPane.showMessageDialog(null,"PERDISTE PO COMPRADRE");
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
                    escenario.t.tiempoRestante=escenario.t.tiempoRestante+5;
               }
               if(escenario.obtenerCeldas()[this.filaJugador+1][this.columnaJugador].obtenerTipo()== TIPO_ENEMIGO){
                    JOptionPane.showMessageDialog(null,"PERDISTE PO COMPRADRE");
               }
            }
            
        }
    }
}
