package com.wwhale.tariff.request;

import com.wwhale.tariff.model.Client;

import java.util.List;
import java.util.Map;

public interface ClientRequest {

    List<Client> findAllClients();

    Map<String, Double> findAllClientsBalance();
}
