/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listasunificadascode;

/**
 *
 * @author camil
 */
public class ListaCircular {

    private Nodo primero;
    private Nodo ultimo;

    public ListaCircular() {
        this.primero = null;
        this.ultimo = null;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public void insertaOrdenado(int valor) {
        // Caso 1: La lisa está vacía.
        if (this.getPrimero() == null) { // Significa que la lista vacía.
            // Paso 1.1 Crear la cajita.   
            // Paso 1.2 inicializo el primero.
            primero = new Nodo(valor);
            // Paso 1.3 iniciar el último.
            ultimo = primero;
            // Paso 1.4 La hago circular.
            ultimo.setSiguiente(primero);
        } else {
            // Caso 2: El elemento a insertar es menor al primero. Lo inserto a la izquierda de la lista.
            if (valor <= primero.getDato()) {
                // Paso 2.1 Creamos la cajita.
                Nodo aux = new Nodo(valor);
                // Paso 2.2 Amarramos la cajita al primero.
                aux.setSiguiente(primero);
                // Paso 2.3 Mover el primero.
                primero = aux;
                // Paso 2.4 Ligar el último al nuevo primero.
                ultimo.setSiguiente(primero);
            } else {
                // Caso 3: El elemento a insertar es mayor al último.
                if (ultimo.getDato() < valor) {
                    // Paso 3.1 Creamos la cajita
                    Nodo aux = new Nodo(valor);
                    // Paso 3.2 Amarramos la cajita al último.
                    ultimo.setSiguiente(aux);
                    // Paso 3.3 Mover el último..
                    ultimo = aux;
                    // Paos 3.4 Ligar el nuevo último al primero.
                    ultimo.setSiguiente(primero);
                } else {
                    // Caso 4: El elemento a insertar va en una posición interna de la lista.
                    // Vamos a iterar la lista para encontrar el lugar donde se inserta.
                    Nodo aux = primero;
                    while (aux.getSiguiente().getDato() < valor) {
                        aux = aux.getSiguiente();
                    }
                    // Paso 4.1 crear la cajita.
                    Nodo temp = new Nodo(valor);
                    // Paso 4.2 Amarrar la neuva caja al resto de la lista.
                    temp.setSiguiente(aux.getSiguiente());
                    // Paso 4.3 Amarro el auxiliar al nuevo sgte.
                    aux.setSiguiente(temp);
                }
            }
        }
    }
}

