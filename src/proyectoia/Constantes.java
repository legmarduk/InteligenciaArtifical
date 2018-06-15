package proyectoia;

//import javafx.scene.paint.Color;
import java.awt.*;

public interface Constantes {
    
    public final String TITULO ="Proyecto IA ";
    //public final int ANCHO_VENTANA =700;/*ANCHO ventana*/
    //public final int LARGO_VENTANA =700;/*LARGO ventana*/
    
    public final int CELDA_ANCHO_ESCENARIO = 19;
    public final int CELDA_LARGO_ESCENARIO = 12;
    
    public final int TAMAÑO_CELDA= 50;
   
    
   public final int ANCHO_VENTANA =(CELDA_ANCHO_ESCENARIO *TAMAÑO_CELDA)+10;/*ANCHO ventana*/
   
   public final int LARGO_VENTANA =(CELDA_LARGO_ESCENARIO *TAMAÑO_CELDA)+10;/*LARGO ventana*/
    
   
   
   /*faltan paredes  recompenza*/
   public final String TIPO_VACIO ="V";
   public final String TIPO_JUGADOR ="J";
   public final String TIPO_ENEMIGO ="E";
   public final String TIPO_MURALLA ="M";
   public final String TIPO_RECOMPENSA="R";
  /*intento bismarck*/
  /* public final String TIPO_ENEMIGOBM="EB";*/
   
   /*por ahora cambiar por imagenes*/
   public final Color COLOR_VACIO = Color.BLUE;
   public final Color COLOR_JUGADOR = Color.WHITE;
   public final Color COLOR_ENEMIGO = Color.RED;
   public final Color COLOR_MURALLA = Color.GRAY;
   public final Color COLOR_RECOMPENSA=Color.GREEN;
   
   /*referencia a la imagen (ruta)*/
   public final String IMAGEN_JUGADOR_DERECHA ="../res/jugadorDerecha.png";
   public final String IMAGEN_VACIO ="../res/cielo.png";
   public final String IMAGEN_RECO="../res/Reconpensa.png"; 
   public final String IMAGEN_MURALLA ="../res/murallaB1.png";
   public final String IMAGEN_ENEMIGO ="../res/enemigo.png";
   
   /*
   public final String IMAGEN_ENEMIGOBISMARK1="../res/bismarck1.png";
   public final String IMAGEN_ENEMIGOBISMARK2="../res/bismarck2.png";
   public final String IMAGEN_ENEMIGOBISMARK3="../res/bismarck3.png";*/
}
