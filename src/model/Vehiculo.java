package model;

public abstract class Vehiculo {
    
    private String matricula;
    private String marca;
    private String modelo;
    private double kilometrosTotales;
    private double consumoLitros100Km;

    public abstract double cargaDisponible();
    public abstract double getPorcentajeCarga();
    public abstract boolean isLleno();
    
    public void aumentarKilometraje(double kilometros){
        this.kilometrosTotales += kilometros;
    }

    public void modificarConsumoLitros100Km(double nuevoConsumo){
        this.consumoLitros100Km = nuevoConsumo;
    }

    public String getMatricula() {
        return matricula;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public double getKilometrosTotales() {
        return kilometrosTotales;
    }
    public double getConsumoLitros100Km() {
        return consumoLitros100Km;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setKilometrosTotales(double kilometrosTotales) {
        this.kilometrosTotales = kilometrosTotales;
    }
    public void setConsumoLitros100km(double consumoLitros100Km) {
        this.consumoLitros100Km = consumoLitros100Km;
    }
    
    public Vehiculo(String matricula, String marca, String modelo, double kilometrosTotales,
            double consumoLitros100Km) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometrosTotales = kilometrosTotales;
        this.consumoLitros100Km = consumoLitros100Km;
    }
    
    public Vehiculo() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
        Vehiculo other = (Vehiculo) obj;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }
}
