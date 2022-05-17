package br.com.esanparto;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EsanpartoDaoRoom {
    @Insert
    void insertAll(List<Esanparto> partos);

    @Delete
    void deleteAll(List<Esanparto> partos);

    default void updateAll(List<Esanparto> partos) {
        deleteAll(partos);
        insertAll(partos);
    }

    @Query("SELECT * FROM ESANPARTO p WHERE p.cdcobertura = :cdcobertura")
    List<Esanparto> findALlByCodCobertura(Integer cdcobertura);
}
