package com.project.smartdevice;

import com.project.smartdevice.utilities.CoolerState;
import com.project.smartdevice.utilities.Icons;
import com.project.smartdevice.utilities.Operation;

public class MainProcessingPlatform implements IMainProcessingPlatform{

    private IActuator actuator;
    private ITemperatureSensor temperatureSensor;
//    private ISubject publisher;

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

        if(newState == CoolerState.OUTOFSERVICE){
            //notify subscriber
        }
        else if(prevState == newState){
            response = "The cooler is already " + prevState;
            //notify subscriber
        }

        return response;
    }

    @Override
    public Double sendRequestToTempertureSensor() {
        String response = null;
        Double temperature = temperatureSensor.readTemperature();

        if(temperature == null){
            response = Icons.ERROR + " Error: Unable to read temperature...";
        }
        else if(temperature > 30){
            response = "Temperature is too high " + Icons.WARNING
                        + ", you might want to turn on the cooler";
        }

        if(response != null)
            System.out.print("");//notify subscriber

        return temperature;
    }
}
