package org.celsoaquino.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum TemperatureEnum {

    CELSIUS_TO_FAHRENHEIT("Celsius para Fahrenheit") {
        public BigDecimal convert(String valueToConvert) {
            BigDecimal value = this.toBigDecimal(valueToConvert);
            BigDecimal result = value.multiply(new BigDecimal(9));
            result = result.divide(new BigDecimal(5), RoundingMode.HALF_EVEN);
            result = result.add(new BigDecimal(32));
            result = result.setScale(2, RoundingMode.HALF_EVEN);
            return result;
        }
    },
    CELSIUS_TO_KELVIN("Celsius para Kelvin") {
        public BigDecimal convert(String valueToConvert) {
            BigDecimal value = this.toBigDecimal(valueToConvert);
            BigDecimal result = value.add(new BigDecimal("273.15"));
            result = result.setScale(2, RoundingMode.HALF_EVEN);
            return result;
        }
    },
    FAHRENHEIT_TO_CELSIUS("Fahrenheit para Celsius") {
        public BigDecimal convert(String valueToConvert) {
            BigDecimal value = this.toBigDecimal(valueToConvert);
            BigDecimal result = value.subtract(new BigDecimal(32));
            result = result.multiply(new BigDecimal(5));
            result = result.divide(new BigDecimal(9), RoundingMode.HALF_EVEN);
            result = result.setScale(2, RoundingMode.HALF_EVEN);
            return result;
        }
    },
    FAHRENHEIT_TO_KELVIN("Fahrenheit para Kelvin") {
        public BigDecimal convert(String valueToConvert) {
            BigDecimal value = this.toBigDecimal(valueToConvert);
            BigDecimal result = value.subtract(new BigDecimal(32));
            result = result.multiply(new BigDecimal(5));
            result = result.divide(new BigDecimal(9), RoundingMode.HALF_EVEN);
            result = result.add(new BigDecimal("273.15"));
            result = result.setScale(2, RoundingMode.HALF_EVEN);
            return result;
        }
    },
    KELVIN_TO_CELSIUS("Kelvin para Celsius") {
        public BigDecimal convert(String valueToConvert) {
            BigDecimal value = this.toBigDecimal(valueToConvert);
            BigDecimal result = value.subtract(new BigDecimal("273.15"));
            result = result.setScale(2, RoundingMode.HALF_EVEN);
            return result;
        }
    },
    KELVIN_TO_FAHRENHEIT("Kelvin para Fahrenheit") {
        public BigDecimal convert(String valueToConvert) {
            BigDecimal value = this.toBigDecimal(valueToConvert);
            BigDecimal result = value.subtract(new BigDecimal("237.15"));
            result = result.multiply(new BigDecimal(5));
            result = result.divide(new BigDecimal(9), RoundingMode.HALF_EVEN);
            result = result.add(new BigDecimal("32"));
            result = result.setScale(2, RoundingMode.HALF_EVEN);
            return result;
        }
    };

    private String description;

    TemperatureEnum(String description) {
        this.description = description;
    }

    public abstract BigDecimal convert(String valueToConvert);

    protected BigDecimal toBigDecimal(String value) {
        try {
            return new BigDecimal(value).setScale(4, RoundingMode.HALF_EVEN);
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
