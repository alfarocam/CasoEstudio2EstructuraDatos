/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listasunificadascode;

/**
 *
 * @author camil
 */
public class ListaDoble {
    private NodoDoble primero;

    public ListaDoble() {
        primero = null;
    }

    public NodoDoble getPrimero() {
        return primero;
    }

    public void setPrimero(NodoDoble primero) {
        this.primero = primero;
    }
    
    public void insertaOrdenado (int valor){
        // Caso 1: La lista está vacía.
        if (primero == null){
            // Paso 1.1 Creo la cajita.
            NodoDoble aux = new NodoDoble(valor);
            primero = aux;
            primero.setSiguiente(aux);
            primero.setAnterior(aux);
        }else 
        // Caso 2: El elemento a insertar es menor al primero.
        if (valor < primero.getDato()){
            // Paso 2.1 creo la cajita
            NodoDoble aux = new NodoDoble(valor);
            // Paso 2.2 Amarro la nueva cajita al resto de la lsita.
            aux.setSiguiente(primero);
            // Paso 2.3 Amarro la anterior primero para atrás.
            primero.setAnterior(aux);
            // Paso 2.4 Muevo el primero (que actualmente es segundo) al nuevo primero.
            primero = aux;
        }else{
        // Caso 3: Inserta en el medio o al final.
            NodoDoble  aux = primero;  // Se crea un nodo aux y se iguala al primero.
            while (aux.getSiguiente().getDato() < valor){
                aux = aux.getSiguiente();
            }
            // Paso 3.1 Creo la cahita
            NodoDoble temp = new NodoDoble(valor);      
            // Paso 3.2 Amarro el sgte de la cajita al que está después del auxiliar.
            temp.setSiguiente(aux.getSiguiente());
            // Paso 3.3. Amarro el anterior de la nueva cajita al aux
            temp.setAnterior(aux);
            // Paso 3.4 Amarro el auxiliar a la nueva cajita para que la lsita quede enlazada.
            aux.setSiguiente(temp);
            // Paso 3.5 Amarró el sgte de la nueva cajita, hacia atrás a la nueva cajita.
            temp.getSiguiente().setAnterior(temp);
            
            
        }
    }
}
