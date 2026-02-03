package test;

import model.Vehiculo;
import model.Camion;
import model.Furgoneta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestHerencia {

    static List<Vehiculo> vehiculos = new ArrayList<>();
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {

        vehiculos.add(new Camion("ABC123", "Volvo", "FH16", 50000, 30, 20000, 12000, 4));
        vehiculos.add(new Camion("DEF456", "Scania", "R500", 80000, 28, 25000, 25000, 6));

        vehiculos.add(new Furgoneta("GHI789", "Ford", "Transit", 40000, 12, 10, 5));
        vehiculos.add(new Furgoneta("JKL012", "Mercedes", "Sprinter", 60000, 13, 12, 12));

        for (Vehiculo v : vehiculos) {
            System.out.println("Matrícula: " + v.getMatricula());
            System.out.println("Marca: " + v.getMarca() + " Modelo: " + v.getModelo());
            System.out.println("Kilómetros: " + v.getKilometrosTotales());
            System.out.println("Consumo: " + v.getConsumoLitros100Km());

            if (v instanceof Camion) {
                Camion c = (Camion) v;
                System.out.println("Carga ocupada (kg): " + c.getCargaOcupadaKg());
            } else if (v instanceof Furgoneta) {
                Furgoneta f = (Furgoneta) v;
                System.out.println("Volumen ocupado (m3): " + f.getVolumenOcupadoM3());
            }

            System.out.println("Carga disponible: " + v.cargaDisponible());
            System.out.println("-----------------------------");
        }
    }
}
