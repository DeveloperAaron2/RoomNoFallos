package Entities;


import androidx.room.Entity;

public class EjerciciosPorUsuarioCrossRef {
    @Entity(primaryKeys = {"idUsuario","idEjercicio"})
    public class EjerciciosPorRutinaCrossRef {
        public int idUsuario;
        public int idEjercicio;
    }
}
