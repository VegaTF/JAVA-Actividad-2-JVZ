package test;

import model.*;
import gestion.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class TestGestionRutas {

    static iGestionRutas irutas = new GestionRutas();
    static Scanner leer = new Scanner(System.in);
    static Ruta ruta;

    public static void main(String[] args) {

        // Creamos empleados
        Empleado emp1 = new Empleado("1234A", "Ana", "Pérez", "ana@mail.com", "M");
        Empleado emp2 = new Empleado("5678B", "Luis", "García", "luis@mail.com", "H");

        // Creamos vehículos
        Camion cam1 = new Camion("ABC123", "Volvo", "FH16", 50000, 30, 20000, 10000, 4);
        Camion cam2 = new Camion("DEF456", "Scania", "R500", 80000, 28, 25000, 25000, 6);
        Furgoneta fur1 = new Furgoneta("GHI789", "Ford", "Transit", 40000, 12, 10, 5);
        Furgoneta fur2 = new Furgoneta("JKL012", "Mercedes", "Sprinter", 60000, 13, 12, 12);

        // Creamos rutas
        Ruta r1 = new Ruta(1, LocalDate.of(2026,1,1), "Madrid", "Barcelona", cam1, emp1, 500, 15000);
        Ruta r2 = new Ruta(2, LocalDate.of(2026,1,5), "Valencia", "Sevilla", cam2, emp2, 600, 20000);
        Ruta r3 = new Ruta(3, LocalDate.of(2026,1,10), "Bilbao", "Madrid", fur1, emp1, 350, 5);
        Ruta r4 = new Ruta(4, LocalDate.of(2026,1,15), "Zaragoza", "Barcelona", fur2, emp2, 300, 10);

        // Añadimos rutas a la gestión
        irutas.addRuta(r1);
        irutas.addRuta(r2);
        irutas.addRuta(r3);
        irutas.addRuta(r4);

        // Probamos rutasPorEmpleado
        System.out.println("Rutas de Ana Pérez:");
        List<Ruta> rutasAna = irutas.rutasPorEmpleado("1234A");
        for (Ruta r : rutasAna) {
            System.out.println(r.getOrigenDestino() + " - Carga correcta: " + r.isCargaCorrecta());
        }

        // Probamos rutasPorVehiculo
        System.out.println("\nRutas del vehículo ABC123:");
        List<Ruta> rutasCam1 = irutas.rutasPorVehiculo("ABC123");
        for (Ruta r : rutasCam1) {
            System.out.println(r.getOrigenDestino() + " - Km recorridos: " + r.getKmRecorridos());
        }

        // Probamos totalKmPorVehiculo
        System.out.println("\nTotal km por vehículo:");
        Map<String, Long> kmPorVehiculo = irutas.totalKmPorVehiculo();
        for (String matricula : kmPorVehiculo.keySet()) {
            System.out.println(matricula + " -> " + kmPorVehiculo.get(matricula) + " km");
        }

        // Probamos rutasPorDestino
        System.out.println("\nRutas con destino Barcelona:");
        List<Ruta> rutasBarcelona = irutas.rutasPorDestino("Barcelona");
        for (Ruta r : rutasBarcelona) {
            System.out.println(r.getOrigenDestino() + " - Vehículo: " + r.getVehiculoUsado().getMarca());
        }

        // Probamos rutasIntervaloFechas
        System.out.println("\nRutas entre 2026-01-05 y 2026-01-15:");
        List<Ruta> rutasIntervalo = irutas.rutasIntervaloFechas(LocalDate.of(2026,1,5), LocalDate.of(2026,1,15));
        for (Ruta r : rutasIntervalo) {
            System.out.println(r.getOrigenDestino() + " - Fecha: " + r.getFecha());
        }

        // Probamos totalKmPorTipoVehiculo
        System.out.println("\nTotal km por tipo de vehículo:");
        Map<String, Long> kmPorTipo = irutas.totalKmPorTipoVehiculo();
        for (String tipo : kmPorTipo.keySet()) {
            System.out.println(tipo + " -> " + kmPorTipo.get(tipo) + " km");
        }
    }
}
