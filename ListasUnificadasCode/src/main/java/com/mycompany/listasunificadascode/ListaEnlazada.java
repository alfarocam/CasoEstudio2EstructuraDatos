/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listasunificadascode;

/**
 *
 * @author CamilaAlfaro
 */
public class ListaEnlazada {
        private Nodo primero;

    public ListaEnlazada() {
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }
    
    public void insertaOrdenado(int valor){
        Nodo nuevo = new Nodo(valor);   // Paso 1: Crer la cajita (Nodo).
        // Caso 1: Insertar en una lista vacía.
        if (this.getPrimero() == null){     // Significa que la lista está vacía.
            this.setPrimero(nuevo);    // Inicializo el primer elemento con la nueva cajita.
        }else if (this.getPrimero().getDato() <= valor) {  // Caso 2: Insertar antes del primero de la lista.
            nuevo.setSiguiente(primero);    // Amarrar la nueva caja al resto de la lista.
            this.setPrimero(nuevo);           // Mover el primero al nuevo primero.  
        }else{      // Caso 3: Insertar en cualquier lugar de la lista.
            // La manera de encontrar una posición dentro de la lista es recorriendola.
            Nodo aux = this.getPrimero();   // Creamos un puntero auxiliar y lo igualamos al primero.
            
            // Este ciclo me permite buscar la posición correcta dentro de la lista 
            //y quedarme la posición anterior a esta.
            while (aux.getSiguiente()!= null &&
                   aux.getSiguiente().getDato() < valor){
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());  // Amarro la neuva caja al resto de la lista,
            aux.setSiguiente(nuevo);  // Amarro lo que esta antes de la lista a la nueva caja, ya amarrada.
        
        }
    }
        public void eliminarNodo(int valor){
            Nodo actual = primero;   // Creo un auxiliar temporal y lo igualo al primero.
            Nodo anterior = null;    // Inicializo el anterior al primero en null.
            
            // Recorra la lista hasta encontrar el elemento que quiero eliminar.
            while (actual != null && actual.getDato() != valor){    // Mientras no hayamos llegado al final y no hayamos
                                                                    //encontrado el elemento
                anterior = actual;
                actual = actual.getSiguiente();
            }
            if (actual == null){ // Significa que no encontré el elemento a eliminar.
                return;
            } 
            if (anterior == null){  // Significa que voy a eliminar la cabeza
                this.setPrimero(actual.getSiguiente());
            }else{
                anterior.setSiguiente(actual.getSiguiente());
            }
        }
        
        
        public boolean eliminarNodoRetorno(int valor){
            Nodo actual = primero;   // Creo un auxiliar temporal y lo igualo al primero.
            Nodo anterior = null;    // Inicializo el anterior al primero en null.
            boolean valorEliminado = false;
            // Recorra la lista hasta encontrar el elemento que quiero eliminar.
            while (actual != null && actual.getDato() != valor){    // Mientras no hayamos llegado al final y no hayamos encontrado el elemento
                anterior = actual;
                actual = actual.getSiguiente();
            }
            if (actual == null){ // Significa que no encontré el elemento a eliminar.
                return valorEliminado;
            } 
            if (anterior == null){  // Significa que voy a eliminar la cabeza
                valorEliminado = true;
                this.setPrimero(actual.getSiguiente());
            }else{
                valorEliminado = true;
                anterior.setSiguiente(actual.getSiguiente());
            }
            return valorEliminado;
        }
        
  public boolean buscar (int valor){
      Nodo actual = primero;    // Creo un puntero auxiliar y lo inicializa igual al primero.
      while ( actual != null){  // Mientras actual NO sea null. Tenemos elementos en la lista.
          if (actual.getDato() == valor){
              return true;          // Significa que encontré el elemento que estoy buscando, por lo tanto retorno TRUE.
          }
          actual = actual.getSiguiente(); // Muevo el puntero auxiliar (actual) al sgte de la lista.
      }
      
      return false;     // Retorna false porque llegó al final de la lista y nunca encontró el elemento que andaba buscando.
  }  
  
  public void recorrer (){
      Nodo actual = primero;    // Creo un puntero auxiliar y lo inicializa igual al primero.
      while ( actual != null){  // Mientras actual NO sea null. Tenemos elementos en la lista.
          System.out.print(actual.getDato() + " - ");
          actual = actual.getSiguiente(); // Muevo el puntero auxiliar (actual) al sgte de la lista.
      }
  }  

  
}

