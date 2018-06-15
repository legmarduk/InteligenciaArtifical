package proyectoia;

import java.awt.Container;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame implements Constantes{
    
    public VentanaPrincipal(){/*constructor*/
        super(TITULO);
        this.setSize(ANCHO_VENTANA +20, LARGO_VENTANA +50 );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Lienzo Mapa=new Lienzo();/*objeto de tipo lienzo en pantalla*/
        
        Container Contenedor = this.getContentPane(); /*creo objeto de tipo contenedor*/
        
        Contenedor.add(Mapa);/*mapa es un objeto de tipo lienzo*/
       
    }
    
}
