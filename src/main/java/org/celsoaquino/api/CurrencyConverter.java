package org.celsoaquino.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.celsoaquino.model.CurrencyData;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class CurrencyConverter {
    private static final String URL = "https://api.apilayer.com/currency_data/";
    /**
     * <p>to use the currency converter you need to get the token from the link</p>
     * @link <a href="https://apilayer.com/marketplace/currency_data-api/">TOKEN</a>
     */
    private static final String TOKEN = "";
    private static CurrencyData currency;
    public static CurrencyData convert(CurrencyData currency) {
             currency = get(currency.getFrom(), currency.getTo(), currency.getAmount());
       return currency;
    }

    private static CurrencyData get(String from, String to, String amount) {
        String URL_CONVERT_GET = URL + "convert?" + "to=" + to + "&from=" + from + "&amount=" + amount;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_CONVERT_GET))
                .header("apikey", TOKEN)
                .GET()
                .build();
        try {
            HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());

            currency = parse(send.body());

            return currency;
        } catch (InterruptedException | IOException | IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Falha na Conexão: " + e.getCause(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    private static CurrencyData parse(String body) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            currency = mapper.readValue(body, CurrencyData.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return currency;
    }
}
