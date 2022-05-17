package br.com.esanfuncionario;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface EsanfuncionarioDao {
    @GET(value = "/funcionarios")
    Call<List<Esanfuncionario>> findALL();

    @GET(value = "/funcionarios/{id}")
    Call<Esanfuncionario> findALL(@Path("id") Integer id);
}
