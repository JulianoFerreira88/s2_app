package br.com.esanparto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface EsanpartoDao {
    @GET(value = "/partos/{cdmatriz}")
    Call<List<Esanparto>> findAll(@Path("cdmatriz") long cdmatriz);

    @GET(value = "/partos")
    Call<List<Esanparto>> findALl();
}
