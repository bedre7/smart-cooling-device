package com.project.smartdevice.patterns.factory;

import com.project.smartdevice.Actuator;
import com.project.smartdevice.IActuator;
import com.project.smartdevice.utilities.CoolerState;

public class ActuatoryFactory implements IActuatorFactory {
    @Override
    public IActuator factoryMethod() {
        Actuator actuator=new Actuator();
        actuator.setCurrentState(CoolerState.OFF);
        actuator.setEfficiency(0.97);

        return actuator;
    }
}
