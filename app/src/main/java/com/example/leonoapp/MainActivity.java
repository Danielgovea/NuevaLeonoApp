package com.example.leonoapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends Activity {

    public int contadorki;
    public int maxhp;
    public int hpactual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maxhp = 52;
        contadorki = 0;
        hpactual = maxhp;

        mostrarki();
        setMaxhp();
    }

    public void setsumaHpActual(View vista){
        int suma;
        TextView actualhptext = (TextView) findViewById(R.id.contadorActualHp);
        EditText hpsuma = (EditText) findViewById(R.id.dañocuratextbox);
        String hsuma = hpsuma.getText().toString();
        if(hsuma == null){
            suma = 0;
        }else{
            suma = Integer.parseInt(hsuma);
            hpactual = hpactual+suma;
            hpsuma.setText("");
            actualhptext.setText("Hp= " + hpactual);
        }
    }

    public void setrestaHpActual(View vista){
        TextView actualhptext = (TextView) findViewById(R.id.contadorActualHp);
        EditText hpresta = (EditText) findViewById(R.id.dañocuratextbox);
        int resta = Integer.parseInt(hpresta.getText().toString());
        hpactual = hpactual-resta;
        hpresta.setText("");
        actualhptext.setText("Hp= " + hpactual);
    }

    public void setMaxhp(){
        TextView maxhptext = (TextView) findViewById(R.id.contadorMaxHp);
        maxhptext.setText("MaxHp= " + maxhp);
    }

    public void incrementaki(View vista) {
        contadorki++;
        mostrarki();
    }

    public void decrementaki(View vista) {
        contadorki--;
        mostrarki();
    }

    public void incrementaMaxHp(View vista) {
        maxhp++;
        setMaxhp();
    }

    public void decrementaMaxHp(View vista) {
        maxhp--;
        setMaxhp();
    }


    public void mostrarki() {
        TextView resultadoki = (TextView) findViewById(R.id.contadorkitexto);
        resultadoki.setText("Ki= " + contadorki);
    }

    public void botondado20(View vista) {

        int random = dado20();
        int suma = random + 8;
        TextView resultado20 = (TextView) findViewById(R.id.dado20texto);
        resultado20.setText(random + "+5Dex+3Proficiency=" + suma);
    }

    public void botondado8(View vista) {
        int random = dado8();
        int suma = random + 5;
        TextView resultado8 = (TextView) findViewById(R.id.dado8texto);
        resultado8.setText(random + " +5Dex= " + suma);
    }

    public void botondado6(View vista) {
        int random = dado6();
        int suma = random + 5;
        TextView resultado6 = (TextView) findViewById(R.id.dado6texto);
        resultado6.setText(random + " +5Dex= " + suma);
    }

    public static int dado20() {
        int random20 = ThreadLocalRandom.current().nextInt(1, 21);
        return random20;
    }

    public static int dado8() {
        int random8 = ThreadLocalRandom.current().nextInt(1, 9);
        return random8;
    }

    public static int dado6() {
        int random6 = ThreadLocalRandom.current().nextInt(1, 7);
        return random6;
    }
}
