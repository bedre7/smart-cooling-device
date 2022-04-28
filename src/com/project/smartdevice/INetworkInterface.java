package com.project.smartdevice;

import com.project.smartdevice.utilities.Operation;

public interface INetworkInterface {
    Operation menu();
    void displayMessage(String message);
    void displayLogin();
    void displayTemperature();
    void turnOnCooler();
    void turnOffCooler();
}
