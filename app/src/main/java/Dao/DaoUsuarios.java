package Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Entities.Usuarios;

@Dao
public interface DaoUsuarios {

    @Insert
    void insert(Usuarios usuarios);
    @Delete
    void borrarUsuario(Usuarios usuarios);
    @Query("SELECT * from Usuarios ORDER BY nombreUsuario desc")
    LiveData<List<Usuarios>> seleccionarTablaUsuarios();
    @Update
    void updateUsuario(Usuarios usuarios);
}
