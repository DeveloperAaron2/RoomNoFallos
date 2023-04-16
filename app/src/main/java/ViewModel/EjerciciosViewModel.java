package ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import Dao.DaoEjercicio;
import Entities.Ejercicio;
import bbdd.LSBBDD;

public class EjerciciosViewModel extends AndroidViewModel {
    private DaoEjercicio daoEjercicio;
    private LiveData<List<Ejercicio>> ejercicios;
    public EjerciciosViewModel(@NonNull Application application) {
        super(application);
        LSBBDD lsbbdd = LSBBDD.getBaseDatosContactos(application);
        daoEjercicio = lsbbdd.daoEjercicio();
        ejercicios= daoEjercicio.seleccionarTablaEjercicios();

    }

    public LiveData<List<Ejercicio>> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(LiveData<List<Ejercicio>> ejercicios) {
        this.ejercicios = ejercicios;
    }
}
