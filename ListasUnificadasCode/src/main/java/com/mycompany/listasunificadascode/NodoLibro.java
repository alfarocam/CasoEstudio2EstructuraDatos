/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listasunificadascode;

/**
 *
 * @author CamilaAlfaro
 */
public class NodoLibro extends Nodo{
    private Libro libro;

    public NodoLibro(Libro libro) {
        // como se hizo herencia aqui tambien se pasa el id del libro como dato al constructor de la clase nodo
        super(libro.getIdLibro()); 
        this.libro = libro;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
        setDato(libro.getIdLibro()); 
    }
    
    @Override
    public NodoLibro getSiguiente() {
        return (NodoLibro) super.getSiguiente();
    }
    
    @Override
    public void setSiguiente(Nodo siguiente) {
        super.setSiguiente(siguiente);
    }
}

