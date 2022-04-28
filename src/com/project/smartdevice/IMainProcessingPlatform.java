package com.project.smartdevice;

import com.project.smartdevice.utilities.CoolerState;
import com.project.smartdevice.utilities.Operation;

public interface IMainProcessingPlatform {
    CoolerState sendRequestToActuator(Operation operation);
    double sendRequestToTempertureSensor();
}
