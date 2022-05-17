package br.com.esanmovanimais;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EsanmovanimaisDaoRoom {
    @Insert
    void insertAll(List<Esanmovanimais> esanmovanimais);

    @Query("SELECT * FROM ESANMOVANIMAIS m WHERE m.cdrelacionado = :cdparto")
    List<Esanmovanimais> findMovimentacoes(Integer cdparto);
}
