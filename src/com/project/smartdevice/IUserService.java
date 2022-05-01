package com.project.smartdevice;

public interface IUserService {
    String readUserInput();
    boolean searchUser(String username);
    User loginUser(String username, String password);
}
