package br.com.esancobertura;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EsancoberturaDaoRoom {
    @Insert
    void insertAll(List<Esancobertura> coberturas);

    @Delete
    void deleteAll(List<Esancobertura> coberturas);

    @Query("SELECT * FROM Esancobertura c WHERE c.cdmatriz = :idMatriz")
    List<Esancobertura> findALlByMatriz(int idMatriz);

    default void updateAll(List<Esancobertura> coberturas) {
        deleteAll(coberturas);
        insertAll(coberturas);
    }
}
