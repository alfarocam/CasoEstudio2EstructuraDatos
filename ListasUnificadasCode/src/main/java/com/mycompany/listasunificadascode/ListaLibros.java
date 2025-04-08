/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listasunificadascode;

/**
 *
 * @author CamilaAlfaro
 */
public class ListaLibros extends ListaEnlazada {

    public void insertarLibro(Libro libro) {
        NodoLibro nuevo = new NodoLibro(libro);
        if (getPrimero() == null) {
            setPrimero(nuevo);
        } else {
            Nodo actual = getPrimero();
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }

    public boolean eliminarLibro(int idLibro) {
        return eliminarNodoRetorno(idLibro);
    }

    public int cantidadLibros() {
        int cantidad = 0;
        Nodo actual = getPrimero();
        while (actual != null) {
            cantidad++;
            actual = actual.getSiguiente();
        }
        return cantidad;
    }

    public Libro buscarLibro(int idLibro) {
        Nodo actual = getPrimero();
        while (actual != null) {
            if (actual.getDato() == idLibro) {
                return ((NodoLibro) actual).getLibro();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public Libro[] toArray() {
        int cantidad = cantidadLibros();
        Libro[] libros = new Libro[cantidad];
        Nodo actual = getPrimero();
        int i = 0;

        while (actual != null) {
            NodoLibro nodoLibro = (NodoLibro) actual;
            libros[i] = nodoLibro.getLibro();
            actual = actual.getSiguiente();
            i++;
        }

        return libros;
    }
}
