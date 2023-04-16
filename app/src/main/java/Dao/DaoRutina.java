package Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Entities.Rutina;

@Dao
public interface DaoRutina {
    @Insert
    void insert(Rutina rutina);
    @Delete
    void borrarRutina(Rutina rutina);
    @Query("SELECT * from Rutina ORDER BY NombreRutina desc")
    LiveData<List<Rutina>> seleccionarTablaRutinas();
    @Update
    void updateRutina(Rutina rutina);
}
