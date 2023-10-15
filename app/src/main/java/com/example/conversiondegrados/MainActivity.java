package com.example.conversiondegrados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.conversiondegrados.models.Celsius;
import com.example.conversiondegrados.models.Farenheit;
import com.example.conversiondegrados.models.Grado;
import com.example.conversiondegrados.models.Kelvin;

import kotlin.collections.UArraySortingKt;

public class MainActivity extends AppCompatActivity {

    private TextView caja;
    private TextView cajaresul;
    String tipo = "";
    private double grado = 0.0;
    double valorobtenido = 0.0;
    private Spinner spinner;
    private String[] lista;
    private Spinner spinner2;
    private String[] lista2;

    Celsius celsius = new Celsius(0.0, "C");

    Farenheit farenheit = new Farenheit(0.0, "F");
    Kelvin kelvin = new Kelvin(0.0, "K");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        caja =findViewById(R.id.caja);
        cajaresul = findViewById(R.id.cajaresul);

        spinner = findViewById(R.id.spinner);
        lista = new String[]{"Celsius", "Farenheit", "Kelvin"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista);
        spinner.setAdapter(adaptador);

        spinner2 = findViewById(R.id.spinner2);
        lista2 = new String[]{"Celsius", "Farenheit", "Kelvin"};
        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista2);
        spinner2.setAdapter(adaptador2);


    }


    public void calcular(View view) {
        String valorCaja = caja.getText().toString();
        grado = Double.parseDouble(valorCaja);
        String selectSpinner = spinner.getSelectedItem().toString();
        String selectSpinner2 = spinner2.getSelectedItem().toString();
        if (valorCaja.isEmpty()) {
            Toast.makeText(this, "Debe escribir el grado a convertir en la línea", Toast.LENGTH_LONG).show();
            return; // Salir del método si el campo está vacío
        }
        else {

            switch (selectSpinner) {
                case "Celsius":
                    if (selectSpinner2.equals("Celsius")) {
                        cajaresul.setText(grado + "" + "°C");
                    } else if (selectSpinner2.equals("Farenheit")) {
                        Farenheit resultado = farenheit.parse(new Celsius(grado, "F"));
                        valorobtenido = resultado.getValor();
                        cajaresul.setText(valorobtenido + "" + "°F");
                    } else if (selectSpinner2.equals("Kelvin")) {
                        Kelvin resultado = kelvin.parse(new Celsius(grado, "K"));
                        valorobtenido = resultado.getValor();
                        cajaresul.setText(valorobtenido + "" + "°K");
                    } else {
                        Toast.makeText(this, "Debe seleccionar un grado a convertir", Toast.LENGTH_LONG).show();
                    }
                    break;

                case "Farenheit":
                    if (selectSpinner2.equals("Celsius")) {
                        Celsius resultado = celsius.parse(new Farenheit(grado, "C"));
                        valorobtenido = resultado.getValor();
                        cajaresul.setText(valorobtenido + "" + "°C");
                    } else if (selectSpinner2.equals("Farenheit")) {
                        cajaresul.setText(grado + "°F");
                    } else if (selectSpinner2.equals("Kelvin")) {
                        Kelvin resultado = kelvin.parse(new Farenheit(grado, "K"));
                        valorobtenido = resultado.getValor();
                        cajaresul.setText(valorobtenido + "" + "°K");
                    } else {
                        Toast.makeText(this, "Debe seleccionar un grado a convertir", Toast.LENGTH_LONG).show();
                    }
                    break;

                case "Kelvin":
                    if (selectSpinner2.equals("Celsius")) {
                        Celsius resultado = celsius.parse(new Kelvin(grado, "C"));
                        valorobtenido = resultado.getValor();
                        cajaresul.setText(valorobtenido + "" + "°C");
                    } else if (selectSpinner2.equals("Farenheit")) {
                        Farenheit resultado = farenheit.parse(new Kelvin(grado, "F"));
                        valorobtenido = resultado.getValor();
                        cajaresul.setText(valorobtenido + "" + "°F");
                    } else if (selectSpinner2.equals("Kelvin")) {
                        cajaresul.setText(grado + "" + "°K");
                    } else {
                        Toast.makeText(this, "Debe seleccionar un grado a convertir", Toast.LENGTH_LONG).show();
                    }
                    break;

                default:
                    Toast.makeText(this, "Debe seleccionar el tipo de grado", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}