/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodo;

/**
 *
 * @author Enzo
 */
public class Nodo {
    int puntuacion, izquierdo, derecho;

    public Nodo(int puntuacion) {
        this.puntuacion = puntuacion;
        this.izquierdo = -1;
        this.derecho = -1;
    }
}
