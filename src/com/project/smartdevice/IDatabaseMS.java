package com.project.smartdevice;

import java.sql.Connection;

public interface IDatabaseMS {
    Connection connect();
    boolean searchUser(String username);
    User authenticateUser(String username, String password);
}
