package com.example.conversiondegrados.models;

public class Celsius extends Grado{

    public Celsius(Double valor, String unidad) {
        super(valor, unidad);
    }

   public Farenheit parse(Celsius c){
        return new Farenheit(c.getValor()*1.8+32,"F");
   }
}
