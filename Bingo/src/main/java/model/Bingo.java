package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bingo {
    private static final int MAX_NUMERO = 99;
    private static final int NUM_NUMEROS_BINGO = 90;
    private static final int NUMERO_LINEA = 5;
    private static final int NUMERO_FILAS = 3;

    public List<Jugador> jugadores;
    private int[] numerosBingo;
    private int indiceNumeroActual;

    public Bingo() {
        jugadores = new ArrayList<>();
        numerosBingo = new int[NUM_NUMEROS_BINGO];
        for (int i = 0; i < NUM_NUMEROS_BINGO; i++) {
            numerosBingo[i] = i + 1;
        }
        shuffleNumerosBingo();
        indiceNumeroActual = 0;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void iniciarJuego() {
        while (indiceNumeroActual < NUM_NUMEROS_BINGO) {
            int numeroActual = numerosBingo[indiceNumeroActual];
            System.out.println("\nNúmero actual: " + numeroActual);

            for (Jugador jugador : jugadores) {
                System.out.println("\nJugador: " + jugador.getNombre());
                for (Carton carton : jugador.getCartones()) {
                    if (carton.contieneNumero(numeroActual)) {
                        System.out.println("Cartón " + carton.getId() + ": ¡Número encontrado!");
                        carton.getNumeros().remove(Integer.valueOf(numeroActual));
                        if (carton.getNumeros().size() == 0) {
                            System.out.println("¡Bingo! Cartón " + carton.getId() + " completo.");
                            jugador.getCartones().remove(carton);
                        } else if (carton.getNumeros().size() % NUMERO_LINEA == 0) {
                            System.out.println("¡Línea! Cartón " + carton.getId() + " línea completa.");
                        }
                    }
                }
            }

            indiceNumeroActual++;

            try {
                Thread.sleep(5000); // Espera 5 segundos antes de mostrar el siguiente número
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nFin del juego. Todos los números han sido cantados.");
    }

    private void shuffleNumerosBingo() {
        Random rand = new Random();
        for (int i = NUM_NUMEROS_BINGO - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = numerosBingo[i];
            numerosBingo[i] = numerosBingo[j];
            numerosBingo[j] = temp;
        }
    }
}