package model;

import java.time.LocalDate;

public class Ruta {

    private int idRuta;
    private LocalDate fecha;
    private String origen;
    private String destino;
    private Vehiculo vehiculoUsado;
    private Empleado empleado;
    private double kmRecorridos;
    private double cargaTransportada;

    public boolean isCargaCorrecta() {
        if (vehiculoUsado instanceof Camion) {
            Camion c = (Camion) vehiculoUsado;
            return cargaTransportada <= c.getCapacidadCargaKg();
        } else if (vehiculoUsado instanceof Furgoneta) {
            Furgoneta f = (Furgoneta) vehiculoUsado;
            return cargaTransportada <= f.getVolumenCargaM3();
        } else {
            return false;
        }
    }

    public void modificarKilometrosYConsumoVehiculo() {
        vehiculoUsado.aumentarKilometraje(kmRecorridos);

        double incrementoConsumo = (cargaTransportada / 1000.0) * 0.1; // ejemplo
        double nuevoConsumo = vehiculoUsado.getConsumoLitros100Km() + incrementoConsumo;

        vehiculoUsado.modificarConsumoLitros100Km(nuevoConsumo);
    }

    public String getOrigenDestino() {
        return this.origen + " - " + this.destino + " - " + this.kmRecorridos + " km";
    }

    public String tipoRuta(){
        if (kmRecorridos <= 0) {
            return "Kilómetros no válidos";
        } else if (kmRecorridos <= 200) {
            return "CORTA";
        } else if (kmRecorridos <= 400) {
            return "MEDIA";
        } else {
            return "LARGA";
        }
    }

    public double calcularConsumoEstimado() {
        return (kmRecorridos * vehiculoUsado.getConsumoLitros100Km()) / 100;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Vehiculo getVehiculoUsado() {
        return vehiculoUsado;
    }

    public void setVehiculoUsado(Vehiculo vehiculoUsado) {
        this.vehiculoUsado = vehiculoUsado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public double getKmRecorridos() {
        return kmRecorridos;
    }

    public void setKmRecorridos(double kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }

    public double getCargaTransportada() {
        return cargaTransportada;
    }

    public void setCargaTransportada(double cargaTransportada) {
        this.cargaTransportada = cargaTransportada;
    }

    public Ruta(int idRuta, LocalDate fecha, String origen, String destino, Vehiculo vehiculoUsado, Empleado empleado,
            double kmRecorridos, double cargaTransportada) {
        this.idRuta = idRuta;
        this.fecha = fecha;
        this.origen = origen;
        this.destino = destino;
        this.vehiculoUsado = vehiculoUsado;
        this.empleado = empleado;
        this.kmRecorridos = kmRecorridos;
        this.cargaTransportada = cargaTransportada;
    }

    public Ruta() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idRuta;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ruta other = (Ruta) obj;
        if (idRuta != other.idRuta)
            return false;
        return true;
    }
}
