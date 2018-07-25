package proyectoia;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame implements Constantes{
    public Tiempo t;
    public VentanaPrincipal(){/*constructor*/
        super(TITULO);
        this.setSize(ANCHO_VENTANA +20, LARGO_VENTANA +50 );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        t= new Tiempo();//panel del tiempo
        
        Lienzo Mapa=new Lienzo(t);/*objeto de tipo lienzo en pantalla*/
        Container Contenedor = this.getContentPane(); /*creo objeto de tipo contenedor*/
        setLayout(new BorderLayout());
      
        Contenedor.add(t,BorderLayout.SOUTH);
        Contenedor.add(Mapa, BorderLayout.CENTER);/*mapa es un objeto de tipo lienzo*/
        
        t.setPreferredSize(new Dimension(ANCHO_VENTANA,30));
        //t.setPreferredSize(new Dimension(120,ALTO_VENTANA)); PONES EAST
    }
}
