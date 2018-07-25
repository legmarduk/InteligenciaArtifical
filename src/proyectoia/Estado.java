/*estados y movientos en el escenario*/
/*neccesita una posicion FILA,COLUMNA , operaciones para llegar (arriba, abajo, derecha, izquierda)*/
/*tener la informacion de nodo padre */
package proyectoia;

public class Estado {
    public int fila,columna;
    public Character operacion;
    public Estado padre;
    
   public Estado(int fila, int columna,Estado padre, Character operacion){
       this.fila = fila;
       this.columna = columna;
       this.operacion = operacion;
       this.padre = padre;
   }
   
   public Estado getPadre(){
       
       return this.padre;//retorna el predecesor
   }
   
   public Character operacion(){
       return this.operacion;
   }
   
    @Override
   public boolean equals(Object x){
       Estado e = (Estado)x; // obtengo un estado de el objeto x
       return this.fila == e.fila && this.columna == e.columna;//si la posicion actual es igua al objeto returna
       //retorna true   
   }
   
/*se genera al crear hash en   funcion equals*/
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.fila;
        hash = 37 * hash + this.columna;
        return hash;
    }
   
    @Override
   public String toString(){
       return "("+this.fila+","+this.columna+")"; // retorna posicion
   } 
   
   
   
   
}
