package com.supera.model.enums;

public enum ColorCode {
    PRETO(0, 1),
    MARROM(1, 10),
    VERMELHO(2, 100),
    LARANJA(3, 1_000),
    AMARELO(4, 10_000),
    VERDE(5, 100_000),
    AZUL(6, 1_000_000),
    VIOLETA(7, 10_000_000),
    CINZA(8, 100_000_000),
    BRANCO(9, 1_000_000_000),
    DOURADO(-1, 0.05);

    private final int value;
    private final double multiplier;

    ColorCode(int value, double multiplier) {
        this.value = value;
        this.multiplier = multiplier;
    }

    public int getValue() {
        return value;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public static ColorCode fromValue(int value) {
        for (ColorCode color : values()) {
            if (color.getValue() == value) {
                return color;
            }
        }
        throw new IllegalArgumentException("Valor de cor inválido: " + value);
    }
}

