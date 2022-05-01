package com.project.smartdevice;

public interface IUserService {
    String readUserInput();
    boolean searchuser(String username);
    User loginUser(String username, String password);
}
