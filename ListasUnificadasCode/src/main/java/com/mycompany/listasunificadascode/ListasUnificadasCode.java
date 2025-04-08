/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.listasunificadascode;

/**
 *
 * @author CamilaAlfaro
 */
public class ListasUnificadasCode {

    public static void main(String[] args) {
        System.out.println("Camila Alfaro Rivera - CASO DE ESTUDIO #2");
        System.out.println("Sistema de Catalogo de Biblioteca");
        System.out.println();
        
        ListaCategorias listaCategorias = new ListaCategorias();
        
        // categorias de libros
        Categoria accion = new Categoria(1, "Accion");
        Categoria romance = new Categoria(2, "Romance");
        Categoria novela = new Categoria(3, "novela");
        Categoria ciencia = new Categoria(4, "ciencia");
        Categoria misterio = new Categoria(5, "misterio");
        
        listaCategorias.insertarCategoria(accion);
        listaCategorias.insertarCategoria(romance);
        listaCategorias.insertarCategoria(novela);
        listaCategorias.insertarCategoria(ciencia);
        listaCategorias.insertarCategoria(misterio);
        
        //punto a) libros según el doc del caso, con el identificador del libro, el título, autor y editorial del libro
        // categ accion
        listaCategorias.insertarLibroEnCategoria(1, new Libro(1, "La Revolucion", "Camila", "Akal"));
        listaCategorias.insertarLibroEnCategoria(1, new Libro(2, "La Odisea", "Homero", "Comares"));
        listaCategorias.insertarLibroEnCategoria(1, new Libro(3, "Hacia un mundo nuevo", "Alfaro", "Comares"));
        
        // categ romance
        listaCategorias.insertarLibroEnCategoria(2, new Libro(4, "La esposa del viajero en el tiempo", "Alexandra", "Comares"));
        listaCategorias.insertarLibroEnCategoria(2, new Libro(5, "Orgullo y prejuicio", "Jane", "Akal"));
        listaCategorias.insertarLibroEnCategoria(2, new Libro(6, "Como agua para chocolate", "Wonka", "Comares"));
        listaCategorias.insertarLibroEnCategoria(2, new Libro(7, "Flores de la tormenta", "Rivera", "Comares"));
        
        // categ Novela
        listaCategorias.insertarLibroEnCategoria(3, new Libro(8, "Cien years de soledad", "Garcia", "Comares"));
        listaCategorias.insertarLibroEnCategoria(3, new Libro(9, "Matar a un ruisenor", "Jose", "Akal"));
        
        // categ Ciencia
        listaCategorias.insertarLibroEnCategoria(4, new Libro(10, "El origen de las especies", "Darwin", "Comares"));
        listaCategorias.insertarLibroEnCategoria(4, new Libro(11, "Manos de luz", "Sol", "Comares"));
        listaCategorias.insertarLibroEnCategoria(4, new Libro(12, "El futuro de la mente", "Ana", "Akal"));
        listaCategorias.insertarLibroEnCategoria(4, new Libro(13, "Pensando, rápido y lento", "Patricia", "Akal"));
        listaCategorias.insertarLibroEnCategoria(4, new Libro(14, "El gen egoísta", "Cris", "Akal"));
        
        // categ misterio
        listaCategorias.insertarLibroEnCategoria(5, new Libro(15, "Perdida", "Flynn", "Comares"));
        listaCategorias.insertarLibroEnCategoria(5, new Libro(16, "El paciente silencioso", "Rich", "Akal"));
        listaCategorias.insertarLibroEnCategoria(5, new Libro(17, "La pareja de al lado", "Pablo", "Comares"));
        
        //punto b) se llama a getLibroseditorial
        System.out.println("\nLibros por Editorial:");
        System.out.println(listaCategorias.getLibrosEditorial("Comares"));
        
        // punto c) se llama al metodo devuelveLibrosCategoria enviando como parámetro una categoría
        System.out.println("\nLibros de la categoria romance:");
        Libro[] librosNovela = listaCategorias.devuelveLibrosCategoria(2);
        for (Libro libro : librosNovela) {
            System.out.println("** " + libro.getTitulo() + " (Editorial: " + libro.getEditorial() + ")");
        }
        
        // punto d) se llama al metodo imprimaCategorias
        System.out.println("\n Categorias y cantidad de libros:");
        System.out.println(listaCategorias.imprimaCategorias());
        
        // punto e) se llama al metodo eliminaLibroCategoria
        System.out.println("\n Eliminando libro El origen de las espcies de la categoria Ciencia:");
        if (listaCategorias.eliminaLibroCategoria(4, 10)) {
            System.out.println("El libro se ha eliminado de forma corrcta");
        } else {
            System.out.println("No se logro eliminar el libro");
        }
        
        // punt f) se llama al metodo imprimaCategorias de nuevo para confirmar que se elimino el libro 
        System.out.println("\nCategorias y cantidad de libros despues de la eliminacion:");
        System.out.println(listaCategorias.imprimaCategorias());
    }
}