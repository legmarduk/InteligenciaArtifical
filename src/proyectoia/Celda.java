package proyectoia;

import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Celda extends JComponent implements Constantes{
    
    public int x;
    public int y;
    public String tipo = "V";/*V= vacio, M = muralla*/
    
    public Image imagenJugadorDerecha;
    public Image imagenCielo;
    public Image imagenActual;
    public Image imagenMuralla;
    public Image imagenRecompensa;
    public Image imagenEnemigo;
    /*intento bismarck*/
    /*public Image imagenBismarck1;
    public Image imagenBismarck2;
    public Image imagenBismarck3;*/
    
    
    public Celda(int x ,int y){
        this.x = x;
        this.y = y;
        this.imagenActual= this.imagenCielo;//cielo es la imagen por defecto vacio
        
        imagenJugadorDerecha = new ImageIcon(getClass().getResource(IMAGEN_JUGADOR_DERECHA)).getImage();
        imagenCielo =new ImageIcon(getClass().getResource(IMAGEN_VACIO)).getImage();
        imagenMuralla = new ImageIcon(getClass().getResource(IMAGEN_MURALLA)).getImage();
        imagenRecompensa = new ImageIcon(getClass().getResource(IMAGEN_RECO)).getImage();
        imagenEnemigo = new ImageIcon(getClass().getResource(IMAGEN_ENEMIGO)).getImage();
       
       /*intento bismarck*/
       /* imagenBismarck1=new ImageIcon(getClass().getResource(IMAGEN_ENEMIGOBISMARK1)).getImage();
        imagenBismarck2=new ImageIcon(getClass().getResource(IMAGEN_ENEMIGOBISMARK2)).getImage();
        imagenBismarck3=new ImageIcon(getClass().getResource(IMAGEN_ENEMIGOBISMARK3)).getImage();*/
    }
   
    /*le entrego el tipo celda en este caso vacio por deferco*/
    public void TipoCelda(String tipo){
        this.tipo=tipo;
        
        switch(tipo) {
            case TIPO_JUGADOR: this.imagenActual = this.imagenJugadorDerecha;break;
            case TIPO_VACIO: this.imagenActual =this.imagenCielo; break;
            case TIPO_MURALLA:this.imagenActual = this.imagenMuralla;break;
            case TIPO_RECOMPENSA:this.imagenActual =this.imagenRecompensa;break;
            case TIPO_ENEMIGO:this.imagenActual = this.imagenEnemigo;break;
            
            /*intento bismarck*/
            //case TIPO_ENEMIGOBM:this.imagenActual = this.imagenBismarck1;break;
            
        }
       
    }
    
    /*obtengo el tipo de celda */
    public String obtenerTipo(){
        return this.tipo;
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        g.drawImage(imagenCielo, this.x, this.y, TAMAÑO_CELDA, TAMAÑO_CELDA, this);//PINTO EL CIELO
        g.drawImage(imagenActual, this.x, this.y, TAMAÑO_CELDA, TAMAÑO_CELDA, this);
        //falta pintar muralla
        
        /*fillrect llena el cuadrado */
       // g.fillRect(x, y, TAMAÑO_CELDA, TAMAÑO_CELDA);
        
    }
    
}