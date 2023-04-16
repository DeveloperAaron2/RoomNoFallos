package Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import Entities.EjerciciosPorUsuario;

@Dao
public interface DaoEjerciciosPorUsuario {

    @Transaction
    @Query("SELECT * FROM Usuarios")
    public List<EjerciciosPorUsuario> getEjerciciosPorUsuario();

}
