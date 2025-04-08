/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listasunificadascode;

/**
 *
 * @author CamilaAlfaro
 */
public class NodoCategoria extends NodoDoble {
    private Categoria categoria;
    private ListaLibros listaLibros;

    public NodoCategoria(Categoria categoria) {
        //al igual que en nodolibro aqui tambien se pasa el id de la categria como dato al constructor de la clase nododoble
        super(categoria.getIdCategoria()); 
        this.categoria = categoria;
        this.listaLibros = new ListaLibros();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
        setDato(categoria.getIdCategoria()); 
    }

    public ListaLibros getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ListaLibros listaLibros) {
        this.listaLibros = listaLibros;
    }
    
    @Override
    public NodoCategoria getSiguiente() {
        return (NodoCategoria) super.getSiguiente();
    }
    
    @Override
    public NodoCategoria getAnterior() {
        return (NodoCategoria) super.getAnterior();
    }
    
    @Override
    public void setSiguiente(NodoDoble siguiente) {
        super.setSiguiente(siguiente);
    }
    
    @Override
    public void setAnterior(NodoDoble anterior) {
        super.setAnterior(anterior);
    }
}
