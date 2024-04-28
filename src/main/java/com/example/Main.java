package com.example;

import java.io.IOException;

import com.example.api.CurrencyApi;
import com.example.models.CurrencyData;
import com.example.util.CurrencyResult;

public class Main {
    public static void main(String[] args) throws IOException {
        var c = new CurrencyApi();
        System.out.println("First Option: ");
        c.setFirstOption("eur");
        System.out.println("Second Option");
        c.setSecondOption("brl");

        var data = new CurrencyData();

        data.setFirstChoose(c.getFirstOption());
        data.setSecondChoose(c.getSecondOption());
        data.setAmount(1);
        data.getData();    

        var result = new CurrencyResult(data.getBaseCode(),data.getTargetCode(),data.getConversionRate(),data.getAmount());
        result.displayResutl();
    


    }
}