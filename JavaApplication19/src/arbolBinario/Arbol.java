/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolBinario;

import Nodo.Nodo;

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
}
//2. Vamos a determinar quien tiene la puntuacion maxima, fijandonos en el ultimo nodo de la derecha . 
//3. Para armar las rondas finales, lo vamos a hacer con una lista segun el orden que elijamos y ingresando a una lista los valores. 