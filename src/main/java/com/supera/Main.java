package com.supera;

import com.supera.model.Resistor;

public class Main {
    public static void main(String[] args) {
        String[] examples = {
                "10 ohms", "100 ohms", "220 ohms", "330 ohms",
                "470 ohms", "680 ohms", "1k ohms", "2M ohms"
        };

        for (String example : examples) {
            Resistor resistor = Resistor.fromOhmsString(example);
            System.out.println(example + " => " + resistor.getColorCode());
        }
    }
}
