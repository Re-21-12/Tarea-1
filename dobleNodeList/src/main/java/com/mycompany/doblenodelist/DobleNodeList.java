package com.mycompany.doblenodelist;

import java.util.Scanner;

public class DobleNodeList {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String ans;
        int valorNuevo;
        int valorDespues;
        Node cabeza = ingresarCabezaColaNodo();
        int opt;
        do {
            System.out.println("Donde desea agregar un valor:\t \n Inicio \t[1] \n Final \t[2] \n En medio \t[3] \n Eliminar \t [4] \n Salir \t[5]");
            opt = entrada.nextInt();
            switch (opt) {
                case 1:
                    do {
                        System.out.println("Agregar un nodo (s/n)");
                        entrada.nextLine();
                        ans = entrada.nextLine();
                        if (ans.equalsIgnoreCase("n")) {
                            break;
                        }
                        System.out.println("Ingrese el valor del nodo nuevo: ");
                        valorNuevo = entrada.nextInt();
                        //aqui actualizamos el valor de la cabeza
                        cabeza = addNodeValInicio(cabeza, valorNuevo);
                        //System.out.println("Nodo actualizado: " + cabeza);
                    } while ((ans.equalsIgnoreCase("s")));
                    mostrarLista(cabeza);
                    break;
                case 2:
                    do {
                        System.out.println("Agregar un nodo (s/n)");
                        entrada.nextLine(); // Consumir la nueva línea pendiente
                        ans = entrada.nextLine();
                        if (ans.equalsIgnoreCase("n")) {
                            break;
                        }
                        System.out.println("Ingrese el valor del nodo nuevo: ");
                        valorNuevo = entrada.nextInt();
                        cabeza = addNodeValFinal(cabeza, valorNuevo);
                    } while ((ans.equalsIgnoreCase("s")));
                    mostrarLista(cabeza);
                    break;
                case 3:
                    do {
                        System.out.println("Agregar un nodo (s/n)");
                        entrada.nextLine(); // Consumir la nueva línea pendiente
                        ans = entrada.nextLine();
                        if (ans.equalsIgnoreCase("n")) {
                            break;
                        }
                        System.out.println("Ingrese el valor del nodo nuevo: ");
                        valorNuevo = entrada.nextInt();
                        System.out.println("Ingrese el valor después del cual se desea insertar el nuevo nodo: ");
                        valorDespues = entrada.nextInt();
                        cabeza = addNodeValMedio(cabeza, valorNuevo, valorDespues);
                    } while ((ans.equalsIgnoreCase("s")));
                    mostrarLista(cabeza);
                    break;
                case 4:
                    cabeza = eliminarPrimeroIzquierda(cabeza);
                    mostrarLista(cabeza);
                    break;
            }
        } while (opt != 5);
    }

    public static Node eliminarPrimeroIzquierda(Node cabeza) {
        // Verificamos si la pila está vacía
        if (cabeza == null) {
            System.out.println("La pila está vacía, no se puede eliminar.");
            return null;
        }
        // Avanzamos al segundo elemento  a la izquierda
        //actualizamos el nuevo null
        Node nuevoTopeIzquierda = cabeza.getSiguiente();
        // Eliminamos el tope actual asignando null como siguiente elemento
        cabeza.setSiguiente(null);
        // Retornamos el nuevo tope de la pila
        return nuevoTopeIzquierda;
    }

//aqui los valores se van empujando de izquierda a derecha hasta llegar a null
    // 1 <- 2 <- null
    public static Node addNodeValInicio(Node cabeza, int valor) {
        Node nuevoNodo = new Node(valor);
        // si es 3 -> null
        nuevoNodo.setSiguiente(cabeza);
        //si no es nulo enetonces agregalo a la izqierda 3-> 5 -> null
        if (cabeza != null) {
            cabeza.setAnterior(nuevoNodo);
        }
        return nuevoNodo;
    }
//aqui los valores se van empujando de derecha a izquierda inicando con null

    // nuull -> 2 -> 1 
    public static Node addNodeValFinal(Node cabeza, int valor) {
        Node nuevoNodo = new Node(valor);
        Node actual = cabeza;
//si la cabeza es nula vas a retornar el valor nuevo
        if (cabeza == null) {
            return nuevoNodo;
        }
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevoNodo);
        nuevoNodo.setAnterior(cabeza);
        //como la cabeza es nula entonces vas a obtener ese valor
        //siguiente es hacia la derecha
        //anterior hacia la izquierda
        return cabeza;
    }

    public static Node addNodeValMedio(Node cabeza, int valor, int valorDespues) {
        Node nuevoNodo = new Node(valor);
        Node actual = cabeza;

        // Buscar el nodo después del cual queremos insertará el nuevo nodo
        //valor despues es nueustro punto de referencia
        while (actual != null && actual.getActual() != valorDespues) {
            actual = actual.getSiguiente();
        }

        // Si el nodo después del cual se  inserta al nuevo nodo no se encuentra, no hacemos nada
        if (actual == null) {
            System.out.println("El valor después del cual se desea insertar no se encontró en la lista.");
            return cabeza;
        }

        // Insertar el nuevo nodo después del nodo actual
        nuevoNodo.setSiguiente(actual.getSiguiente());
        nuevoNodo.setAnterior(actual);
        //si el siuiente del actuual es un nmero entonces
        if (actual.getSiguiente() != null) {
            //lo desplazamos
            actual.getSiguiente().setAnterior(nuevoNodo);
        }
        actual.setSiguiente(nuevoNodo);

        return cabeza;
    }

    public static void mostrarLista(Node cabeza) {
        Node actual = cabeza;

        while (actual != null) {
            System.out.print(actual.getActual() + " <-> "); // Imprime el valor del nodo actual
            actual = actual.getSiguiente(); // Avanza al siguiente nodo
        }
        System.out.println("null"); // Agrega "null" al final de la lista
    }

    public static Node ingresarCabezaColaNodo() {
        System.out.println("desea ingresar un valor para la cabeza o cola del nodo? [s/n]:");
        Scanner entrada = new Scanner(System.in);
        String opt = entrada.nextLine();
        if (opt.equalsIgnoreCase("s")) {
            System.out.println("Ingrese un numeroo para el nodo:");
            //si se le da un valor vas a retornar un nodo para la cebza
            int valorInicial = entrada.nextInt();
            Node node = new Node(valorInicial);
            return node;
        } else {
            //si no es nuulo
            return null;
        }
    }
}
