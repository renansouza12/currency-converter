package com.example.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class CurrencyApi {
    private String customUrl;
    private String firstOption;
    private String secondOption;

    public String currencyRequest() {
        try (Scanner scanner = new Scanner(new File("apikey.txt"))) {
            if (scanner.hasNext()) {
                String apiKey = scanner.next();
                setCustomUrl(String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s", apiKey, getFirstOption(), getSecondOption()));
            } else {
                System.err.println("API Key not found in the file.");
                return null;
            }
        } catch (FileNotFoundException e) {
            System.err.println("API key file not found: " + e.getMessage());
            return null;
        }

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(getCustomUrl()))
                .build();

        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return response.body();
            } else {
                System.err.println("Failed to fetch data. HTTP error code: " + response.statusCode());
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Request failed: " + e.getMessage());
        }
        return null;
    }

    public String getCustomUrl() {
        return customUrl;
    }

    public void setCustomUrl(String customUrl) {
        this.customUrl = customUrl;
    }

    public String getFirstOption() {
        return firstOption;
    }

    public void setFirstOption(String firstOption) {
        this.firstOption = firstOption;
    }

    public String getSecondOption() {
        return secondOption;
    }

    public void setSecondOption(String secondOption) {
        this.secondOption = secondOption;
    }
}
