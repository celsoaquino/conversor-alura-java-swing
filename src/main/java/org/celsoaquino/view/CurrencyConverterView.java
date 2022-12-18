package org.celsoaquino.view;

import org.celsoaquino.api.CurrencyConverter;
import org.celsoaquino.model.CurrencyData;
import org.celsoaquino.model.CurrencyEnum;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyConverterView {

    private final CurrencyEnum[] currencyToConvert = CurrencyEnum.values();

    public CurrencyConverterView() {
        this.init();
    }

    public void init() {
        String amount;

        while (true) {
            amount = JOptionPane.showInputDialog(null, "Insira um valor:");
            if (amount == null) break;
            try{
                Double.parseDouble(amount);
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido");
            }
        }

        var result = (CurrencyEnum) JOptionPane.showInputDialog(null, "Escolha uma opção",
                "Menu", JOptionPane.PLAIN_MESSAGE, null, currencyToConvert, currencyToConvert[0]);

        var type = CurrencyEnum.values()[result.ordinal()];

        var convertData = new CurrencyData(type.getFrom(), type.getTo(), amount);

        var convertResult = CurrencyConverter.convert(convertData);

        var value = new BigDecimal(convertResult.getResult()).setScale(2, RoundingMode.HALF_EVEN);

        JOptionPane.showMessageDialog(null, "O valor da conversão é de " + type.getTo() + " " + value);

        new ProceedView();
    }
}
