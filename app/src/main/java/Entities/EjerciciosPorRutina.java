package Entities;





import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.room.TypeConverters;

import java.util.List;

@TypeConverters(EjercicioListConverter.class)
public class EjerciciosPorRutina {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @Embedded
    public Rutina rutina;
    @Relation(
            parentColumn = "idRutina",
            entityColumn = "idEjercicio",
            associateBy = @Junction(EjerciciosPorRutinaCrossRef.class)
    )

    public List<Ejercicio> ejercicios;
}
