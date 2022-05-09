package com.project.smartdevice;

import com.project.smartdevice.patterns.factory.ActuatorFactory;
import com.project.smartdevice.patterns.factory.IActuatorFactory;
import com.project.smartdevice.patterns.factory.ITemperatureFactory;
import com.project.smartdevice.patterns.factory.TemperatureFactory;
import com.project.smartdevice.patterns.observer.IObserver;
import com.project.smartdevice.patterns.observer.ISubject;
import com.project.smartdevice.patterns.observer.Publisher;
import com.project.smartdevice.utilities.CoolerState;
import com.project.smartdevice.utilities.Icons;
import com.project.smartdevice.utilities.Operation;

public class MainProcessingPlatform implements IMainProcessingPlatform{

    private final IActuator actuator;
    private final ITemperatureSensor temperatureSensor;
    private final ISubject publisher;
    private final IActuatorFactory actuatorFactory;
    private final ITemperatureFactory temperatureFactory;

    public MainProcessingPlatform(){
        actuatorFactory = new ActuatorFactory();
        actuator = actuatorFactory.factoryMethod();
        temperatureFactory=new TemperatureFactory();
        temperatureSensor = temperatureFactory.factoryMethod();
        publisher = new Publisher();
    }

    @Override
    public void attachUser(IObserver subscriber) {
        this.publisher.attach(subscriber);
    }

    @Override
    public void detachUser(IObserver subscriber) {
        this.publisher.detach(subscriber);
    }

    @Override
    public boolean sendRequestToActuator(Operation operation) {
        boolean switched = false;
        CoolerState newState = null;
        CoolerState prevState = actuator.getCurrentState();

        switch (operation)
        {
            case TURNONCOOLER -> newState = actuator.turnOnCooler();
            case TURNOFFCOOLER -> newState = actuator.turnOffCooler();
        }

        if(newState == CoolerState.OUTOFSERVICE){
            this.publisher.notify(Icons.OUTOFSERVICE + " " + CoolerState.OUTOFSERVICE + " Logging you out...");
            Tools.delay();
            System.exit(0);
        }
        else if(prevState == newState)
            this.publisher.notify("The cooler is already " + prevState);
        else
            switched = true;

        return switched;
    }

    @Override
    public Double sendRequestToTempertureSensor() {
        Double temperature = temperatureSensor.readTemperature();

        //if the temperature sensor failed to read temperature accurately
        if(temperature == null){
            this.publisher.notify(Icons.ERROR + " Error: Unable to read temperature, logging you out...");
            Tools.delay();
            System.exit(0);
        }
        else if(temperature > 30){          //critical temperature level is reached
            this.publisher.notify("Temperature is too high " + Icons.WARNING
                                    + ", you might want to turn on the cooler");
        }
        return temperature;
    }
}
