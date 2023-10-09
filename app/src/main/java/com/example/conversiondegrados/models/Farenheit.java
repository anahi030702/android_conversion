package com.example.conversiondegrados.models;

public class Farenheit extends Grado{
    public Farenheit(Double valor, String unidad) {
        super(valor, unidad);
    }

    public Farenheit parse(Celsius c){
        return new Farenheit(c.getValor()*(1.8)+32, "F");
    }

    public Farenheit parse(Kelvin c){
        return new Farenheit((c.getValor()-273.15)*9/5+32, "F");
    }
}
