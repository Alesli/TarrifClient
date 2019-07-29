package com.wwhale.tariff.api;

import com.wwhale.tariff.model.Client;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ClientApi {

    @GET("xml/client/findAll")
    Call<List<Client>> findAllXml();

    @GET("json/client/findAll")
    Call<List<Client>> findAllJson();
}
