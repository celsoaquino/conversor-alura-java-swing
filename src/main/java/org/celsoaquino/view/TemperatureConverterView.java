package org.celsoaquino.view;

import org.celsoaquino.model.TemperatureEnum;

import javax.swing.*;

public class TemperatureConverterView {

    private final TemperatureEnum[] temperatureToConvert = TemperatureEnum.values();

    public TemperatureConverterView() {
        this.init();
    }

    public void init() {
        String entry;
        while (true) {
            entry = JOptionPane.showInputDialog(null, "Insira um valor:");
            if (entry == null) break;
            try {
                Double.parseDouble(entry);
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido");
            }
        }

        var result = (TemperatureEnum) JOptionPane.showInputDialog(null, "Escolha uma opção",
                "Menu", JOptionPane.PLAIN_MESSAGE, null, temperatureToConvert, temperatureToConvert[0]);

        var type = temperatureToConvert[result.ordinal()];

        var convertedValue = type.convert(entry);

        JOptionPane.showMessageDialog(null, entry + "° " + type.getDescription() + " " + convertedValue + "°");

        new ProceedView();
    }
}
