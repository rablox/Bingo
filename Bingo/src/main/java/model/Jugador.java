package model;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private String dni;
    private int saldo;
    private List<Carton> cartones;

    public Jugador(String nombre, String dni, int saldo) {
        this.nombre = nombre;
        this.dni = dni;
        this.saldo = saldo;
        cartones = new ArrayList<>();
    }

    public void comprarCartones(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            if (saldo >= 1) {
                Carton carton = new Carton();
                cartones.add(carton);
                saldo -= 1;
            } else {
                System.out.println("Saldo insuficiente para comprar más cartones.");
                break;
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getSaldo() {
        return saldo;
    }

    public List<Carton> getCartones() {
        return cartones;
    }
}
