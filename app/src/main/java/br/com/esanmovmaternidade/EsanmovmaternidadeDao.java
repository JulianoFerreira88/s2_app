package br.com.esanmovmaternidade;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface EsanmovmaternidadeDao {
    @GET(value = "/movmaternidade")
    Call<List<Esanmovmaternidade>> findALl();
}
