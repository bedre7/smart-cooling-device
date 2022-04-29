package com.project.smartdevice;

import com.project.smartdevice.utilities.Operation;

import java.util.Scanner;

public class NetworkInterface implements INetworkInterface {

    private IMainProcessingPlatform mainPP;

    public NetworkInterface(){
        mainPP = new MainProcessingPlatform();
    }
    @Override
    public Operation displayMenu() {

        this.displayMessage("+--------------------------------------------------------+");
        this.displayMessage("|                           MENU                         |");
        this.displayMessage("+--------------------------------------------------------+");
        this.displayMessage("       [1] Display Temperature");
        this.displayMessage("       [2] Turn On the Cooler");
        this.displayMessage("       [3] Turn Off the Cooler");
        this.displayMessage("       [4] Log Out");
        System.out.print("\nEnter your choice: ");

        int choice;
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();

        while(choice > 4 || choice < 1)
        {
            this.displayMessage("Please enter a valid choice [1-4]");
            choice = scanner.nextInt();
        }

        return switch (choice)
        {
            case 1 -> Operation.DISPLAYTEMPERATURE;
            case 2 -> Operation.TURNONCOOLER;
            case 3 -> Operation.TURNOFFCOOLER;
            case 4 -> Operation.LOGOUT;
            default -> null;
        };
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayLogin() {

    }

    @Override
    public void displayTemperature() {
        String response = mainPP.sendRequestToTempertureSensor();
        this.displayMessage(response);
    }

    @Override
    public void turnOnCooler() {
        String response = mainPP.sendRequestToActuator(Operation.TURNONCOOLER);
        this.displayMessage(response);
    }

    @Override
    public void turnOffCooler() {
        String response = mainPP.sendRequestToActuator(Operation.TURNOFFCOOLER);
        this.displayMessage(response);
    }
}
