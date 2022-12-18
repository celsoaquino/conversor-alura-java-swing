package org.celsoaquino;

import org.celsoaquino.view.Menu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Menu();
        });

        /*CurrencyData currencyData = CurrencyConverter.convert("BRL", "USD", "1.5");
        System.out.println(currencyData.getResult());*/
    }
}