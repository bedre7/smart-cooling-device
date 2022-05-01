package com.project.smartdevice;

import java.util.Scanner;

public class UserService implements IUserService {
    private IDatabaseMS database;

    public UserService(IDatabaseMS database){
        this.database=database;
    }

    public IDatabaseMS getDatabase() {
        return database;
    }

    @Override
    public User loginUser(String username, String password) {
        return getDatabase().authenticateUser(username,password);
    }

    @Override
    public String readUserInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    @Override
    public boolean searchUser(String username) {
        return getDatabase().searchUser(username);
    }


}
