package Entities;




import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class EjercicioListConverter {
    @TypeConverter
    public static List<Ejercicio> fromString(String value) {
        Type listType = new TypeToken<List<Ejercicio>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromList(List<Ejercicio> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
