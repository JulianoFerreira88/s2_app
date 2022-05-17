package br.com.esancobertura;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface EsancoberturaDao {
    @GET(value = "/coberturas")
    Call<List<Esancobertura>> findAll();

    @GET(value = "/coberturas/{cdmatriz}")
    Call<List<Esancobertura>> findAll(@Path("cdmatriz") long cdmatriz);
}
