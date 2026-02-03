package model;

public class Furgoneta extends Vehiculo{

    private double volumenCargaM3;
    private double volumenOcupadoM3;

    @Override
    public double cargaDisponible() {
        return volumenCargaM3 - volumenOcupadoM3;
    }

    @Override
    public double getPorcentajeCarga() {
        return (volumenOcupadoM3 / volumenCargaM3) * 100;
    }

    @Override
    public boolean isLleno() {
        return volumenOcupadoM3 >= volumenCargaM3;
    }

    public double getVolumenCargaM3() {
        return volumenCargaM3;
    }
    public void setVolumenCargaM3(double volumenCargaM3) {
        this.volumenCargaM3 = volumenCargaM3;
    }
    public double getVolumenOcupadoM3() {
        return volumenOcupadoM3;
    }
    public void setVolumenOcupadoM3(double volumenOcupadoM3) {
        this.volumenOcupadoM3 = volumenOcupadoM3;
    }
    
    public Furgoneta(String matricula, String marca, String modelo, double kilometrosTotales,
            double consumoLitros100Km, double volumenCargaM3, double volumenOcupadoM3) {
        super(matricula, marca, modelo, kilometrosTotales, consumoLitros100Km);
        this.volumenCargaM3 = volumenCargaM3;
        this.volumenOcupadoM3 = volumenOcupadoM3;
    }
    
    public Furgoneta() {
    }

}
