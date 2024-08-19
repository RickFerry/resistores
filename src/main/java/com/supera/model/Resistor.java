package com.supera.model;

import com.supera.model.enums.ColorCode;

public class Resistor {
    private final int significantFigure1;
    private final int significantFigure2;
    private final int multiplier;
    private final double tolerance;

    public Resistor(int significantFigure1, int significantFigure2, int multiplier, double tolerance) {
        this.significantFigure1 = significantFigure1;
        this.significantFigure2 = significantFigure2;
        this.multiplier = multiplier;
        this.tolerance = tolerance;
    }

    public String getColorCode() {
        ColorCode firstBand = ColorCode.fromValue(significantFigure1);
        ColorCode secondBand = ColorCode.fromValue(significantFigure2);
        ColorCode multiplierBand = ColorCode.fromValue(multiplier);
        ColorCode toleranceBand = ColorCode.DOURADO;

        return firstBand.name().toLowerCase() + " " +
                secondBand.name().toLowerCase() + " " +
                multiplierBand.name().toLowerCase() + " " +
                toleranceBand.name().toLowerCase();
    }

    public static Resistor fromOhmsString(String ohms) {
        String[] parts = ohms.split(" ");
        String valuePart = parts[0].replace("k", "000").replace("M", "000000");
        double value = Double.parseDouble(valuePart);

        int multiplier = 0;
        while (value >= 100) {
            value /= 10;
            multiplier++;
        }

        int significantFigure1 = (int) value / 10;
        int significantFigure2 = (int) value % 10;

        return new Resistor(significantFigure1, significantFigure2, multiplier, 0.05);
    }
}

