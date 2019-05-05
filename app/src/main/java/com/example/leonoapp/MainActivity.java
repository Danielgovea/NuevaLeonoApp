package com.example.leonoapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends Activity {
    public SharedPreferences sharedPreferences;
    public MediaPlayer mplayer;
    public int contadorki;
    public int maxhp;
    public int hpactual;
    public int danototal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = this.getSharedPreferences("com.example.leonoapp", Context.MODE_PRIVATE);
        maxhp = 75;
        danototal = 0;
        contadorki = sharedPreferences.getInt("actualki", 0);
        hpactual = sharedPreferences.getInt("actualhp", 0);
        mostrarki();
        setMaxhp();
        setDanoTotal();
        setActualHp();
    }

    public void setsumaHpActual(View vista){

        TextView actualhptext = (TextView) findViewById(R.id.contadorActualHp);
        EditText hpsuma = (EditText) findViewById(R.id.dañocuratextbox);
        if(hpsuma.getText().toString().equals(null) || hpsuma.getText().toString().equals("") ){
             actualhptext.setText("Hp= " + hpactual);
        }else {
            Integer hsuma = Integer.parseInt(hpsuma.getText().toString());
            hpactual = hpactual + hsuma;
            hpsuma.setText("");
            actualhptext.setText("Hp= " + hpactual);
            sharedPreferences.edit().putInt("actualhp", hpactual).apply();
        }
    }

    public void setrestaHpActual(View vista){
        TextView actualhptext = (TextView) findViewById(R.id.contadorActualHp);
        EditText hpresta = (EditText) findViewById(R.id.dañocuratextbox);
        if(hpresta.getText().toString().equals(null) || hpresta.getText().toString().equals("") ){
            actualhptext.setText("Hp= " + hpactual);
        }else {
            Integer resta = Integer.parseInt(hpresta.getText().toString());
            hpactual = hpactual - resta;
            hpresta.setText("");
            actualhptext.setText("Hp= " + hpactual);
            sharedPreferences.edit().putInt("actualhp", hpactual).apply();
        }
    }

    public void setMaxhp(){
        TextView maxhptext = (TextView) findViewById(R.id.contadorMaxHp);
        maxhptext.setText("MaxHp= " + maxhp);
    }
    public void setDanoTotal(){
        TextView danototaltext = (TextView) findViewById(R.id.danototal);
        danototaltext.setText("Daño Total= " + danototal);
    }
        public void setActualHp(){
        TextView actualHpText = (TextView) findViewById(R.id.contadorActualHp);
        actualHpText.setText("Hp= " + hpactual);
        }


    public void incrementaki(View vista) {
        sharedPreferences.edit().putInt("actualki",++contadorki).apply();
        mostrarki();
    }

    public void decrementaki(View vista) {
        sharedPreferences.edit().putInt("actualki",--contadorki).apply();
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
        int suma = random + 11;
        TextView resultado20 = (TextView) findViewById(R.id.dado20texto);
        resultado20.setText(random + "+7Strength + 4 Proficiency=" + suma);
        playAudioDice();
    }

    public void botondado8(View vista) {
        int random8 = dado8();
        int random6 = dado6();
        int suma = random8 + 7 + random6;
        TextView resultado8 = (TextView) findViewById(R.id.dado8texto);
        resultado8.setText(random8+"BludgeoningDamage+"+random6+"IceDamage"+" +7Strength =" + suma+ "Damage");
        danototal = danototal + suma;
        setDanoTotal();
        playAudioSlap();
    }



    public void clear(View view){
        danototal = 0;
        setDanoTotal();
    }

   /* public void botondado6(View vista) {
        int random = dado6();
        int suma = random + 7;
        TextView resultado6 = (TextView) findViewById(R.id.dado6texto);
        resultado6.setText(random + " + 7Strength= " + suma);
    }*/

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

    public void playAudioSlap(){
        mplayer = MediaPlayer.create(this,R.raw.slap);
        mplayer.start();
    }
    public void playAudioDice(){
        mplayer = MediaPlayer.create(this,R.raw.dice);
        mplayer.start();
    }
}
