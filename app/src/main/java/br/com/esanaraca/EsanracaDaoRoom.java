package br.com.esanaraca;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EsanracaDaoRoom {
    @Insert
    void insert(Esanraca raca);

    @Insert
    void insertAllRacas(List<Esanraca> racas);

    default void insertAll(List<Esanraca> racas) {
        deleteAll(racas);
        insertAllRacas(racas);
    }

    @Delete
    void deleteAll(List<Esanraca> racas);

    @Delete
    void delete(Esanraca raca);

    @Query("SELECT * FROM Esanraca r")
    List<Esanraca> findAll();

    @Query("SELECT * FROM Esanraca r WHERE r.cdraca = :id")
    Esanraca findById(int id);
}
