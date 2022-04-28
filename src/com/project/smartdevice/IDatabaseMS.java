package com.project.smartdevice;

import java.sql.Connection;

public interface IDatabaseMS {
    Connection connect();
    User login(String username, String password);
}
