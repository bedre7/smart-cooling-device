package com.project.smartdevice;

import java.text.DecimalFormat;
import java.util.Random;

public class TemperatureSensor implements ITemperatureSensor{

    private double efficiency;

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public Double readTemperature() {
        Double temperature;
        Random rand = new Random();
        //The temperature sensor works 97% of the time
        double error = rand.nextDouble(efficiency + 0.03);

        if(error < efficiency)
        {
            temperature = (rand.nextDouble(30) + 10);
        }
        else
            return null;

        return Double.parseDouble(new DecimalFormat("##.#").format(temperature));
    }
}
