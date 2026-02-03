package model;

public class Camion extends Vehiculo {

    private double capacidadCargaKg;
    private double cargaOcupadaKg;
    private int numeroEjes;
    
    @Override
    public double cargaDisponible(){
        return capacidadCargaKg - cargaOcupadaKg;
    }

    @Override
    public double getPorcentajeCarga(){
        return (cargaOcupadaKg / capacidadCargaKg) * 100;
    }

    @Override
    public boolean isLleno() {
        return cargaOcupadaKg >= capacidadCargaKg;
    }

    public double getCapacidadCargaKg() {
        return capacidadCargaKg;
    }
    public void setCapacidadCargaKg(double capacidadCargaKg) {
        this.capacidadCargaKg = capacidadCargaKg;
    }
    public double getCargaOcupadaKg() {
        return cargaOcupadaKg;
    }
    public void setCargaOcupadaKg(double cargaOcupadaKg) {
        this.cargaOcupadaKg = cargaOcupadaKg;
    }
    public int getNumeroEjes() {
        return numeroEjes;
    }
    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }
    
    public Camion(String matricula, String marca, String modelo, double kilometrosTotales,
            double consumoLitros100Km, double capacidadCargaKg, double cargaOcupadaKg, int numeroEjes) {
        super(matricula, marca, modelo, kilometrosTotales, consumoLitros100Km);
        this.capacidadCargaKg = capacidadCargaKg;
        this.cargaOcupadaKg = cargaOcupadaKg;
        this.numeroEjes = numeroEjes;
    }
    
    public Camion() {
    }
}
