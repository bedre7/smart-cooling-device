package com.project.smartdevice;

import com.project.smartdevice.utilities.CoolerState;
import com.project.smartdevice.utilities.Operation;

public class MainProcessingPlatform implements IMainProcessingPlatform{

    private IActuator actuator;
    private ITemperatureSensor temperatureSensor;

    public MainProcessingPlatform(){
        actuator = new Actuator();
        temperatureSensor = new TemperatureSensor();
    }
    @Override
    public String sendRequestToActuator(Operation operation) {

        String response = null;
        CoolerState newState = null;
        CoolerState prevState = actuator.getCurrentState();

        switch (operation) {
            case TURNONCOOLER -> newState = actuator.turnOnCooler();
            case TURNOFFCOOLER -> newState = actuator.turnOffCooler();
        }

        if(prevState == newState)
        {
            response = "The cooler is already " + prevState;
        }
        else
        {
            response = "The cooler has been turned " + newState + " successfully";
        }

        return response;
    }

    @Override
    public String sendRequestToTempertureSensor() {
        String response = null;
        Double temperature = temperatureSensor.readTemperature();

        if(temperature == null)
        {
            response = "An error has occured: Unable to read temperature...";
        }
        else
        {
            response = "The current temperature is " + temperature + "°C";
        }

        return response;
    }
}
