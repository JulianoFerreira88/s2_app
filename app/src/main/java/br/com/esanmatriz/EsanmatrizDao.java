package br.com.esanmatriz;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface EsanmatrizDao {
    @GET(value = "/matrizes")
    Call<List<Esanmatriz>> findAll();

    @GET(value = "/matriz_completa/lactantes")
    Call<List<Esanmatriz>> findLactantes();

    @GET(value = "/matrizes/vazias")
    Call<List<Esanmatriz>> findVazias();

    @GET(value = "/matrizes/gestantes")
    Call<List<Esanmatriz>> findGestantes();

    @GET(value = "/matrizes/{id}")
    Call<Esanmatriz> findById(@Path("id") String id);
}
