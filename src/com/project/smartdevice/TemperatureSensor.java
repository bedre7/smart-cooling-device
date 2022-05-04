package com.project.smartdevice;

import java.text.DecimalFormat;
import java.util.Random;

public class TemperatureSensor implements ITemperatureSensor{

    private final double efficiency;

    public TemperatureSensor(){
        efficiency = 0.97;
    }
    @Override
    public Double readTemperature() {
        Double temperature = null;
        Random rand = new Random();
        double error = rand.nextDouble(efficiency + 0.03);

        if(error < efficiency)
        {
            temperature = (rand.nextDouble(30) + 5);

        }
        else
            return null;

        return Double.parseDouble(new DecimalFormat("##.#").format(temperature));
    }
}
