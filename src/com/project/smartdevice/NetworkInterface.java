package com.project.smartdevice;

import com.project.smartdevice.utilities.CoolerState;
import com.project.smartdevice.utilities.Icons;
import com.project.smartdevice.utilities.Operation;

import java.util.Scanner;

public class NetworkInterface implements INetworkInterface {

    private final IMainProcessingPlatform mainPP;
    private User user;

    public NetworkInterface(){
        mainPP = new MainProcessingPlatform();
        user = null;
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
        this.displayMessage("|=========================================================|\n");
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
    public void displayLogin() {
        this.displayMessage("\n+=========================================================+");
        this.displayMessage("|                           LOGIN                         |");
        this.displayMessage("+=========================================================+\n\n");

        IUserService userService = new UserService(new PostgreSQLDriver());
        int loginAttempts = 0;
        boolean userWasFound = false;

        do{
            this.promptUser(Icons.USER + " Username ");
            String username = userService.readUserInput();

//            userWasFound = true;
            userWasFound = userService.searchUser(username);
            loginAttempts++;

            if(!userWasFound){
                this.displayMessage("\nNo such username was found, please try again...");
                Tools.clearScreen();
                if(loginAttempts == 3)
                    Tools.awaitUser(5);
            }
            else if(userWasFound) {
                this.promptUser(Icons.PASSWORD + " Password ");
                String password = userService.readUserInput();

                user = userService.loginUser(username, password);
                this.displayMessage("\n" + Icons.LOADING + " Logging you in...");
                Tools.delay();

//                user = new User.Builder(username, password).build();
                if(user == null){
                    this.displayMessage("\nIncorrect password, please try again...");
                    Tools.clearScreen();
                }
                else{
                    this.displayMessage("Logged in successfully " + Icons.SUCCESS);
                    this.displayMessage("Welcome " + user.getUsername() + "!\n");
                    Tools.delay(4000);
                    mainPP.attachUser(user);
                }
            }
        }while(!userWasFound);
    }

    @Override
    public void logoutUser() {
        this.displayMessage(Icons.LOADING + " Logging you out... ");
        Tools.delay();
        this.mainPP.detachUser(user);
        this.displayMessage("Logged out");
        System.exit(0);
    }

    @Override
    public void displayTemperature() {

        this.displayMessage(Icons.LOADING + " " + CoolerState.PROCESSING);
        Tools.delay(2000);
        this.displayMessage(Icons.WAITING + "  " + CoolerState.WAITING);
        Tools.delay();
        this.displayMessage(Icons.THERMOMETER + "  " + CoolerState.DETECTING);
        Tools.delay();

        Double temperature = mainPP.sendRequestToTempertureSensor();
        if(temperature != null)
            this.displayMessage("\nThe current temperature is: " + temperature + "°C");
    }

    @Override
    public void turnOnCooler() {

        this.displayMessage(Icons.LOADING + " " + CoolerState.PROCESSING);
        Tools.delay(2000);
        this.displayMessage(Icons.WAITING + "  " + CoolerState.WAITING);
        Tools.delay();

        boolean isTurnedOn = mainPP.sendRequestToActuator(Operation.TURNONCOOLER);
        if(isTurnedOn)
            this.displayMessage("The cooler has been turned on successfully " + Icons.COOLING);
    }

    @Override
    public void turnOffCooler() {

        this.displayMessage(Icons.LOADING + " " + CoolerState.PROCESSING);
        Tools.delay(2000);
        this.displayMessage(Icons.WAITING + "  " + CoolerState.WAITING);
        Tools.delay();

        boolean isTurnedOff = mainPP.sendRequestToActuator(Operation.TURNOFFCOOLER);
        if(isTurnedOff)
            this.displayMessage("The cooler has been turned off successfully " + Icons.POWEROFF);
    }
}
