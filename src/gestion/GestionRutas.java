package gestion;

import model.Camion;
import model.Ruta;
import model.Vehiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GestionRutas implements iGestionRutas {

    private List<Ruta> rutas = new ArrayList<>();

    @Override
    public void addRuta(Ruta ruta){
        rutas.add(ruta);
    }

    @Override
    public void eliminarRuta(Ruta ruta){
        rutas.remove(ruta);
    }

    @Override
    public void eliminarRuta(int idRuta){
        for (int i = 0; i < rutas.size(); i++) {
            if (rutas.get(i).getIdRuta() == idRuta) {
                rutas.remove(i);
                return;
            }
        }
    }

    @Override
    public List<Ruta> rutasPorEmpleado(String dni){
        List<Ruta> resultado = new ArrayList<>();

        for (Ruta r : rutas){
            if (r.getEmpleado().getDni().equals(dni)) {
                resultado.add(r);
            }
        }

        return resultado;
    }

    @Override
    public List<Ruta> rutasPorVehiculo(String matricula){
        List<Ruta> resultado = new ArrayList<>();

        for (Ruta r : rutas){
            if (r.getVehiculoUsado().getMatricula().equals(matricula)) {
                resultado.add(r);
            }
        }
        return resultado;
    }

    @Override
    public Map<String, Long> totalKmPorVehiculo(){
        Map<String, Long> resultado = new HashMap<>();

        for (Ruta r : rutas){
            String matricula = r.getVehiculoUsado().getMatricula();

            if (resultado.containsKey(matricula)) {
                resultado.put(matricula, resultado.get(matricula) + (long)r.getKmRecorridos());
            } else {
                resultado.put(matricula, (long)r.getKmRecorridos());
            }
        }
        return resultado;
    }

    @Override
    public List<Ruta> rutasPorDestino(String destino){
        List<Ruta> resultado = new ArrayList<>();

        for (Ruta r : rutas) {
            if (r.getDestino().equals(destino)) {
                resultado.add(r);
            }
        }
        return resultado;
    }

    @Override
    public List<Ruta> rutasIntervaloFechas(LocalDate inicio, LocalDate fin){
        List<Ruta> resultado = new ArrayList<>();

        for (Ruta r : rutas) {
            if (!r.getFecha().isBefore(inicio) && !r.getFecha().isAfter(fin)) {
                resultado.add(r);
            }
        }
        return resultado;
    }

    @Override
    public Map<String, Long> totalKmPorTipoVehiculo(){
        Map<String, Long> resultado = new HashMap<>();

        for (Ruta r : rutas){
            Vehiculo v = r.getVehiculoUsado();
            String tipo;
            if (v instanceof Camion){
                tipo = "CAMION";
            } else {
                tipo = "FURGONETA";
            }
            resultado.put(tipo, resultado.getOrDefault(tipo, 0L) + (long) r.getKmRecorridos());
        }
        return resultado;
    }

}
