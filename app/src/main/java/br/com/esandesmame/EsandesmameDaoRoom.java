package br.com.esandesmame;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EsandesmameDaoRoom {
    @Insert
    void insertAll(List<Esandesmame> desmames);

    @Delete
    void deleteAll(List<Esandesmame> desmames);

    default void updateAll(List<Esandesmame> desmames) {
        deleteAll(desmames);
        insertAll(desmames);
    }

    @Query("SELECT * FROM Esandesmame")
    List<Esandesmame> findAll();

    @Query("SELECT * FROM Esandesmame d WHERE d.cdcobertura = :cod")
    List<Esandesmame> findAllByCoberturaCod(int cod);
}
