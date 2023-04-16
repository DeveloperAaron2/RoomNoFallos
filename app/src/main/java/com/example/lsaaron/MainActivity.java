package com.example.lsaaron;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import Dao.DaoEjercicio;
import Entities.Ejercicio;
import ViewModel.EjerciciosViewModel;
import bbdd.LSBBDD;

public class MainActivity extends AppCompatActivity {
    LSBBDD lsbbdd;
    DaoEjercicio daoEjercicio;
    private LiveData<List<Ejercicio>> ejercicios;
    private TextView textoPrueba;
    private EjerciciosViewModel ejerciciosViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.lsbbdd = LSBBDD.getBaseDatosContactos(this.getApplicationContext());
        ejerciciosViewModel = new ViewModelProvider(this).get(EjerciciosViewModel.class);
        ejercicios = ejerciciosViewModel.getEjercicios();
        this.textoPrueba = (TextView) findViewById(R.id.TextoPrueba);
        ejercicios.observeForever(ejercicios -> {
            for (Ejercicio ejercicio : ejercicios) {
                System.out.println(ejercicio);
                textoPrueba.append(ejercicio.toString() + "\n");
            }
        });
    }
}