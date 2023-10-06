package com.example.conversiondegrados.models;

public class Celsius extends Grado{

    public Celsius(Double valor, String unidad) {
        super(valor, unidad);
    }

   public Celsius parse(Farenheit c){
        return new Celsius((c.getValor()-32)*5/9,"C");
   }

   public Celsius parse(Kelvin c){
        return new Celsius(c.getValor()-273.15, "C");
   }
}
