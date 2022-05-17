package br.com.esanmatriz;

import androidx.room.*;

import java.util.List;

@Dao
public interface EsanmatrizDaoRoom {
    @Query("SELECT * FROM Esanmatriz")
    List<Esanmatriz> findALl();

    default void updateAll(List<Esanmatriz> matrizes) {
        deleteAll(matrizes);
        insertAll(matrizes);
    }

    @Query("SELECT * FROM Esanmatriz m WHERE m.estadoreprodutivo = 'L'")
    List<Esanmatriz> findLactantes();


    @Query("SELECT * FROM Esanmatriz m WHERE m.estadoreprodutivo = 'G'")
    List<Esanmatriz> findGestantes();

    @Query("SELECT * FROM Esanmatriz m WHERE m.estadoreprodutivo = 'V'")
    List<Esanmatriz> findVazias();

    @Insert
    void insertAll(List<Esanmatriz> Esanmatrizes);

    @Insert
    void insert(Esanmatriz Esanmatriz);

    @Delete
    void deleteAll(Esanmatriz... Esanmatrizes);

    @Update
    void updateAll(Esanmatriz... Esanmatrizes);


    @Delete
    void deleteAll(List<Esanmatriz> matrizes);
}
