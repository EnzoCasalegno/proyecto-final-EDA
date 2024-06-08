

import java.util.ArrayList;
import java.util.List;

public class Arbol {
    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void insertar(int puntuacion) {
        if (raiz == null) {
            raiz = new Nodo(puntuacion, null, null);
            System.out.println("El arbol se encuentra vacio, el valor " + puntuacion + " ahora es la raiz");
        } else {
            insertarRecursivo(raiz, puntuacion);
        }
    }

    private void insertarRecursivo(Nodo nodo, int puntuacion) {
        if (puntuacion >= nodo.puntuacion) {
            if (nodo.derecho == null) {
                nodo.derecho = new Nodo(puntuacion, null, null);
            } else {
                insertarRecursivo(nodo.derecho, puntuacion);
            }
        } else {
            if (nodo.izquierdo == null) {
                nodo.izquierdo = new Nodo(puntuacion, null, null);
            } else {
                insertarRecursivo(nodo.izquierdo, puntuacion);
            }
        }
    }

    public List<Integer> recorridoInorden() {
        List<Integer> resultado = new ArrayList<>();
        recorridoInordenRecursivo(raiz, resultado);
        return resultado;
    }

    private void recorridoInordenRecursivo(Nodo nodo, List<Integer> resultado) {
        if (nodo != null) {
            recorridoInordenRecursivo(nodo.izquierdo, resultado);
            resultado.add(nodo.puntuacion);
            recorridoInordenRecursivo(nodo.derecho, resultado);
        }
    }

    public List<List<Integer>> organizarRondasFinales() {
    List<List<Integer>> rondas = new ArrayList<>();
    List<Integer> puntuaciones = recorridoInorden();

    // Definir los nombres de las rondas
    String[] nombresRondas = {"Cuartos de final", "Semi final", "Final"};

    // Organizar las rondas
    int nivelInicial = nombresRondas.length - 1;
    int jugadores = puntuaciones.size();
    int ronda = 0;

    while (jugadores > 1 && ronda < nombresRondas.length) {
        List<Integer> rondaActual = new ArrayList<>();
        for (int i = 0; i < jugadores; i += 2) {
            if (i + 1 < puntuaciones.size()) {
                rondaActual.add(Math.max(puntuaciones.get(i), puntuaciones.get(i + 1)));
            } else {
                // Si hay un jugador sin oponente, avanza automáticamente a la siguiente ronda
                rondaActual.add(puntuaciones.get(i));
            }
        }
        rondas.add(rondaActual);
        puntuaciones = rondaActual;
        jugadores = (int) Math.ceil((double) jugadores / 2); // Actualizamos la cantidad de jugadores para la siguiente ronda
        ronda++;
    }

    // Imprimir las rondas con nombres específicos
    for (int i = 0; i < rondas.size(); i++) {
        System.out.print(nombresRondas[i] + ": ");
        for (Integer punt : rondas.get(i)) {
            System.out.print(punt + " ");
        }
        System.out.println();
    }

    // Agregar el ganador
    if (!rondas.isEmpty()) {
        int ganador = rondas.get(rondas.size() - 1).get(0);
        System.out.println("Ganador: " + ganador);
    }

    return rondas;
}


    public void mostrarArbol() {
        System.out.println("Arbol Binario:");
        mostrarArbolRecursivo(raiz, 0);
        System.out.println("\nRondas Finales:");
        organizarRondasFinales(); // Llama a organizarRondasFinales() una vez
    }

    private void mostrarArbolRecursivo(Nodo nodo, int nivel) {
        if (nodo != null) {
            mostrarArbolRecursivo(nodo.derecho, nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("\t");
            }
            if (nivel == 0) {
                System.out.println(nodo.puntuacion);
            } else {
                System.out.println("|_ " + nodo.puntuacion);
            }
            mostrarArbolRecursivo(nodo.izquierdo, nivel + 1);
        }
    }
}


