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
    public ArrayList<Character> busquedaPorAnchura(int filaInicial,int columnaInicial,int filaObjetivo,int columnaObjetivo){//busqueda no infomada
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
                   // System.out.println(temporal.padre.toString());
                pasos.add(0,temporal.operacion);//en pasos esta la ruta correcta con el 0 funciona como pila 

                temporal = temporal.padre;
            }
            
                     for(Character c:this.pasos)
            {
                //System.out.println(c);
            }
        }
        return pasos;
    }
   
    public void moverDerecha(Estado temporal){
          if(temporal.columna+1 < CELDA_ANCHO_ESCENARIO && (escenario.obtenerCeldas()[temporal.fila][temporal.columna+1].obtenerTipo().equals(TIPO_VACIO) 
                  || escenario.obtenerCeldas()[temporal.fila][temporal.columna+1].obtenerTipo().equals(TIPO_JUGADOR)
                   || escenario.obtenerCeldas()[temporal.fila][temporal.columna+1].obtenerTipo().equals(TIPO_JUGADORI)
                   || escenario.obtenerCeldas()[temporal.fila][temporal.columna+1].obtenerTipo().equals(TIPO_JUGADORAB)
                   || escenario.obtenerCeldas()[temporal.fila][temporal.columna+1].obtenerTipo().equals(TIPO_JUGADORAR))){
             
                  Estado derecha = new Estado(temporal.fila,temporal.columna+1,temporal,MOVIENTO_DERECHA);
                  
                  if(!this.historial.contains(derecha)){
                      if(derecha.equals(this.estadoObjetivo)){
                          exito=true;
                          this.estadoObjetivo=derecha;
                      }else{
                          this.historial.add(derecha);
                          this.colaEstados.add(derecha);
                      }
                  }
              
          }
    }
    
    public void moverIzquierda(Estado temporal){
        if(temporal.columna-1 >=0 && (escenario.obtenerCeldas()[temporal.fila][temporal.columna-1].obtenerTipo().equals(TIPO_VACIO)
                || escenario.obtenerCeldas()[temporal.fila][temporal.columna-1].obtenerTipo().equals(TIPO_JUGADOR)
                 || escenario.obtenerCeldas()[temporal.fila][temporal.columna-1].obtenerTipo().equals(TIPO_JUGADORI)
                 || escenario.obtenerCeldas()[temporal.fila][temporal.columna-1].obtenerTipo().equals(TIPO_JUGADORAB)
                 || escenario.obtenerCeldas()[temporal.fila][temporal.columna-1].obtenerTipo().equals(TIPO_JUGADORAR) )){
              if(escenario.obtenerCeldas()[temporal.fila][temporal.columna-1].obtenerTipo().equals(TIPO_VACIO)){
                  Estado izquierda = new Estado(temporal.fila,temporal.columna-1,temporal,MOVIENTO_IZQUIERDA);
                  
                  if(!this.historial.contains(izquierda)){
                      if(izquierda.equals(this.estadoObjetivo)){
                          exito=true;
                          this.estadoObjetivo=izquierda;
                      }else{
                          this.historial.add(izquierda);
                          this.colaEstados.add(izquierda);
                      }
                  }
              }
          }
    }

    public void moverArriba(Estado temporal){
          if(temporal.fila-1 >=0 && (escenario.obtenerCeldas()[temporal.fila-1][temporal.columna].obtenerTipo().equals(TIPO_VACIO) 
                  || escenario.obtenerCeldas()[temporal.fila-1][temporal.columna].obtenerTipo().equals(TIPO_JUGADOR) 
                    || escenario.obtenerCeldas()[temporal.fila-1][temporal.columna].obtenerTipo().equals(TIPO_JUGADORI)
                    || escenario.obtenerCeldas()[temporal.fila-1][temporal.columna].obtenerTipo().equals(TIPO_JUGADORAB)
                    || escenario.obtenerCeldas()[temporal.fila-1][temporal.columna].obtenerTipo().equals(TIPO_JUGADORAR))){
              if(escenario.obtenerCeldas()[temporal.fila-1][temporal.columna].obtenerTipo().equals(TIPO_VACIO)){
                  Estado arriba = new Estado(temporal.fila-1,temporal.columna,temporal,MOVIENTO_ARRIBA);
                  
                  if(!this.historial.contains(arriba)){
                      if(arriba.equals(this.estadoObjetivo)){
                          exito=true;
                          this.estadoObjetivo=arriba;
                      }else{
                          this.historial.add(arriba);
                          this.colaEstados.add(arriba);
                      }
                  }
              }
          }
    }        

    public void moverAbajo(Estado temporal){
        if(temporal.fila+1 < CELDA_LARGO_ESCENARIO && (escenario.obtenerCeldas()[temporal.fila+1][temporal.columna].obtenerTipo().equals(TIPO_VACIO)
               || escenario.obtenerCeldas()[temporal.fila+1][temporal.columna].obtenerTipo().equals(TIPO_JUGADOR)
                || escenario.obtenerCeldas()[temporal.fila+1][temporal.columna].obtenerTipo().equals(TIPO_JUGADORI)
                || escenario.obtenerCeldas()[temporal.fila+1][temporal.columna].obtenerTipo().equals(TIPO_JUGADORAB)
                || escenario.obtenerCeldas()[temporal.fila+1][temporal.columna].obtenerTipo().equals(TIPO_JUGADORAR))){
              if(escenario.obtenerCeldas()[temporal.fila+1][temporal.columna].obtenerTipo().equals(TIPO_VACIO)){
                  Estado abajo = new Estado(temporal.fila+1,temporal.columna,temporal,MOVIENTO_ABAJO);
                  
                  if(!this.historial.contains(abajo)){
                      if(abajo.equals(this.estadoObjetivo)){
                          exito=true;
                          this.estadoObjetivo=abajo;
                      }else{
                          this.historial.add(abajo);
                          this.colaEstados.add(abajo);
                      }
                  }
              }
          }   
    }
    

    
    
}
