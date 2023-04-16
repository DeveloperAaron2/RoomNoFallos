package bbdd;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import Dao.DaoEjercicio;
import Dao.DaoEjerciciosPorUsuario;
import Dao.DaoRutina;
import Dao.DaoUsuarios;
import Entities.Ejercicio;
import Entities.EjerciciosPorUsuario;
import Entities.Rutina;
import Entities.Usuarios;

@Database(entities = {Ejercicio.class, EjerciciosPorUsuario.class, Rutina.class, Usuarios.class},version = 1,exportSchema = false)
public abstract class LSBBDD extends RoomDatabase {
    public abstract DaoEjercicio daoEjercicio();
    public abstract DaoRutina daoRutina();
    public abstract DaoUsuarios daoUsuarios();

    public abstract DaoEjerciciosPorUsuario daoEjerciciosPorUsuario();
    private static final String DB_NOMBRE = "LSBBDD";

    private static final int NUMERO_HILOS = 4;
    public static final ExecutorService baseDatosEscritor = Executors.newFixedThreadPool(NUMERO_HILOS);

    private static volatile LSBBDD INSTANCIA;

    public static LSBBDD getBaseDatosContactos(final Context contexto){
        if (INSTANCIA == null) {
            synchronized (LSBBDD.class){
                if (INSTANCIA == null){
                    INSTANCIA = Room.databaseBuilder(contexto.getApplicationContext(),
                                    LSBBDD.class,DB_NOMBRE)
                            .addCallback(callBackEjercicios).build();

                }

            }
        }
        return INSTANCIA;
    }

    private static void InsertaEjercicios(DaoEjercicio daoEjercicio) {

        daoEjercicio.insert(new Ejercicio("Sentadilla","Multiarticular"));
        daoEjercicio.insert(new Ejercicio("Press de Banca","Multiarticular"));

    }

    private static Callback callBackEjercicios = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            baseDatosEscritor.execute(()->{
                DaoEjercicio daoEjercicio = INSTANCIA.daoEjercicio();
                DaoRutina daoRutina = INSTANCIA.daoRutina();
                DaoUsuarios daoUsuarios = INSTANCIA.daoUsuarios();
                InsertaEjercicios(daoEjercicio);
                InsertaUsuarios(daoUsuarios);
            });
        }

        private void InsertaUsuarios(DaoUsuarios daoUsuarios) {
            daoUsuarios.insert(new Usuarios("Aaron","1234"));
            daoUsuarios.insert(new Usuarios("German","1234"));
        }
    };
}
