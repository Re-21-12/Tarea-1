/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea1;

/**
 *
 * @author victo
 */
public class NodoLista {

    private int actual;
    private NodoLista siguiente;

    public NodoLista(int actual) {
        this.actual = actual;
        this.siguiente = null; // Loo colocamos en null pq automaticamente la cola de un nodo es siempre nuull al llegar al fifnal cuandoo es un nodo normal
    }

    public int getActual() {
        return actual;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }

}
