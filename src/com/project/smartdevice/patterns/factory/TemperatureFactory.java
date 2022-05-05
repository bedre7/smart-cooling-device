package com.project.smartdevice.patterns.factory;

import com.project.smartdevice.ITemperatureSensor;
import com.project.smartdevice.TemperatureSensor;

public class TemperatureFactory implements ITemperatureFactory{
    @Override
    public ITemperatureSensor factoryMethod() {
        TemperatureSensor temperatureSensor=new TemperatureSensor();
        temperatureSensor.setEfficiency(0.97);
        return temperatureSensor;
    }
}
