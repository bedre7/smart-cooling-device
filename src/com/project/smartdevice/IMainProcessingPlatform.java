package com.project.smartdevice;

import com.project.smartdevice.patterns.observer.IObserver;
import com.project.smartdevice.utilities.Operation;

public interface IMainProcessingPlatform {
    boolean sendRequestToActuator(Operation operation);
    Double sendRequestToTempertureSensor();
    void attachUser(IObserver subscriber);
    void detachUser(IObserver subscriber);
}
