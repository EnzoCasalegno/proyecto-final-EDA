import java.util.List;
import java.util.Scanner;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arbol arbol = new Arbol();

        while (true) {
            System.out.println("-------------------------------------------------------");
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Ingresar puntuaciones.");
            System.out.println("2. Obtener mejores puntuaciones.");
            System.out.println("3. Armar rondas finales con mejores puntuaciones.");
            System.out.println("4. Mostrar Arbol");
            System.out.println("5. Salir");
            System.out.println("-------------------------------------------------------");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la puntuacion entre 1 y 100:");
                    int puntuacion = scanner.nextInt();
                    scanner.nextLine();
                    if (puntuacion >= 1 && puntuacion <= 100) {
                        arbol.insertar(puntuacion);
                        System.out.println("Puntuacion ingresada correctamente.");
                    } else {
                        System.out.println("Puntuacion invalida, debe estar entre 1 y 100");
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Mejores puntuaciones de menor a mayor:");
                    for (Integer punt : arbol.recorridoInorden()) {
                        System.out.println(punt);
                    }
                    break;
                case 3:
                    System.out.println("Armando rondas finales...");
                    arbol.organizarRondasFinales();
                    break;
                case 4:
                    System.out.println("Mostrando arbol binario y ubicación de las puntuaciones:");
                    arbol.mostrarArbol();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opcion no valida. Por favor, seleccione una opcion correcta.");
            }
        }
    }
}

