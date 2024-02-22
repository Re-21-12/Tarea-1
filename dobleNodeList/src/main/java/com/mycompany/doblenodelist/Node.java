/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.doblenodelist;

/**
 *
 * @author victo
 */
public class Node {

    private int actual;
    private Node siguiente;
    private Node anterior;

    //si no se le da un valor de cabeza o cola sera nulo en ambas
    public Node(int actual) {
        this.actual = actual;
        this.siguiente = null;
        this.anterior = null;
    }

    public int getActual() {
        return actual;
    }

    public Node getSiguiente() {
        return siguiente;
    }

    public Node getAnterior() {
        return anterior;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    public void setSiguiente(Node siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(Node anterior) {
        this.anterior = anterior;
    }

    
}
