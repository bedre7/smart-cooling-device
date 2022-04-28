package com.project.smartdevice.utilities;

public enum CoolerState {
    OFF("The cooler is turned Off"),
    ON("The cooler is turned On"),
    TESTING("Testing ..."),
    WAITING("Waiting ..."),
    DETECTING("Detecting Temperature ..."),
    PROCESSING("Your request is being processed..."),
    OUTOFSERVICE("The cooler is out of service");

    public String details;

    CoolerState(String details){
        this.details = details;
    }

    @Override
    public String toString() {
        return details;
    }
}
