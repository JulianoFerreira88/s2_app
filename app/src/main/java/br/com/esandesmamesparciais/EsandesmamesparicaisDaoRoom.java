package br.com.esandesmamesparciais;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EsandesmamesparicaisDaoRoom {
    @Insert
    void insertAll(List<Econdesmamesparciais> econdesmamesparciais);

    @Delete
    void deleteAll(List<Econdesmamesparciais> econdesmamesparciais);

    default void updateAll(List<Econdesmamesparciais> econdesmamesparciais) {
        deleteAll(econdesmamesparciais);
        insertAll(econdesmamesparciais);
    }

    @Query("SELECT * FROM Econdesmamesparciais d WHERE d.cdcobertura = :cdcobertura")
    List<Econdesmamesparciais> findByIdCobertura(Integer cdcobertura);
}
