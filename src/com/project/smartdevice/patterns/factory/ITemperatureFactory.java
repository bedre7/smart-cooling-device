package com.project.smartdevice.patterns.factory;

import com.project.smartdevice.ITemperatureSensor;

public interface ITemperatureFactory {
    ITemperatureSensor factoryMethod();
}
