package com.project.smartdevice;

import com.project.smartdevice.utilities.Operation;

public class SmartDeviceApp {
    public static void main(String[] args)
    {
        NetworkInterface networkInterface = new NetworkInterface();
        Operation operation = networkInterface.displayMenu();

        System.out.println(operation);

    }
}
