package Entities;



import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Junction;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.room.TypeConverters;

import java.util.List;
@Entity(tableName = "EjerciciosPorUsuario")
@TypeConverters(EjercicioListConverter.class)
public class EjerciciosPorUsuario {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @Embedded
    public Usuarios usuarios;
    @Relation(
            parentColumn = "idUsuario",
            entityColumn = "idEjercicio",
            associateBy = @Junction(EjerciciosPorUsuarioCrossRef.class)
    )
    public List<Ejercicio> ejercicios;
}
