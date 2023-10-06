package com.example.conversiondegrados.models;

public class Farenheit extends Grado{
    public Farenheit(Double valor, String unidad) {
        super(valor, unidad);
    }

    public Farenheit parse(Celsius c){
        return new Farenheit(c.getValor()-32/1.8, "F");
    }

    public Farenheit parse(Kelvin c){
        return new Farenheit((c.getValor()-32)*5/9+273.15, "F");
    }
}
