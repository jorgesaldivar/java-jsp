package gato;
import java.util.Arrays;

public class Algoritmo {

    
    class NodoG{
        
        int mejorMovimiento;
        /*Nodos hijos.*/
        NodoG nodos[];
        /*Tablero del juego.*/
        public int tablero[];
        /*Turno de la computadora.*/
        boolean miTurno = false;
        /*Indice de la posicion.*/
        int indice;
        /*Ganador.*/
        int ganador = 0;

        NodoG(){
          tablero = new int[9];
               
        }
    }
    
    /*Raíz del árbol*/
    NodoG arbol = new NodoG();
    
    /*Atributos.*/
    int[] tablero;
    
    /*Mi ficha.*/
    public final int miFICHA = 2;
    
    /*Metodo que nos devuelve los espacios disponibles.*/
    public int movDisponibles( int[] tablero ){
        int mov = 0;
        
        for ( int i = 0; i < 9; i ++ )
            if ( tablero[i] == 0 )
                mov++;
        return mov;
    }
    
    /*Metodo que nos devuelve los indices del tablero de las posiciones vacías.*/
    public int[] posVacias( int[] tablero ){
        /*Creamos el vector con los índices.*/
        int[] indices = new int[movDisponibles(tablero)];
        int indice = 0;
        
        /*Recorremos y guardamos los indices.*/
        for ( int i = 0; i < 9; i ++ ){
            if ( tablero[i] == 0 ){
                indices[indice] = i;
                indice++;
            }
        }
        return indices;
    }
    
    /*Clase que recibe el tablero actual.*/
    public int movimiento( int[] tablero ){

        this.tablero = tablero;

        
        /*Copiamos el tablero a nuestro nodo raíz.*/
        for ( int i = 0; i < 9; i ++ )
            this.arbol.tablero[i] = this.tablero[i];
        
        /*Calculamos el mejor movimiento del árbol, desde las hojas hasta la raiz.*/
        movComputadora( arbol );
        
        /*Devolvemos el mejor movimiento.*/
        return arbol.mejorMovimiento;
    }

    /*Método recursivo, que genera los nodos con los movimientos.*/
    public void movComputadora( NodoG raiz ){

        /*Número de movimientos disponibles y sus indices en el tablero.*/
        int movimientos = movDisponibles(raiz.tablero);
        int indices[] = posVacias(raiz.tablero);
        int Max, Min;
        
        /*Inicializamos el nodo.*/
        raiz.nodos = new NodoG[movimientos];
        
        /*Verificamos si hay un ganador.*/
        int ganador = terminado(raiz.tablero);
        if ( ganador == 1 ) ganador = -1;
        else if ( ganador == 2 ) ganador = 1;
  
        if ( ganador!= 0 || movimientos == 0){
            raiz.ganador = ganador;
        }else{

            /*Creamos los datos de cada hijo.*/
            for( int i = 0; i < movimientos; i ++ ){
                
                /*Inicializamos los nodos hijos del árbol.*/
                raiz.nodos[i] = new NodoG();
                
                /*Les pasamos su tablero.*/
                for ( int j = 0; j < 9; j ++ )
                    raiz.nodos[i].tablero[j] = raiz.tablero[j];
                                
                /*Creamos los diferentes movimientos posibles.*/
                if ( raiz.miTurno )
                    raiz.nodos[i].tablero[indices[i]] = 1;
                else
                    raiz.nodos[i].tablero[indices[i]] = 2;
                
                /*Cambiamos el turno de los hijos*/
                raiz.nodos[i].miTurno = !raiz.miTurno;
                
                
                /*Guardamos el indice de su movimiento.*/
                raiz.nodos[i].indice = indices[i];
                    
                movComputadora(raiz.nodos[i]);
                                
            }

            /*Minimax*/
            if (!raiz.miTurno)
                raiz.ganador = Max(raiz);
            else
                raiz.ganador = Min(raiz);
            
       }    

    }
   
    /*Método que calcula el MÁXIMO de los nodos hijos de MIN*/
    public int Max( NodoG raiz ){
        int Max = -111;
        /*Máximo para la computadora, buscamos el valor donde gane.*/
        for (int i = 0; i < raiz.nodos.length; i++){
          /*Preguntamos por un nodo con un valor alto MAX*/
            if (raiz.nodos[i].ganador > Max){
                /*Lo asignamos y pasamos el mejor movimiento a la raíz.*/
                Max = raiz.nodos[i].ganador;
                raiz.mejorMovimiento = raiz.nodos[i].indice;

                /*Terminamos de buscar.*/
                if (Max == 1) break;
            }
         }
        
        /*Borramos los nodos.*/
        raiz.nodos = null;
        
        return Max;
    }
    
    /*Método que calcula el MÍNIMO de los nodos hijos de MAX.*/
    public int Min( NodoG raiz ){
        int Min = 111;
        /*Mínimo para el jugador*/
        for (int i = 0; i < raiz.nodos.length; i++)
          if (raiz.nodos[i].ganador < Min ){
            Min = raiz.nodos[i].ganador;
            raiz.mejorMovimiento = raiz.nodos[i].indice;

            if (Min == -1) break;
          }
        
        /*Borramos los nodos.*/
        raiz.nodos = null;
        
        return Min;
    }
                
    /*Método que dice si el juego está terminado.*/
    /*Regresa 0 si nadie gana, 1 si gana jugador 1, y 2 si gana la computadora*/
    public int terminado( int[] tablero ){
        /*Comprobamos si el juego terminó.*/
        /*Filas*/
        if ( tablero[0] == tablero[1] && tablero[0] == tablero[2] && tablero[0] != 0 )
            return tablero[0];
        else if ( tablero[3] == tablero[4] && tablero[3] == tablero[5]  && tablero[3] != 0  )
            return tablero[3];
        else if ( tablero[6] == tablero[7] && tablero[6]== tablero[8]  && tablero[6] != 0 )
            return tablero[6];
        /*Columnas*/
        else if( tablero[0] == tablero[3] && tablero[0] == tablero[6]  && tablero[0] != 0 )
            return tablero[0];
        else if ( tablero[1] == tablero[4] && tablero[1] == tablero[7]  && tablero[1] != 0  )
            return tablero[1];
        else if ( tablero[2] == tablero[5] && tablero[2] == tablero[8]  && tablero[2] != 0 )
            return tablero[2];
        /*Diagonales*/
        else if ( tablero[0] == tablero[4] && tablero[0] == tablero[8] && tablero[0] !=0 )
            return tablero[0];
        else if ( tablero[2] == tablero[4] && tablero[2] == tablero[6] && tablero[2] != 0 )
            return tablero[2];

        return 0;
        
    }
    

    /*Método que dice si el juego está terminado ó inconcluso.
      Si está terminado regresa el resultado.
    */
public String resultado( int[] tablero ){
     String result="";
     boolean incompleto=false;
     for (int i=0; i<9; i++){
        if (tablero[i]==0)
           incompleto=true;
}
int res=terminado(tablero);
if (res==0 && incompleto)
    res=-1;

switch (res) {
  case 0: 
    result="Empate";
    break;
  case 1: 
    result="Jugador";
    break;
  case 2: 
    result="Computadora";
    break;
  case -1: 
    result="Inconcluso";
    break;
}  
return result;     
}    


}
