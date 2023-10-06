package com.example.conversiondegrados.models;

public class Kelvin extends Grado{
    public Kelvin(Double valor, String unidad) {
        super(valor, unidad);
    }

    public Kelvin parse(Celsius c){
        return new Kelvin(c.getValor()+273.15, "K");
    }

    public Kelvin parse(Farenheit c){
        return new Kelvin((c.getValor()-32)*5/9+273.15, "K");
    }
}
