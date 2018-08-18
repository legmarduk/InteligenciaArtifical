package proyectoia;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;

public class Lienzo extends JComponent implements Constantes, KeyListener,Runnable{
    public Escenario escenario;
    public boolean corriendo;/*si jugador muere para el hilo*/
    public Thread hilo;
    public  Tiempo t;
    public Lienzo l;
    public int estado=0;
    
    
    public Lienzo(Tiempo t){
        this.t=t;
        this.l = l;
        escenario = new Escenario(t,this);/* CREO UN OBJETO ESCENARIO EN LA CLASE Lienzo*/
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
        this.addKeyListener(this);
    
        hilo = new Thread(this);
        start();
    }
    /*eventos de teclados para mover el jugador */
    @Override
    public void paint(Graphics g){
     
        escenario.paintComponent(g);/*pinto escenario en clase lienzo*/   
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
     if(estado!=1){   
       escenario.moverJugador(e);
       repaint(); /*siempre repintar para actualizar la posicion*/
     }
    }

    @Override
    public void keyReleased(KeyEvent e) {    
    }

    /*hilo funciona con star y para con el stop para cuando pierdas*/
    public synchronized void start(){
        corriendo = true;
        hilo.start();
    }
    public synchronized void stop(){
        corriendo = false;
        try{
            hilo.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    /* hilo */
    @Override
    public void run() {
        long ultimaVez = System.nanoTime();
        final double fps= 1000000000.0/2;//2 veces por segundo
        double delta=0;
        
        while(corriendo){
            long ahora = System.nanoTime();
            delta=delta + ((ahora - ultimaVez)/ fps);
            ultimaVez = ahora;
            
            while(delta >=1){
                repaint();
                delta--;
                //System.out.println("repinto");
            }
            repaint();
        }       
    }

}
