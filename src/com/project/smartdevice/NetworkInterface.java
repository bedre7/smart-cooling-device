package com.project.smartdevice;

import com.project.smartdevice.utilities.CoolerState;
import com.project.smartdevice.utilities.Icons;
import com.project.smartdevice.utilities.Operation;

import java.util.Scanner;

public class NetworkInterface implements INetworkInterface {

    private final IMainProcessingPlatform mainPP;

    public NetworkInterface(){
        mainPP = new MainProcessingPlatform();
    }
    @Override
    public Operation displayMenu() {

        this.displayMessage("+=========================================================+");
        this.displayMessage("|                      MAIN MENU                          |");
        this.displayMessage("+=========================================================+");
        this.displayMessage("|       [1] Display Temperature                           |");
        this.displayMessage("|       [2] Turn On the Cooler                            |");
        this.displayMessage("|       [3] Turn Off the Cooler                           |");
        this.displayMessage("|       [4] Log Out                                       |");
        this.displayMessage("|                                                         |");
        this.displayMessage("|=========================================================|");
        this.promptUser("Enter your choice");

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
    public void promptUser(String request) {
        System.out.print(request + ": ");
    }

    @Override
    public User displayLogin() {
        this.displayMessage("+---------------------------------------------------------+");
        this.displayMessage("|                           LOGIN                         |");
        this.displayMessage("+---------------------------------------------------------+\n");

//        IUserService userService = new UserService();

//        int loginAttempts = 0;
//        boolean userFound;
//
//        do{
//            this.promptUser(Icons.USER + " Username ");
//            String username = userService.readUserInput();
//
//            userFound = userService.searchUser(username);
//
//            loginAttempts++;
//            if(!userFound)
//                this.displayMessage("No such username was found, please try again...");
//
//            if(loginAttempts == 3)
//                Tools.awaitUser(5);
//
//            if(userFound)
//            {
//                this.promptUser(Icons.PASSWORD + " Password ");
//                String password = userService.readUserInput();
//
//                User user = userService.loginUser(username, password);
//
//                return user;
//            }
//        }while(!userFound);
//
        return null;
    }

    @Override
    public void displayTemperature() {

        this.displayMessage(Icons.LOADING + " " + CoolerState.PROCESSING);
        Tools.delay(2000);

        this.displayMessage(Icons.WAITING + " " + CoolerState.WAITING);
        Tools.delay();

        Double temperature = mainPP.sendRequestToTempertureSensor();

        this.displayMessage(Icons.THERMOMETER + " " + CoolerState.DETECTING);
        Tools.delay();

        if(temperature != null){
            this.displayMessage("The current temperature is: " + temperature + "°C");
        }
    }

    @Override
    public void turnOnCooler() {

        this.displayMessage(Icons.LOADING + " " + CoolerState.PROCESSING);
        Tools.delay(2000);

        String error = mainPP.sendRequestToActuator(Operation.TURNONCOOLER);

        this.displayMessage(Icons.WAITING + " " + CoolerState.WAITING);
        Tools.delay();

        if(error == null)
            this.displayMessage("The cooler has been turned on successfully");
    }

    @Override
    public void turnOffCooler() {

        this.displayMessage(Icons.LOADING + " " + CoolerState.PROCESSING);
        Tools.delay(2000);

        String error = mainPP.sendRequestToActuator(Operation.TURNOFFCOOLER);

        this.displayMessage(Icons.WAITING + " " + CoolerState.WAITING);
        Tools.delay();

        if(error == null)
            this.displayMessage("The cooler has been turned off successfully");
    }
}
