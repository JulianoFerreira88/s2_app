package br.com.esandesmame;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface EsandesmameDao {
    @GET(value = "/desmames")
    Call<List<Esandesmame>> findAll();

    @GET(value = "/desmames/{cdmatriz}")
    Call<List<Esandesmame>> findLactantes(@Path("cdmatriz") Integer cdmatriz);

}
