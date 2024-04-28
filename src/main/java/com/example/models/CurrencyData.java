package com.example.models;
import com.example.api.CurrencyApi;
import com.google.gson.Gson;

public class CurrencyData {
    private String firstChoose;
    private String secondChoose;
    private int amount;

    private String baseCode;
    private String targetCode;
    private double conversionRate;

    public void getData() {
        var gson = new Gson();

        var currencyApi = new CurrencyApi();
        currencyApi.setFirstOption(getFirstChoose());
        currencyApi.setSecondOption(getSecondChoose());

        String json = currencyApi.currencyRequest();
        CurrencyFormat currencyFormat = gson.fromJson(json, CurrencyFormat.class);
        
        setBaseCode(currencyFormat.base_code());
        setTargetCode(currencyFormat.target_code());
        setConversionRate(currencyFormat.conversion_rate());
    }

    public String getFirstChoose() {
        return firstChoose;
    }

    public void setFirstChoose(String firstChoose) {
        this.firstChoose = firstChoose;
    }

    public String getSecondChoose() {
        return secondChoose;
    }

    public void setSecondChoose(String secondChoose) {
        this.secondChoose = secondChoose;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
