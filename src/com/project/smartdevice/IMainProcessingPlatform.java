package com.project.smartdevice;

import com.project.smartdevice.utilities.Operation;

public interface IMainProcessingPlatform {
    String sendRequestToActuator(Operation operation);
    String sendRequestToTempertureSensor();
}
