package com.project.smartdevice;

import java.sql.Connection;

public interface IDatabaseMS {
    Connection connect();
    User authenticateUser(String username, String password);
}
