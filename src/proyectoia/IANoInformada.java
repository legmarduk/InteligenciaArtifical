/*maneja info de escenario, de estados inicial y final, historial de estados generado(para no repetir pasos)*/
/*listado solucion, saber si la busqueda funciono (booleano)*/
package proyectoia;
import java.util.ArrayList;

public class IANoInformada implements Constantes { //dice IAN la clase culia
    
    public Escenario escenario;
    public Estado estadoInical;
    public Estado estadoObjetivo;
    public ArrayList<Estado> historial;
    public ArrayList<Estado> colaEstados; //lista de estados por recorrer
    public ArrayList<Character> pasos; //movimientos
    public boolean exito;//si la busqueda es exitosa es true
    
    public IANoInformada(Escenario escenario){
        this.escenario = escenario;
        //guardo memoria para las listas al usar
        this.historial= new ArrayList<>();
        this.colaEstados=new ArrayList<>();
        this.pasos =new ArrayList<>();
    }
                                    //enemigo                         //jugador
    public void busquedaPorAnchura(int filaInicial,int columnaInicial,int filaObjetivo,int columnaObjetivo){//busqueda no infomada
        this.exito=false;
        this.estadoInical= new Estado(filaInicial, columnaInicial, null, 'x');
        this.estadoObjetivo = new Estado(filaObjetivo, columnaObjetivo, null, 'x');//x es un estado que no tengo un posicion random
        /*limpio las listas*/
        this.historial.clear();
        this.colaEstados.clear();
        this.pasos.clear();
        
        if(this.estadoInical.equals(this.estadoObjetivo)){//si las posiciones son iguales
            this.exito=true;
        }
        /*añado el estado inical a los arrays*/
        this.colaEstados.add(estadoInical);//movientos por verificar
        this.historial.add(estadoInical);
        
        while(! this.colaEstados.isEmpty() && !this.exito){//=>si la cola de estado no esta vacia o llego al exito
            
            Estado temporal =this.colaEstados.get(0);//traigo el elemnto y lo pongo en estado temporal
            this.colaEstados.remove(0);// saco el elemento de estos por recorrer
            
            moverDerecha(temporal);
            moverIzquierda(temporal);
            moverArriba(temporal);
            moverAbajo(temporal);
           
        }   
        //si exito recuperar la ruta => obtener todos los padres
        if(exito){
            
            Estado temporal=this.estadoObjetivo;
            while(temporal.padre != null){
                System.out.print(temporal.toString());
                temporal = temporal.padre;
            }
            
        }
    }
   
    public void moverDerecha(Estado temporal){
        if(temporal.columna+1 < CELDA_ANCHO_ESCENARIO){
            if(escenario.c[temporal.fila][temporal.columna+1].obtenerTipo()!=TIPO_MURALLA &&
               escenario.c[temporal.fila][temporal.columna+1].obtenerTipo()!=TIPO_MURALLABISUNO &&
               escenario.c[temporal.fila][temporal.columna+1].obtenerTipo()!=TIPO_MURALLABISDOS &&
               escenario.c[temporal.fila][temporal.columna+1].obtenerTipo()!=TIPO_MURALLABISTRES &&
               escenario.c[temporal.fila][temporal.columna+1].obtenerTipo()!=TIPO_MURALLABISCUATRO &&
               escenario.c[temporal.fila][temporal.columna+1].obtenerTipo()!=TIPO_RECOMPENSA /*&&
               escenario.c[temporal.fila][temporal.columna+1].obtenerTipo()!=TIPO_JUGADOR*/)
            {
                Estado derecha =new Estado(temporal.fila,temporal.columna+1,temporal,MOVIENTO_DERECHA);
                if(!this.historial.contains(derecha))//si en histoail no esta derecha funciona
                {
                    this.colaEstados.add(derecha);//agrego derecha a cola de estados
                    if(derecha.equals(this.estadoObjetivo)){
                        exito=true; //llegue a mi objetivo
                        this.estadoObjetivo=derecha;
                    }else{
                        this.colaEstados.add(derecha);
                    }
                   
                }
            }
        }       
    }
    
    public void moverIzquierda(Estado temporal){
        if(temporal.columna-1 >= 0){
            if(escenario.c[temporal.fila][temporal.columna-1].obtenerTipo()!=TIPO_MURALLA &&
               escenario.c[temporal.fila][temporal.columna-1].obtenerTipo()!=TIPO_MURALLABISUNO &&
               escenario.c[temporal.fila][temporal.columna-1].obtenerTipo()!=TIPO_MURALLABISDOS &&
               escenario.c[temporal.fila][temporal.columna-1].obtenerTipo()!=TIPO_MURALLABISTRES &&
               escenario.c[temporal.fila][temporal.columna-1].obtenerTipo()!=TIPO_MURALLABISCUATRO &&
               escenario.c[temporal.fila][temporal.columna-1].obtenerTipo()!=TIPO_RECOMPENSA /*&&
               escenario.c[temporal.fila][temporal.columna-1].obtenerTipo()!=TIPO_JUGADOR*/)
            {
                Estado izquierda =new Estado(temporal.fila,temporal.columna-1,temporal,MOVIENTO_IZQUIERDA);
                if(!this.historial.contains(izquierda))//si en histoail no esta derecha funciona
                {
                    this.colaEstados.add(izquierda);//agrego derecha a cola de estados
                    if(izquierda.equals(this.estadoObjetivo)){
                        exito=true; //llegue a mi objetivo
                        this.estadoObjetivo=izquierda;
                        
                    } else{
                        this.colaEstados.add(izquierda);
                    }
                   
                }
            }
        }       
    }

    public void moverArriba(Estado temporal){
        if(temporal.fila-1 >= 0){
            if(escenario.c[temporal.fila-1][temporal.columna].obtenerTipo()!=TIPO_MURALLA &&
               escenario.c[temporal.fila-1][temporal.columna].obtenerTipo()!=TIPO_MURALLABISUNO &&
               escenario.c[temporal.fila-1][temporal.columna].obtenerTipo()!=TIPO_MURALLABISDOS &&
               escenario.c[temporal.fila-1][temporal.columna].obtenerTipo()!=TIPO_MURALLABISTRES &&
               escenario.c[temporal.fila-1][temporal.columna].obtenerTipo()!=TIPO_MURALLABISCUATRO &&
               escenario.c[temporal.fila-1][temporal.columna].obtenerTipo()!=TIPO_RECOMPENSA /*&&
               escenario.c[temporal.fila-1][temporal.columna].obtenerTipo()!=TIPO_JUGADOR*/)
            {
                Estado arriba =new Estado(temporal.fila-1,temporal.columna,temporal,MOVIENTO_ARRIBA);
                if(!this.historial.contains(arriba))//si en histoail no esta derecha funciona
                {
                    this.colaEstados.add(arriba);//agrego derecha a cola de estados
                    if(arriba.equals(this.estadoObjetivo)){
                        exito=true; //llegue a mi objetivo
                        this.estadoObjetivo=arriba;
                    } else{
                        this.colaEstados.add(arriba);
                    }
                   
                }
            }
        }       
    }        

    public void moverAbajo(Estado temporal){
        if(temporal.fila+1 > CELDA_LARGO_ESCENARIO){
            if(escenario.c[temporal.fila+1][temporal.columna].obtenerTipo()!=TIPO_MURALLA &&
               escenario.c[temporal.fila+1][temporal.columna].obtenerTipo()!=TIPO_MURALLABISUNO &&
               escenario.c[temporal.fila+1][temporal.columna].obtenerTipo()!=TIPO_MURALLABISDOS &&
               escenario.c[temporal.fila+1][temporal.columna].obtenerTipo()!=TIPO_MURALLABISTRES &&
               escenario.c[temporal.fila+1][temporal.columna].obtenerTipo()!=TIPO_MURALLABISCUATRO &&
               escenario.c[temporal.fila+1][temporal.columna].obtenerTipo()!=TIPO_RECOMPENSA /*&&
               escenario.c[temporal.fila+1][temporal.columna].obtenerTipo()!=TIPO_JUGADOR*/)
            {
                Estado abajo =new Estado(temporal.fila+1,temporal.columna,temporal,MOVIENTO_ABAJO);
                if(!this.historial.contains(abajo))//si en histoail no esta derecha funciona
                {
                    this.colaEstados.add(abajo);//agrego derecha a cola de estados
                    if(abajo.equals(this.estadoObjetivo)){
                        exito=true; //llegue a mi objetivo
                        this.estadoObjetivo=abajo;
                    } else{
                        this.colaEstados.add(abajo);
                    }
                   
                }
            }
        }       
    }
    
    
}
