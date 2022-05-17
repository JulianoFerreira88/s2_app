package br.com.esantipoparto;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EsantipopartoDaoRoom {
    @Insert
    void insertAll(List<Esantipoparto> tipos);

    @Insert
    void insert(Esantipoparto tipoparto);

    @Delete
    void deleteAll(List<Esantipoparto> tipos);

    @Delete
    void delete(Esantipoparto tipoparto);

    @Query("SELECT * FROM Esantipoparto r")
    List<Esantipoparto> findAll();
}
