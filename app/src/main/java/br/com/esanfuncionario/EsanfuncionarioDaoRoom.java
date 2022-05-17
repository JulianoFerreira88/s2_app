package br.com.esanfuncionario;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EsanfuncionarioDaoRoom {
    @Insert
    void insert(Esanfuncionario funcionario);

    @Insert
    void insertAll(List<Esanfuncionario> funcionarios);

    @Delete
    void delete(Esanfuncionario funcionario);

    @Query("SELECT * FROM ESANFUNCIONARIO f")
    List<Esanfuncionario> findAll();

    @Query("SELECT * FROM ESANFUNCIONARIO f WHERE f.cdfuncionario = :cdfuncionario")
    Esanfuncionario findById(Integer cdfuncionario);
}
