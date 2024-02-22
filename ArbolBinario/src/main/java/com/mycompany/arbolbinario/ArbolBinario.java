/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.arbolbinario;

import java.util.Scanner;

/**
 *
 * @author victo
 */
public class ArbolBinario {

    public static void main(String[] args) {
        System.out.println("Bienvenido al arbol binario ");
        Scanner entrada = new Scanner(System.in);
        String ans;
        int valorNuevo;
        int valorEliminar;
        //le asignamos un valor al primer nodo o a la raiz
        NodoBinario raiz = addRaiz();
        int opt;
        do {
            System.out.println("\nAgregar un nuevo valor \t[1] \nEliminar un valor \t[2] \nSalir \t[3]");
            opt = entrada.nextInt();
            //mostramos una lista de opciones para realizar en el nodo
            switch (opt) {
                case 1:
                    entrada.nextLine(); // Consumir la nueva línea pendiente
                    System.out.println("Ingrese el valor del nodo nuevo: ");
                    valorNuevo = entrada.nextInt();
                    raiz = addNode(raiz, valorNuevo);
                    mostrarLista(raiz);
                    break;
                case 2:
                    System.out.println("Ingrese el valor a eliminar: ");
                    valorEliminar = entrada.nextInt();
                    raiz = eliminarNodo(raiz, valorEliminar);
                    mostrarLista(raiz);
                    break;
            }
        } while (opt != 3);
    }

    public static NodoBinario addNode(NodoBinario raiz, int valor) {
        // Si la raíz es nula, creamos un nuevo nodo con el valor dado y lo retornamos
        if (raiz == null) {
            return new NodoBinario(valor);
        }

        // Si el valor es menor que el valor del nodo actual, insertamos en el subárbol izquierdo
        if (valor < raiz.getDato()) {
            // Verificamos si el subárbol izquierdo está vacío
            if (raiz.getIzquierdo() == null) {
                // Si está vacío, creamos un nuevo nodo y lo asignamos como hijo izquierdo del nodo actual
                raiz.setIzquierdo(new NodoBinario(valor));
            } else {
                // Si no está vacío, llamamos recursivamente a la función para insertar en el subárbol izquierdo
                raiz.setIzquierdo(addNode(raiz.getIzquierdo(), valor));
            }
        } // Si el valor es mayor que el valor del nodo actual, insertamos en el subárbol derecho
        else if (valor > raiz.getDato()) {
            // Verificamos si el subárbol derecho está vacío
            if (raiz.getDerecho() == null) {
                // Si está vacío, creamos un nuevo nodo y lo asignamos como hijo derecho del nodo actual
                raiz.setDerecho(new NodoBinario(valor));
            } else {
                // Si no está vacío, llamamos recursivamente a la función para insertar en el subárbol derecho
                raiz.setDerecho(addNode(raiz.getDerecho(), valor));
            }
        }

        // Retornamos la raíz actualizada
        return raiz;
    }

    public static NodoBinario addRaiz() {
        System.out.println("desea ingresar un valor para la raiz del nodo? [s/n]:");
        Scanner entrada = new Scanner(System.in);
        String opt = entrada.nextLine();
        if (opt.equalsIgnoreCase("s")) {
            System.out.println("Ingrese un valor para la raiz del nodo:");
            //si se le da un valor vas a retornar un nodo para la cebza
            int valorInicial = entrada.nextInt();
            NodoBinario nodo = new NodoBinario(valorInicial);
            return nodo;
        } else {
            //si no es nuulo
            return null;
        }
    }

    public static void mostrarLista(NodoBinario nodo) {
        if (nodo != null) {

            System.out.println("\t  -> " + nodo.getDato() + "\t <-");
            if (nodo.getIzquierdo() != null) {
                System.out.println("Subárbol izquierdo [<-]:");
                mostrarLista(nodo.getIzquierdo());
            }
            if (nodo.getDerecho() != null) {
                System.out.println("Subárbol derecho [->]:");
                mostrarLista(nodo.getDerecho());
            }
        }
    }

    public static NodoBinario eliminarNodo(NodoBinario raiz, int valor) {
        //Si no hay raiz retorna nulo
        if (raiz == null) {
            return null;
        }

        // Si el valor que buscamos es menor que el valor de la raíz, buscamos en el subárbol izquierdo.
        if (valor < raiz.getDato()) {
            raiz.setIzquierdo(eliminarNodo(raiz.getIzquierdo(), valor));
        } // Si el valor que buscamos es mayor que el valor de la raíz, buscamos en el subárbol derecho.
        else if (valor > raiz.getDato()) {
            raiz.setDerecho(eliminarNodo(raiz.getDerecho(), valor));
        } // Si encontramos el valor que buscamos.
        else {
            //aqui validamos que sea un nodo hijo 
            if (raiz.getIzquierdo() == null) {
                return raiz.getDerecho();
            } else if (raiz.getDerecho() == null) {
                return raiz.getIzquierdo();
            }

            // Si el nodo no es una hoja entonces buscamos el quue este mas a la izqiuerda del lado derecho
            raiz.setDato(buscarSucesor(raiz.getDerecho()));
            raiz.setDerecho(eliminarNodo(raiz.getDerecho(), raiz.getDato()));
        }

        return raiz;
    }

// Función para encontrar el sucesor inmediato (el nodo más pequeño en el subárbol derecho).
    public static int buscarSucesor(NodoBinario nodo) {
        int sucesor = nodo.getDato();
        while (nodo.getIzquierdo() != null) {
            sucesor = nodo.getIzquierdo().getDato();
            nodo = nodo.getIzquierdo();
        }
        return sucesor;
    }

}
