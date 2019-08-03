package com.wwhale.tariff.request.impl;

import com.wwhale.tariff.api.ClientApi;
import com.wwhale.tariff.model.Client;
import com.wwhale.tariff.request.ClientRequest;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientRequestImpl implements ClientRequest {

    private static final String BASE_URL = "http://localhost:8090/api";
    private static OkHttpClient httpClient = new OkHttpClient();
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    @Override
    public List<Client> findAllClients() {
        ClientApi clientApi = (ClientApi) createService(Client.class);
        Call<List<Client>> callEmployeeList = clientApi.findAllJson();
        return (List<Client>) getAllResults(callEmployeeList);
    }

    @Override
    public Map<String, Double> findAllClientsBalance() {
        List<Client> clientList = findAllClients();
        Map<String, Double> employeeMap = new HashMap<>();
        for (Client client : clientList) {
            employeeMap.put(client.getId().toString(), client.getBalance());
        }
        return employeeMap;
    }

    private <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }

    private <R> R getAllResults(Call<List<R>> callClass) {
        try {
            Response<List<R>> response = callClass.execute();
            return (R) response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
