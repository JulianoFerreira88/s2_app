package br.com.esanaraca;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface EsanracaDao {
    @GET(value = "/racas")
    Call<List<Esanraca>> findALl();
}
