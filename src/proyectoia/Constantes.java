package proyectoia;

import java.awt.*;

public interface Constantes {
    
    public final String TITULO ="Proyecto IA";
    public final int CELDA_ANCHO_ESCENARIO = 19;
    public final int CELDA_LARGO_ESCENARIO = 12;    
    public final int TAMAÑO_CELDA= 50;
   

   public final int ANCHO_VENTANA =(CELDA_ANCHO_ESCENARIO *TAMAÑO_CELDA)+10;/*ANCHO ventana*//*120 para los paneles de tiempo*/
   public final int LARGO_VENTANA =(CELDA_LARGO_ESCENARIO *TAMAÑO_CELDA)+40;/*LARGO ventana*/
    
   /*faltan paredes  recompenza*/
   public final String TIPO_VACIO ="V";
   public final String TIPO_JUGADOR ="J";
   public final String TIPO_JUGADORI="JI";
   public final String TIPO_JUGADORAB="JAB";
   public final String TIPO_JUGADORAR="JAR";
   
   public final String TIPO_ENEMIGO ="E";
   public final String TIPO_MURALLA ="M";
   public final String TIPO_RECOMPENSA="R";
  /*intento bismarck*/
   public final String TIPO_MURALLABISUNO="MB1";
   public final String TIPO_MURALLABISDOS="MB2";
   public final String TIPO_MURALLABISTRES="MB3";
   public final String TIPO_MURALLABISCUATRO="MB4";

   /*referencia a la imagen (ruta)
   public final String IMAGEN_JUGADOR_DERECHA ="../res/jugadorDerecha.png";
   public final String IMAGEN_JUGADOR_IZQUIERDA="../res/jugadorIzquierda.png";
   public final String IMAGEN_JUGADOR_ABAJO="../res/jugadorAbajo.png";
   public final String IMAGEN_JUGADOR_ARRIBA="../res/jugadorArriba.png";*/
   
   public final String IMAGEN_JUGADOR_DERECHA ="../res/derecha50.png";
   public final String IMAGEN_JUGADOR_IZQUIERDA="../res/izquierda50.png";
   public final String IMAGEN_JUGADOR_ABAJO="../res/abajo50.png";
   public final String IMAGEN_JUGADOR_ARRIBA="../res/arriba50.png";
   
   //public final String IMAGEN_VACIO ="../res/cielo.png";//
   public final String IMAGEN_VACIO ="../res/cielo50.png";
   public final String IMAGEN_RECO="../res/Reconpensa.png"; 
   public final String IMAGEN_ENEMIGO ="../res/enemigo.png";
   public final String IMAGEN_MURALLA ="../res/cieloe.png";
   
   public final String IMAGEN_MURALLAB1 ="../res/b1.png";
   public final String IMAGEN_MURALLAB2 ="../res/b3.png";
   public final String IMAGEN_MURALLAB3 ="../res/b2.png";
   public final String IMAGEN_MURALLAB4 ="../res/b4.png";
   
   /*ESTADOS*/
   public final Character MOVIENTO_DERECHA ='R';
   public final Character MOVIENTO_IZQUIERDA ='L';
   public final Character MOVIENTO_ARRIBA ='U';
   public final Character MOVIENTO_ABAJO ='D';
}
