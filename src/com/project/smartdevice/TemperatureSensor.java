package com.project.smartdevice;

import java.util.Random;

public class TemperatureSensor implements ITemperatureSensor{

    private final double efficiency;

    public TemperatureSensor(){
        efficiency = 0.95;
    }
    @Override
    public Double readTemperature() {
        Double temperature = null;
        Random rand = new Random();
        double error = rand.nextDouble(efficiency + 0.05);

        if(error < efficiency)
        {
            temperature = (rand.nextDouble(40) + 5);
        }

        return temperature;
    }
}
