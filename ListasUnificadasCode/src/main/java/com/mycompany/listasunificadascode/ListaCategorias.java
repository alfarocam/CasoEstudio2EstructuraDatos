/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listasunificadascode;

/**
 *
 * @author CamilaAlfaro
 */
public class ListaCategorias extends ListaDobleCircular {

    public void insertarCategoria(Categoria categoria) {
        NodoCategoria nuevo = new NodoCategoria(categoria);

        if (getCabeza() == null) {
            setCabeza(nuevo);
            setUltimo(nuevo);
            nuevo.setSiguiente(nuevo);
            nuevo.setAnterior(nuevo);
        } else {
            NodoDoble aux = getCabeza();
            boolean insertado = false;
            do {
                if (aux.getDato() == categoria.getIdCategoria()) {
                    return;
                }
                aux = aux.getSiguiente();
            } while (aux != getCabeza());
            getUltimo().setSiguiente(nuevo);
            nuevo.setAnterior(getUltimo());
            nuevo.setSiguiente(getCabeza());
            getCabeza().setAnterior(nuevo);
            setUltimo(nuevo);
        }
    }

    public NodoCategoria buscarCategoria(int idCategoria) {
        if (getCabeza() == null) {
            return null;
        }
        NodoDoble actual = getCabeza();
        do {
            if (actual.getDato() == idCategoria) {
                return (NodoCategoria) actual;
            }
            actual = actual.getSiguiente();
        } while (actual != getCabeza());
        return null;
    }

    public boolean insertarLibroEnCategoria(int idCategoria, Libro libro) {
        NodoCategoria nodoCategoria = buscarCategoria(idCategoria);
        if (nodoCategoria != null) {
            nodoCategoria.getListaLibros().insertarLibro(libro);
            return true;
        }
        return false;
    }

    public String getLibrosEditorial(String editorial) {
        String resultado = "Los libros de la editorial " + editorial + " son: ";

        if (getCabeza() == null) {
            return resultado + "Ninguno";
        }
        boolean encontrado = false;
        NodoDoble actualCategoria = getCabeza();

        do {
            NodoCategoria nodoCategoria = (NodoCategoria) actualCategoria;
            ListaLibros listaLibros = nodoCategoria.getListaLibros();
            Nodo actualLibro = listaLibros.getPrimero();

            while (actualLibro != null) {
                NodoLibro nodoLibro = (NodoLibro) actualLibro;
                Libro libro = nodoLibro.getLibro();

                if (libro.getEditorial().equals(editorial)) {
                    if (encontrado) {
                        resultado += ", ";
                    }
                    resultado += libro.getTitulo();
                    encontrado = true;
                }

                actualLibro = actualLibro.getSiguiente();
            }

            actualCategoria = actualCategoria.getSiguiente();
        } while (actualCategoria != getCabeza());

        if (!encontrado) {
            resultado += "Ninguno";
        }

        return resultado;
    }

    public Libro[] devuelveLibrosCategoria(int idCategoria) {
        NodoCategoria nodoCategoria = buscarCategoria(idCategoria);
        if (nodoCategoria != null) {
            return nodoCategoria.getListaLibros().toArray();
        }
        return new Libro[0];
    }

    public String imprimaCategorias() {
        if (getCabeza() == null) {
            return "No hay categorias";
        }
        String resultado = "";
        NodoDoble actual = getCabeza();

        do {
            NodoCategoria nodoCategoria = (NodoCategoria) actual;
            resultado += "Categoria " + nodoCategoria.getCategoria().getNombre()
                    + " tiene " + nodoCategoria.getListaLibros().cantidadLibros() + " libros\n";
            actual = actual.getSiguiente();
        } while (actual != getCabeza());

        return resultado;
    }

    public boolean eliminaLibroCategoria(int idCategoria, int idLibro) {
        NodoCategoria nodoCategoria = buscarCategoria(idCategoria);
        if (nodoCategoria != null) {
            return nodoCategoria.getListaLibros().eliminarLibro(idLibro);
        }
        return false;
    }
}
