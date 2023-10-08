package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Carton {
    private static int contador = 1;
    private int id;
    private List<Integer> numeros;

    public Carton() {
        id = contador++;
        numeros = new ArrayList<>();
        Random rand = new Random();
        while (numeros.size() < 15) {
            int num = rand.nextInt(99) + 1;
            if (!numeros.contains(num)) {
                numeros.add(num);
            }
        }
    }

    public int getId() {
        return id;
    }

    public List<Integer> getNumeros() {
        return numeros;
    }

    public boolean contieneNumero(int numero) {
        return numeros.contains(numero);
    }
}