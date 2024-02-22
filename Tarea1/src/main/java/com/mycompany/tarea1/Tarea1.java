/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tarea1;

import java.util.Scanner;

/**
 *
 * @author victo
 */
public class Tarea1 {

    public static void main(String[] args) {
        System.out.println("Bienvenido");
        Scanner entrada = new Scanner(System.in);
        String ans;
        int valorNuevo;
        NodoLista raiz = ingresarRaiz();
        System.out.println("Seleccioone una opcion:\t \n Pila \t[1] \n Cola \t[2] ");
        int opt = entrada.nextInt();
        switch (opt) {
            case 1:
                do {
                    System.out.println("Seleccione una opcion:\t \n Agregar\t[1] \n Eliminar\t[2] \n Salir \t[3] ");
                    opt = entrada.nextInt();
                    switch (opt) {
                        case 1:
                            entrada.nextLine(); // Consumir la nueva línea pendiente
                            System.out.println("Ingrese el valor del nodo nuevo: ");
                            valorNuevo = entrada.nextInt();
                            //vamos actalizando el nodo en base a la raiz
                            raiz = agregarEnPila(raiz, valorNuevo);
                            mostrarPila(raiz);
                            break;
                        case 2:
                            // Llamamos a la función eliminarDePila para eliminar el elemento del tope
                            raiz = eliminarDePilayCola(raiz);
                            // Mostramos la pila actualizada
                            mostrarPila(raiz);
                            break;
                    }
                } while (opt != 3);
                break;
            case 2:
                do {
                    System.out.println("Seleccione una opcion:\t \n Agregar\t[1] \n Eliminar\t[2]\n Salir \t[3] ");
                    opt = entrada.nextInt();
                    switch (opt) {
                        case 1:
                            entrada.nextLine(); // Consumir la nueva línea pendiente
                            System.out.println("Ingrese el valor del nodo nuevo: ");
                            valorNuevo = entrada.nextInt();
                            //vamos actalizando el nodo en base a la raiz
                            raiz = agregarEnCola(raiz, valorNuevo);
                            mostrarCola(raiz);
                            break;
                        case 2:
                            // Llamamos a la función eliminarDePila para eliminar el elemento del tope
                            raiz = eliminarDePilayCola(raiz);
                            // Mostramos la pila actualizada
                            mostrarPila(raiz);
                            break;
                    }
                } while (opt != 3);
                break;
        }
    }

    public static NodoLista agregarEnPila(NodoLista raiz, int siguiente) {
        //este nos va a servvir para agregar nodos
        NodoLista nuevoNodo = new NodoLista(siguiente);
        //si el nodo que te no esta vacio entonces agrega nodo nuevo coomo la cabeza con el valor que me pasaste
        if (raiz != null) {
            nuevoNodo.setSiguiente(raiz);
        }
        //retornamos
        return nuevoNodo;
    }

    public static NodoLista agregarEnCola(NodoLista raiz, int siguiente) {
        // Creamos un nuevo nodo con el valor especificado
        NodoLista nuevoNodo = new NodoLista(siguiente);

        // Si la raíz (frente de la cola) es null, significa que la cola está vacía
        // Por lo tanto, simplemente devolvemos el nuevo nodo como el nuevo frente de la cola
        if (raiz == null) {
            return nuevoNodo;
        }

        // Si la raíz no es null, significa que ya hay elementos en la cola
        // Entonces, necesitamos encontrar el último nodo y establecer el nuevo nodo como su siguiente
        NodoLista actual = raiz;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevoNodo);

        // Retornamos la raíz de la cola (que sigue siendo el frente de la cola)
        return raiz;
    }

    public static NodoLista eliminarDePilayCola(NodoLista raiz) {
        // Verificamos si la pila está vacía
        if (raiz == null) {
            System.out.println("La pila está vacía, no se puede eliminar.");
            return null;
        }
        // Avanzamos al segundo elemento  a la izquierda
        //actualizamos el nuevo null
        NodoLista nuevoTope = raiz.getSiguiente();
        // Eliminamos el tope actual asignando null como siguiente elemento
        raiz.setSiguiente(null);
        // Retornamos el nuevo tope de la pila
        return nuevoTope;
    }

    public static void mostrarPila(NodoLista raiz) {

        while (raiz != null) {
            System.out.print(raiz.getActual() + " <- "); // Imprime el valor del nodo actual
            raiz = raiz.getSiguiente();
        }
        System.out.println("null");
    }

    public static void mostrarCola(NodoLista raiz) {

        while (raiz != null) {
            System.out.print(raiz.getActual() + " -> "); // Imprime el valor del nodo actual
            raiz = raiz.getSiguiente();
        }
        System.out.println("null");
    }

    public static NodoLista ingresarRaiz() {
        System.out.println("desea ingresar un valor para la cabeza o cola del nodo? [s/n]:");
        Scanner entrada = new Scanner(System.in);
        String opt = entrada.nextLine();
        if (opt.equalsIgnoreCase("s")) {
            System.out.println("Ingrese un numeroo para el nodo:");
            //si se le da un valor vas a retornar un nodo para la cebza
            int valorInicial = entrada.nextInt();
            NodoLista raiz = new NodoLista(valorInicial);
            return raiz;
        } else {
            //si no es nuulo
            return null;
        }
    }
}
