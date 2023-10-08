import model.Bingo;
import model.Jugador;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bingo bingo = new Bingo();

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Crear jugador");
            System.out.println("2. Comprar cartón");
            System.out.println("3. Iniciar juego");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume la línea en blanco después de leer la opción numérica

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del jugador: ");
                    String nombre = scanner.nextLine();
                    System.out.print("DNI del jugador: ");
                    String dni = scanner.nextLine();
                    System.out.print("Saldo inicial del jugador: ");
                    int saldo = scanner.nextInt();
                    scanner.nextLine(); // Consume la línea en blanco después de leer el saldo
                    Jugador jugador = new Jugador(nombre, dni, saldo);
                    bingo.agregarJugador(jugador);
                    System.out.println("Jugador creado con éxito.");
                    break;

                case 2:
                    System.out.print("DNI del jugador que desea comprar cartones: ");
                    String dniCompra = scanner.nextLine();
                    System.out.print("Número de cartones a comprar: ");
                    int cantidadCartones = scanner.nextInt();
                    scanner.nextLine(); // Consume la línea en blanco después de leer la cantidad de cartones
                    Jugador jugadorCompra = null;
                    for (Jugador j : bingo.jugadores) {
                        if (j.getDni().equals(dniCompra)) {
                            jugadorCompra = j;
                            break;
                        }
                    }
                    if (jugadorCompra != null) {
                        jugadorCompra.comprarCartones(cantidadCartones);
                        System.out.println("Compra de cartones realizada con éxito.");
                    } else {
                        System.out.println("No se encontró ningún jugador con ese DNI.");
                    }
                    break;

                case 3:
                    bingo.iniciarJuego();
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
