package com.project.smartdevice.utilities;

public enum CoolerState {
    OFF("off"),
    ON("On"),
    TESTING("The device is being tested ..."),
    WAITING("Waiting for response ..."),
    DETECTING("Detecting Temperature ..."),
    PROCESSING("Your request is being processed..."),
    OUTOFSERVICE("The cooler is out of service");

    public final String detail;

    CoolerState(String detail){
        this.detail = detail;
    }

    @Override
    public String toString() {
        return detail;
    }
}
