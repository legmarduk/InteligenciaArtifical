
package proyectoia;

import static proyectoia.Constantes.CELDA_ANCHO_ESCENARIO;
import static proyectoia.Constantes.CELDA_LARGO_ESCENARIO;
import static proyectoia.Constantes.TIPO_JUGADOR;


public class Jugador implements Constantes{
    
    public int filaJugador;
    public int columnaJugador;
 
    public Escenario escenario;
    
    public Jugador(Escenario escenario){
        this.filaJugador = 8;
        this.columnaJugador = 2;
        this.escenario = escenario;
    }
    
    
    public void moverJugadorDerecha(){
       if(columnaJugador+1< CELDA_ANCHO_ESCENARIO){//no se pasa las celdas
            String tipo= escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador + 1].obtenerTipo();
            escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador].TipoCelda(tipo);
            escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador+1].TipoCelda(TIPO_JUGADOR);
            this.columnaJugador++;
       }
       
    }
    
    public void moverJugadorIzquierda(){
        if(columnaJugador-1 >= 0){
            String tipo = escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador -1].obtenerTipo();
            escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador].TipoCelda(tipo);
            escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador-1].TipoCelda(TIPO_JUGADOR);
            this.columnaJugador--;
        }

    }
    
    public void moverJugadorArriba(){
        if(filaJugador-1 >=0){
            String tipo = escenario.obtenerCeldas()[this.filaJugador -1][this.columnaJugador].obtenerTipo();
            escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador].TipoCelda(tipo);
            escenario.obtenerCeldas()[this.filaJugador -1][this.columnaJugador].TipoCelda(TIPO_JUGADOR);
            this.filaJugador--;    
        }
        
    }
    
    public void moverJugadorAbajo(){
        
        if(filaJugador +1 <CELDA_LARGO_ESCENARIO){
            String tipo= escenario.obtenerCeldas()[this.filaJugador +1][this.columnaJugador].obtenerTipo();
            escenario.obtenerCeldas()[this.filaJugador][this.columnaJugador].TipoCelda(tipo);
            escenario.obtenerCeldas()[this.filaJugador +1][this.columnaJugador].TipoCelda(TIPO_JUGADOR);
            this.filaJugador++;
        }

    }
}
