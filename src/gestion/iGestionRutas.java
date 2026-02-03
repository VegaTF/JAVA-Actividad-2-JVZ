package gestion;

import model.Ruta;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

public interface iGestionRutas {

    void addRuta(Ruta ruta);
    void eliminarRuta(Ruta ruta);
    void eliminarRuta(int idRuta);
    List<Ruta> rutasPorEmpleado(String dni);
    List<Ruta> rutasPorVehiculo(String matricula);
    Map<String, Long> totalKmPorVehiculo(); // String es la matrícula
    List<Ruta> rutasPorDestino(String destino);
    List<Ruta> rutasIntervaloFechas(LocalDate inicio, LocalDate fin);
    Map<String, Long> totalKmPorTipoVehiculo(); // String es o CAMION o FURGONETA
    
}
