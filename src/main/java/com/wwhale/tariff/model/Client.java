package com.wwhale.tariff.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {

    private Long id;
    private String name;
    private String tariff;
    private Double balance;
}
