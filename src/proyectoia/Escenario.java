package proyectoia;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;

public class Escenario extends JComponent implements Constantes{
    public Celda[][] c;
    public Jugador jugador;
    public Enemigo enemigo;
    
    /*variables de posicion inicial del jugador para mover*/
    /*public int filaJugador=12;
    public int columnaJugador=10;*/
    
    
    
    public Escenario(){
        
        c = new Celda[CELDA_LARGO_ESCENARIO][CELDA_ANCHO_ESCENARIO];
        int x=5;
        int y=5;
        for(int i =0; i<CELDA_LARGO_ESCENARIO;i++){
            for(int j=0;j<CELDA_ANCHO_ESCENARIO;j++){
                
                c[i][j]=new Celda(x,y);
                
                x=x+TAMAÑO_CELDA;
            }
            y=y+TAMAÑO_CELDA;
            x=5;
        }
        this.jugador = new Jugador(this);
        this.enemigo = new Enemigo(this);
        
        c[jugador.filaJugador][jugador.columnaJugador].TipoCelda(TIPO_JUGADOR);
        c[enemigo.filaEnemigo1][enemigo.columnaEnemigo1].TipoCelda(TIPO_ENEMIGO);
        
        /*murallas*/       

        c[4][13].TipoCelda(TIPO_MURALLA);
        c[5][13].TipoCelda(TIPO_MURALLA);
        c[6][13].TipoCelda(TIPO_MURALLA);
        
        /*c[9][9].TipoCelda(TIPO_ENEMIGO);
        c[5][5].TipoCelda(TIPO_ENEMIGO);
        c[1][16].TipoCelda(TIPO_ENEMIGO);*/
     
        c[10][10].TipoCelda(TIPO_RECOMPENSA);
        c[1][3].TipoCelda(TIPO_RECOMPENSA);
        /*c[0][0].TipoCelda(TIPO_MURALLA);
        c[0][1].TipoCelda(TIPO_MURALLA);*/
    }
    /*retorna por que el jugador necesita las celdas*/
    public Celda[][] obtenerCeldas(){
        
        return this.c;
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        for(int i= 0; i<CELDA_LARGO_ESCENARIO;i++){
            for(int j=0;j<CELDA_ANCHO_ESCENARIO;j++){
               
                c[i][j].paintComponent(g);/*funcion pintar de clase celda*/
                
            
            }
        }
      
        
    }
    
        /*movimiento manual por teclado del jugador */
      public void moverJugador(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_RIGHT: 
                  if(jugador.columnaJugador +1 < CELDA_ANCHO_ESCENARIO){ 
                    if(c[jugador.filaJugador][jugador.columnaJugador+1].obtenerTipo()!=TIPO_MURALLA &&
                       c[jugador.filaJugador][jugador.columnaJugador+1].obtenerTipo()!=TIPO_ENEMIGO )
                    {
                        System.out.println("muevela wea");
                        jugador.moverJugadorDerecha();
                    }
                  }
                  
                    break;
                case KeyEvent.VK_LEFT:
                   if(jugador.columnaJugador -1 >= 0){
                    if(c[jugador.filaJugador][jugador.columnaJugador-1].obtenerTipo()!=TIPO_MURALLA &&
                       c[jugador.filaJugador][jugador.columnaJugador-1].obtenerTipo()!=TIPO_ENEMIGO )
                    {
                        jugador.moverJugadorIzquierda();
                    }
                   }
                     break;
                case KeyEvent.VK_UP:
                  if(jugador.filaJugador -1 >= 0){
                    if(c[jugador.filaJugador -1][jugador.columnaJugador].obtenerTipo()!=TIPO_MURALLA &&
                       c[jugador.filaJugador -1][jugador.columnaJugador].obtenerTipo()!=TIPO_ENEMIGO )
                    {
                        jugador.moverJugadorArriba();
                    }
                  }    
                    break;
                case KeyEvent.VK_DOWN:
                  if(jugador.filaJugador +1 < CELDA_LARGO_ESCENARIO){
                     if(c[jugador.filaJugador +1][jugador.columnaJugador].obtenerTipo()!=TIPO_MURALLA &&
                        c[jugador.filaJugador +1][jugador.columnaJugador].obtenerTipo()!=TIPO_ENEMIGO )
                        {
                            jugador.moverJugadorAbajo();
                        }
                  }
                    break;
            }
        }
    
}
