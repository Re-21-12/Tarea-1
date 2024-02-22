/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolbinario;

/**
 *
 * @author victo
 */
public class NodoBinario {
    private int dato;
    private NodoBinario Izquierdo;
    private NodoBinario Derecho;

    public NodoBinario(int dato) {
        this.dato = dato;
        this.Izquierdo = null;
        this.Derecho = null;
    }

    public int getDato() {
        return dato;
    }

    public NodoBinario getIzquierdo() {
        return Izquierdo;
    }

    public NodoBinario getDerecho() {
        return Derecho;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setIzquierdo(NodoBinario Izquierdo) {
        this.Izquierdo = Izquierdo;
    }

    public void setDerecho(NodoBinario Derecho) {
        this.Derecho = Derecho;
    }
    
    
}
