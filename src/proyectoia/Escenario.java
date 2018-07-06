package proyectoia;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JComponent;

public class Escenario extends JComponent implements Constantes{
    public Celda[][] c;
    public Jugador jugador;
    //public Enemigo enemigo;
    public ArrayList<Enemigo> enemigos;
    /*variables de posicion inicial del jugador para mover*/
   
    
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
       
        //creo el jugador
        this.jugador = new Jugador(this); 
        c[jugador.filaJugador][jugador.columnaJugador].TipoCelda(TIPO_JUGADOR);
        //reservo memoria
        this.enemigos= new ArrayList<>();
        //creo los enemigos 
        this.enemigos.add(new Enemigo(this,8,8));
        this.enemigos.add(new Enemigo(this,3,14));
        this.enemigos.add(new Enemigo(this,1,2));
   
        //otras posiciones 
        c[4][13].TipoCelda(TIPO_MURALLA);
        c[5][13].TipoCelda(TIPO_MURALLA);
        c[6][13].TipoCelda(TIPO_MURALLA);
        
       /*bismark*/
        c[3][6].TipoCelda(TIPO_MURALLABISCUATRO);
        c[3][7].TipoCelda(TIPO_MURALLABISDOS);
        c[3][8].TipoCelda(TIPO_MURALLABISTRES);
        c[3][9].TipoCelda(TIPO_MURALLABISUNO);
        
        c[10][10].TipoCelda(TIPO_RECOMPENSA);
        c[1][3].TipoCelda(TIPO_RECOMPENSA);

        
        
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
                       c[jugador.filaJugador][jugador.columnaJugador+1].obtenerTipo()!=TIPO_MURALLABISUNO &&
                       c[jugador.filaJugador][jugador.columnaJugador+1].obtenerTipo()!=TIPO_MURALLABISDOS &&
                       c[jugador.filaJugador][jugador.columnaJugador+1].obtenerTipo()!=TIPO_MURALLABISTRES &&
                       c[jugador.filaJugador][jugador.columnaJugador+1].obtenerTipo()!=TIPO_MURALLABISCUATRO &&
                       c[jugador.filaJugador][jugador.columnaJugador+1].obtenerTipo()!=TIPO_ENEMIGO )
                    {
                        jugador.moverJugadorDerecha();
                    }
                  }
                  
                    break;
                case KeyEvent.VK_LEFT:
                   if(jugador.columnaJugador -1 >= 0){
                    if(c[jugador.filaJugador][jugador.columnaJugador-1].obtenerTipo()!=TIPO_MURALLA &&
                       c[jugador.filaJugador][jugador.columnaJugador-1].obtenerTipo()!=TIPO_MURALLABISUNO &&
                       c[jugador.filaJugador][jugador.columnaJugador-1].obtenerTipo()!=TIPO_MURALLABISDOS &&
                       c[jugador.filaJugador][jugador.columnaJugador-1].obtenerTipo()!=TIPO_MURALLABISTRES &&  
                       c[jugador.filaJugador][jugador.columnaJugador-1].obtenerTipo()!=TIPO_MURALLABISCUATRO &&   
                       c[jugador.filaJugador][jugador.columnaJugador-1].obtenerTipo()!=TIPO_ENEMIGO )
                    {
                        jugador.moverJugadorIzquierda();
                    }
                   }
                     break;
                case KeyEvent.VK_UP:
                  if(jugador.filaJugador -1 >= 0){
                    if(c[jugador.filaJugador -1][jugador.columnaJugador].obtenerTipo()!=TIPO_MURALLA &&
                       c[jugador.filaJugador -1][jugador.columnaJugador].obtenerTipo()!=TIPO_MURALLABISUNO &&
                       c[jugador.filaJugador -1][jugador.columnaJugador].obtenerTipo()!=TIPO_MURALLABISDOS &&
                       c[jugador.filaJugador -1][jugador.columnaJugador].obtenerTipo()!=TIPO_MURALLABISTRES &&
                       c[jugador.filaJugador -1][jugador.columnaJugador].obtenerTipo()!=TIPO_MURALLABISCUATRO &&
                       c[jugador.filaJugador -1][jugador.columnaJugador].obtenerTipo()!=TIPO_ENEMIGO )
                    {
                        jugador.moverJugadorArriba();
                    }
                  }    
                    break;
                case KeyEvent.VK_DOWN:
                  if(jugador.filaJugador +1 < CELDA_LARGO_ESCENARIO){
                     if(c[jugador.filaJugador +1][jugador.columnaJugador].obtenerTipo()!=TIPO_MURALLA &&
                        c[jugador.filaJugador +1][jugador.columnaJugador].obtenerTipo()!=TIPO_MURALLABISUNO &&
                        c[jugador.filaJugador +1][jugador.columnaJugador].obtenerTipo()!=TIPO_MURALLABISDOS &&
                        c[jugador.filaJugador +1][jugador.columnaJugador].obtenerTipo()!=TIPO_MURALLABISTRES &&
                        c[jugador.filaJugador +1][jugador.columnaJugador].obtenerTipo()!=TIPO_MURALLABISCUATRO &&
                        c[jugador.filaJugador +1][jugador.columnaJugador].obtenerTipo()!=TIPO_ENEMIGO )
                        {
                            jugador.moverJugadorAbajo();
                        }
                  }
                    break;
            }
        }
    
}
