/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolBinario;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Enzo
 */
public class Arbol {

    Nodo raiz;
    private int[] arbolBinario;

    public Arbol() {
        this.arbolBinario = new int[20];
        cargar();// Creamos el arbol vacio ( -1 ). 
    }

    public void insertar(int puntuacion) {
        int indice = 0;
        if (arbolBinario[indice] == -1) {
            System.out.println("El arbol se encuentra vacio, el valor " + puntuacion + " ahora es la raiz");
            System.out.println();
        }

        while (arbolBinario[indice] != -1) { //Verificamos si el arbol tiene raiz o no. Si tiene ingresa, sino se le asigna el valor mediante la primer puntuacion
            if (puntuacion >= arbolBinario[indice]) {
                indice = 2 * indice + 2; // Nodo derecha

            } else {
                indice = 2 * indice + 1; //Nodo izquierda
            }
        }
        arbolBinario[indice] = puntuacion; // Aca insertamos la puntuacion deltro del arbol (RAIZ)
    }

    public void cargar() {
        for (int i = 0; i < 20; i++) {
            arbolBinario[i] = -1;
        }

    }

    public List<Integer> recorridoInorden() {
        List<Integer> resultado = new ArrayList<>();
        recorridoInordenRecursivo(0, resultado);
        return resultado;
    }
    //Recorre mediante el inorden el arbol binario y devuelve una lista con las puntuaciones ordenadas

    private void recorridoInordenRecursivo(int indice, List<Integer> resultado) {
        if (indice < 20 && arbolBinario[indice] != -1) {
            recorridoInordenRecursivo(2 * indice + 1, resultado);
            // Recorrer el subárbol izquierdo
            resultado.add(arbolBinario[indice]);
            // Agregar la puntuación actual
            recorridoInordenRecursivo(2 * indice + 2, resultado);
            // Recorrer el sub arbol derecho
        }
    }

    public List<List<Integer>> organizarRondasFinales() {
        List<List<Integer>> rondas = new ArrayList<>(); //Almacena las rondas finales
        List<Integer> puntuaciones = recorridoInorden(); //Contiene todas las puntuacioenes de los arqueros
        // ordenados de forma ascendente

        int nivel = 0;  //Representa en el nivel del arbol que estamos 
        int ronda = 0;  //Representa el numero de ronda que estamos organizando

        while (!puntuaciones.isEmpty()) {
            //El bucle funciona mientas que existan puntuaciones en la lista 
            rondas.add(new ArrayList<>());  // en cada iteracion creamos una lista dentro de rondas para representar una ronda
            int n = (int) Math.pow(2, nivel); // Número de nodos en el nivel actual

            for (int i = 0; i < n; i++) {
                //Con este for recorremos cada nodo en la ronda actual
                if (!puntuaciones.isEmpty()) { //Siempre que existan puntuanciones 
                    if (ronda % 2 == 0) { // En las rondas pares, tomar la puntuación más alta
                        rondas.get(ronda).add(puntuaciones.remove(0));
                    } else { // En las rondas impares, tomar la puntuación más baja
                        rondas.get(ronda).add(puntuaciones.remove(puntuaciones.size() - 1));
                    }
                }
            }

            nivel++; //incrementamos el nivel para pasar al siguiente nivel del arbol
            ronda++; //Incrementamos el numero de ronda para pasar a organizar la siguiente ronda
        }

        return rondas;
//        Una vez que se han organizado todas las rondas, retornamos la lista rondas, que
//        contiene todas las rondas finales con las puntuaciones de los arqueros
//        organizadas según el criterio especificado (alta-baja, baja-alta, alta-baja, ...).
    }

    public void mostrarArbol() {
        System.out.println("Árbol Binario:");
        mostrarArbolRecursivo(0, 0);
        System.out.println("\nRondas Finales:");
        List<List<Integer>> rondasFinales = organizarRondasFinales();
        for (int i = 0; i < rondasFinales.size(); i++) {
            System.out.print("Ronda " + (i + 1) + ": ");
            for (Integer punt : rondasFinales.get(i)) {
                System.out.print(punt + " ");
            }
            System.out.println();
        }
    }

    private void mostrarArbolRecursivo(int indice, int nivel) {
        if (indice < 20 && arbolBinario[indice] != -1) {
            mostrarArbolRecursivo(2 * indice + 2, nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("\t");
            }
            System.out.println("|__ " + arbolBinario[indice]);
            mostrarArbolRecursivo(2 * indice + 1, nivel + 1);
        }
    }
}
