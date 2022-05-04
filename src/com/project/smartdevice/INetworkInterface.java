package com.project.smartdevice;

import com.project.smartdevice.utilities.Operation;

public interface INetworkInterface {
    Operation displayMenu();
    void displayMessage(String message);
    void promptUser(String request);
    void displayLogin();
    void logoutUser();
    void displayTemperature();
    void turnOnCooler();
    void turnOffCooler();
}
