package proyectoia;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JComponent;

public class Escenario extends JComponent implements Constantes{
    public Celda[][] c;
    public Jugador jugador;
    //public Enemigo enemigo;
    public ArrayList<Enemigo> enemigos;
    //boolean jugando=true;
   public Tiempo t;
    
    public Escenario(Tiempo t){
        this.t=t;
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
        /*recompensa*/
        c[10][10].TipoCelda(TIPO_RECOMPENSA);
        c[1][3].TipoCelda(TIPO_RECOMPENSA);
        c[1][11].TipoCelda(TIPO_RECOMPENSA);
        c[5][3].TipoCelda(TIPO_RECOMPENSA);
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
    
    public void nuevaRecompensa(){
            Random r = new Random();
            int filaRandom=0,columnaRandom=0;
            do{
            filaRandom = r.nextInt(CELDA_LARGO_ESCENARIO);
            columnaRandom= r.nextInt(CELDA_ANCHO_ESCENARIO);
            
            }while(!this.c[filaRandom][columnaRandom].obtenerTipo().equals(TIPO_VACIO));
           // System.out.print(filaRandom+","+columnaRandom);
            c[filaRandom][columnaRandom].TipoCelda(TIPO_RECOMPENSA);
            
    }
    /*  
    public void terminarJuego(){
        jugando=false;
    }*/
    
    /*movimiento manual por teclado del jugador */
    public void moverJugador(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_RIGHT: 
                            jugador.moverJugadorDerecha();
                  
                    break;
                case KeyEvent.VK_LEFT:
                        jugador.moverJugadorIzquierda();
                   
                     break;
                case KeyEvent.VK_UP:
                        jugador.moverJugadorArriba();

                    break;
                case KeyEvent.VK_DOWN:
                            jugador.moverJugadorAbajo();

                    break;
            }
        }

}
