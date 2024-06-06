/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package menu;

import java.util.Scanner;

/**
 *
 * @author Enzo
 */
public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ingresar puntuaciones.");
            System.out.println("2. Obtener mejores puntuaciones.");
            System.out.println("3. Armar rondas finales con mejores puntuaciones. ");
            System.out.println("7. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                
            }
        }
    }
}
