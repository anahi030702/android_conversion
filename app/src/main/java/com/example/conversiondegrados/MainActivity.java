package com.example.conversiondegrados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.conversiondegrados.models.Celsius;
import com.example.conversiondegrados.models.Farenheit;
import com.example.conversiondegrados.models.Grado;
import com.example.conversiondegrados.models.Kelvin;

public class MainActivity extends AppCompatActivity {

    private TextView caja;
    private TextView cajaresul;
    private Button celcius;
    String tipo = "";
    double grado = 0.0;
    double valorobtenido = 0.0;

    Celsius celsius = new Celsius(0.0, "C");

    Farenheit farenheit = new Farenheit(0.0, "F");
    Kelvin kelvin = new Kelvin(0.0, "K");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        caja =findViewById(R.id.caja);
        cajaresul = findViewById(R.id.cajaresul);
        celcius = findViewById(R.id.celsius);


    }

    public void celsiusuno(View view) {
        grado = Double.parseDouble(caja.getText().toString());
        tipo = "celsius";
    }

    public void fareheitdos(View view) {
        if("celsius".equals(tipo)){
            Farenheit resultado = farenheit.parse(new Celsius(grado, "F"));
            valorobtenido = resultado.getValor();
            cajaresul.setText(valorobtenido + "" + "°F");
              } else if ("faren".equals(tipo)) {
            cajaresul.setText(grado + "°F");
        } else if ("kelvin".equals(tipo)) {
            Farenheit resultado = farenheit.parse(new Kelvin(grado, "F"));
            valorobtenido = resultado.getValor();
            cajaresul.setText(valorobtenido + "" + "°F");
        }
    }

    public void kelvindos(View view) {
        if("celsius".equals(tipo)){
            Kelvin resultado = kelvin.parse(new Celsius(grado, "K"));
            valorobtenido = resultado.getValor();
            cajaresul.setText(valorobtenido + ""+ "°K");
        } else if ("faren".equals(tipo)) {
            Kelvin resultado = kelvin.parse(new Farenheit(grado, "K"));
            valorobtenido = resultado.getValor();
            cajaresul.setText(valorobtenido + "" + "°K");
        }
        else if("kelvin".equals(tipo)){
        cajaresul.setText(grado + "" +"°K");
        }
    }

    public void celsiusdos(View view) {
        if("celsius".equals(tipo)){
            cajaresul.setText(grado + "" + "°C");
        } else if ("faren".equals(tipo)) {
            Celsius resultado = celsius.parse(new Farenheit(grado, "C"));
            valorobtenido = resultado.getValor();
            cajaresul.setText(valorobtenido + "" + "°C");
        } else if ("kelvin".equals(tipo)) {
            Celsius resultado = celsius.parse(new Kelvin(grado, "C"));
            valorobtenido = resultado.getValor();
            cajaresul.setText(valorobtenido + "" + "°C");
        }
    }

    public void farenheituno(View view) {
        grado = Double.parseDouble(caja.getText().toString());
        tipo = "faren";
    }

    public void kelvin(View view) {
        grado = Double.parseDouble(caja.getText().toString());
        tipo = "kelvin";
    }
}