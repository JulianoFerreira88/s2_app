package br.com.esanmovmaternidade;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EsanmovmaternidadeDaoRoom {
    @Insert
    void insertAll(List<Esanmovmaternidade> list);

    @Query("SELECT * FROM ESANMOVMATERNIDADE m WHERE m.cdpartodestino = :cdparto")
    List<Esanmovmaternidade> findEntradas(Integer cdparto);

    @Query("SELECT * FROM ESANMOVMATERNIDADE m WHERE m.cdpartoorigem = :cdparto")
    List<Esanmovmaternidade> findSaidas(Integer cdparto);
}
