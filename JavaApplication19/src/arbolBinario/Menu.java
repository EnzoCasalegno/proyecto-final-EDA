

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import arbolBinario.Arbol;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arbol arbol = new Arbol();

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ingresar puntuaciones.");
            System.out.println("2. Obtener mejores puntuaciones.");
            System.out.println("3. Armar rondas finales con mejores puntuaciones.");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la puntuación:");
                    int puntuacion = scanner.nextInt();
                    scanner.nextLine();
                    arbol.insertar(puntuacion);
                    System.out.println("Puntuación ingresada correctamente.");
                    break;
                case 2:
                    System.out.println("Mejores puntuaciones:");
                    for (Integer punt : arbol.recorridoInorden()) {
                        System.out.println(punt);
                    }
                    break;
                case 3:
                    System.out.println("Armando rondas finales...");
                    for (List<Integer> ronda : arbol.organizarRondasFinales()) {
                        System.out.print("Ronda: ");
                        for (Integer punt : ronda) {
                            System.out.print(punt + " ");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
            }
        }
    }
}