package proyectoia;

import java.awt.Font;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tiempo extends JPanel implements Runnable {
    public Integer tiempoRestante =30;
    public Integer tiempoTotal=0;
    public JLabel labelTiempoRestante;
    public JLabel labelTiempoTotal;
    boolean corriendo;
    Thread hilo;
    
    public Tiempo()
    {
        this.add(new JLabel ("Tiempo Restante",JLabel.CENTER));
        this.labelTiempoRestante = new JLabel(tiempoRestante.toString(),JLabel.CENTER);
        //labelTiempoRestante.setFont(new Font(labelTiempoRestante.getFont().getName(),Font.PLAIN));
        this.labelTiempoTotal = new JLabel(tiempoTotal.toString(),JLabel.CENTER);
        this.add(labelTiempoRestante);
        this.add(new JLabel("segundos:", JLabel.CENTER));
        this.add(new JLabel("Tiempo Total:",JLabel.CENTER));
        this.add(labelTiempoTotal);
        this.add(new JLabel("Segundos", JLabel.CENTER));
        
        this.hilo = new Thread(this);
        this.start();
    }

    public synchronized void start(){
        corriendo = true;
        hilo.start();
    }
    
    public synchronized void stop(){
        corriendo = false;
        try {
            hilo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.labelTiempoRestante.setText(tiempoRestante.toString());
        this.labelTiempoTotal.setText(tiempoTotal.toString());
    }
    
    @Override
    public void run() {

        long ultimaVez = System.currentTimeMillis();
        int tiempoEspera = 1500;//1000 ms son 1 segundo
        double delta = 0.0;
        
        while(corriendo){//corriendo = a decir corriendo == true
            long ahora = System.currentTimeMillis();
            delta = delta + (ahora - ultimaVez);//se resta la ultima medicion
            ultimaVez = ahora;
            
            if(delta >=tiempoEspera){
              
                   this. tiempoTotal=tiempoTotal+1;
                    this.tiempoRestante=tiempoRestante-1;
                    repaint();
                    
                    if(tiempoRestante <=0){
                        stop();
                    }
                delta=0.0;           
            }
        }    
    }
    
    public void sumarTiempo(int tiempo){
        this.tiempoRestante= tiempoRestante+tiempo;
    }
    
}
