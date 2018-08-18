package proyectoia;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JComponent;

public class Escenario extends JComponent implements Constantes{
    public Celda[][] c;
    public Jugador jugador;
    public ArrayList<Enemigo> enemigos;
    public Tiempo t;
    public Lienzo l;
    
    public Escenario(Tiempo t,Lienzo l){
        this.t=t;
        this.l = l;
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
        this.enemigos= new ArrayList<>();
        //creo los enemigos 

        //this.enemigos.add(new Enemigo(this,3,14,t,l));
        //this.enemigos.add(new Enemigo(this,1,2,t,l));
        
        //creo el jugador
        this.jugador = new Jugador(this,t); 
        //c[jugador.filaJugador][jugador.columnaJugador].TipoCelda(TIPO_JUGADOR);
        
        
        c[jugador.getFilaJugador()][jugador.getColumnaJugador()].TipoCelda(TIPO_JUGADOR);
        
        
        
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
        c[8][8].TipoCelda(TIPO_ENEMIGO);
        
       this.enemigos.add(new Enemigo(this,8,8,t,l,jugador));
       this.enemigos.add(new Enemigo(this,3,14,t,l,jugador));
       this.enemigos.add(new Enemigo(this,1,2,t,l,jugador));
       
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
    
    public void pararEnemigos(){
        for(Enemigo e: enemigos){
            e.stop();
        }
    }
            
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

    public Jugador getJugador(){
        
        return this.jugador;
    }
}
