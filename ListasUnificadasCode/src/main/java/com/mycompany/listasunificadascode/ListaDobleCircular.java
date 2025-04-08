/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listasunificadascode;

/**
 *
 * @author CamilaAlfaro
 */
public class ListaDobleCircular {

    private NodoDoble cabeza;
    private NodoDoble ultimo;

    public ListaDobleCircular() {
    }

    public ListaDobleCircular(NodoDoble cabeza, NodoDoble ultimo) {
        this.cabeza = cabeza;
        this.ultimo = ultimo;
    }

    public void setCabeza(NodoDoble cabeza) {
        this.cabeza = cabeza;
    }

    public void setUltimo(NodoDoble ultimo) {
        this.ultimo = ultimo;
    }

    public NodoDoble getCabeza() {
        return cabeza;
    }

    public NodoDoble getUltimo() {
        return ultimo;
    }

    public void insertar(int valor) {
        if (cabeza == null) {        // CASO 1: La lista está vacía
            NodoDoble temp = new NodoDoble(valor); // Paso 1: Crea la cajita.
            cabeza = temp;                // Paso 2: Apuntar la cabeza a la cajita recien creada.
            ultimo = cabeza;              // Paso 3: Apuntar el último a la cajita recien creada.
            ultimo.setSiguiente(cabeza);  // Paso 4: Apunta el sgte del último a la cabeza. 
            cabeza.setAnterior(ultimo);    // Paso 5: Apunta el anterior de la cabeza al último
        } else if (valor < cabeza.getDato()) {  // CASO 2: Cuando quiero insertar un elemento menor.
            NodoDoble temp = new NodoDoble(valor);    // Paso 1:Crear la cajota
            temp.setSiguiente(cabeza);        // Paso 2: Poner la nueva cajita de primero amarrada a la cabeza.
            cabeza.setAnterior(temp);// Paso 3: Poner el anterior de la cabeza amarrado a la nueva cajita.
            cabeza = temp; // Paso 4: Mover la cabeza al nuevo elemento para que ya no quede de segunda.
            // Ahora hagámoslo circular de nuevo.
            cabeza.setAnterior(ultimo);    //Paso 5: Amarra la cabeza al último. (La hacen circular)
            ultimo.setSiguiente(cabeza);  // paso 6: Amarra el último a la nueva cabeza. (La hacen circular)  
        } else if (valor >= ultimo.getDato()) { // CASO 3: Cuando quiero insertar un elemento mayor o igual al último
            NodoDoble temp = new NodoDoble(valor); // Paso 1: Crear la cajita.
            ultimo.setSiguiente(temp);     // Paso 2: Poner el sgte del ultimo apuntando a la nueva cajita.
            temp.setAnterior(ultimo);       // Paso 3: Poner el anterior de la nueva cajita apuntando al último
            ultimo = temp;                 // Paso 4: Mover el último a la nueva cajita.
            // Ahora hagámoslo circular de nuevo.
            ultimo.setSiguiente(cabeza);// Paso 5: Hacerla Circular desde el último a la cabeza.
            cabeza.setAnterior(ultimo);// Paso 6: Hacerla Circular desde la cabeza al último.
        } else {     // CASO 4: Insertar en el medio.
            NodoDoble aux = cabeza;      // Creo un nodo aux y lo apunto a la cabaza
            while (aux.getSiguiente().getDato() < valor) {  // recorrer para encotnrar un lugar
                aux = aux.getSiguiente();
            }
            NodoDoble temp = new NodoDoble(valor);   //Paso 1: Crear la cajita.
            temp.setSiguiente(aux.getSiguiente());  //Paso 2: Amarrar la nueva cajita al sgte de la lista.
            temp.setAnterior(aux);                    // Paso 3: Amarro la nueva cajita para atrás.

            aux.setSiguiente(temp);             // Paso 4: Amarramos el aux a la nueva cajita.
            temp.getSiguiente().setAnterior(temp);     // Paso 5: Amarrar la caja sgte para atrás a la nueva cajita.
        }

    }

}
