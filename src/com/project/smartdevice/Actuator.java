package com.project.smartdevice;

import com.project.smartdevice.utilities.CoolerState;

import java.util.Random;

public class Actuator implements IActuator{

    private CoolerState currentState;
    private final double efficiency;

    public Actuator()
    {
        currentState = CoolerState.OFF;
        efficiency = 0.97;
    }

    public CoolerState getCurrentState() {
        return currentState;
    }

    @Override
    public CoolerState turnOnCooler() {
        Random rand = new Random();
        double error = rand.nextDouble(efficiency + 0.03);

        if(error < efficiency){
            if(currentState == CoolerState.OFF)
                currentState = CoolerState.ON;
        }
        else{
            currentState = CoolerState.OUTOFSERVICE;
        }

        return currentState;
    }

    @Override
    public CoolerState turnOffCooler() {
        Random rand = new Random();
        double error = rand.nextDouble(efficiency + 0.03);

        if(error < efficiency){
            if(currentState == CoolerState.ON)
                currentState = CoolerState.OFF;
        }
        else{
            currentState = CoolerState.OUTOFSERVICE;
        }

        return currentState;
    }

}
