package org.celsoaquino.view;

import javax.swing.*;

public class Menu {
    protected final Object[] converters = {"Conversor de Moeda", "Conversor de Temperatura"};

    public Menu() {
        this.init();
    }

    public void init() {
        String result = JOptionPane.showInputDialog(null, "Escolha uma opção",
                "Menu", JOptionPane.PLAIN_MESSAGE, null, converters, "").toString();
        switch (result) {
            case "Conversor de Moeda" -> new CurrencyConverterView();
            case "Conversor de Temperatura" -> new TemperatureConverterView();
            default -> JOptionPane.showMessageDialog(null,"Opção não existe: " + result);
        }
    }
}
