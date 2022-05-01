package com.project.smartdevice;

import com.project.smartdevice.utilities.Icons;

import java.sql.*;

public class PostgreSQLDriver implements IDatabaseMS {

    @Override
    public Connection connect() {
        Connection con=null;

        try{
            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/smartDevice","postgres","1234");
            if(con!=null)
                System.out.println("Connected..."+ Icons.SUCCESS);
            else
                System.out.println("Connection error "+Icons.ERROR);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    @Override
    public boolean searchUser(String username) {
        System.out.println("searching user..."+Icons.LOADING);

        boolean isUser = false;

        String sql = "SELECT * FROM \"User\" WHERE username =" + username ;

        Connection conn = this.connect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            conn.close();

            isUser = rs.next();

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isUser;
    }

    @Override
    public User authenticateUser(String username, String password) {
        User user = null;

        System.out.println(Icons.LOADING+" User authenticate");

        if(searchUser(username)){

            String sql = "SELECT *  FROM \"User\" WHERE \"username\"="+username+" AND \"password\"=" + password;

            Connection conn = this.connect();
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                conn.close();

                while (rs.next()) {
                    username = rs.getString("username");
                    password = rs.getString("password");

                    user = new User.Builder(username, password)
                            .build();
                }
                rs.close();
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return user;
    }
}
