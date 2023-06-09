package Entities;



import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Usuarios")
public class Usuarios {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idUsuario")
    private int idUsuario;
    @ColumnInfo(name = "nombreUsuario")
    private String nombreUsuario;
    @ColumnInfo(name = "contraseña")
    private String contraseña;

    public Usuarios( String nombreUsuario, String contraseña) {

        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "idUsuario=" + idUsuario +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }

}
