package com.project.smartdevice;

import com.project.smartdevice.utilities.CoolerState;

public interface IActuator {
    CoolerState turnOnCooler();
    CoolerState turnOffCooler();
}
