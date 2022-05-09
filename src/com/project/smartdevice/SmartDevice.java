package com.project.smartdevice;

import com.project.smartdevice.utilities.CoolerState;
import com.project.smartdevice.utilities.Icons;
import com.project.smartdevice.utilities.Operation;

public class SmartDevice implements ISmartDevice{
    private final INetworkInterface networkInterface;

    SmartDevice(){
        networkInterface = new NetworkInterface();
    }
    @Override
    public void run()
    {
        User user = this.networkInterface.displayLogin();
        //simulating the working mechanism of the device
        this.networkInterface.displayMessage(Icons.LOADING + " Starting the device ...");
        Tools.delay();
        this.networkInterface.displayMessage(Icons.SETTING + "" + CoolerState.TESTING);
        Tools.delay();

        Operation choice;
        do{
            Tools.clearScreen();
            choice = this.networkInterface.displayMenu();
            this.networkInterface.displayMessage("");
            switch (choice){
                case DISPLAYTEMPERATURE -> this.networkInterface.displayTemperature();
                case TURNONCOOLER -> this.networkInterface.turnOnCooler();
                case TURNOFFCOOLER -> this.networkInterface.turnOffCooler();
                case LOGOUT -> this.networkInterface.logoutUser(user);
            }

            Tools.redirect("\nPress Enter to continue...");
            this.networkInterface.displayMessage(Icons.LOADING + " Redirecting you to the main menu...");
            Tools.delay();

        }while(choice != Operation.LOGOUT);
    }
}
