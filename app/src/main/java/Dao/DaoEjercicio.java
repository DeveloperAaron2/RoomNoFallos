package Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Entities.Ejercicio;

@Dao
public interface DaoEjercicio {

    @Insert
    void insert(Ejercicio ejercicio);
    @Delete
    void borrarEjercicio(Ejercicio ejercicio);
    @Query("SELECT * from Ejercicios")
    LiveData<List<Ejercicio>> seleccionarTablaEjercicios();
    @Update
    void updateEjercicio(Ejercicio ejercicio);

}
