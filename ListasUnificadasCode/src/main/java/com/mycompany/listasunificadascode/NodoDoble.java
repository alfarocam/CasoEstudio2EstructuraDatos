/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listasunificadascode;

/**
 *
 * @author CamilaAlfaro
 */
public class NodoDoble {
    private int dato;
    private NodoDoble siguiente;
    private NodoDoble anterior;

    public NodoDoble(int dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public int getDato() {
        return dato;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }
    
    
    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
    
    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
    
}
